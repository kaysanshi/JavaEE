package com.leo.e3mall.solrj;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;


/**
 * 测试solr服务器单机版
 * @author leoill
 *TODO
 *2019年1月14日
 */
public class TestSolrJ {
	/**
	 * 添加索引库
	 * @throws SolrServerException
	 * @throws IOException
	 */
	@Test
	public void addDoucment() throws SolrServerException, IOException {
		//创建一个SolrServer对象，创建一个连接参数 ：服务器的url
		SolrServer solrServer=new HttpSolrServer("http://39.105.4.254:8080/solr/conection1");
		//创建一个文档对象SolrInputDocument
		SolrInputDocument sdocument=new SolrInputDocument();
		//向文档对象添加域，文档必须包含一个id域，所有的域的名称必须在scheam.xml中配置
		sdocument.addField("id", "doc1");
		sdocument.addField("item_title", "测试商品1");
		sdocument.addField("item_price", 1000);
		//把文档写入索引库中
		solrServer.add(sdocument);
		//提交
		solrServer.commit();
	}
	/**
	 * 删除搜索的文档
	 * @throws SolrServerException
	 * @throws IOException
	 */
	public void deleDoucment() throws SolrServerException, IOException {
		SolrServer solrServer=new HttpSolrServer("http://39.105.4.254:8080/solr/conection1");
		//删除文档
		solrServer.deleteById("doc01");
		//根据查询删除
		solrServer.deleteByQuery("id:doc01");
		//提交
		solrServer.commit();
	}
	/**
	 * 根据删除索引
	 * 
	 * @throws Exception
	 */
	public void deleteDocumentByQuery()throws Exception {
		SolrServer solrServer=new HttpSolrServer("http://39.105.4.254");
				//根据查询删除
		solrServer.deleteByQuery("id:doc01");
				//提交
		solrServer.commit();
	}
	/**
	 * 简单的的查询
	 * @throws Exception
	 */
	public void queryDoucment() throws Exception{
		//，创建solrServer对象
		SolrServer solrServer=new HttpSolrServer("http://39.105.4.154");
		//创建一个solrQuery对象
		SolrQuery query=new SolrQuery();
		//向solrquery中添加查询条件
		query.setQuery(":");
		//执行查询
		QueryResponse response=solrServer.query(query);
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
	/**
	 * 带高亮的查询
	 * @throws Exception
	 */
	public void queryDoucmentWithLighting() throws Exception{
		//，创建solrServer对象
		SolrServer solrServer=new HttpSolrServer("http://39.105.4.154");
		//创建一个solrQuery对象
		SolrQuery query=new SolrQuery();
		//向solrquery中添加查询条件
		query.setQuery("测试");
		//指定默认的搜索域
		query.set("df", "item_keywords");
		//开启并显示高亮
		query.setHighlight(true);
		//高亮显示的域
		query.addHighlightField("item_title");
		query.addHighlightField("<em>");
		query.addHighlightField("</em>");
		//执行查询
		QueryResponse response=solrServer.query(query);
		//去查询结果
		SolrDocumentList solrDocumentList=response.getResults();
		System.out.println("总的记录数为："+solrDocumentList.getNumFound());
		//遍历结果并打印
		for(SolrDocument solrDocument:solrDocumentList) {
			System.out.println(solrDocument.get("id"));
			//取高亮显示
			Map<String, Map<String, List<String>>> higthlighting=response.getHighlighting();
			List<String> list =higthlighting.get(solrDocument.get("id")).get("item_title");
			String itemTitle=null;
			if (list!=null&& list.size()>0) {
				itemTitle=list.get(0);
			}else {
				itemTitle=(String) solrDocument.get("item_title");
			}
			System.out.println(itemTitle);
			System.out.println(solrDocument.get("item_price"));
		}
	
	}
	/**
	 * 查询功能
	 * @throws Exception
	 */
	public void queryDocument() throws Exception {
		//创建一个SolrServer对象
		SolrServer solrServer = new HttpSolrServer("http://192.168.25.154:8080/solr");
		//创建一个查询对象，可以参考solr的后台的查询功能设置条件
		SolrQuery query = new SolrQuery();
		//设置查询条件
//		query.setQuery("阿尔卡特");
		query.set("q","阿尔卡特");
		//设置分页条件
		query.setStart(1);
		query.setRows(2);
		//开启高亮
		query.setHighlight(true);
		query.addHighlightField("item_title");
		query.setHighlightSimplePre("<em>");
		query.setHighlightSimplePost("</em>");
		//设置默认搜索域
		query.set("df", "item_title");
		//执行查询，得到一个QueryResponse对象。
		QueryResponse queryResponse = solrServer.query(query);
		//取查询结果总记录数
		SolrDocumentList solrDocumentList = queryResponse.getResults();
		System.out.println("查询结果总记录数：" + solrDocumentList.getNumFound());
		//取查询结果
		Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
		for (SolrDocument solrDocument : solrDocumentList) {
			System.out.println(solrDocument.get("id"));
			//取高亮后的结果
			List<String> list = highlighting.get(solrDocument.get("id")).get("item_title");
			String title= "";
			if (list != null && list.size() > 0) {
				//取高亮后的结果
				title = list.get(0);
			} else {
				title = (String) solrDocument.get("item_title");
			}
			System.out.println(title);
			System.out.println(solrDocument.get("item_sell_point"));
			System.out.println(solrDocument.get("item_price"));
			System.out.println(solrDocument.get("item_image"));
			System.out.println(solrDocument.get("item_category_name"));
		}
		
	}

}
