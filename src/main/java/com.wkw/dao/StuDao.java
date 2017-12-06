package com.wkw.dao;

import com.wkw.entity.StudentEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * created by wkw
 * ����ѧ����Ϣ�Ĳ���
 */
public interface StuDao {

    /**
     * ����ID����ѧ��
     * @param stuID
     * @return
     */
    StudentEntity queryByID(String stuID);

    /**
     * ����ѧ����������ѧ��
     * @param stuName
     * @return
     */
    List<StudentEntity> queryByName(String stuName);

    /**
     * ����ѧ��ѧԺ��Ϣ����ѧ��
     * @param school
     * @return
     */
    List<StudentEntity> queryBySchool(String school);

    /**
     * �����������������һ
     * @param stuID
     * @return
     */
    int addBorrowNum(String stuID);

    /**
     * �����������������һ
     * @param stuID
     * @return
     */
    int reduceBorrowNum(String stuID);

    /**
     * ѧ���������루Ҳ����ע�ᣩ
     * @param stuID
     * @param password
     * @return
     */
    int setPassword(@Param("stuID") String stuID, @Param("password") String password);

    /**
     * ����Ա����һ��ѧ����Ϣ
     * @param stu
     * @return
     */
    int insertOne(StudentEntity stu);

}
