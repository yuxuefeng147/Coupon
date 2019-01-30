package com.imooc.passbook.dao;

import com.imooc.passbook.entity.Merchants;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: rd
 * @description: dao层
 * @author: xuefeng
 * @create: 2019/1/30 15:12
 */
public interface MerchantsDao extends JpaRepository<Merchants, Integer> {
    /**
     * 根据商户id 获取商户对象
     *
     * @param id 商户id
     * @return {@link Merchants}
     */
    Merchants findById(Integer id);

    /**
     * <h2>根据名称获取商户对象</h2>
     *
     * @param name 商户名称
     * @return {@link Merchants}
     */
    Merchants findByName(String name);
}
