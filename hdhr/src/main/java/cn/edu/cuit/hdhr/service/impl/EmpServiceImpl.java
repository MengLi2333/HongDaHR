package cn.edu.cuit.hdhr.service.impl;

import cn.edu.cuit.hdhr.entity.Dept;
import cn.edu.cuit.hdhr.entity.Emp;
import cn.edu.cuit.hdhr.entity.Post;
import cn.edu.cuit.hdhr.entity.Title;
import cn.edu.cuit.hdhr.mapper.EmpMapper;
import cn.edu.cuit.hdhr.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmpServiceImpl implements EmpService {
    private EmpMapper testMapper;

    @Autowired
    public EmpServiceImpl(EmpMapper testMapper) {
        this.testMapper = testMapper;
    }



    @Override
    public void deleteEmpByEmpID(Long empID) {
        testMapper.deleteEmpByEmpID(empID);
    }

    @Override
    public void updateEmp(Emp emp)
    {
        System.out.println(emp.getEmpName());
        testMapper.updateEmp(emp);
    }

    @Override
    public ArrayList<Dept> getAllDept() {
        return testMapper.getAllDept();
    }

    @Override
    public ArrayList<Title> getAllTitle() {
        return testMapper.getAllTitle();
    }

    @Override
    public ArrayList<Post> getAllPost() {
        return testMapper.getAllPost();
    }

    @Override
    public ArrayList<Emp> getAllEmp() {
        return testMapper.getAllEmp();
    }

    @Override
    public boolean save(Emp emp) {
        System.out.println("enter service");
        return testMapper.save(emp);
    }


}
