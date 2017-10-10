package com.test.testclient1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
/**
 *
 */
@RestController
@ConfigurationProperties()
public class RestControllerTest {

    @Autowired
    private FeignCLient2 feignCLient2;

   @Value("${name}")
    private String name;
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;

    /**
     * Methods used by Client2 service using @Feignclient
     */
    @RequestMapping("/test/getString")
    public String returnString() {
        return "Hello " + username + "....Text Displayed from client-1 to client-2 using cloud property";
    }

    @RequestMapping("/test/getList")
    public List<String> returnList(){
        List<String> props = new ArrayList<String>();
        props.add(name);
        props.add(username);
        props.add(password);
        return props;
    }


    /**
     * Methods to call Client2 using Feignclient from Client1
     * @return
     */

    @RequestMapping("/feign/client2/all")
    public List<Object> getAllFromClient2() {
        return feignCLient2.getAll();
    }

    @RequestMapping(value="/feign/client2/byName/{name}",method = RequestMethod.GET)
    public Object getByNameClient2(@PathVariable String name)
    {

        String paramName=name;
        return feignCLient2.getByName(paramName);
    }

    @RequestMapping("/feign/client2/save")
    public Object saveInClient2(@RequestBody Object obj)
    {
        return feignCLient2.loadDetails(obj);
    }


}
