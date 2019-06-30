package cn.qfengx.portal.bean;

public class Newscate {
	private Integer id;
	private Integer pid;
	private String name;
	
	private String pname;

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

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	@Override
	public String toString() {
		return "Newscate [id=" + id + ", pid=" + pid + ", name=" + name + ", pname=" + pname + "]";
	}
}
