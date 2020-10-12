package com.yang.springcloud.service;

import com.yang.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {
    boolean addDept(Dept dept);

    Dept queryDeptById(Long id);

    List<Dept> queryAll();
}
