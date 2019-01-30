package com.imooc.passbook.service;

import com.imooc.passbook.vo.CreateMerchantsRequest;
import com.imooc.passbook.vo.PassTemplate;
import com.imooc.passbook.vo.Response;
import org.springframework.stereotype.Service;

/**
 * @program: rd
 * @description: <h1>商户服务的接口定义</h1>
 * @author: xuefeng
 * @create: 2019/1/30 17:41
 */
@Service
public interface IMerchantsService {
    /**
     * <h2>创建商户服务</h2>
     *
     * @param createMerchantsRequest {@link CreateMerchantsRequest} 创建商户请求
     * @return {@link Response}
     */
    Response createMerchants(CreateMerchantsRequest createMerchantsRequest);

    /**
     * <h1>根据id构造商户id</h1>
     *
     * @param id 商户id
     * @return {@link Response}
     */
    Response buildMerchantsInfoById(Integer id);

    /**
     * <h2>投放优惠券</h2>
     *
     * @param passTemplate {@link PassTemplate} 优惠券对象
     * @return {@link Response}
     */
    Response dropPassTemplate(PassTemplate passTemplate);

}
