package com.xgit.iot.manager.restTemplate;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bkrwin.ufast.infra.infra.log.LogHelper;
import com.xgit.iot.infra.ErrorCode;
import com.xgit.iot.infra.FunctionResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 类注释
 *
 * @author: hz
 * @date: 2019/03/08
 * @since: 1.0
 */
@Service
public class RestTemplateHelper {
    @Resource(name = "restTemplate")
    private RestTemplate restTemplate;

    /**
     * 请求第三方接口，返回指定类型的数据
     *
     * @param url
     * @param requestObject
     * @param responseType
     * @param uriVariables
     * @param <T>
     * @return
     */
    public <T> FunctionResult<T> request(String url, HttpMethod httpMethod, Object requestObject,
                                         Class<T> responseType, Map<String, ?> uriVariables) {
        LogHelper.debug("[RestTemplate请求],url:[" + url + "]" +
                "uriVariables=["+uriVariables+"]," +
                "request:[" + requestObject + "]");
        if (StringUtils.isBlank(url)) {
            return new FunctionResult(ErrorCode.RestTempleateNotParamInURL);
        }
        try {
            FunctionResult<JSONObject> jsonObjectResult = getJsonObject(url, httpMethod, requestObject, uriVariables);
            if (jsonObjectResult.getCode() != ErrorCode.Success) {
                return new FunctionResult<T>(jsonObjectResult.getCode());
            }
            JSONObject jsonObject = jsonObjectResult.getT();
            T javaObject = jsonObject.toJavaObject(responseType);
            return new FunctionResult(javaObject);
        } catch (RestClientException e) {
            LogHelper.debug("[RestTemplate返回异常],url:[" + url + "],RestClientException:[" + e.getMessage() + "]");
            return new FunctionResult(ErrorCode.RestTempleateConnecTimeout);
        } catch (Exception e) {
            LogHelper.debug("[RestTemplate返回异常],url:[" + url + "],Exception:[" + e.getMessage() + "]");
            return new FunctionResult(ErrorCode.RestTempleateConnectFailed);
        }
    }

    /**
     * 请求第三方接口，返回json串数据
     *
     * @param url
     * @param requestObject
     * @param uriVariables
     * @return
     */
    public FunctionResult<JSONObject> requestOrinal(String url, HttpMethod httpMethod, Object requestObject,
                                                    Map<String, ?> uriVariables) {
        LogHelper.debug("[RestTemplate请求],url:[" + url + "],request:[" + requestObject + "]");
        if (StringUtils.isBlank(url)) {
            return new FunctionResult(ErrorCode.RestTempleateNotParamInURL);
        }
        try {
            FunctionResult<JSONObject> jsonObjectResult = getJsonObject(url, httpMethod, requestObject, uriVariables);
            return jsonObjectResult;
        } catch (RestClientException e) {
            LogHelper.debug("[RestTemplate返回异常],url:[" + url + "],RestClientException:[" + e.getMessage() + "]");
            return new FunctionResult(ErrorCode.RestTempleateConnecTimeout);
        } catch (Exception e) {
            LogHelper.debug("[RestTemplate返回异常],url:[" + url + "],Exception:[" + e.getMessage() + "]");
            return new FunctionResult(ErrorCode.RestTempleateConnectFailed);
        }
    }

    private FunctionResult<JSONObject> getJsonObject(String url, HttpMethod httpMethod, Object requestObject,
                                                     Map<String, ?> uriVariables) {
        // 这个对象有add()方法，可往请求头存入信息
        HttpHeaders headers = new HttpHeaders();
        // 解决中文乱码
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Object> entity = new HttpEntity<Object>(requestObject, headers);
        ResponseEntity<String> responseObject = restTemplate.exchange(url, httpMethod, entity, String.class, uriVariables);
        LogHelper.debug("[RestTemplate返回],url:[" + url + "],response:[" + responseObject + "]");
        HttpStatus httpStatus = responseObject.getStatusCode();
        if (httpStatus != HttpStatus.OK) {
            return new FunctionResult(ErrorCode.RestTempleateConnectFailed);
        }
        JSONObject jsonObject = JSON.parseObject(responseObject.getBody());
        return new FunctionResult<>(jsonObject);
    }
}
