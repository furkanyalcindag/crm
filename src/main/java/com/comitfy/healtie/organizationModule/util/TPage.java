package com.comitfy.healtie.organizationModule.util;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

@Data
public class TPage <T>{
    private int number; //frontEnd ile
    private int size; //
    private Sort sort;
    private int totalPage; //toplamsayfalama
    private Long totalElements; //toplam kayıt sayısı
    private List<T> content;

    public void setStart(Page page, List<T> list){
        this.number=page.getNumber();
        this.size=page.getSize();
        this.sort=page.getSort();
        this.totalPage=page.getTotalPages();
        this.totalElements=page.getTotalElements();
        this.content=list;


    }
}
