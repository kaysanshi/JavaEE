package com.kayleoi.springbootshop.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @Author kay三石
 * @date:2019/11/10
 */
public class BaseResult implements Serializable {
    private static final String SuccessStatus = "0";// 0 表示陈功 1表失败

    private static final String ErrorStatus = "1";

    private static final String SUCCESSMESSAGE = "操作成功";
    private static final String ERRORMESSAGE = "操作失败";

    private String code;
    private Object data;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 创建返回结果
     *
     * @param result
     * @param data
     * @return
     */
    private static BaseResult createResult(String result, String message, Object data) {
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(result);
        baseResult.setData(data);
        baseResult.setMessage(message);
        return baseResult;
    }

    /**
     * 成功并返回数据
     *
     * @param data
     * @return
     */
    public static BaseResult success(Object data) {
        return createResult(SuccessStatus, SUCCESSMESSAGE, data);
    }
    /**
     * 失败返回数据
     */
    public static  BaseResult error(Object data){
        return createResult(ErrorStatus,ERRORMESSAGE,data);
    }
}
