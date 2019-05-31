package com.zero.base.dynamicDB;

/**
 * 
 * @author ljz 将数据源对象绑定到当前线程上
 *
 */
public final class DataSourceContextHolder {

	private static String DEFALUT_DATASOURCE = "ds.sys";
	private static ThreadLocal<String> dbContextHolder = new ThreadLocal<String>();

	public static String getDbType() {
		return dbContextHolder.get();
	}

	public static void setDbType(String dbType) {
		dbContextHolder.set(dbType);
	}

	public static void resetDbType() {
		dbContextHolder.set(DEFALUT_DATASOURCE);
	}

}
