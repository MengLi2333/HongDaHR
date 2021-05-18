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

    @RequestMapping("/addChild")
    @RequiresRoles("HRDeptManager")
    public Result addChild(Long parentDeptID, Dept child) {
        // TODO
    }

//    public Result addChild(Dept parent, Dept child) { // TODO 测试该类参数如何通过MyBatis完成数据库访问
//
//    }
}
