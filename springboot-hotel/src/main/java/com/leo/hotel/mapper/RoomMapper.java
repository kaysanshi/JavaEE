package com.leo.hotel.mapper;

import java.util.List;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.leo.hotel.domain.Merchant;
import com.leo.hotel.domain.Room;
import com.leo.hotel.utils.PageBean;

public interface RoomMapper {

	int selectCount();

	List<Merchant> getPageQueryList(PageBean pageBean);

	int add(Room room);

	int update(Room room);

	List<Room> getListByAjax(String merchantid);

	int deleteBatch(String id);

}
