package com.onuo.common.util;

public class CommonMapper<T> {
    private static CommonMapper commonMapper=new CommonMapper();
    private CommonMapper(){}
    public  static CommonMapper getInstance(){
        return commonMapper;
    }
    public T getMapper(Class<T> c){
        return MybatisUtil.getSession().getMapper(c);
    }
}
