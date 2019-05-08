package com.huateng.service;

import java.util.List;

import com.huateng.common.DataSource;
import com.huateng.entity.Dept;

public interface DataSource1 {
	@DataSource("ds1")
	public List<Dept> selectDeptList();
}
