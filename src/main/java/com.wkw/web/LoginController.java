package com.wkw.web;

import com.mysql.jdbc.Statement;
import com.wkw.dto.json.JsonData;
import com.wkw.entity.StudentEntity;
import com.wkw.exception.StuActEp;
import com.wkw.service.StuActService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * create by wkw
 * 处理的登录注册请求
 */
@Controller
@RequestMapping("/lib")
public class LoginController {

    @Autowired
    private StuActService stuActService;

    //登录页面
    @RequestMapping(value = "/login")
    public String signPage(){
        return"login";
    }


    //登录操作  验证输入信息是否和后台是否一致并作出相应处理

    /**
     * TODO 优化提取状态信息
     * 登录操作
     * 1 验证登录对象是否正确
     * 2 验证成功将信息保存到session，跳转到页面
     *   验证失败提示失败和失败原因
     * @param ID
     * @param password
     * @return
     */
    @RequestMapping(value = "/{ID}/{password}/loginIn",
            produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonData signIn(@PathVariable("ID") String ID,
                           @PathVariable("password") String password, HttpSession session){
        StudentEntity studentEntity = stuActService.queryMyInfo(ID);
       // System.out.println("student:"+studentEntity);
        //1.无此用户，提示出错
        if(studentEntity==null){
            return new JsonData(false,"wuciyonghu");
        }
        //2.未注册
        if(studentEntity.getPassword()==null){
            return new JsonData(false,"weizhuce");
        }
        //3.密码错误
        if(!studentEntity.getPassword().equals(password)){
            return new JsonData (false,"mimacuowu");
        }
        //4.验证成功
        //加入session
        session.setAttribute("user",studentEntity);
        return new JsonData<StudentEntity>(true,studentEntity);
    }

    //登出操作

    @RequestMapping(value = "/signOut")
    @ResponseBody
    public void signOut(HttpSession session){
        session.removeAttribute("user");
    }

    //注册相关操作

    //注册页面
    @RequestMapping(value = "/registerPage")
    public String registerPage(){
        return "register";
    }

    //注册请求,注册成功他拿出登录页面
    @RequestMapping(value = "/{stuID}/register",
            produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonData register( @PathVariable("stuID")String stuID,
                              String password,HttpServletResponse response){
        try {
            stuActService.register(stuID,password);
            //response.sendRedirect("/lib/login");//是否转移到客户端代码
            return new JsonData(true,null);
        }catch (StuActEp ep){
            return new JsonData(false,ep.getState().getStatInfo());
        }
    }
}
