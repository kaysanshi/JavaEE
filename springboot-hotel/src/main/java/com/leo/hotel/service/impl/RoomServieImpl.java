package com.leo.hotel.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.leo.hotel.config.UploadConfig;
import com.leo.hotel.domain.Merchant;
import com.leo.hotel.domain.Room;
import com.leo.hotel.mapper.RoomMapper;
import com.leo.hotel.service.RoomService;
import com.leo.hotel.utils.MD5Utils;
import com.leo.hotel.utils.PageBean;
/**
 * 房间操作：
 * @author leoill
 *TODO
 *2018年11月30日
 */
@Service("RoomServieImpl")
@Transactional
public class RoomServieImpl implements RoomService{
	@Autowired
	private RoomMapper roomMapper;
	@Autowired 
	private UploadConfig uploadConfig;
	@Override
	public Map<String, Object> getPageList(Integer page, Integer rows, PageBean pageBean) {
		// TODO Auto-generated method stub
		pageBean.setCurrentPage((page-1)*rows);
		//设置每页页大小
		pageBean.setPageSize(rows);
		//查询总的记录数
		int totalCount=roomMapper.selectCount();
		System.out.println("总的记录数："+totalCount);
		//设置总页数
		pageBean.setTotal(totalCount);
		//分页
		List<Merchant> listdata=roomMapper.getPageQueryList(pageBean);
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
	public Map<String, Object> add(Room room, MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<>();
		room.setMerchantid((Integer)request.getSession().getAttribute("loginUserid"));
		room.setStutscode(Room.STUTS_YS);
		//获取文件的原名
		String fileName=file.getOriginalFilename();
		System.out.println(fileName);
		//转换后的文件名
		String fileNewName=UUID.randomUUID().toString()+fileName;
		File dest=new File(uploadConfig.getPimgPath()+fileNewName);
		System.out.println(dest.exists());
		if (!dest.getParentFile().exists()){
			dest.getParentFile().mkdirs();
			try {
				dest.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			file.transferTo(dest);
			String filepath=uploadConfig.getPimgPath()+fileNewName;
			room.setRoompicture(filepath);
						System.out.println("filepath:"+uploadConfig.getPimgPath()+fileNewName);
			//
			if (roomMapper.add(room)> 0){
				map.put("code", "0");
				map.put("msg", "添加成功");
				map.put("data", null);
				System.out.println(map.get("msg"));
				return map;
			} else {
				map.put("code", "1");
				map.put("msg", "添加失败");
				map.put("data", null);
				System.out.println("aaaa");
				System.out.println(map.get("msg"));
				return map;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	@Override
	public Map<String, Object> update(Room room, MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<>();
		room.setMerchantid((Integer)request.getSession().getAttribute("loginUserid"));
		room.setStutscode(Room.STUTS_YS);
		//获取文件的原名
		String fileName=file.getOriginalFilename();
		System.out.println(fileName);
		//转换后的文件名
		String fileNewName=UUID.randomUUID().toString()+fileName;
		File dest=new File(uploadConfig.getPimgPath()+fileNewName);
		System.out.println(dest.exists());
		if (!dest.getParentFile().exists()){
			dest.getParentFile().mkdirs();
			try {
				dest.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			file.transferTo(dest);
			String filepath=uploadConfig.getPimgPath()+fileNewName;
			room.setRoompicture("/imgs/"+fileNewName);
						System.out.println("filepath:"+filepath);
			//
			if (roomMapper.update(room)> 0){
				map.put("code", "0");
				map.put("msg", "修改成功");
				map.put("data", null);
				System.out.println(map.get("msg"));
				return map;
			} else {
				map.put("code", "1");
				map.put("msg", "修改失败");
				map.put("data", null);
				System.out.println("aaaa");
				System.out.println(map.get("msg"));
				return map;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	@Override
	public Map<String, Object> getRoomListByAjax(String merchantid,HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<>();
		List<Room> list=roomMapper.getListByAjax(merchantid);
		if (list.size()>0) {
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
	@Override
	public Map<String, Object> delete(String ids) {
		// TODO Auto-generated method stub
		Map<String , Object> map=new HashMap<>();
		if (Strings.isNotBlank(ids)) {
			String[] rids=ids.split(",");
			int i=0;
			//循环执行delete 语句
			for(String id:rids) {
				i=roomMapper.deleteBatch(id);
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

}
