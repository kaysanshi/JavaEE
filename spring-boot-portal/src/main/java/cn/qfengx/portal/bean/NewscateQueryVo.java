package cn.qfengx.portal.bean;

public class NewscateQueryVo {
	private Integer page;
	private Integer limit;
	private Integer start;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	@Override
	public String toString() {
		return "ProductcateQueryVo [page=" + page + ", limit=" + limit + ", start=" + start + "]";
	}
}
