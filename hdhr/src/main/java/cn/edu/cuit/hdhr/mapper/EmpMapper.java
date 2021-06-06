package cn.edu.cuit.hdhr.mapper;

import cn.edu.cuit.hdhr.entity.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Mapper
@Component
public interface EmpMapper {
    ArrayList<Emp> getEmps();
    boolean save(Emp emp);

    void deleteEmpByEmpID(Long empID);

    void updateEmp(Emp emp);
}
