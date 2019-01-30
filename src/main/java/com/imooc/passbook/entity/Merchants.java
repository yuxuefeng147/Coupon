package com.imooc.passbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

/**
 * @program: rd
 * @description:
 * @author: xuefeng
 * @create: 2019/1/30 14:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "merchants")
public class Merchants {
    /**
     * 商户id 主键
     */
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    /**
     * 商户名称
     */
    @Basic
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Basic
    @Column(name = "logo_url", nullable = false)
    private String logoUrl;

    /**
     * 商户营业执照
     */
    @Basic
    @Column(name = "business_license_url", nullable = false)
    private String businessLicenseUrl;

    /**
     * 商户的联系电话
     */
    @Basic
    @Column(name = "phone", nullable = false)
    private String phone;

    /**
     * 商户地址
     */
    @Basic
    @Column(name = "address", nullable = false)
    private String address;

    /**
     * 商户是否通过审核
     */
    @Basic
    @Column(name = "is_audit", nullable = false)
    private Boolean isAudit = false;


}
