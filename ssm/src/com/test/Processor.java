package com.test;
/**
 * 父接口
 * @author leoi555
 *
 */
public interface Processor {
	String name();
	Object process(Object input);
}
