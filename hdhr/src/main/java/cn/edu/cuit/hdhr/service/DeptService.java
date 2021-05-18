package cn.edu.cuit.hdhr.service;

import cn.edu.cuit.hdhr.entity.Dept;
import cn.edu.cuit.hdhr.entity.DeptTree;

import java.util.List;

public interface DeptService {
    List<DeptTree> getDeptForest();

    Dept getDeptByDeptID(Long deptID);
}
