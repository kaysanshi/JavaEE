package com.leo.struts2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {
	   private File myFile;//这是用户已上传的实际文件
	   private String myFileContentType;//file类型
	   private String myFileFileName;//file 名称
	   private String destPath;//盘符
	public File getMyFile() {
		return myFile;
	}
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	public String getMyFileContentType() {
		return myFileContentType;
	}
	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}
	public String getMyFileFileName() {
		return myFileFileName;
	}
	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}
	public String getDestPath() {
		return destPath;
	}
	public void setDestPath(String destPath) {
		this.destPath = destPath;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		/* Copy file to a safe location */
		//这两种方式都可以进行上传路径设置
		String realpath = ServletActionContext.getServletContext().getRealPath("/images");
		//设置上传路径
		String destpase="D:/SoftWare/apache-tomcat-9.0.10/webapps/";
	      destPath = realpath;

	      try{
	     	 System.out.println("Src File name: " + myFile);
	     	 System.out.println("Dst File name: " + myFileFileName);   	 
	     	 File destFile  = new File(destPath, myFileFileName);
	    	 FileUtils.copyFile(myFile, destFile);
	  
	      }catch(IOException e){
	         e.printStackTrace();
	         return "ERROR";
	      }
	      return "SUCCESS";
	}
	   

}
