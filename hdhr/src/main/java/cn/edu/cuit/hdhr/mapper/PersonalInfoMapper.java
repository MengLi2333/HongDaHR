package cn.edu.cuit.hdhr.mapper;

import cn.edu.cuit.hdhr.entity.Emp;
import cn.edu.cuit.hdhr.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component // 为了消除IDEA找不到bean的error
@Mapper
public interface PersonalInfoMapper {
    Emp selectEmpByEmpCode(String empCode);
    Emp selectEmpByEmpID(Long empID);
    ArrayList<Role> selectRolesByEmpCode(String empCode);
    Integer updEmpByEmpID(Emp emp);
}
