package com.leo.e3mall.search.service;
/**|
 * 商品搜索
 * @author leoill
 *TODO
 *2019年1月14日
 */

import com.leo.e3mall.common.pojo.SearchResult;
import com.leo.e3mall.utils.E3Result;


public interface SearchItemService {
	/**
	 * 批量导入商品
	 * @return
	 */
	E3Result  importAllItem();
	/**
	 * 商品搜索
	 * @param keyword
	 * @param page
	 * @param sEARCH_RESULT_ROWS
	 * @return
	 */
	SearchResult search(String keyword, Integer page, Integer rows)throws Exception;
}
