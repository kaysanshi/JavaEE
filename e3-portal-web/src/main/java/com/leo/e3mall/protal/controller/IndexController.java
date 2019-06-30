package com.leo.e3mall.protal.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leo.e3mall.content.service.ContentService;
import com.leo.e3mall.pojo.Content;

/**
 * 首页展示Controller
 * @author leoill
 *TODO
 *2019年1月7日
 */
@Controller
public class IndexController {
	
	@Autowired
	private ContentService contentService;
	
	@Value("${CONTENT_LUNBO_ID}")
	private Long CONTENT_LUNBO_ID;
	/**
	 * 这里的是写的首页(轮播)的功能
	 * @param model
	 * @return
	 */
	//handler是指的一个方法：
	@RequestMapping("/index")
	public String showIndex(Model model) {
		List<Content> list = contentService.getContentListByCid(CONTENT_LUNBO_ID);
		//广告1前面的用jsp然后接受foreach的遍历
		model.addAttribute("ad1List", list);
		return "index";
	}
	

}
