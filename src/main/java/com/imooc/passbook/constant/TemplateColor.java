package com.imooc.passbook.constant;

/**
 * @program: rd
 * @description:
 * @author: xuefeng
 * @create: 2019/1/30 14:03
 */
public enum TemplateColor {
    /**
     * 表示优惠券的颜色
     */
    RED(1, "红色"),
    GREEN(2, "绿色"),
    Blue(3, "蓝色");

    /**
     * 背景颜色的代码
     */
    private Integer code;
    /**
     * 颜色的描述
     */
    private String color;

    TemplateColor(Integer code, String color) {
        this.code = code;
        this.color = color;
    }

    public Integer getCode() {
        return code;
    }

    public String getColor() {
        return color;
    }

}
