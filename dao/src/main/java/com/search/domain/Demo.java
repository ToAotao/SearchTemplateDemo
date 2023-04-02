package com.search.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "provider")
public class Demo {
    @Id
    private String id;
    @Field(name = "d_id", type = FieldType.Long)
    private Long d_id;
    @Field(type = FieldType.Text)
    private String name;
    @Field(type = FieldType.Text)
    private String address;
}
