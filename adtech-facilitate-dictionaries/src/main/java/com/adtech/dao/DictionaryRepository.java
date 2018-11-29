package com.adtech.dao;

import com.adtech.dictionary.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DictionaryRepository extends JpaRepository<Dictionary,String> {
}
