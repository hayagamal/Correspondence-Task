package com.example.cms.Service;

import com.example.cms.Entity.Data;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.ZonedDateTime;

@Service
public class authServer {

    private ResponseEntity<String> response;


        public String testing()throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "*/*");
        headers.add("Accept-Encoding", "gzip, deflate");
        headers.setContentType(MediaType.APPLICATION_JSON);
        String url= "http://10.0.11.87:8080/otdsws/rest/authentication/credentials";

        JSONObject personJsonObject = new JSONObject();
        personJsonObject.put("userName", "admin");
        personJsonObject.put("password", "Asset99a");



        HttpEntity<String> requestEntity= new HttpEntity<>(personJsonObject.toString(), headers);

        response = restTemplate.postForEntity(url, requestEntity, String.class);


            ObjectMapper map = new ObjectMapper();
            JSONObject replys = map.readValue(response.getBody(), JSONObject.class);
        return replys.get("ticket").toString();
    }


    public void validate(){
            String URL = "http://10.0.11.87:81/home/MOD/com.eibus.web.soap.Gateway.wcp";

    }
    /*public Boolean isSamlArtValid(String samlArt) {
        String URL = "http://10.0.11.87:81/home/MOD/com.eibus.web.soap.Gateway.wcp";
        Http http = new Http().setContentType(Http.ContentType.XML_REQUEST)
                .setData(samlArtToAssertion(samlArt))
                .post(URL);
        String samlArtInResponse = SystemUtil.getJsonByPtrExpr(SystemUtil.convertXMLtoJSON(http.getResponse()), "/Body/Response/AssertionArtifact");
        return !samlArtInResponse.equals("");
    }
    private String getSAMLart(String ticket) throws IOException {
        String gatewayUrl = "http://10.0.11.87:81/home/MOD/com.eibus.web.soap.Gateway.wcp";
        Http http = new Http().setContentType(Http.ContentType.XML_REQUEST)
                .setData(samlartRequest(ticket))
                .post(gatewayUrl);
        String samlart =  SystemUtil.getJsonByPtrExpr(SystemUtil.convertXMLtoJSON(http.getResponse()), "/Body/Response/AssertionArtifact");
        return samlart;
    }*/
    public String postXML() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "*/*");
        headers.add("Accept-Encoding", "gzip, deflate");

        String body  = samlartRequest(testing());
        System.out.println(body);
        headers.setContentType(MediaType.APPLICATION_XML);
        HttpEntity<String> request = new HttpEntity<String>(body, headers);

        String url = "http://10.0.11.87:81/home/MOD/com.eibus.web.soap.Gateway.wcp";

        response = restTemplate.postForEntity(url, request, String.class);
        return response.getBody();

    }
    private String samlartRequest(String ticket){
        return "<SOAP:Envelope xmlns:SOAP=\"http://schemas.xmlsoap.org/soap/envelope/\">"
                +    "    <SOAP:Header>"
                +    "        <OTAuthentication xmlns=\"urn:api.bpm.opentext.com\">"
                +    "            <AuthenticationToken>"+ticket+"</AuthenticationToken>"
                +    "        </OTAuthentication>"
                +    "    </SOAP:Header>"
                +    "    <SOAP:Body>"
                +    "        <samlp:Request xmlns:samlp=\"urn:oasis:names:tc:SAML:1.0:protocol\" MajorVersion=\"1\" MinorVersion=\"1\" IssueInstant=\"2018-09-07T16:47:13.359Z\" RequestID=\"a5470c392e-264e-jopl-56ac-4397b1b416d\">"
                +    "            <samlp:AuthenticationQuery>"
                +    "                <saml:Subject xmlns:saml=\"urn:oasis:names:tc:SAML:1.0:assertion\">"
                +    "                    <saml:NameIdentifier Format=\"urn:oasis:names:tc:SAML:1.1:nameid-format:unspecified\"/>"
                +    "                </saml:Subject>"
                +    "            </samlp:AuthenticationQuery>"
                +    "        </samlp:Request>"
                +    "    </SOAP:Body>"
                +    "</SOAP:Envelope>";
    }


    String samlArtToAssertion(String samlArt) {
        return "<SOAP:Envelope xmlns:SOAP=\"http://schemas.xmlsoap.org/soap/envelope/\">"
                +    "    <SOAP:Body>"
                +    "        <samlp:Request xmlns:samlp=\"urn:oasis:names:tc:SAML:1.0:protocol\" MajorVersion=\"1\" MinorVersion=\"1\">"
                +    "            <samlp:AssertionArtifact xmlns:samlp=\"urn:oasis:names:tc:SAML:1.0:protocol\">"+samlArt+"</samlp:AssertionArtifact>"
                +    "        </samlp:Request>"
                +    "    </SOAP:Body>"
                +    "</SOAP:Envelope>";
    }

}
