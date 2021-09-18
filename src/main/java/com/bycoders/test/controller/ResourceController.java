package com.bycoders.test.controller;

import com.bycoders.test.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping
    public String getPageUpload() {
        return "upload";
    }

    @PostMapping(value = "/uploadFile")
    public String uploadFile(@RequestParam MultipartFile file) throws IOException {
        resourceService.processFile(file);
        return "uploadSuccess";
    }

}
