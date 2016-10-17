package com.java1234.bean;

/**
 * 返回数据对象
 * 
 * @author phantomfjh
 *
 */
public class Data {

	private Object model;

	private Data(Object model) {
		this.model = model;
	}

	public Object getModel() {
		return model;
	}

}
