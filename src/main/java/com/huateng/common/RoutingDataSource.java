package com.huateng.common;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
/**
 * ����Դ·��
 * @author zhouf
 *
 */
public class RoutingDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		
		return DataSourceHolder.getDataSourceType();
	}

}
