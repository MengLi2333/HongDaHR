package cn.edu.cuit.hdhr.service;

import cn.edu.cuit.hdhr.entity.Emp;

import java.util.ArrayList;

public interface EmpService {
    boolean save(Emp emp);

    ArrayList<Emp> getEmps();

    void deleteEmpByEmpID(Long empID);

    void updateEmp(Emp emp);
}
