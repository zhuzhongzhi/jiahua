package com.xgit.iot.infra.exception;

import com.xgit.iot.infra.ErrorCode;
import com.bkrwin.ufast.infra.infra.ActionResult;
import com.bkrwin.ufast.infra.infra.log.LogHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class ExceptionAdvice {

	@Value("${isThrowServerError}")
	private Boolean isThrowServerError;
	
	@ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ActionResult processExcption(NativeWebRequest request, BusinessException e) {
		LogHelper.error(e.getMessage(),e.getCode());
		return new ActionResult(e.getCode(),e.getMessage(),e.getValue());
    }
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ActionResult processExcption(NativeWebRequest request, Exception e) throws Exception{
		LogHelper.fatal(e.getMessage(),e.getCause());
		if(isThrowServerError) {
			throw e;
		}
		return new ActionResult(ErrorCode.UnExceptedError.getCode(),ErrorCode.UnExceptedError.getDesc());
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseBody
	public ActionResult processIllegalArumentExcption(NativeWebRequest request, IllegalArgumentException e) {
		LogHelper.fatal(e.getMessage(), e);
		ErrorCode code = ErrorCode.IllegalArument;
		return new ActionResult(code.getCode(), code.getDesc(), null);
	}

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	@ResponseBody
	public ActionResult processSQLIntegrityConstraintViolationException(NativeWebRequest request, IllegalArgumentException e) {
		LogHelper.fatal(e.getMessage(), e);
		ErrorCode code = ErrorCode.SQLIntegrityConstraintViolation;
		return new ActionResult(code.getCode(), code.getDesc(), null);
	}
}
