package com.berkemericgur.bitlydemo.service;

import com.opsmatters.bitly.Bitly;
import com.opsmatters.bitly.api.model.v4.CreateBitlinkResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class BitlyService {

    @Value("${BITLY_TOKEN}")
    private String BITLY_TOKEN;

    private Bitly client;

    @PostConstruct //used in initialization or preparation processes.
    public void setup(){
        client = new Bitly(BITLY_TOKEN);
    }

    public String getShortURL(String longUrl){
        String link = "error";
        try {
            CreateBitlinkResponse bitlinkResponse = client.bitlinks().shorten(longUrl).get();
            link = bitlinkResponse.getLink();

        }catch (Exception e){

        }
        return link;
    }
}
