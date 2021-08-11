package com.bjpowernode.vo;

public class QueryParam {

    private String paramname;
    private Integer paramage;

    public String getParamname() {
        return paramname;
    }

    public void setParamname(String paramname) {
        this.paramname = paramname;
    }

    public Integer getParamage() {
        return paramage;
    }

    public void setParamage(Integer paramage) {
        this.paramage = paramage;
    }

    @Override
    public String toString() {
        return "QueryParam{" +
                "paramname='" + paramname + '\'' +
                ", paramage=" + paramage +
                '}';
    }
}
