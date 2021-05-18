package cn.edu.cuit.hdhr.mapper;

import cn.edu.cuit.hdhr.entity.Dept;
import cn.edu.cuit.hdhr.entity.DeptTree;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component  // 为了消除IDEA找不到bean的error
public interface DeptMapper {
    List<DeptTree> selectDeptForestByPID(Long parentID);
    Dept selectDeptByDeptID(Long deptID);
    Integer addChildByDeptID(Long parentDeptID, Dept child);
}
