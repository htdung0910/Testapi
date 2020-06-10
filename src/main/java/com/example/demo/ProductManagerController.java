package com.example.demo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import Process.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
public class ProductManagerController {

    private Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = FileProcess.uploadToDropBox(file);
        return new ResponseEntity<>(gson.toJson(fileName),HttpStatus.OK);
    }

    @RequestMapping(value = "/uploadMultipleFiles", method = RequestMethod.POST)
    public ResponseEntity<String> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return new ResponseEntity<>(gson.toJson(
                                Arrays.asList(files).stream()
                                .map(file -> FileProcess.uploadToDropBox(file))
                                .collect(Collectors.toList())),
                HttpStatus.OK);
    }


}
