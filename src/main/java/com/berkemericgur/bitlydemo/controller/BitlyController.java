package com.berkemericgur.bitlydemo.controller;

import com.berkemericgur.bitlydemo.model.BitlyRequest;
import com.berkemericgur.bitlydemo.service.BitlyService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
@Slf4j
public class BitlyController {


    private final BitlyService bitlyService;

    public BitlyController(BitlyService bitlyService){
        this.bitlyService = bitlyService;
    }

    @PostMapping(value = "/add")
    private String addBitly(@RequestBody BitlyRequest bitlyRequest){

        String shortUrl = bitlyService.getShortURL(bitlyRequest.getLongUrl());

        return shortUrl;
    }

}
