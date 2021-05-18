package cn.edu.cuit.hdhr.service.impl;

import cn.edu.cuit.hdhr.entity.Dept;
import cn.edu.cuit.hdhr.entity.DeptTree;
import cn.edu.cuit.hdhr.mapper.DeptMapper;
import cn.edu.cuit.hdhr.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    private final DeptMapper deptMapper;

    @Autowired
    public DeptServiceImpl(DeptMapper deptMapper) {
        this.deptMapper = deptMapper;
    }

    @Override
    public List<DeptTree> getDeptForest() {
        return deptMapper.selectDeptForestByPID(0L);
    }

    @Override
    public Dept getDeptByDeptID(Long deptID) {
        return deptMapper.selectDeptByDeptID(deptID);
    }
}
