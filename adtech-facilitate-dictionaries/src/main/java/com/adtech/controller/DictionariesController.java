package com.adtech.controller;

import com.adtech.dao.DictionaryRepository;
import com.adtech.dictionary.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dictionaries")
public class DictionariesController {

    @Autowired
    private DictionaryRepository dictionaryRepository;

    @RequestMapping("/getDictionaryById")
    @ResponseBody
    public Dictionary getDictionaryById(@RequestBody Dictionary dictionary){
        return  dictionaryRepository.getOne(dictionary.getId());
    }
}
