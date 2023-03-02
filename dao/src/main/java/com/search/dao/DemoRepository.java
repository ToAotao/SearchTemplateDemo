package com.search.dao;

import com.search.domain.Demo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.SearchPage;

import java.util.List;

public interface DemoRepository {
    SearchPage<Demo> findByNameWithSearchTemplate(String name, Pageable pageable);
}
