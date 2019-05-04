package com.qhit.text.proxy;

/**
 * Created by yy on 2018/12/6.
 */
public class test {
    public static void main(String[] args) {
        Fandian Fandian = new xican();
        FandianProxy fandianProxy = new FandianProxy();
        Fandian fandian = (Fandian) fandianProxy.getInstance(Fandian);
        fandian.TiGongFancai();
    }
}
