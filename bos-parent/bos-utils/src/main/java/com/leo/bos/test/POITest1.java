package com.leo.bos.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 * poi测试
 * @author leoi555
 *
 */
public class POITest1 {
	/**
	 * HSSFWorkbook类，创建excel表空的excel：
	 */
	public void createExcel(String filename) {
		//创建一个空的workbook
				HSSFWorkbook workbook=new HSSFWorkbook();
				FileOutputStream outputStream=null;//创建输出流
				try {
					outputStream=new FileOutputStream(filename);
					//调用HSSFWorkbook中的类的write方法
					workbook.write(outputStream);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(e.toString());
				}finally {
					try {
						outputStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
	}
	/**
	 * 用POIFSFileSystem类读取excel表格
	 * 然后向另一个excel表中写入
	 * POIFSFileSystem()类
		Constructor, intended for writing 
		POIFSFileSystem(java.io.InputStream stream)
		Create a POIFSFileSystem from an InputStream 

	 */
	public void readExcel(String filepath,String filename) {
		FileInputStream inputStream=null;
		HSSFWorkbook workbook=null;
		try {
			inputStream=new FileInputStream(filepath);
			//创建带有输入流的类的对象
			POIFSFileSystem frFileSystem=new POIFSFileSystem(inputStream);
			//创建HSSFWorkbook(POIFSFileSystem fs) ;
			workbook=new HSSFWorkbook(frFileSystem);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//读取后然后输出
		FileOutputStream outputStream=null;
		
		try {
			outputStream=new FileOutputStream(filename);
			workbook.write(outputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 创建Sheet通过传入的文件名
	 * public HSSFSheet createSheet(java.lang.String sheetname)
	 * public HSSFSheet createSheet()
	 */
	public void createSheet(String filename) {
		HSSFWorkbook workbook = new HSSFWorkbook();

	    workbook.createSheet();//创建workbook的sheet0
	    workbook.createSheet();//sheet1
	    workbook.createSheet("test");

	    FileOutputStream out = null;
	    try{
	      out = new FileOutputStream(filename);
	      workbook.write(out);
	    }catch(IOException e){
	      System.out.println(e.toString());
	    }finally{
	      try {
	        out.close();
	        System.out.println("创建成功");
	      }catch(IOException e){
	        System.out.println(e.toString());
	      }
	    }

	}
	/**
	 * 复制sheet
	 * public HSSFSheet cloneSheet(int sheetNum)
	 */
	public void copySheet(String filename) {
		 FileInputStream in = null;
		    HSSFWorkbook workbook = null;
		    try{
		    	//先进型读取
		      in = new FileInputStream(filename);
		      POIFSFileSystem fs = new POIFSFileSystem(in);
		      workbook = new HSSFWorkbook(fs);
		      
		    }catch(IOException e){
		      System.out.println(e.toString());
		    }finally{
		      try{
		        in.close();
		       //读取成功
		        System.out.println("读取成功");
		      }catch (IOException e){
		        System.out.println(e.toString());
		      }
		    }
		    //复制0和一sheet就是在这个excel中多加入一个空白页同时有前面的数据
		    workbook.cloneSheet(0);
		    workbook.cloneSheet(1);

		    FileOutputStream out = null;
		    try{
		    //然后在进行写入
		      out = new FileOutputStream(filename);
		      workbook.write(out);
		    }catch(IOException e){
		      System.out.println(e.toString());
		    }finally{
		      try {
		        out.close();
		        System.out.println("复制成功");
		      }catch(IOException e){
		        System.out.println(e.toString());
		      }
		    }
	}
	/**
	 * 删除sheet后然后在写到哪个文件中
	 * public void removeSheetAt(int index)
	 * public int getSheetIndex(java.lang.String name)
	 *更改sheet的名称
	 *	public void setSheetName(int sheet, java.lang.String name)
		set the sheet name. Will throw IllegalArgumentException if the name
		is greater than 31 chars or contains /\?*[]

	 * @param args
	 */
	public void deleteSheet(String filename, String sheetname,String tofilename) {
		FileInputStream in = null;
	    HSSFWorkbook workbook = null;
	    try{
	    	//先进型读取
	      in = new FileInputStream(filename);
	      POIFSFileSystem fs = new POIFSFileSystem(in);
	      workbook = new HSSFWorkbook(fs);
	      
	    }catch(IOException e){
	      System.out.println(e.toString());
	    }finally{
	      try{
	        in.close();
	       //读取成功
	        System.out.println("读取成功");
	      }catch (IOException e){
	        System.out.println(e.toString());
	      }
	    }
	    //更改sheet名字：
	    workbook.setSheetName(0, "修改1sheet"); 
	    
	    int sheet=workbook.getSheetIndex(sheetname);
	    System.out.println("删除的页数："+sheet);
	    workbook.removeSheetAt(sheet);
	  
	    System.out.println("删除sheet页成功");
	    System.out.println("Sheet0 = " + workbook.getSheetIndex("Sheet0"));
	    System.out.println("test = " + workbook.getSheetIndex("test"));
	   
	    // 然后再写回到文件；
	    FileOutputStream out = null;
	    try{
	      out = new FileOutputStream(tofilename);
	      workbook.write(out);
	      
	    }catch(IOException e){
	      System.out.println(e.toString());
	    }finally{
	      try {
	        out.close();
	      }catch(IOException e){
	        System.out.println(e.toString());
	      }
	    }
	
	}
	/**
	 * HSSFRow类定义
		用POI在工作表里作成一个行，可以用「HSSFRow」类，
		protected HSSFRow()
		protected HSSFRow(Workbook book, Sheet sheet, int rowNum)
		Creates new HSSFRow from scratch.
		protected HSSFRow(Workbook book, Sheet sheet, RowRecord record)
		Creates an HSSFRow from a low level RowRecord object.
			public int getFirstRowNum()
			public int getLastRowNum()获得最后一行的序列号
			public int getPhysicalNumberOfRows()实际存在的行的总数
	 * @param args
	 */
	public void createRow(String filename) {
		 HSSFWorkbook workbook = new HSSFWorkbook();
		    HSSFSheet sheet = workbook.createSheet();//创建空白的sheet

		    System.out.println("创建行之前的状态:");
		    System.out.println("First:" + sheet.getFirstRowNum());//sheet.getFirstRowNum()获取sheet的第一行行号
		    System.out.println("Last:" + sheet.getLastRowNum());//getLastRowNum()获取sheet的最后行行号
		    System.out.println("Total:" + sheet.getPhysicalNumberOfRows() + "\n");// getPhysicalNumberOfRows()获取sheet的行总数

		    sheet.createRow(0);

		    System.out.println("创建第一行后的状态:");
		    System.out.println("First:" + sheet.getFirstRowNum());
		    System.out.println("Last:" + sheet.getLastRowNum());
		    System.out.println("Total:" + sheet.getPhysicalNumberOfRows() + "\n");
		    //创建行号为1的行，excel中的第2行
		    HSSFRow createRow = sheet.createRow(1);
		    ////创建上面行的第一个单元格,第二个单元格书写其中的值
		   HSSFCell createCell = createRow.createCell(0);
		   createCell.setCellValue("单元格1：");
		   HSSFCell createCell2 = createRow.createCell(1);
		   createCell2.setCellValue("单元格2：");
		   FileOutputStream out = null;
		    try{
		      out = new FileOutputStream(filename);
		      workbook.write(out);
		      System.out.println("创建成功");
		    }catch(IOException e){
		      System.out.println(e.toString());
		    }finally{
		      try {
		        out.close();
		      }catch(IOException e){
		        System.out.println(e.toString());
		      }
		    }
		
		 
	}
	/**
	 * 读取行
	 * public HSSFRow getRow(int rownum)
	 * //获取行
	    HSSFRow row2 = sheet.getRow(1);
	    //获得单元格
	    HSSFCell cell=row2.getCell(1);
	    //取得其中的值
	    System.out.println(cell.getStringCellValue());
	 */
	public void readRow(String filename) {
		//先进行读取出这个excel文件
		FileInputStream in = null;
	    HSSFWorkbook workbook = null;
	    try{
	    	//先进型读取
	      in = new FileInputStream(filename);
	      POIFSFileSystem fs = new POIFSFileSystem(in);
	      workbook = new HSSFWorkbook(fs);
	      
	    }catch(IOException e){
	      System.out.println(e.toString());
	    }finally{
	      try{
	        in.close();
	       //读取成功
	        System.out.println("读取成功");
	      }catch (IOException e){
	        System.out.println(e.toString());
	      }
	    }
	    //读取第一个sheet
	    HSSFSheet sheet=workbook.getSheetAt(0);
	    //获取行
	    HSSFRow row2 = sheet.getRow(1);
	    //获得单元格
	    HSSFCell cell=row2.getCell(1);
	    //取得其中的值
	    System.out.println(cell.getStringCellValue());
	}
	/**
	 * 通过向单元格中写入不同的数据
	 * @param args
	 */
	public void writeExcel(String filname) {
		  HSSFWorkbook workbook = new HSSFWorkbook();

		    HSSFSheet sheet = workbook.createSheet();
		    HSSFRow row = sheet.createRow(1);//创建第二行

		    HSSFCell cell1 = row.createCell((short)0);//2,1格
		    cell1.setCellValue(true);//写入true

		    HSSFCell cell2 = row.createCell((short)1);//2,2格
		    Calendar cal = Calendar.getInstance();//Calendar类获取实例
		    cell2.setCellValue(cal);//写入Calendar型对象cal

		    HSSFCell cell3 = row.createCell((short)2);//2,3格
		    Date date = new Date();	//日期型
		    cell3.setCellValue(date);//写入日期型

		    HSSFCell cell4 = row.createCell((short)3);//2,4格
		    cell4.setCellValue(150);//写入150

		    HSSFCell cell5 = row.createCell((short)4);//2.5格
		    cell5.setCellValue("hello");//写入hello

		    HSSFRow row2 = sheet.createRow(2);//第三行

		    HSSFCell cell6 = row2.createCell((short)0);//3,1格
		   // cell6.setCellErrorValue(HSSFErrorConstants.ERROR_NUM);//写入error型

		    FileOutputStream out = null;
		    try{
		      out = new FileOutputStream(filname);
		      workbook.write(out);
		    }catch(IOException e){
		      System.out.println(e.toString());
		    }finally{
		      try {
		        out.close();
		        System.out.println("写入类型值完毕!");
		      }catch(IOException e){
		        System.out.println(e.toString());
		      }
		    }
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		POITest1 test1=new POITest1();
		//test1.createExcel("test.xls");
		//test1.readExcel("test.xls", "sample2.xls");
		//test1.createSheet("test.xls");
		//test1.copySheet("test.xls");
		//test1.deleteSheet("test.xls", "Sheet1","test1.xls");
		//test1.createRow("test2.xls");
		//test1.readRow("test2.xls");
		test1.writeExcel("test3.xls");
		
	}
}
