package com.leo.e3mall.solrj;

import org.apache.ibatis.reflection.wrapper.BaseWrapper;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

/**
 * 测试solr集群版的，使用的时候除了需要创建一个集群的连接对象后其他的都不用改变
 * @author leoill
 *TODO
 *2019年2月4日
 */
public class TestSolrCloud {
	//创建一个集群的连接，应该使用CloudSolrServer对象
	//Zkhost:zookeeper的地址列表
	//设置一个defaultCollection属性
	//创建一个文档对象
	//向文档对象添加域
	//把文件写入索引库
	//提交
	@Test
	public void testSolrCloudAddDocument() throws Exception {
		// 第一步：把solrJ相关的jar包添加到工程中。
		// 第二步：创建一个SolrServer对象，需要使用CloudSolrServer子类。构造方法的参数是zookeeper的地址列表。
		//参数是zookeeper的地址列表，使用逗号分隔
		CloudSolrServer solrServer = new CloudSolrServer("192.168.25.154:2181,192.168.25.154:2182,192.168.25.154:2183");
		// 第三步：需要设置DefaultCollection属性。
		solrServer.setDefaultCollection("collection2");
		// 第四步：创建一SolrInputDocument对象。
		SolrInputDocument document = new SolrInputDocument();
		// 第五步：向文档对象中添加域
		document.addField("item_title", "测试商品");
		document.addField("item_price", "100");
		document.addField("id", "test001");
		// 第六步：把文档对象写入索引库。
		solrServer.add(document);
		// 第七步：提交。
		solrServer.commit();
	}
	/**
	 * 查询
	 * @throws Exception
	 */
	@Test
	public void testQueryDocument() throws Exception{
		//创建一个CloudSolrServer对象
		CloudSolrServer cServer=new CloudSolrServer("");
		// 第三步：需要设置DefaultCollection属性。
		cServer.setDefaultCollection("collection2");
		//创建一个solrQuery对象
		SolrQuery query=new SolrQuery();
		//向solrquery中添加查询条件
		query.setQuery(":");
		//执行查询
		QueryResponse response=cServer.query(query);
		//去查询结果
		SolrDocumentList solrDocumentList=response.getResults();
		System.out.println("总的记录数为："+solrDocumentList.getNumFound());
		//遍历结果并打印
		for(SolrDocument solrDocument:solrDocumentList) {
			System.out.println(solrDocument.get("id"));
			System.out.println(solrDocument.get("item_title"));
			System.out.println(solrDocument.get("item_price"));
		}
	}
}
