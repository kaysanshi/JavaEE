package com.leo.e3mall.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leo.e3mall.common.pojo.SearchItem;
import com.leo.e3mall.common.pojo.SearchResult;

/**
 * 商品搜索的Dao
 * @author leoill
 *TODO
 *2019年1月27日
 */
@Repository
public class SearchDao {
	
	@Autowired
	private SolrServer solrServer;
	/**
	 * 根据条件查询索引库
	 * @param query
	 * @return
	 * @throws SolrServerException 
	 */
	public SearchResult search(SolrQuery query) throws SolrServerException {
		//根据solrserver的query查询
		QueryResponse queryResponse=solrServer.query(query);
		//去查询结果
		SolrDocumentList results = queryResponse.getResults();
		//去查询结果的记录数
		long numFound =results.getNumFound();
		//创建一个返回结果对象
		SearchResult result = new SearchResult();
		result.setRecordCount(numFound);
		//创建一个商品列表对象
		List<SearchItem> itemList = new ArrayList<>();
		//取商品列表
		//取高亮后的结果
		Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
		for (SolrDocument solrDocument : results) {
			//取商品信息
			SearchItem searchItem = new SearchItem();
			searchItem.setCategory_name((String) solrDocument.get("item_category_name"));
			searchItem.setId((String) solrDocument.get("id"));
			searchItem.setImage((String) solrDocument.get("item_image"));
			searchItem.setPrice((long) solrDocument.get("item_price"));
			searchItem.setSell_point((String) solrDocument.get("item_sell_point"));
			//取高亮结果
			List<String> list = highlighting.get(solrDocument.get("id")).get("item_title");
			String itemTitle = "";
			if (list != null && list.size() > 0) {
				itemTitle = list.get(0);
			} else {
				itemTitle = (String) solrDocument.get("item_title");
			}
			searchItem.setTitle(itemTitle);
			//添加到商品列表
			itemList.add(searchItem);
		}
		//把列表添加到返回结果对象中
		result.setItemList(itemList);
		return result;
	}
}
