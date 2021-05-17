package cn.edu.cuit.hdhr.service;

import cn.edu.cuit.hdhr.entity.Emp;
import cn.edu.cuit.hdhr.entity.Role;

import java.util.ArrayList;

public interface PersonalInfoService {
    Emp getEmpByEmpCode(String empCode);
    ArrayList<Role> getRolesByEmpCode(String empCode);
    Integer updEmpByEmpID(Emp emp);
    Emp getEmpByEmpID(Long empID);
}
