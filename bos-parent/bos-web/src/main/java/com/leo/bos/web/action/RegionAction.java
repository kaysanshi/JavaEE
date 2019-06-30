package com.leo.bos.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts2.ServletActionContext;
import org.aspectj.bridge.MessageWriter;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.leo.bos.domain.BcRegion;
import com.leo.bos.domain.BcStaff;
import com.leo.bos.service.IRegionService;
import com.leo.bos.utils.PageBean;
import com.leo.bos.utils.PinYin4jUtils;
import com.leo.bos.web.action.base.BaseAction;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
/**
 * 区域管理
 * @author leoi555
 *
 */

@Scope("prototype")
@Controller
public class RegionAction extends BaseAction<BcRegion> {
	private File regionFile;//属性驱动，接收上传的文件
	private int rows;
	private int page;
	private String q;
	/**
	 * @return the q
	 */
	public String getQ() {
		return q;
	}
	/**
	 * @return the rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(int rows) {
		this.rows = rows;
	}

	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}
	@Autowired
	private IRegionService regionService;
	/**
	 * @return the regionFile
	 */
	
	public File getRegionFile() {
		return regionFile;
	}

	/**
	 * @param regionFile the regionFile to set
	 */
	public void setRegionFile(File regionFile) {
		this.regionFile = regionFile;
	}
	/**
	 * 区域导入：通过文件上传到服务器中
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public String importXls() throws FileNotFoundException, IOException {
		List<BcRegion> list=new ArrayList<>();
		System.out.println(regionFile);
		//解析是通过poi技术
		//包装excel
		HSSFWorkbook workbook=new HSSFWorkbook(new FileInputStream(regionFile));
		//获得标签页
		HSSFSheet sheet=workbook.getSheetAt(0);
		//获得标签页通过获得指定名称的sheet
		//HSSFSheet sheet2=workbook.getSheet("sheet1");
		for (Row row : sheet) {
			//跳过这个头
			int rowNum=row.getRowNum();
			if (rowNum==0) {
				continue;
			}
			String id=row.getCell(0).getStringCellValue();//获得第一列的值
			String province=row.getCell(1).getStringCellValue();//获得第二列值
			String city=row.getCell(2).getStringCellValue();//
			String district=row.getCell(3).getStringCellValue();//
			String postcode=row.getCell(4).getStringCellValue();//获得第一列的值
			//包装一个区域对象
			BcRegion region=new BcRegion(id,province,city,district,postcode, null, null, null);
			
			//简码： HBSJZQX
			province=province.substring(0, province.length()-1);
			city=city.substring(0, city.length()-1);
			district=district.substring(0, district.length()-1);
			String info=province+city+district;
			System.out.println(info);
			
			String[] headByString = PinYin4jUtils.getHeadByString(info);
			System.out.println(headByString);
			//简码
			String shortcode=StringUtils.join(headByString);
			System.out.println(shortcode);
			//城市编码--拼音编码
			String citycode=PinYin4jUtils.hanziToPinyin(city);
			System.out.println(citycode);
			region.setCitycode(citycode);
			region.setShortcode(shortcode);
			list.add(region);
		}
		//批量保存
		regionService.saveBatch(list);
		return NONE;
	}
	/**
	 * 数据分页
	 * @return
	 * @throws IOException 
	 */
	public String pageQuery() throws IOException {
		PageBean  pageBean=new PageBean();
		pageBean.setCurrentPage(page);
		pageBean.setPageSize(rows);
		//创建离线查询对象
		DetachedCriteria sCriteria=DetachedCriteria.forClass(BcRegion.class);
		pageBean.setDetachedCriteria(sCriteria);
		regionService.pageQuery(pageBean);
		//将pagebean转换为json通过输出流写会到前台
		//jsonObject---将单一的对象转为json
		//jsonArray---将数组或集合转为json
		//去掉多于的属性
		JsonConfig jsonConfig=new JsonConfig();
		//指定哪些不需要转json
		jsonConfig.setExcludes(new String[] {"currentPage","detachedCriteria","pageSize","bcSubareas"});
		//jsonObjectd中的方法
		String json=JSONObject.fromObject(pageBean).toString();
		System.out.println(json);
		//写回到前台
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		//print.write
		ServletActionContext.getResponse().getWriter().print(json);
		
		return NONE;
	}
	/**
	 * 获取所有的列表数据(区域)
	 * @return
	 * @throws IOException 
	 */
	public String list() throws IOException {
		List<BcRegion> list=null;
		if (StringUtils.isNotBlank(q)) {
			list=regionService.getlistByQ(q);         
		}else {
			list=regionService.getlist();
		}
		//将pagebean转换为json通过输出流写会到前台
		//jsonObject---将单一的对象转为json
		//jsonArray---将数组或集合转为json
		//去掉多于的属性
		JsonConfig jsonConfig=new JsonConfig();
		//指定哪些不需要转json
		jsonConfig.setExcludes(new String[] {"subareas"});
		//jsonObjectd中的方法
		String json=JSONArray.fromObject(list).toString();
		System.out.println(json);
		//写回到前台
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		//print.write
		ServletActionContext.getResponse().getWriter().print(json);
		return NONE;
	}
}
