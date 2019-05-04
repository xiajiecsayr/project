package com.qhit.text.proxy2;

/**
 * Created by yy on 2018/12/6.
 */
public class test {
    public static void main(String[] args) {
        xican xican = new xican();
        FandianCGLIBProxy fandianCGLIBProxy = new FandianCGLIBProxy();
        xican instance = (xican) fandianCGLIBProxy.getInstance(xican);
        instance.TiGongJiuShui();
    }
}
