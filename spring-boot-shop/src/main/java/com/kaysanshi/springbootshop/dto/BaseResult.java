package com.kaysanshi.springbootshop.dto;

import java.io.Serializable;
import java.util.Map;

/**
 * @Author kay三石
 * @date:2019/11/10
 */
public class BaseResult implements Serializable {
    private static final String SuccessStatus = "0";// 0 表示成功 1表失败

    private static final String ErrorStatus = "1";

    private static final String SUCCESSMESSAGE = "操作成功";
    private static final String ERRORMESSAGE = "操作失败";

    private String code;
    private Object data;
    private String message;

    private Object count;


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
     * @param code
     * @param data
     * @return
     */
    private static BaseResult createResult(String code, String message, Object data) {
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(code);
        baseResult.setMessage(message);
        baseResult.setData(data);
        return baseResult;
    }

    public static BaseResult createResult(String code,String message, Object data,String count){
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(code);
        baseResult.setMessage(message);
        baseResult.setData(data);
        if (count!=null){
            baseResult.setCount(count);
        }
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
    public static BaseResult error(Object data) {
        return createResult(ErrorStatus, ERRORMESSAGE, data);
    }

    /**
     * 成功
     *
     * @param
     * @return
     */
    public static BaseResult success() {
        return createResult(SuccessStatus, SUCCESSMESSAGE, null);
    }

    /**
     * 失败
     */
    public static BaseResult error() {
        return createResult(ErrorStatus, ERRORMESSAGE, null);
    }

    /**
     * 创建自定义的返回的消息
     *
     * @param
     * @param data
     * @return
     */
    public static BaseResult createSuccessMessageResult(String message1, Object data) {
        return createResult(SuccessStatus, message1, data);
    }

    /**
     * 创建自定义的返回的消息
     *
     * @param data
     * @param message
     * @return
     */
    public static BaseResult createErrorMessageResult(Object data, String message) {
        return createResult(ErrorStatus, message, data);
    }

    public Object getCount() {
        return count;
    }

    public void setCount(Object count) {
        if (count!=null){
            this.count = count;
        }
    }
}
