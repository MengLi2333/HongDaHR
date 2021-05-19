package cn.edu.cuit.hdhr.controller;

import cn.edu.cuit.hdhr.common.Result;
import cn.edu.cuit.hdhr.entity.Dept;
import cn.edu.cuit.hdhr.service.DeptService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(allowCredentials = "true", originPatterns = "http://localhost:*")
@RequestMapping("/dept")
public class DeptController {
    private final DeptService deptService;

    @Autowired
    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    @RequestMapping("/deptForest")
    @RequiresRoles("HRDeptManager")
    public Result deptForest() {
        return Result.succ(deptService.getDeptForest());
    }

    @RequestMapping("/detail")
    @RequiresRoles("HRDeptManager")
    public Result detail(Long deptID) {
        return Result.succ(deptService.getDeptByDeptID(deptID));
    }

    @RequestMapping("/addDept")
    @RequiresRoles("HRDeptManager")
    public Result addChild(Dept dept) {
        deptService.addDept(dept);
        return Result.succ(null);
    }

    @RequestMapping("/updateDept")
    @RequiresRoles("HRDeptManager")
    public Result updateDept(Dept dept) {
        deptService.updateDeptIgnoreNull(dept);
        return Result.succ(null);
    }

    @RequestMapping("/deleteDept")
    @RequiresRoles("HRDeptManager")
    public Result deleteDept(Long deptID) {
        deptService.deleteDept(deptID);
        return Result.succ(null);
    }

    @RequestMapping("/removeDept")
    @RequiresRoles("HRDeptManager")
    public Result removeDept(Long deptID) {
        deptService.removeDept(deptID);
        return Result.succ(null);
    }

    @RequestMapping("/rejoinDept")
    @RequiresRoles("HRDeptManager")
    public Result rejoinDept(Long deptID) {
        deptService.rejoinDept(deptID);
        return Result.succ(null);
    }

    @RequestMapping("/resetDept")
    @RequiresRoles("HRDeptManager")
    public Result resetDept(Long deptID, Long parentID) {
        deptService.resetDept(deptID, parentID);
        return Result.succ(null);
    }

//    public Result addChild(Dept parent, Dept child) { // TODO 测试该类参数如何通过MyBatis完成数据库访问
//
//    }
}
