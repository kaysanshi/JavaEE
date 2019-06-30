package com.leo.bos.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;

/**
 * 测试解析Excel
 * Apache POI是Apache软件基金会的开放源码函式库，POI提供API给Java程序对Microsoft Office格式档案读和写的功能。
 * @author leoi555
 *
 */
public class POITest {
	/**
	 * HSSF － 提供读写Microsoft Excel格式档案的功能。
XSSF － 提供读写Microsoft Excel OOXML格式档案的功能。
HWPF － 提供读写Microsoft Word格式档案的功能。
HSLF － 提供读写Microsoft PowerPoint格式档案的功能。
HDGF － 提供读写Microsoft Visio格式档案的功能。
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	@Test	
	public void test() throws FileNotFoundException, IOException {
		String filepath="‪E:\\\\Java全集\\\\Java基础视频\\\\上海传智播客\\\\黑马32框架\\\\项目一：物流BOS系统（58-71天）\\\\BOS-day05\\\\BOS-day05\\\\资料\\\\分区导入测试数据.xls";
		System.out.println(filepath);
		File file=new File(filepath);
		//包装一个Excel文件对象
		
		HSSFWorkbook hworkbook=new HSSFWorkbook(new FileInputStream(file));
		//读取文件中的第一个Sheet标签页
		HSSFSheet hssfSheet=hworkbook.getSheetAt(0);
		//遍历标签页的所有行
		for (Row row: hssfSheet) {
			//跳过标题
			if (row.getRowNum()==0) {
				continue;
			}
			//换行
			System.out.println();
			//遍历单元格
			for (Cell cell : row) {
				String value=cell.getStringCellValue();
				System.out.println(value);
			}
		}
	}
}
