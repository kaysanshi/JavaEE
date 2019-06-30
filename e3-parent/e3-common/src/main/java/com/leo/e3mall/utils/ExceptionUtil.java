package com.leo.e3mall.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
/**
 * 异常工具类
 * @author leoill
 *TODO
 *2019年1月7日
 */
public class ExceptionUtil {

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
