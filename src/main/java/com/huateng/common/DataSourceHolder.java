package com.huateng.common;

public class DataSourceHolder {

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
	/**
	 * ��������Դ����
	 * @param dataSourceType
	 */
	public static void setDataSourceType(String dataSourceType){
		contextHolder.set(dataSourceType);
	}
	/**
	 * ��ȡ����Դ����
	 * @return
	 */
	public static String getDataSourceType(){
		return contextHolder.get();
	}
	/**
	 * �������Դ����
	 */
	public static void clearDataSourceType(){
		contextHolder.remove();
	}
}
