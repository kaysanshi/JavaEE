package com.leo.bos.test;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.leo.bos.utils.PinYin4jUtils;

import freemarker.template.utility.StringUtil;

/**]
 * 拼音插件
 * @author leoi555
 *
 */
public class Pinyin4JTest {
	@Test
	public void test1() {
		//河北石家庄桥西区
		String province="河北省";
		String city="石家庄市";
		String district="桥西区";
		//简码： HBSJZQX
		province=province.substring(0, province.length()-1);
		city=city.substring(0, city.length()-1);
		district=district.substring(0, district.length()-1);
		String info=province+city+district;
		System.out.println(info);
		
		String[] headByString = PinYin4jUtils.getHeadByString(info);
		System.out.println(headByString);
		//简码
		String shortcode=StringUtils.join(headByString);
		System.out.println(shortcode);
		//城市编码--拼音编码
		String citycode=PinYin4jUtils.hanziToPinyin(city);
		System.out.println(citycode);
		
	}
}
