package com.imooc.passbook.vo;

import com.imooc.passbook.constant.ErrorCode;
import com.imooc.passbook.dao.MerchantsDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @program: rd
 * @description: <h1>投放的优惠券的定义</h1>
 * @author: xuefeng
 * @create: 2019/1/30 15:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassTemplate {
    /**
     * 所属商户id
     */
    private Integer id;
    /**
     * 优惠券标题
     */
    private String title;
    /**
     * 优惠券摘要
     */
    private String summery;
    /**
     * 优惠券的详细信息
     */
    private String desc;
    /**
     * 最大个数限制
     */
    private long limit;
    /**
     * 是否有token
     */
    private boolean hasToken;
    /**
     * 优惠券背景色
     */
    private Integer background;
    /**
     * 优惠券开始时间
     */
    private Date start;
    /**
     * 优惠券结束时间
     */
    private Date end;

    /**
     * <h2>校验优惠券对象的有效性</h2>
     *
     * @param merchantsDao {@link MerchantsDao}
     * @return {@link ErrorCode}
     */
    public ErrorCode validate(MerchantsDao merchantsDao) {
        if (null == merchantsDao.findById(id)) {
            return ErrorCode.MERCHANTS_NOT_EXIST;
        }
        return ErrorCode.SUCCESS;
    }
}
