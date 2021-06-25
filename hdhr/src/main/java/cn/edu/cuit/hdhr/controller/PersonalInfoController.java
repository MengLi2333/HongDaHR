package cn.edu.cuit.hdhr.controller;

import cn.edu.cuit.hdhr.common.BusinessException;
import cn.edu.cuit.hdhr.common.Result;
import cn.edu.cuit.hdhr.entity.Emp;
import cn.edu.cuit.hdhr.service.PersonalInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
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
        if (emp == null) {
            throw new BusinessException("服务器错误");
        }
        emp.setPassword(null);
        return Result.succ(emp);
    }

    @RequestMapping("/logout")
    public Result logout() {
        SecurityUtils.getSubject().logout();
        return Result.succ(null);
    }

    @RequestMapping("/updInfo")
    @RequiresAuthentication
    public Result updInfo(Emp emp) {
        if (emp.getEmpID() == null) {
            throw new BusinessException("无员工编号");
        }
        personalInfoService.updEmpByEmpID(emp);
        return Result.succ(null);
    }

    @RequestMapping("/getInfo")
    @RequiresAuthentication
    public Result getInfo() {
        String empCode = SecurityUtils.getSubject().getPrincipal().toString();
        Emp emp = personalInfoService.getEmpByEmpCode(empCode);
        if (emp == null) {
            throw new BusinessException("服务器错误");
        }
        return Result.succ(emp);
    }

    @RequestMapping("/chgPwd")
    @RequiresAuthentication
    public Result chgPwd(Long empID, String orgPassword, String newPassword) {
        Emp emp = personalInfoService.getEmpByEmpID(empID);
        if (emp.getPassword().equals(orgPassword)) {
            emp.setPassword(newPassword);
            Emp newEmp = new Emp();
            newEmp.setEmpID(empID);
            newEmp.setPassword(newPassword);
            personalInfoService.updEmpByEmpID(newEmp);
            return Result.succ(null);
        } else {
            throw new BusinessException("原密码不正确");
        }
    }

}
