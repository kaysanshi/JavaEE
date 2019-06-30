package com.leo.bean;

import java.io.Serializable;
import java.util.Iterator;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

/**
 * 拦截器：
 * @author leoi555
 *
 */
public class Myinterceptor  extends EmptyInterceptor{
	private int updates;
	private int creates;
	private int loads;
	/**
	 * 
	 * @param entity
	 * @param id
	 * @param state
	 * @param propertyNames
	 * @param types
	 */
	public void oneDelete(Object entity,
            Serializable id,
            Object[] state,
            String[] propertyNames,
            Type[] types) {
		
	}
	/**
	 *更新
	 */
	public boolean onFlushDirty(Object enttity, Serializable id,
			Object[] currentState,
			Object[] previousState,
			String[] propertyNames,
			Type[] types) {
		if (enttity instanceof Employee) {
			System.out.println("Update Operation");
			return true;
		}
		return false;
	}
	/**
	 * 
	 */
	public boolean onLoad(Object entity,
            Serializable id,
            Object[] state,
            String[] propertyNames,
            Type[] types) {
			// do nothing
			return true;
	}
	/**
	 * 保存
	 * @param entity
	 * @param id
	 * @param state
	 * @param propertyNames
	 * @param types
	 * @return
	 */
	public boolean oneSave(Object entity,
            Serializable id,
            Object[] state,
            String[] propertyNames,
            Type[] types) {
		if (entity instanceof Employee) {
			System.out.println("create Operation");
			return true;
		}
		return false;
	}
	/**
	 * 
	 */
	public void preFlush(Iterator iterator) {
	      System.out.println("preFlush");
	   }
	  /**
	   * 
	   */
	 public void postFlush(Iterator iterator) {
	      System.out.println("postFlush");
	   }	
}
