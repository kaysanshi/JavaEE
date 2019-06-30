package com.leo.e3mall.fast;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import com.leo.e3mall.utils.FastDFSClient;

/**
 * 测试fastDfs客户端上传文件
 * @author leoill
 *TODO
 *2019年1月6日
 */
public class DastDfsTest {
	
	@Test
	public void testUpload() throws Exception, MyException {
		//trackerserver的服务器端口号为22122
		//创建一个配置文件，文件名任意，内容就是tracker服务器的地址
		//使用全局对象加载配置文件(必须是绝对路径)
			ClientGlobal.init("F:\\Java\\javaEE/e3-manager-web/src/main/resources/conf/client.conf");
		//创建一个TrackerClient对象
			TrackerClient trackerClient=new TrackerClient();
		//通过TrackerClient获得TrackerServer对象
			TrackerServer trackerServer=trackerClient.getConnection();
		//创建一个引用的StorageServer的引用可以为null
			StorageServer storageServer=null;
		//创建一个StoreageClient参数需要TrackerServer和StorageServer
			StorageClient storageClient=new StorageClient(trackerServer,storageServer);
		//使用StorageClient上传文件(必须为绝对路径)
			String[] upload_file = storageClient.upload_file("/.jpg","jpg", null);
			for(String string :upload_file) {
				System.out.println(string);
			}
	}
	/**
	 * 用工具类的方式测试
	 * @throws Exception 
	 */
	@Test
	public void testFastDfsClient() throws Exception {
		FastDFSClient fastDFSClient=new FastDFSClient("F:\\Java\\javaEE/e3-manager-web/src/main/resources/conf/client.conf");
		String string=fastDFSClient.uploadFile("////.jpg");
		System.out.println(string);
	}
}
