package com.leo.craw.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import sun.net.www.protocol.http.HttpURLConnection;

/**
 * 简单的爬虫
 * @author leoill
 *TODO
 *2018年12月18日
 */
public class CrawTest {
	/**
	 * 通过xml解析器解析
	 * @throws IOException
	 */
	void thoughJsoup() throws IOException{
		String url = "http://www.baidu.com";
		Document document = Jsoup.connect(url).timeout(3000).get();
		//通过Document的select方法获取属性结点集合
		Elements elements = document.select("a");
		//得到节点的第一个对象
		//Element element = elements.get(0);
		System.out.println(elements);

		}
	
	
	public static void main(String[] args0) {
		String rString;
		try {
			//1.新建url对象，表示要访问的url
			URL url=new URL("https://www.zhihu.com/topic/19555513/hot");
			//建立http连接诶返回urlconnection
			HttpsURLConnection urlConnection=(HttpsURLConnection) url.openConnection();
			//3.获取相应的http状态码，
			int responseCode= urlConnection.getResponseCode();
			//4.如果获取成功，从URLconnection对象获取输入流来获取请求网页的源代码
			if(responseCode == 200){
				BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
				while((rString=reader.readLine())!=null){
					System.out.println(rString);
				}
			}else{
				System.out.println("获取不到源代码 ，服务器响应代码为："+responseCode);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
