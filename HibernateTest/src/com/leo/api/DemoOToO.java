package com.leo.api;

import java.nio.channels.SeekableByteChannel;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.leo.domain.IDcard;
import com.leo.domain.People;

/**
 * 一对一主键映射
 * @author leoi555
 *
 */
public class DemoOToO {
	@Test
	public void test() {
		Session session=HibernateUtil.openSession();
		Transaction transaction=session.beginTransaction();
		People people=new People();
		people.setId(1);
		people.setName("1233");
		people.setSex("男");
		IDcard card=new IDcard();
		card.setId(people.getId());
		card.setIDCode("123445566677");
		session.save(card);
		session.save(people);
		transaction.commit();
		session.close();	
	}
}
