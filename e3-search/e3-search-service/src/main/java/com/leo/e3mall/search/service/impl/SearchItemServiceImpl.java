package com.leo.e3mall.search.service.impl;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;

import com.leo.e3mall.common.pojo.SearchItem;
import com.leo.e3mall.common.pojo.SearchResult;
import com.leo.e3mall.search.SearchDao;
import com.leo.e3mall.search.mapper.ItemMapper;
import com.leo.e3mall.search.service.SearchItemService;
import com.leo.e3mall.utils.E3Result;
/**
 * 索引库的维护
 * @author leoill
 *TODO
 *2019年1月14日
 * @param <ItemMapper>
 */
public class SearchItemServiceImpl implements SearchItemService {
	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private SolrServer solrServer;
	@Autowired
	private SearchDao searchDao;
	private String DEFAULT_FIELD="item_title";
	@Override
	public E3Result importAllItem() {
		// TODO Auto-generated method stub
		try {
		//查询商品列表
		List<SearchItem> itemList=itemMapper.getItemList();
		//遍历商品列表
		for (SearchItem searchItem : itemList) {
			//创建文档的对象
			SolrInputDocument document=new SolrInputDocument();
			//向文档对象添加索引库
			//把文档对象写入索引库	
			document.addField("id","test01");
			document.addField("id", searchItem.getId());
			document.addField("item_title", searchItem.getTitle());
			document.addField("item_sell_point", searchItem.getSell_point());
			document.addField("item_price", searchItem.getPrice());
			document.addField("item_image", searchItem.getImage());
			document.addField("item_category_name", searchItem.getCategory_name());
			//写入索引库
			solrServer.add(document);
			}
			//提交
			solrServer.commit();
			//返回成功
			return E3Result.ok();
		} catch (SolrServerException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return E3Result.build(500, "商品导入失败");
		}
		
	}
	/**
	 * service些写完需要发布服务
	 */
	@Override
	public SearchResult search(String keyword, Integer page, Integer rows) throws Exception {
		// TODO Auto-generated method stub
		//创建一个SolrQuery对象
				SolrQuery query = new SolrQuery();
				//设置查询条件
				query.setQuery(keyword);
				//设置分页条件
				query.setStart((page - 1) * rows);
				//设置rows
				query.setRows(rows);
				//设置默认搜索域
				query.set("df", DEFAULT_FIELD);
				//设置高亮显示
				query.setHighlight(true);
				query.addHighlightField("item_title");
				query.setHighlightSimplePre("<em style=\"color:red\">");
				query.setHighlightSimplePost("</em>");
				//执行查询
				SearchResult searchResult = searchDao.search(query);
				//计算总页数
				long recourdCount = searchResult.getRecordCount();
				int pages = (int) (recourdCount / rows);
				if (recourdCount % rows > 0) pages++;
				//设置到返回结果
				searchResult.setTotalPages(pages);
				return searchResult;
			}

}
