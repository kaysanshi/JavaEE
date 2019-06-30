package com.leo.spring.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 转换日期
 * S:页面传过来的s类型
 * T:转换后的类型
 * @author leoi555
 *
 */
public class DateConveter implements Converter<String, Date> {

	@Override
	public Date convert(String arg0) {
		// TODO Auto-generated method stub
		if (null !=arg0) {
			DateFormat dFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				return  dFormat.parse(arg0);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
