package cn.qfengx.portal.bean;

public class Productcate {
	private Integer id;
	private Integer pid;
	private String name;
	
	private String pcname;
	
	public String getPcname() {
		return pcname;
	}
	public void setPcname(String pcname) {
		this.pcname = pcname;
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
		return "Productcate [id=" + id + ", pid=" + pid + ", name=" + name + ", pcname=" + pcname + "]";
	}
}
