package cn.edu.cuit.hdhr.controller;

import cn.edu.cuit.hdhr.common.Result;
import cn.edu.cuit.hdhr.entity.Emp;
import cn.edu.cuit.hdhr.service.PersonalInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(allowCredentials = "true", originPatterns = "http://localhost:*")
@RequestMapping("/personalInfo")
public class PersonalInfoController {
    private final PersonalInfoService personalInfoService;

    @Autowired
    public PersonalInfoController(PersonalInfoService personalInfoService) {
        this.personalInfoService = personalInfoService;
    }

    @RequestMapping("/login")
    public Result login(String empCode, String password) {
        SecurityUtils.getSubject().login(new UsernamePasswordToken(empCode, password));
        Emp emp = personalInfoService.getEmpByEmpCode(empCode);
        emp.setPassword(null);
        return Result.succ(emp);
    }

//    @RequestMapping("/info")
//    @RequiresAuthentication
//    public Result info() {
//        String empCode = SecurityUtils.getSubject().getPrincipal().toString();
//        Emp emp = personalInfoService.getEmpByEmpCode(empCode);
//        emp.setPassword(null);
//        return Result.succ(emp);
//    }

    @RequestMapping(value = "/mytest")
    @RequiresRoles("HRDeptManager")
    public Result mytest(String empCode) {
        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject.getPrincipal().toString());
        return Result.succ(personalInfoService.getEmpByEmpCode(empCode));
    }
}
