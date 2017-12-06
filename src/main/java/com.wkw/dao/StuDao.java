package com.wkw.dao;

import com.wkw.entity.StudentEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * created by wkw
 * 关于学生信息的操作
 */
public interface StuDao {

    /**
     * 根据ID搜索学生
     * @param stuID
     * @return
     */
    StudentEntity queryByID(String stuID);

    /**
     * 根据学生姓名搜索学生
     * @param stuName
     * @return
     */
    List<StudentEntity> queryByName(String stuName);

    /**
     * 根据学生学院信息搜索学生
     * @param school
     * @return
     */
    List<StudentEntity> queryBySchool(String school);

    /**
     * 借书操作借书数量加一
     * @param stuID
     * @return
     */
    int addBorrowNum(String stuID);

    /**
     * 还书操作借书数量减一
     * @param stuID
     * @return
     */
    int reduceBorrowNum(String stuID);

    /**
     * 学生设置密码（也就是注册）
     * @param stuID
     * @param password
     * @return
     */
    int setPassword(@Param("stuID") String stuID, @Param("password") String password);

    /**
     * 管理员插入一条学生信息
     * @param stu
     * @return
     */
    int insertOne(StudentEntity stu);

}
