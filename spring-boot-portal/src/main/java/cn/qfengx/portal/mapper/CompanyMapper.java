package cn.qfengx.portal.mapper;

import java.util.List;

import cn.qfengx.portal.bean.Company;
import cn.qfengx.portal.bean.CompanyQueryV;

public interface CompanyMapper {

	public Company query();

	public int add(Company company);

	public List<Company> queryall(CompanyQueryV nvo);

	public int querySum(CompanyQueryV nvo);

	public int update(Company company);

	public void delete(Integer[] ids);

}
