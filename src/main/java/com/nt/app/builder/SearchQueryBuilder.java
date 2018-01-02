package com.nt.app.builder;

import com.nt.app.persistence.model.Property;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchQueryBuilder {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    public List<Property> getAll(String text) {
        QueryBuilder query = QueryBuilders.boolQuery()
                .should(QueryBuilders.multiMatchQuery(text)
                .fuzziness(Fuzziness.TWO)
                .lenient(true)
                .field("city")
                .field("id")
                .type(MultiMatchQueryBuilder.Type.BEST_FIELDS));

        QueryBuilder score = QueryBuilders.functionScoreQuery();

        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder()
                .withQuery(query)
                .build();

        return elasticsearchTemplate.queryForList(nativeSearchQuery, Property.class);
    }
}
