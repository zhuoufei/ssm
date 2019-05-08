package com.huateng.service;

import java.util.List;

import com.huateng.common.DataSource;
import com.huateng.entity.Dept;

public interface DataSource2 {

	@DataSource("ds2")
	public List<Dept> selectDeptList();
}
