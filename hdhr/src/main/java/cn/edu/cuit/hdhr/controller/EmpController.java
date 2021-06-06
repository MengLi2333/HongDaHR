package cn.edu.cuit.hdhr.controller;

import cn.edu.cuit.hdhr.common.Result;
import cn.edu.cuit.hdhr.entity.Emp;
import cn.edu.cuit.hdhr.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/emp")
@CrossOrigin(allowCredentials = "true", originPatterns = "http://localhost:*")
public class EmpController {
    private EmpService testService;

    @Autowired
    public EmpController(EmpService testService) {
        this.testService = testService;
    }

    @RequestMapping("/save")
    public Result saveEmp(Emp emp) {
        testService.save(emp);
        System.out.println("enter controller");
        Result succ = Result.succ(null);
        return succ;
    }

    @RequestMapping("/get")
    public Result getEmp()
    {
        ArrayList<Emp> emps = testService.getEmps();
        Result succ = Result.succ(emps);
        return succ;
    }

    @RequestMapping("/delete")
    public Result deleteEmpByEmpID(Emp emp)
    {
        testService.deleteEmpByEmpID(emp.getEmpID());
        Result succ = Result.succ(null);
        return succ;
    }

    @RequestMapping("/update")
    public Result updateEmp(Emp emp)
    {
        testService.updateEmp(emp);
        Result succ = Result.succ(null);
        return succ;
    }
}
