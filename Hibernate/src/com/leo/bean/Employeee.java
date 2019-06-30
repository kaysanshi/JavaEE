package com.leo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 使用注释的形式来实现
 * @author leoi555
 *
 */

@Entity
@Table(name = "EMPLOYEE")
public class Employeee {
	
	/**
	 * @entity注释标志这这个类为一个实体的bean所以类必须提供默认的构造函数
	 * @Table允许表明表的详细信息保存实体在数据库中持续存在
	 * @Id 和 @GeneratedValue 注释每一个实体 bean 都有一个主键，你在类中可以用 @Id 来进行注释。主键可以是一个字段或者是多个字段的组合，这取决于你的表的结构。
，@Id 注释将自动确定最合适的主键生成策略，但是你可以通过使用 @GeneratedValue 注释来覆盖掉它。strategy 和 generator 这两个参数我不打算在这里讨论，所以我们只使用默认键生成策略。让 Hibernate 确定使用哪些生成器类型来使代码移植于不同的数据库之间。
@Column Annotation
@Column 注释用于指定某一列与某一个字段或是属性映射的细节信息。您可以使用下列注释的最常用的属性:
name 允许显式地指定列的名称。
length 特别为一个字符串值的列的大小。
nullable ，一个列可以被标记为非空。
unique 唯一的内容
	 */
	@Id @GeneratedValue
	   @Column(name = "id")
	   private int id;

	   @Column(name = "first_name")
	   private String firstName;

	   @Column(name = "last_name")
	   private String lastName;

	   @Column(name = "salary")
	   private int salary;  

	   public Employeee() {}
	   public Employeee(String fname, String lname, int salary) {
		      this.firstName = fname;
		      this.lastName = lname;
		      this.salary = salary;
		   }
	   public int getId() {
	      return id;
	   }
	   public void setId( int id ) {
	      this.id = id;
	   }
	   public String getFirstName() {
	      return firstName;
	   }
	   public void setFirstName( String first_name ) {
	      this.firstName = first_name;
	   }
	   public String getLastName() {
	      return lastName;
	   }
	   public void setLastName( String last_name ) {
	      this.lastName = last_name;
	   }
	   public int getSalary() {
	      return salary;
	   }
	   public void setSalary( int salary ) {
	      this.salary = salary;
	   }	
}
