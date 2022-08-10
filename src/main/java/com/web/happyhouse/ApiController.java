package com.web.happyhouse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = { "Hello"})
@RestController
@RequestMapping("/api")
public class ApiController {
    @ApiOperation(value = "TEST", notes = "TEST")
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
