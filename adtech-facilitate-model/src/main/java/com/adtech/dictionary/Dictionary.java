package com.adtech.dictionary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="N_DICTIONARY_DETAIL")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Dictionary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private String id;
    @Column(name = "TYPE_CODE")
    private String typeCode;
    @Column(name = "TYPE_NAME")
    private String typeName;
    @Column(name = "TYPE_VALUE")
    private String typeValue;
    @Column(name = "EXPLAIN")
    private String explain;
    @Column(name = "IS_DISCONTINUATION")
    private String isDiscontinuation;
}
