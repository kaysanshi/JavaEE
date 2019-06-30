package com.leo.bos.serviceImpl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.crm.ICustomerService;
import com.leo.bos.dao.IDecidedZoneDao;
import com.leo.bos.dao.INoticebillDao;
import com.leo.bos.dao.IWorkbillDao;
import com.leo.bos.domain.BcDecidedzone;
import com.leo.bos.domain.QpNoticebill;
import com.leo.bos.domain.QpWorkbill;
import com.leo.bos.domain.User;
import com.leo.bos.service.INoticebillService;
import com.leo.bos.utils.SessionUtils;

/**
 * 
 * @author leoi555
 *
 */
@Service
@Transactional
public class INoticebillServiceImpl implements INoticebillService{
	@Autowired
	private INoticebillDao noticeDao;
	//这里项目启动不成功
	//@Autowired
	//private ICustomerService customerService;// customerservice
	@Autowired
	private IDecidedZoneDao decidedZoneDao;
	@Autowired
	private IWorkbillDao workBillDao;
	@Override
	public void add(QpNoticebill model) {
		// TODO Auto-generated method stub
		User user=SessionUtils.getLoginUser();
		model.setUser(user);//设置当前登录用户
		noticeDao.save(model);
		//获取取件地址
		String pickaddress =model.getPickaddress();
		//远程调用Crm根据取件地址查询定区id；
		//String decideId=customerService.findDecidedzoneIdByAddress(pickaddress);
		//判断是否为空
//		if (decideId!=null) {
//			//查询定区id对象可以完成自动分单
//			BcDecidedzone decidedzone=decidedZoneDao.findById(decideId);
//			//设置分单类型
//			model.setOrdertype(QpNoticebill.ORDETYPE_AUTO);
//			//为取派员产生一个工单
//			QpWorkbill workbill=new QpWorkbill();
//			workbill.setAttachbilltimes(0);//设置追单次数
//			//获取系统时间
//			workbill.setBuildtime(new Timestamp(System.currentTimeMillis()));
//			workbill.setQpNoticebill(model);//工单关联页面通知
//			workbill.setPickstate(workbill.PICKSTATE_NO);//取件状态
//			workbill.setRemark(model.getRemark());//备注信息
//			workbill.setType(workbill.TYPE_1);//工单类型
//			workBillDao.save(workbill);
//			//调用短信平台发送短信
//			
//		}else {
//			//设置分单类型人工
//			model.setOrdertype(QpNoticebill.ORDETYPE_MAN);
//			
//		}
	}
}
