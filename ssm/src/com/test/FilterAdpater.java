package com.test;
/**
 * 适配器类：
 * 将现有的对象放到新的环境中，即将一个接口转换为用户需要的另一个接口
 * @author leoi555
 *
 */
public class FilterAdpater implements Processor {
	Filter filter;
	
	public FilterAdpater(Filter filter) {
		super();
		this.filter = filter;
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return filter.name();
	}

	/**
	 * 转换为需要的接口转换到filter中相应的方法中
	 */
	public Waveform process(Object input) {
		// TODO Auto-generated method stub
		return filter.process((Waveform)input);
	}

}
