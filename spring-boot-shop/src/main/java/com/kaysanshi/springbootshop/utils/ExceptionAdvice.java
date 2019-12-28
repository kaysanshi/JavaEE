package com.kaysanshi.springbootshop.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @Author kay三石
 * @date:2019/12/2
 */
public class ExceptionAdvice {

    /**
     * 获取异常的堆栈信息
     *
     * @param t
     * @return
     */
    public static String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        try {
            t.printStackTrace(pw);
            return sw.toString();
        } finally {
            pw.close();
        }
    }
}
