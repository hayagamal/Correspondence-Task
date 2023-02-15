package com.example.cms.Authorization;





import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.example.cms.Entity.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Token {

    
    public String getToken(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, String> body
        = new LinkedMultiValueMap<>();
        body.add("username","Admin");
        body.add("password","Asset99a");
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, String>> requestEntity= new HttpEntity<>(body, headers);
        String url = "http://psuite.example.com/otcs/cs.exe/api/v1/auth";
        ResponseEntity<Data> response = restTemplate.postForEntity(url, requestEntity, Data.class);
        try{
            @SuppressWarnings("null")
            String token= response.getBody().getTicket();
            return token;
        }
        catch(Exception e){
            System.out.println(e);
            return "error";
        }
        
    }
}
