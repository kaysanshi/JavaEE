package com.leo.bos.web.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.leo.bos.domain.BcRegion;
import com.leo.bos.domain.BcSubarea;
import com.leo.bos.service.ISubareaService;
import com.leo.bos.utils.FileUtils;
import com.leo.bos.web.action.base.BaseAction;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * 分区管理
 * @author leoi555
 *
 */
@Controller
@Scope("prototype")
public class SubareaAction extends BaseAction<BcSubarea>{
	@Resource
	private ISubareaService sbService;
	
	
	/**
	 * 添加分区
	 */
	public String add() {
		sbService.save(model);
		return "list";
		
	}

	/**
	 * 分页查询
	 * @throws IOException 
	 */
	public String pageQuery() throws IOException{
		DetachedCriteria dc = pageBean.getDetachedCriteria();
		//动态添加过滤条件
		String addresskey = model.getAddresskey();
		if(StringUtils.isNotBlank(addresskey)){
			//添加过滤条件，根据地址关键字模糊查询
			//Restrictions相当于条select * from xxx where addresskey like xxx;
			dc.add(Restrictions.like("addresskey", "%"+addresskey+"%"));
		}
		
		BcRegion region = model.getBcRegion();
		if(region != null){
			String province = region.getProvince();
			String city = region.getCity();
			String district = region.getDistrict();
			dc.createAlias("region", "r");//设置属性名别名相当于sql语句中的别名
			if(StringUtils.isNotBlank(province)){
				//添加过滤条件，根据省份模糊查询-----多表关联查询，使用别名方式实现
				//参数一：分区对象中关联的区域对象属性名称
				//参数二：别名，可以任意
				dc.add(Restrictions.like("r.province", "%"+province+"%"));
			}
			if(StringUtils.isNotBlank(city)){
				//添加过滤条件，根据市模糊查询-----多表关联查询，使用别名方式实现
				//参数一：分区对象中关联的区域对象属性名称
				//参数二：别名，可以任意
				dc.add(Restrictions.like("r.city", "%"+city+"%"));
			}
			if(StringUtils.isNotBlank(district)){
				//添加过滤条件，根据区模糊查询-----多表关联查询，使用别名方式实现
				//参数一：分区对象中关联的区域对象属性名称
				//参数二：别名，可以任意
				dc.add(Restrictions.like("r.district", "%"+district+"%"));
			}
		}
		sbService.pageQuery(pageBean);
		//去掉多于的属性
		JsonConfig jsonConfig=new JsonConfig();
		//指定哪些不需要转json
		jsonConfig.setExcludes(new String[] {"currentPage","detachedCriteria","pageSize","bcDecidedzone","bcSubareas"});
		//jsonObjectd中的方法
		String json=JSONObject.fromObject(pageBean).toString();
		System.out.println(json.toString());
		//写回到前台
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		//print.write
		ServletActionContext.getResponse().getWriter().print(json);
		return NONE;
	}
	
	/**
	 * 分区数据导出功能
	 * @throws IOException 
	 */
	public String exportXls() throws IOException{
		//第一步：查询所有的分区数据
		List<BcSubarea> list = sbService.findAll();
		
		//第二步：使用POI将数据写到Excel文件中
		//在内存中创建一个Excel文件
		HSSFWorkbook workbook = new HSSFWorkbook();
		//创建一个标签页
		HSSFSheet sheet = workbook.createSheet("分区数据");
		//创建标题行(第一行的数据)
		HSSFRow headRow = sheet.createRow(0);
		//设置行中的单元格
		headRow.createCell(0).setCellValue("分区编号");
		headRow.createCell(1).setCellValue("开始编号");
		headRow.createCell(2).setCellValue("结束编号");
		headRow.createCell(3).setCellValue("位置信息");
		headRow.createCell(4).setCellValue("省市区");
		//循环数据的读取
		for (BcSubarea subarea : list) {
			HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);//从第二行开始写入数据
			dataRow.createCell(0).setCellValue(subarea.getId());//依次得到每个单元格属性
			dataRow.createCell(1).setCellValue(subarea.getStartnum());
			dataRow.createCell(2).setCellValue(subarea.getEndnum());
			dataRow.createCell(3).setCellValue(subarea.getPosition());
			//拼接一个省市区
			dataRow.createCell(4).setCellValue(subarea.getBcRegion().getName());
			//循环一行然后继续循环到下一行中
		}
		
		//第三步：使用输出流进行文件下载（一个流、两个头）
		
		String filename = "分区数据.xls";
		//动态获取contentType
		String contentType = ServletActionContext.getServletContext().getMimeType(filename);
		ServletOutputStream out = ServletActionContext.getResponse().getOutputStream();
		//在不动态获取数据的类型时就要这样指定他的类型
		//ServletActionContext.getResponse().setContentType("application/vnd.ms-excel");
		ServletActionContext.getResponse().setContentType(contentType);
		
		//获取客户端浏览器类型。浏览器发出的头
		String agent = ServletActionContext.getRequest().getHeader("User-Agent");
		//处理文件名
		filename = FileUtils.encodeDownloadFilename(filename, agent);
		ServletActionContext.getResponse().setHeader("content-disposition", "attachment;filename="+filename);
		workbook.write(out);//用POI提供的写入
		return NONE;
	}
	
	/**
	 * 查询所有未关联到定区的分区，返回json
	 * @throws IOException 
	 */
	public String list() throws IOException{
		List<BcSubarea> list = sbService.findListNotAssociation();
		//去掉多于的属性
		JsonConfig jsonConfig=new JsonConfig();
		//指定哪些不需要转json
		jsonConfig.setExcludes(new String[]{"bcDecidedzone"," bcRegion"});
		//jsonObjectd中的方法
		String json=JSONObject.fromObject(list).toString();
		System.out.println(json.toString());
		//写回到前台
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		//print.write
		ServletActionContext.getResponse().getWriter().print(json);
		return NONE;
	}
	
	/**
	 * 获得所有的分区分布图
	 * @return
	 * @throws IOException 
	 */
	public String findSubarea() throws IOException {
		List<Object> list=sbService.findSubareaGroupByProvince();
		this.javaToJson(list, new String[]{});
		return NONE;
		
	}
	
}
