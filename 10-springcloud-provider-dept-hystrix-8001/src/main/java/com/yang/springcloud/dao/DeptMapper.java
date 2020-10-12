package com.yang.springcloud.dao;

import com.yang.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptMapper {
    boolean addDept(Dept dept);

    Dept queryDeptById(Long id);

    List<Dept> queryAll();
}
