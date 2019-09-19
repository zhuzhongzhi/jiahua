package com.xgit.iot.service.system;


import com.bkrwin.ufast.infra.infra.ActionResult;
import com.bkrwin.ufast.infra.infra.SearchCommonVO;
import com.xgit.iot.dao.entity.system.AopEntity;
import com.xgit.iot.service.vo.system.JiahuaUserAuthVO;
import com.xgit.iot.service.vo.system.JiahuaUserVO;
import com.xgit.iot.service.vo.system.UserInfoVO;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Date;
import java.util.List;

/**
 * @author aways on 2019/2/26
 */
@Aspect
@Component
@Service
@Transactional
@RequiredArgsConstructor
public class WebLogAspect {
    @Autowired
    private JiahuaUserService jiahuaUserService;

    @Autowired
    private AopEntityService aopEntityService;

    private final static Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
    ThreadLocal<AopEntity> loggerEntityThreadLocal = new ThreadLocal<AopEntity>();

    @Pointcut("execution(public * com.xgit.iot.web..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        // 接收到请求，记录请求内容
        //logger.info("WebLogAspect.doBefore()");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //创建日志实体
        AopEntity aopEntity = new AopEntity();
        aopEntity.setReqTime(new Date()); //请求时间
        //请求路径
        String url = request.getRequestURI();
        aopEntity.setUri(url); //请求地址

        // 获取ip地址
        String clientIp = request.getHeader("x-forwarded-for");
        if (clientIp == null || clientIp.trim() == "" || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getHeader("Proxy-Client-IP");
        }
        if (clientIp == null || clientIp.trim() == "" || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getHeader("WL-Proxy-Client-IP");
        }
        if (clientIp == null || clientIp.trim() == "" || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getRemoteAddr();
        }

        // 多个路由时，取第一个非unknown的ip
        final String[] arr = clientIp.split(",");
        for (final String str : arr) {
            if (!"unknown".equalsIgnoreCase(str)) {
                clientIp = str;
                break;
            }
        }
        aopEntity.setClientIp(clientIp);

        //
        String basicToken = request.getHeader("Authorization");
        if (basicToken != null){
            String[] tokens = basicToken.split(" ");
            if (tokens[0].equals("Basic")){
                byte[] decoded = Base64.getDecoder().decode(tokens[1]);
                String decodeStr = new String(decoded);
                String[] infos = decodeStr.split(":");
                String userName = infos[0];
                String password = infos[1];

                //设置访问的用户名
                aopEntity.setUserName(userName);

                //获取用户信息以及用户权限信息
                UserInfoVO userInfoVO = new UserInfoVO();
                JiahuaUserVO jiahuaUserVO = jiahuaUserService.selectByUserName(userName);
                if (jiahuaUserVO != null) {
                    //设置访问的用户ID
                    aopEntity.setUserId(jiahuaUserVO.getUserId());
                }
            }
        }

        loggerEntityThreadLocal.set(aopEntity);
    }

    @AfterReturning(value = "webLog()",returning = "returnData")
    public void  doAfterReturning(JoinPoint joinPoint, Object returnData){
        // 处理完请求，返回内容
        //logger.info("WebLogAspect.doAfterReturning()");
        //logger.info("RETURN DATA:"+ returnData);

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();


        //获取本次请求日志实体
        AopEntity aopEntity = loggerEntityThreadLocal.get();

        //请求结束时间
        aopEntity.setRspTime(new Date());

        //设置响应结果
        String dataString = null;
        if (returnData instanceof ActionResult){
            ActionResult rs = (ActionResult)returnData;
            dataString = "code:" + rs.getCode() + ", value:" + ((rs.getValue()!=null)?rs.getValue().toString():"");
        } else {
            dataString = returnData.toString();
        }
        //获取请求错误码
        int status = response.getStatus();
        String result = "Status:" + status + ",Data:" + dataString;
        result = (result.length() > 512) ? result.substring(0, 512) : result;
        aopEntity.setRspResult(result);


        // 写入数据库
        aopEntityService.addAopEntity(aopEntity);
    }

    @AfterThrowing(value = "webLog()",throwing = "exception")
    public void doAfterThrowingAdvice(JoinPoint joinPoint, Throwable exception){
        //目标方法名：
        AopEntity aopEntity = loggerEntityThreadLocal.get();
        String result = exception.getMessage();
        if (result != null) {
            result = (result.length() > 512) ? result.substring(0, 512) : result;
            aopEntity.setRspResult(result);
        }

        //请求结束时间
        aopEntity.setRspTime(new Date());

        // 写入数据库
        aopEntityService.addAopEntity(aopEntity);
    }

    /*@After(value = "webLog()")
     public void doAfterAdvice(JoinPoint joinPoint){
         System.out.println("后置通知执行了!!!!");
     } */
}
