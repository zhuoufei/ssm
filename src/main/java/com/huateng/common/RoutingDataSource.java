package com.huateng.common;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
/**
 * 数据源路由
 * @author zhouf
 *
 */
public class RoutingDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		
		return DataSourceHolder.getDataSourceType();
	}

}
