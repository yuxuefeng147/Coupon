package com.imooc.passbook.controller;

import com.alibaba.fastjson.JSON;
import com.imooc.passbook.service.IMerchantsService;
import com.imooc.passbook.vo.CreateMerchantsRequest;
import com.imooc.passbook.vo.PassTemplate;
import com.imooc.passbook.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: rd
 * @description: <h1>商户服务</h1>
 * @author: xuefeng
 * @create: 2019/1/31 14:55
 */
@Slf4j
@RestController
@RequestMapping("/merchants")
public class MerchantsController {

    @Autowired
    private IMerchantsService iMerchantsService;

    @PostMapping("/create")
    public Response createMerchants(@RequestBody CreateMerchantsRequest request) {
        log.info("CreateMerchants: {}", JSON.toJSONString(request));
        return iMerchantsService.createMerchants(request);
    }

    @GetMapping("/{id}")
    public Response buildMerchantsInfo(@PathVariable Integer id) {
        log.info("BuildMerchantsInfo: {}", id);
        return iMerchantsService.buildMerchantsInfoById(id);
    }

    @PostMapping("/drop")
    public Response dropPassTemplate(@RequestBody PassTemplate passTemplate) {
        log.info("DropPassTemplate: {}", passTemplate);
        return iMerchantsService.dropPassTemplate(passTemplate);
    }
}
