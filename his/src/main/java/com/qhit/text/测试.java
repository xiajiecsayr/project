package com.qhit.text;

import com.qhit.medicinePurchaseInfo.dao.IMedicinePurchaseInfoDao;
import com.qhit.medicinePurchaseInfo.dao.impl.MedicinePurchaseInfoDaoImpl;

import java.util.List;

/**
 * Created by yy on 2018/12/9.
 */
public class 测试 {
    public static void main(String[] args) {
        IMedicinePurchaseInfoDao dao = new MedicinePurchaseInfoDaoImpl();
        String sql3 = "SELECT COUNT(*) from medicine_req_plan WHERE STATUS = 3 GROUP BY medicine_codeid";
        List race = dao.freeFind(sql3);
        int a = Integer.parseInt(String.valueOf(race));
        System.out.println(a);

    }
}
