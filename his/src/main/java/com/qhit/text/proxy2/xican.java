package com.qhit.text.proxy2;

import com.qhit.text.proxy.Fandian;

/**
 * Created by yy on 2018/12/6.
 */
public class xican implements Fandian {
    @Override
    public void TiGongFancai() {
        System.out.println("提供西餐...");
    }

    @Override
    public void TiGongJiuShui() {
        System.out.println("提供拉菲...");
    }
}
