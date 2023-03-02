package com.search.service;

import com.alibaba.fastjson.JSON;
import com.search.dao.impl.DemoRepositoryImpl;
import com.search.domain.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHitMapping;
import org.springframework.data.elasticsearch.core.SearchPage;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DemoService {
    @Autowired
    DemoRepositoryImpl demoRepositoryImpl;

    public List<Demo> query(String name, Integer page,Integer size) {

        Pageable firstPageWithTwoItems = PageRequest.of(page,size);
        SearchPage<Demo> searchPage = demoRepositoryImpl.findByNameWithSearchTemplate(name, firstPageWithTwoItems);
        List<Demo> result = searchPage.map(SearchHit::getContent).stream().toList();
        return result;

    }
}
