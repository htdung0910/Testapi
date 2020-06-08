package com.example.demo;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import Process.*;

@RestController
public class ProductManagerController {


    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<String> findAllProduct() {
        return new ResponseEntity<>("hahaha", HttpStatus.OK);
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        FileProcess p = new FileProcess();
        String fileName = p.storeFile(file);
        String fileType = file.getContentType();
        long fileSize = file.getSize();

        return new ResponseEntity<>("hahaha", HttpStatus.OK);
    }
    private String getSuccessMessage() {
        String json = "{\"brand\":\"Jeep\", \"doors\": 3}";
        return json;
    }
}
