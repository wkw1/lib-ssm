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
 * ����ĵ�¼ע������
 */
@Controller
@RequestMapping("/lib")
public class LoginController {

    @Autowired
    private StuActService stuActService;

    //��¼ҳ��
    @RequestMapping(value = "/login")
    public String signPage(){
        return"login";
    }


    //��¼����  ��֤������Ϣ�Ƿ�ͺ�̨�Ƿ�һ�²�������Ӧ����

    /**
     * TODO �Ż���ȡ״̬��Ϣ
     * ��¼����
     * 1 ��֤��¼�����Ƿ���ȷ
     * 2 ��֤�ɹ�����Ϣ���浽session����ת��ҳ��
     *   ��֤ʧ����ʾʧ�ܺ�ʧ��ԭ��
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
        //1.�޴��û�����ʾ����
        if(studentEntity==null){
            return new JsonData(false,"wuciyonghu");
        }
        //2.δע��
        if(studentEntity.getPassword()==null){
            return new JsonData(false,"weizhuce");
        }
        //3.�������
        if(!studentEntity.getPassword().equals(password)){
            return new JsonData (false,"mimacuowu");
        }
        //4.��֤�ɹ�
        //����session
        session.setAttribute("user",studentEntity);
        return new JsonData<StudentEntity>(true,studentEntity);
    }

    //�ǳ�����

    @RequestMapping(value = "/signOut")
    @ResponseBody
    public void signOut(HttpSession session){
        session.removeAttribute("user");
    }

    //ע����ز���

    //ע��ҳ��
    @RequestMapping(value = "/registerPage")
    public String registerPage(){
        return "register";
    }

    //ע������,ע��ɹ����ó���¼ҳ��
    @RequestMapping(value = "/{stuID}/register",
            produces={"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonData register( @PathVariable("stuID")String stuID,
                              String password,HttpServletResponse response){
        try {
            stuActService.register(stuID,password);
            //response.sendRedirect("/lib/login");//�Ƿ�ת�Ƶ��ͻ��˴���
            return new JsonData(true,null);
        }catch (StuActEp ep){
            return new JsonData(false,ep.getState().getStatInfo());
        }
    }
}
