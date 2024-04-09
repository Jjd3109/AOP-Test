package com.example.aoptest;

import org.aspectj.lang.annotation.Around;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/aop")
    @PerfLog(PageName = "PageNameTest", ActionName = "ActionNameTest", CRUDType = "SelectTest")
    public ResponseEntity<?> AopController(){

        return ResponseEntity.ok("success");
    }

}
