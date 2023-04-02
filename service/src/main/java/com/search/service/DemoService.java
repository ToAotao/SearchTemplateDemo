package com.search.service;

import com.alibaba.fastjson.JSON;
import com.search.dao.impl.DemoRepositoryImpl;
import com.search.domain.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.SearchHit;

import org.springframework.data.elasticsearch.core.SearchPage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;


@Service
public class DemoService {
    @Autowired
    DemoRepositoryImpl demoRepositoryImpl;

    public List<Demo> query(String name, Integer page,Integer size) {

        Pageable firstPageWithTwoItems = PageRequest.of(page,size);
        SearchPage<Demo> searchPage = demoRepositoryImpl.findByNameWithSearchTemplate(name, firstPageWithTwoItems);
        List<Demo> result = new ArrayList<>(searchPage.map(SearchHit::getContent).stream().toList());

        //sorting base on specific field
        result.sort(Comparator.comparingLong(Demo::getD_id));
        return result;

    }
}
