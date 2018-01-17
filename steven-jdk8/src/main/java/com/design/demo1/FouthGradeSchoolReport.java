package com.design.demo1;

/**
 * Created by Steven on 2017/7/4.
 */
public class FouthGradeSchoolReport extends SchoolReport {

    //我的成绩单
    @Override
    public void report() {
        System.out.println("成绩单是这样");
    }

    //成绩单
    @Override
    public void sign(String name) {
        System.out.println("签名:"+name);
    }
}
