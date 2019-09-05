package com.xgit.iot.infra;

public class FunctionResult<T> {
    private T t;

    private ErrorCode code;

    public FunctionResult(){
    }

    public FunctionResult(ErrorCode code){
        this.code=code;
    }

    public FunctionResult(T t){
        this.code=ErrorCode.Success;
        this.t=t;
    }

    public FunctionResult(ErrorCode code, T t){
        this.code=code;
        this.t=t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public ErrorCode getCode() {
        return code;
    }

    public void setCode(ErrorCode code) {
        this.code = code;
    }

}
