package com.adtech.feign;


import com.adtech.dictionary.Dictionary;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("adtech-facilitate-dictionaries")
public interface DictionaryFeign {

    @PostMapping(value = "/dictionaries/getDictionaryById")
    Dictionary getDictionaryById(@RequestBody Dictionary dictionary);
}
