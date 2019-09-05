package com.xgit.iot.infra;

import com.bkrwin.ufast.dto.UserDetailDTO;
import com.bkrwin.ufast.feign.AuthClient;
import com.bkrwin.ufast.infra.infra.ActionResult;import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by john on 2017/4/11.
 */
public class BasicController {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private AuthClient authClient;

    public <T> ActionResult<T> actionResult(ErrorCode code, T value) {
        return new ActionResult<T>(code.getCode(),
                code.getDesc(),
                value);
    }

    public <T> ActionResult<T> actionResult(T value) {
        ErrorCode code = ErrorCode.Success;
        return actionResult(code, value);
    }

    public ActionResult actionResult(ErrorCode code) {
        return actionResult(code, null);
    }

    public String getUserId() {
        if (null == request) {
            return StringUtils.EMPTY;
        }
        String userId = request.getHeader("x-user-id");
        if (StringUtils.isNotBlank(userId)) {
            return userId;
        }
        return StringUtils.EMPTY;
    }

    public UserDetailDTO getUserDetail() {
        ActionResult ret;
        try {
            ret = authClient.getUserDetail(getUserId());
            if (ret == null || ret.getCode() != ErrorCode.Success.getCode()) {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
        return (UserDetailDTO) ret.getValue();
    }

    public String getOrgId() {
        ActionResult ret = null;
        try {
            ret = authClient.queryWorkspaceId(getUserId());
            if (ret == null || ret.getCode() != ErrorCode.Success.getCode()) {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        return (String) ret.getValue();
    }
    public String getMpUserId(){
        String userId = (String)request.getHeader("mp-user-id");
        return userId;
    }
    public String getMpOrgId(){
        ActionResult ret = null;
        try {
            ret = authClient.queryWorkspaceId(getMpUserId());
            if (ret == null || ret.getCode() != ErrorCode.Success.getCode()) {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        return (String) ret.getValue();
    }

    public UserDetailDTO getMpUserDetail() {
        ActionResult ret = null;
        try {
            ret = authClient.getUserDetail(getMpUserId());
            if (ret == null || ret.getCode() != ErrorCode.Success.getCode()) {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        return (UserDetailDTO) ret.getValue();
    }

}
