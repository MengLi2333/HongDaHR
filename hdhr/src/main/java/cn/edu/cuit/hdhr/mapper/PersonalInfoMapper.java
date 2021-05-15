package cn.edu.cuit.hdhr.mapper;

import cn.edu.cuit.hdhr.entity.Emp;
import cn.edu.cuit.hdhr.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface PersonalInfoMapper {
    Emp selectEmpByEmpCode(String empCode);
    ArrayList<Role> selectRolesByEmpCode(String empCode);
}
