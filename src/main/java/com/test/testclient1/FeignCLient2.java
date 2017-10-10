package com.test.testclient1;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ganumukkal.hemakumar on 10/6/2017.
 */
@FeignClient(value = "test-client2")
public interface FeignCLient2 {
    @RequestMapping("/all")
    public List<Object> getAll();

    @GetMapping("/byName/{name}")
    public Object getByName(@PathVariable(value = "name") String name);

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public List<Object> loadDetails(@RequestBody Object user);
}
