package com.qhit.test;

import com.qhit.utils.CommonUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class poitest {
    public static void main(String[] args) {
        String title = "商品代码表";
        String[] name = {"流程ID","流程名称","斗轮机ID","装船机ID","皮带机ID","所属公司ID"};
        //获取数据
        Connection connection = CommonUtil.getConnection();
        Statement statement = null;

        {
            try {
                statement = connection.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        String sql = "SELECT flowid,flowname,dljid,zcjid,pdjid,compid\n" +
                "FROM base_flow \n";
        ResultSet rs;

        {
            try {
                rs = statement.executeQuery(sql);
                CommonUtil.exportExcel(title,name,rs);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }





}
