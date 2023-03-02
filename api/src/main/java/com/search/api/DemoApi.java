package com.search.api;

import com.search.domain.Demo;
import com.search.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoApi {
    @Autowired
    DemoService demoService;
    @GetMapping("/search/{name}")
    public ResponseEntity<List<Demo>> query(@PathVariable String name,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "2") int size) {
        return new ResponseEntity<List<Demo>>(demoService.query(name, page, size), HttpStatus.OK);
    }
}
