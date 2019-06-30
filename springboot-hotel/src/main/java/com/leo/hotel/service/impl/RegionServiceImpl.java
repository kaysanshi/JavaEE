package com.leo.hotel.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leo.hotel.domain.Region;
import com.leo.hotel.domain.User;
import com.leo.hotel.mapper.RegionMapper;
import com.leo.hotel.service.RegionService;
import com.leo.hotel.utils.PageBean;
import com.leo.hotel.utils.PinYin4jUtils;

/**
 * 区域
 * @author leoill
 *TODO
 *2018年11月29日
 */
@Service(value="RegionServiceImpl")
@Transactional
public class RegionServiceImpl implements RegionService{
	@Autowired
	private RegionMapper regionMapper;
	@Autowired
	private PinYin4jUtils pyinUtils;
	@Override
	public Map<String, Object> getList(Integer page, Integer rows, PageBean pageBean) {
		// TODO Auto-generated method stub
		//设置开始当前页
				pageBean.setCurrentPage((page-1)*rows);
				//设置每页页大小
				pageBean.setPageSize(rows);
				//查询总的记录数
				int totalCount=regionMapper.selectCount();
				System.out.println("总的记录数："+totalCount);
				//设置总页数
				pageBean.setTotal(totalCount);
				//分页
				//
				List<Region> listdata=regionMapper.getPageQueryList(pageBean);
				pageBean.setRows(listdata);
				System.out.println("数据"+listdata);
				Map<String, Object> map=new HashMap<>();
				if (!listdata.isEmpty()) {
					map.put("total", pageBean.getTotal());
					map.put("rows", pageBean.getRows());
					return map;
				}else {
					map.put("msg", "获取失败");
					map.put("code", "0");
					map.put("data", null);
					return map;
				}
	}

	@Override
	public Map<String, Object> update(Region region, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<String, Object> res=new HashMap<>();
		if(regionMapper.update(region)>0) {
			res.put("code", "0");
			res.put("msg", "修改成功");
			res.put("data", null);
		} else {
			res.put("code", "1");
			res.put("msg", "修改失败");
			res.put("data", null);
		}
		return res;
	}

	@Override
	public Map<String, Object> addRegion(Region region, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<String, Object> res=new HashMap<>();
		String ssq=region.getProvince()+region.getCity()+region.getDistrict();
		String[] headArray =pyinUtils. getHeadByString(ssq); // 获得每个汉字拼音首字母
		System.out.println(Arrays.toString(headArray));
		if(regionMapper.add(region)>0) {
			res.put("code", "0");
			res.put("msg", "修改成功");
			res.put("data", null);
		} else {
			res.put("code", "1");
			res.put("msg", "修改失败");
			res.put("data", null);
		}
		return res;
	}
	@Override
	public Map<String, Object> deleteRegion(String ids, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<String , Object> map=new HashMap<>();
		if (Strings.isNotBlank(ids)) {
			String[] userids=ids.split(",");
			int i=0;
			//循环执行delete 语句
			for(String id:userids) {
				i=regionMapper.delete(id);
			}
			if (i>0) {
				map.put("code", '0');
				map.put("message", "删除成功");
				map.put("data", null);
			}else {
				map.put("code", '1');
				map.put("message", "删除失败");
				map.put("data", null);
			}
 		}
		return map;
	}

	@Override
	public Map<String, Object> getReionListByAjax(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<>();
		List<Region> list=regionMapper.getReionListByAjax();
		if (!list.isEmpty()) {
			map.put("msg", "获取成功");
			map.put("code", "0");
			map.put("data", list);
		}else {
			map.put("msg", "获取失败");
			map.put("code", "0");
			map.put("data", null);
		}
		return map;
	}
	
}
