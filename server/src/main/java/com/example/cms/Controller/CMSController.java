package com.example.cms.Controller;


import java.io.IOException;


import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.cms.DTO.CDTO;

import com.example.cms.Service.CService;
import com.example.cms.Service.PersonService;

import com.example.cms.Entity.*;
@RestController
public class CMSController {
    @Autowired
    private PersonService personService;
    @Autowired
    private CService cService;


    @GetMapping("/addPerson")
    public boolean addPerson(){
        personService.addPerson(new Person("mohamed"));
        return personService.addPerson(new Person("ahmed"));
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping("/addCorrespondence")
    public ResponseEntity<?> addTask(@RequestBody Correspondence correspondence) {
        return new ResponseEntity<>(cService.addCorrespondence(correspondence), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/getCorrespondence")
    public ResponseEntity<?> getTask() {
        return new ResponseEntity<>(cService.getCorrespondence(), HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/image/{id}")
    public ResponseEntity<?>  DownloadFisle(@PathVariable("id") String id) throws IOException{
        return cService.DownloadFile(id);
    }

    // @CrossOrigin(origins = "*", maxAge = 3600)
    // @PostMapping("/imagePost")
    // public ResponseEntity<?>  uploadfile(@RequestParam("file") MultipartFile file) throws IOException{
    
    //        System.out.println(file);
    //     return  new ResponseEntity<>(cService.uploadFileExtended(file), HttpStatus.OK);
    // }
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/outgoing/{name}")
    public ResponseEntity<?>  getSentMesssage(@PathVariable("name") String name) throws IOException{
        return new ResponseEntity<>(cService.getCorrespondenceByPerson(name), HttpStatus.OK);
    }
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/incoming/{name}")
    public ResponseEntity<?>  getRecivedMesssage(@PathVariable("name") String name) throws IOException{
        return new ResponseEntity<>(cService.getCorrespondenceByReceiver(name), HttpStatus.OK);
    }
    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping("/addCorrespondenceWithFile")
    public ResponseEntity<?>  AddCorr(@RequestParam("file") MultipartFile file, @RequestParam("message") String message) throws IOException{
        ObjectMapper map = new ObjectMapper();
        CDTO c = map.readValue(message, CDTO.class);
        long fromID = personService.getPerson(c.getFrom());
        long ToID   = personService.getPerson(c.getTo());
        Correspondence correspondence = new Correspondence(c.getSubject(),c.getDescription(),c.getType(),c.getPriority(),fromID,ToID);
        long AttachmentID = cService.uploadFileExtended(file).getId();
        correspondence.setAttachmentID(AttachmentID);
        return  new ResponseEntity<>(cService.addCorrespondence(correspondence), HttpStatus.OK);
    }
}
