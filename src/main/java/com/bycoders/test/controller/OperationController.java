package com.bycoders.test.controller;

import com.bycoders.test.domain.StoreResumeValues;
import com.bycoders.test.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/store")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @GetMapping
    public ResponseEntity<List<StoreResumeValues>> getStoreValue(){

        return ResponseEntity.ok(operationService.processStore());
    }

}
