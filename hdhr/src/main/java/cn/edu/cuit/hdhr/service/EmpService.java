package cn.edu.cuit.hdhr.service;

import cn.edu.cuit.hdhr.entity.Dept;
import cn.edu.cuit.hdhr.entity.Emp;
import cn.edu.cuit.hdhr.entity.Post;
import cn.edu.cuit.hdhr.entity.Title;

import java.util.ArrayList;

public interface EmpService {
    boolean save(Emp emp);

    void deleteEmpByEmpID(Long empID);

    void updateEmp(Emp emp);

    ArrayList<Dept> getAllDept();

    ArrayList<Title> getAllTitle();

    ArrayList<Post> getAllPost();

    ArrayList<Emp> getAllEmp();
}
