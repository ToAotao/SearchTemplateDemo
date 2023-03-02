package com.search.dao.impl;

import com.search.dao.DemoRepository;
import com.search.domain.Demo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.*;

import org.springframework.data.elasticsearch.core.query.SearchTemplateQuery;
import org.springframework.stereotype.Repository;


import java.util.Map;
@Repository
public class DemoRepositoryImpl implements DemoRepository {
    private final ElasticsearchOperations operations;
    public DemoRepositoryImpl(ElasticsearchOperations operations){
        this.operations = operations;
    }

    @Override
    public SearchPage<Demo> findByNameWithSearchTemplate(String name, Pageable pageable) {
        var query = SearchTemplateQuery.builder()
                .withId("demo-template")
                .withParams(
                        Map.of(
                                "name", name,
                                "from", pageable.getOffset(),
                                "size", pageable.getPageSize()
                        )
                )
                .build();
        SearchHits<Demo> searchHits = operations.search(query, Demo.class);
        return SearchHitSupport.searchPageFor(searchHits, pageable);
    }
}
