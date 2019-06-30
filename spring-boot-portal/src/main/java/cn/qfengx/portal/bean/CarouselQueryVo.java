package cn.qfengx.portal.bean;

public class CarouselQueryVo {
	private Integer start;
	private Integer limit;
	private Integer page;
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	@Override
	public String toString() {
		return "CarouselQueryVo [start=" + start + ", limit=" + limit + ", page=" + page + "]";
	}
}
