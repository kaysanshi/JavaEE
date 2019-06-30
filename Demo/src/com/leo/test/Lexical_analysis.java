package com.leo.test;

import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 词法分析
 * @author leoill
 *TODO
 *2018年12月12日
 */
public class Lexical_analysis {
	public int ch;
	public int code;//保留字状态码
	
	public StringBuffer strToken = new StringBuffer();//存放构成单词符号的字符串
	
	public String [] retainWord = new String[]{"int","if","else","return","main","void","while","break"};//保留字
	
	//判断是否是字母
	public boolean IsLetter(){
		//大写小写
		if((ch>=65 && ch <= 90) || (ch >= 97 && ch <=122)){
			return true;
		}
		return false;
	}
	
	//判断是否是数字
	public boolean IsDigit(){
		if(ch>=48 && ch <= 57){
			return true;
		}
		return false;
	}
	
	//判断是否是空格
	public boolean IsBC(int ch){
		if(ch == 32){
			return true;
		}
		return false;
	}
	
	//连接字符
	public void Concat(char ch){
		strToken.append(ch);
	}
	
	//判断是否是保留字
	public int Reserve(){
		for(int i = 0;i < retainWord.length;i++){
			if(strToken.toString().equals(retainWord[i])){
				return 1;
			}
		}
		if(strToken.length() != 0){
			if(strToken.charAt(0)>='0' && strToken.charAt(0)<='9'){
				return 3;
			}
		}
		
		return 2;
	}
	
	//
	public void Retract(){
		code = Reserve();
		if(code == 1){
			System.out.println("("+"$key"+",'"+strToken+"')");
		}else if(code == 2){
			System.out.println("("+"$ID"+",'"+strToken+"')");
		}
		else if(code == 3){
			System.out.println("("+"$ASSIGN"+",'"+strToken+"')");
		}
		strToken.delete(0, strToken.length());
	}
	
	/**
	 * 读取文件
	 */
	public void scanner(){
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\leoill\\Desktop\\tests.txt"));
			while((ch = br.read()) != -1){
				//System.out.println("======="+(char)ch);
				if(IsBC(ch) == false){
					if(IsLetter()){
						if(IsLetter() == true || IsDigit() == true){
							Concat((char) ch);
						}
					}else if(IsDigit() == true){
						Concat((char)ch);
					}else if(IsDigit()){
						Concat((char) ch);
					}else if(ch == 61){
						if((strToken.length() != 0 )&& (strToken.charAt(0) == '=')){
							strToken.append((char)ch);
							System.out.println("("+"$OPERATOR"+",'"+strToken+"')");
							strToken.delete(0, strToken.length());
						}else{
							strToken.append((char)ch);
						}
					}else if(ch == 43){
						Retract();
						System.out.println("("+"$OPERATOR"+",'"+(char) ch+"')");
					}else if(ch == 45){
						Retract();
						System.out.println("("+"$OPERATOR"+",'"+(char) ch+"')");
					}else if(ch == 42){
						Retract();
						System.out.println("("+"$OPERATOR"+",'"+(char) ch+"')");
					}else if(ch == 47){
						Retract();
						System.out.println("("+"$OPERATOR"+",'"+(char) ch+"')");
					}else if((char) ch == ';'){
						Retract();
						System.out.println("("+"$DELIMITER"+",'"+(char) ch+"')");
					}else if((char) ch == '('){
						Retract();
						System.out.println("("+"$DELIMITER"+",'"+(char) ch+"')");
					}else if((char) ch == ')'){
						Retract();
						System.out.println("("+"$DELIMITER"+",'"+(char) ch+"')");
					}else if((char) ch == '{'){
						Retract();
						System.out.println("("+"$DELIMITER"+",'"+(char) ch+"')");
					}else if((char) ch == '}'){
						Retract();
						System.out.println("("+"$DELIMITER"+",'"+(char) ch+"')");
					}else if((char) ch == ','){
						Retract();
						System.out.println("("+"$DELIMITER"+",'"+(char) ch+"')");
					}
					
				}else{
					Retract();
				}
				
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Lexical_analysis analysis=new Lexical_analysis();
		analysis.scanner();
		
	}

	
}
