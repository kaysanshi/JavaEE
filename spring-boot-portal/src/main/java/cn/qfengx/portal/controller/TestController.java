package cn.qfengx.portal.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 模拟测试数据返回
 * <p>Title: TestController</p>
 * <p>Description: </p>
 * <p>Domain: qfengx.cn</p>
 * @author Qfeng
 * @date 2018年11月8日 下午7:51:24
 * @version 1.0
 *
 */
@Controller
@RequestMapping("/test")
public class TestController {
	
	private Integer random(Integer start, Integer end) { //[start, end)之间的随机数
		double num = Math.random() * (end - start);
		return start + (int) num;
	}
	
	@RequestMapping("/accesslog")
	@ResponseBody
	public Map<String, Object> accesslog() {
		Map<String, Object> map = new HashMap<>();
	
		map.put("code", "0");
		map.put("count", 8);
		map.put("msg", "获取成功");
		List<Alog> list = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Alog alog = new Alog();
			alog.setTime(new Date());
			alog.setIp("1.2.3." + i);
			alog.setUrl("/demo/table.html?i=" + i);
			list.add(alog);
		}
		map.put("data", list);
		return map;
	}
	
	@RequestMapping("/pcate/list")
	@ResponseBody
	public Map<String, Object> pcateList() {
		Map<String, Object> map = new HashMap<>();
		
		map.put("code", "0");
		map.put("msg", "获取成功");
		List<Pcate> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Pcate pcate = new Pcate();
			pcate.setId(i);
			pcate.setPid(-1);
			pcate.setName("pcate" + i);
			pcate.setPname("无");
			list.add(pcate);
		}
		for (int i = 10; i < 20; i++) {
			Pcate pcate = new Pcate();
			pcate.setId(i);
			pcate.setPid(random(0, 10));
			pcate.setName("pcate" + i);
			pcate.setPname(list.get(pcate.getPid()).getName());
			list.add(pcate);
		}
		map.put("data", list);
		map.put("count", list.size());
		return map;
	}
	
	@RequestMapping("/p/list")
	@ResponseBody
	public Map<String, Object> plist() {
		Map<String, Object> map = new HashMap<>();
		
		map.put("code", "0");
		map.put("msg", "获取成功");
		List<Product1> list = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			Product1 p = new Product1();
			p.setId(i);
			p.setName("product" + i);
			p.setClick(i);
			p.setAddtime(new Date());
			p.setTitle("title" + i);
			p.setDetail("detail" + i);
			p.setPcid(i);
			p.setPcname("pcname" + i);
			list.add(p);
		}
		map.put("data", list);
		map.put("count", list.size());
		return map;
	}
	
	@RequestMapping("/news/list")
	@ResponseBody
	public Map<String, Object> nlist() {
		Map<String, Object> map = new HashMap<>();
		
		map.put("code", "0");
		map.put("msg", "获取成功");
		List<tNews> list = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			tNews p = new tNews();
			
			p.setId(i);
			p.setClick(random(0, 100));
			p.setDetail("detail" + i);
			p.setPcname("pcname" + i);
			p.setTitle("title" + i);
			p.setAddtime(new Date());
			
			list.add(p);
		}
		map.put("data", list);
		map.put("count", list.size());
		
		return map;
	}
	
	@RequestMapping("/case/list")
	@ResponseBody
	public Map<String, Object> clist() {
		Map<String, Object> map = new HashMap<>();
		
		map.put("code", "0");
		map.put("msg", "获取成功");
		List<Case> list = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			Case c = new Case();
			
			c.setId(i);
			c.setClick(random(0, 100));
			c.setTitle("title" + i);
			c.setDetail("detail" + i);
			c.setAddtime(new Date());
		
			
			list.add(c);
		}
		map.put("data", list);
		map.put("count", list.size());
		
		return map;
	}
	
}
class Case {
	private Integer id;
	private String title;
	private String detail;
	private Integer click;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
	private Date addtime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Integer getClick() {
		return click;
	}
	public void setClick(Integer click) {
		this.click = click;
	}
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	@Override
	public String toString() {
		return "Case [id=" + id + ", title=" + title + ", detail=" + detail + ", click=" + click + ", addtime="
				+ addtime + "]";
	}
}
class tNews {
	private Integer id;
	private String title;
	private String detail;
	private String pcname;
	private Integer click;
	
	
	public Integer getClick() {
		return click;
	}

	public void setClick(Integer click) {
		this.click = click;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
	private Date addtime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getPcname() {
		return pcname;
	}

	public void setPcname(String pcname) {
		this.pcname = pcname;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", detail=" + detail + ", pcname=" + pcname + ", addtime="
				+ addtime + "]";
	}
	
	
}

class Product1 {
	private Integer id;
	private String name;
	private String title;
	private String detail;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
	private Date addtime;
	private Integer click;
	private Integer pcid;
	private String pcname;
	
	private String imgurl;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	public Integer getClick() {
		return click;
	}
	public void setClick(Integer click) {
		this.click = click;
	}
	public Integer getPcid() {
		return pcid;
	}
	public void setPcid(Integer pcid) {
		this.pcid = pcid;
	}
	public String getPcname() {
		return pcname;
	}
	public void setPcname(String pcname) {
		this.pcname = pcname;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", title=" + title + ", detail=" + detail + ", addtime="
				+ addtime + ", click=" + click + ", pcid=" + pcid + ", pcname=" + pcname + "]";
	}
}
class Pcate {
	private Integer id;
	private Integer pid;
	private String name;
	private String pname;
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Pcate [id=" + id + ", pid=" + pid + ", name=" + name + ", pname=" + pname + "]";
	}
}

class Alog {
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
	private Date time;
	private String ip;
	private String url;
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Alog [time=" + time + ", ip=" + ip + ", url=" + url + "]";
	}
}
