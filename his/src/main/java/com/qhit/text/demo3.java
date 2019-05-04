package com.qhit.text;

import com.qhit.utils.BaseDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by yy on 2019/1/2.
 */
public class demo3 {

    public static void main(String[] args) throws SQLException {
        BaseDao baseDao = new BaseDao();
        Connection conn = baseDao.getConn();
        //开启事务
        conn.setAutoCommit(false);
        String sql1 = "update patient_register_record set status = 2 where register_id=87";
        String sql2 = "insert into base_dept(dept_id,dept_name)values(11,'感冒科')";
        Statement statement = conn.createStatement();
        statement.executeUpdate(sql1);
        int i=1/0;
        statement.executeUpdate(sql2);
        //结束事务
        conn.commit();
        conn.close();
        System.out.println("执行成功");


    }
}
