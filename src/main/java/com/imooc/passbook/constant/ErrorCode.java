package com.imooc.passbook.constant;

/**
 * @program: rd
 * @description: 错误码
 * @author: xuefeng
 * @create: 2019/1/30 14:14
 */
public enum ErrorCode {
    /**
     * 返回的状态
     */
    SUCCESS(0, ""),
    DUPLICATE_NAME(1, "商户名称重复"),
    EMPTY_LOGO(2, "商户logo为空"),
    EMPTY_BUSINESS_LICENSE(3, "商户营业执照为空"),
    EMPTY_PHONE(4, "商户联系电话错误"),
    EMPTY_ADDRESS(5, "商户地址为空"),
    MERCHANTS_NOT_EXIST(6, "商户不存在");

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误描述
     */
    private String desc;

    ErrorCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
