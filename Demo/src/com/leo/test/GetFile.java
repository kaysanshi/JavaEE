package com.leo.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GetFile {
	static List<File> filelist=new ArrayList<>();
	
	public static List<File> getFileList(String FilePath) {
		File dir=new File(FilePath);
		File[] files=dir.listFiles();
		if (files !=null) {
			for(int i=0;i<files.length;i++) {
				if (files[i].isDirectory()) {
					getFileList(files[i].getAbsolutePath());
				}else {
					filelist.add(files[i]);
				}
			}
		}
		
		
		
		return filelist;
		
	}
	public static void main(String[] args) throws IOException {
		List<File> list=getFileList("C://Users//leoill//Desktop//Ufile");
		for (File file :list) {
			System.out.println(file.getPath()+":"+file.getName());
//			G:\大三呀\职业规划\大三\时装设计3王铮\寒江雪  服饰图案设计\201605134115耿露露\平时作业\平时作业三\复古.jpg
//			FileUtil.save("C:/Users/leoill/Desktop/Ufile1"+file.getPath().replaceAll("G:", "").replaceAll("\\\\", "/").replaceAll("\\\\" + file.getName(), ""), file.getName(), FileUtil.read(file.getPath()));;
		}
//		String string = "G:\\大三呀\\职业规划\\大三\\时装设计3王铮\\寒江雪  服饰图案设计\\201605134115耿露露\\平时作业\\平时作业三\\复古.jpg";
//		System.out.println(string.replaceAll("G:", "").replaceAll("\\\\", "/").replaceAll("\\\\" , ""));
		
	}

}
