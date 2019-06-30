package com.leo.e3mall.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leo.e3mall.common.pojo.EasyUiTreeNote;
import com.leo.e3mall.content.service.ContentCatgoryService;
import com.leo.e3mall.utils.E3Result;

/**
 * 内容分类管理 这是调用的另一个服务，是不同的工程下发布的只有使用dubbo提供对外开放的服务，
 * 然后就可以访问，启动一个web工程必须启动三个这样才能够发布服务。
 * @author leoill
 *TODO
 *2019年1月8日
 */
@Controller
@RequestMapping("/content/category")
public class ContentCatController {
	
	@Autowired
	private ContentCatgoryService contentCategoryService;
	/**
	 * 获得tree结构
	 * @param parentid
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public List<EasyUiTreeNote> getContentCatList(@RequestParam(name="id",defaultValue="0")Long parentid) {
		List<EasyUiTreeNote> list = contentCategoryService.getContentCatList(parentid);
		return list;	
	}
	/**
	 * 添加分类节点
	 * @param parentId
	 * @param name
	 * @return
	 */
	@RequestMapping("/create")
	@ResponseBody
	public E3Result createContentCategory(Long parentId,String name) {
		return contentCategoryService.addContentCategory(parentId, name);
		
	}
	/**
	 * 删除节点时：
	 * 如果删除的是叶子节点：判断父节点是否存在子节点
	 * 根据id查询出是否有父节点，如果有查询他下面的子节点，
	 * 
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public E3Result deleteContentCategory(Long id) {
		
		return null;
		
	}
	/**
	 * 修改节点
	 */
	@RequestMapping("/update")
	@ResponseBody
	public E3Result updateContentCategory(Long id,String name) {
		return null;
		
	}
}
