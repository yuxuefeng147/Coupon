package com.imooc.passbook.service.impl;

import com.alibaba.fastjson.JSON;
import com.imooc.passbook.constant.Constants;
import com.imooc.passbook.constant.ErrorCode;
import com.imooc.passbook.dao.MerchantsDao;
import com.imooc.passbook.entity.Merchants;
import com.imooc.passbook.service.IMerchantsService;
import com.imooc.passbook.vo.CreateMerchantsRequest;
import com.imooc.passbook.vo.CreateMerchantsResponse;
import com.imooc.passbook.vo.PassTemplate;
import com.imooc.passbook.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @program: rd
 * @description: <h1>商户服务接口实现</h1>
 * @author: xuefeng
 * @create: 2019/1/31 10:28
 */
@Slf4j
@Service
public class MerchantsServiceImpl implements IMerchantsService{

    @Autowired
    private MerchantsDao merchantsDao;
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Override
    public Response createMerchants(CreateMerchantsRequest createMerchantsRequest) {
        Response response = new Response();
        CreateMerchantsResponse merchantsResponse = new CreateMerchantsResponse();
        ErrorCode errorCode = createMerchantsRequest.validate(merchantsDao);
        if (errorCode != ErrorCode.SUCCESS) {
            merchantsResponse.setId(-1);
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());
        } else {
            merchantsResponse.setId(merchantsDao.save(createMerchantsRequest.toMerchants()).getId());
        }
        response.setData(merchantsResponse);
        return response;
    }

    @Override
    public Response buildMerchantsInfoById(Integer id) {
        Response response = new Response();
        Merchants merchants = merchantsDao.findById(id);
        if (null == merchants) {
            response.setErrorCode(ErrorCode.MERCHANTS_NOT_EXIST.getCode());
            response.setErrorMsg(ErrorCode.MERCHANTS_NOT_EXIST.getDesc());
        }
        response.setData(merchants);
        return response;
    }

    @Override
    public Response dropPassTemplate(PassTemplate passTemplate) {
        Response response = new Response();
        ErrorCode errorCode = passTemplate.validate(merchantsDao);
        if(errorCode != ErrorCode.SUCCESS){
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());
        }else{
            String template = JSON.toJSONString(passTemplate);
            kafkaTemplate.send(Constants.TEMPLATE_TOPIC,Constants.TEMPLATE_TOPIC,template);
            log.info("DropPassTemplates: {}", passTemplate);
        }
        return response;
    }
}
