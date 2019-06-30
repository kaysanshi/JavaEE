package com.leo.hotel.mapper;

import java.util.List;

import com.leo.hotel.domain.Merchant;
import com.leo.hotel.utils.PageBean;

/**
 * 商家
 * @author leoill
 *TODO
 *2018年11月28日
 */
public interface MerchantMapper {
	/**
	 * 添加
	 * @param merchant
	 * @return
	 */
	int addMerChant(Merchant merchant);
	/**
	 * 获取总的行数
	 * @return
	 */
	int selectCount();
	/**
	 * 获取分页数据
	 * @param pageBean
	 * @return
	 */
	List<Merchant> getPageQueryList(PageBean pageBean);
	/**
	 * 修改
	 * @param merchant
	 * @return
	 */
	int updateMerChant(Merchant merchant);
	/**
	 * 
	 * @return
	 */
	List<Merchant> getListByAjax(String regionid);
	/**
	 * 
	 * @param merchant
	 * @return
	 */
	Merchant checkMerchant(Merchant merchant);

}
