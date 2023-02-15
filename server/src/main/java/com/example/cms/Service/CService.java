package com.example.cms.Service;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import java.time.ZonedDateTime;


import com.example.cms.Entity.Correspondence;
import com.example.cms.Entity.Data;
import com.example.cms.Repository.CMSRepository;

import java.io.IOException;

import com.example.cms.Authorization.Token;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;





@Service
public class CService {

    @Autowired
    private CMSRepository cmsRepository;
    private ResponseEntity<Data> response;
    @Autowired
    private RestTemplateBuilder restTemplate;
    @Autowired
    private Token token;
    @Autowired
    private PersonService ps;

    public CService(CMSRepository cmsRepository, Token token , PersonService ps) {
        this.cmsRepository = cmsRepository;
        this.token = token;
        this.ps = ps;
    }

    public CService() {
    }
   
    public boolean addCorrespondence(Correspondence correspondence){
        cmsRepository.save(new Correspondence(correspondence.getSubject(),
                                            correspondence.getDescription(),
                                            correspondence.getType(),
                                            correspondence.getPriority(),
                                            correspondence.getAttachmentID(),
                                            correspondence.getFrom_id(),
                                            correspondence.getReferance_id()));
        return true;
    }
    
    public List<Correspondence> getCorrespondence(){
        return cmsRepository.findAll();
    }

    public Data uploadFileExtended(MultipartFile file) throws IOException{
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("OTCSTicket", token.getToken());
        headers.add("Accept", "*/*");
        headers.add("Accept-Encoding", "gzip, deflate");

        ByteArrayResource fileR = new ByteArrayResource(file.getBytes()){
            @Override
            public String getFilename() {
                return file.getOriginalFilename();
            }


        };

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("parent_id","11414");
        // body.add("name",String.valueOf(Date.from(ZonedDateTime.now().toInstant()))+"_"+file.getOriginalFilename());
        body.add("name",ZonedDateTime.now().toString().replace(":", ".")+"_"+file.getOriginalFilename());
        body.add("type","144");
        body.add("file",fileR);
            
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, Object>> requestEntity= new HttpEntity<>(body, headers);
        String url = "http://psuite.example.com/otcs/cs.exe/api/v1/nodes";

        response = restTemplate.postForEntity(url, requestEntity, Data.class);
        
        
        Data data = response.getBody();

        return data;
    }

    public ResponseEntity<?> DownloadFile(String id){     
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
            headers.add("OTCSTicket", token.getToken());
            headers.add("Accept", "*/*");
            headers.add("Accept-Encoding", "gzip, deflate");
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<byte[]> response = restTemplate.build().exchange("http://psuite.example.com/otcs/cs.exe/api/v1/nodes/"+ id+"/content", HttpMethod.GET, entity, byte[].class);
            List<String> header = response.getHeaders().get("Content-Disposition");
            @SuppressWarnings("null")
            ResponseEntity<?> entityResponse=ResponseEntity.ok().contentType(MediaType.parseMediaType("application/octet-stream")
            ).header("Content-Disposition",header.get(0)).body(response.getBody());
                return entityResponse;
                    
        }catch (Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.ok().build();
    }
       
    public List<Correspondence> getCorrespondenceByPerson(String Name){
        return cmsRepository.getSentMessages(ps.getPerson(Name));
    }
    
    public List<Correspondence> getCorrespondenceByReceiver(String Name){
        return cmsRepository.getReceivedMessages(ps.getPerson(Name));
    }
}


