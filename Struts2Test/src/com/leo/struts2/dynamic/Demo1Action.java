package com.leo.struts2.dynamic;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * POJO：不用继承任何父类
 * 入侵的小
 * @author leoi555
 *
 */
public class Demo1Action {

}
/**
 * 实现Action
 * Action中有预先定义得用于传递信息
 **/
class Demo2Action implements Action{

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
/**
 * 通过继承ActionSupport
 * 
 **/
class Demo3Action extends ActionSupport{

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
	
}
