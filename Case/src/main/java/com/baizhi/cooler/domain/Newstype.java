package com.baizhi.cooler.domain;
// Generated 2018-11-3 16:12:45 by Hibernate Tools 5.3.0.Beta2

import java.util.HashSet;
import java.util.Set;

/**
 * Newstype generated by hbm2java
 */
public class Newstype implements java.io.Serializable {

	private int id;
	private String name;
	private Set newses = new HashSet(0);

	public Newstype() {
	}

	public Newstype(int id) {
		this.id = id;
	}

	public Newstype(int id, String name, Set newses) {
		this.id = id;
		this.name = name;
		this.newses = newses;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getNewses() {
		return this.newses;
	}

	public void setNewses(Set newses) {
		this.newses = newses;
	}

}
