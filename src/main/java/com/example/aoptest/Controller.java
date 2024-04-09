package com.example.aoptest;

import org.aspectj.lang.annotation.Around;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/v1/aop")
    @PerfLog(PageName = "PageNameTest", ActionName = "ActionNameTest", CRUDType = "SelectTest")
    public ResponseEntity<?> AopController(){

        return ResponseEntity.ok("success");
    }


    @GetMapping("/v2/aop")
    @PerfLog(PageName = "PageNameTest2", ActionName = "ActionNameTest2", CRUDType = "SelectTes2t")
    public ResponseEntity<?> AopTest(){

        return ResponseEntity.ok("success2");
    }

}
