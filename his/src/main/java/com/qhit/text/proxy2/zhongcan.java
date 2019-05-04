package com.qhit.text.proxy2;

import com.qhit.text.proxy.Fandian;

/**
 * Created by yy on 2018/12/6.
 */
public class zhongcan implements Fandian {


    @Override
    public void TiGongFancai() {
        System.out.println("提供中餐...");
    }

    @Override
    public void TiGongJiuShui() {
        System.out.println("提供小郎白酒...");
    }
}
