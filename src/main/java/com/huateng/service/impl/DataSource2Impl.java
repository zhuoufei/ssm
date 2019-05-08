package com.huateng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.common.DataSource;
import com.huateng.dao.DeptDao;
import com.huateng.entity.Dept;
import com.huateng.service.DataSource2;
@Service
public class DataSource2Impl implements DataSource2 {

	@Autowired
	DeptDao deptDao;
	
	
	@Override
	public List<Dept> selectDeptList() {
		List<Dept> selectDeptList = deptDao.selectDeptList();
		for (Dept dept : selectDeptList) {
			System.out.println(dept.toString());
		}
		return null;
	}

}
