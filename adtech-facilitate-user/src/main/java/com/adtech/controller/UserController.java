package com.adtech.controller;

import com.adtech.dao.UserRepository;
import com.adtech.dictionary.Dictionary;
import com.adtech.feign.DictionaryFeign;
import com.adtech.user.User;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DictionaryFeign dictionaryFeign;

    @PostMapping("/getUser")
    @ResponseBody
    public User getUser(@RequestBody User user){
        Dictionary d = new Dictionary();
        d.setId("1");
       Dictionary dictionary = dictionaryFeign.getDictionaryById(d);
       log.info(JSON.toJSONString(dictionary));
        return userRepository.getOne(user.getId());
    }
}
