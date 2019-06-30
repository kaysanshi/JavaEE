package com.leo.e3mall.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leo.e3mall.content.service.ContentService;
import com.leo.e3mall.pojo.Content;
import com.leo.e3mall.utils.E3Result;

/**
 * 内容管理
 * @author leoill
 *TODO
 *2019年1月10日
 */
@Controller
@RequestMapping("/content")
public class ContentController {
	@Autowired
	private ContentService contentService;
	/**
	 * 内容添加
	 * @param content
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public E3Result addContent(Content content) {
		return contentService.addContent(content);
	}
}
