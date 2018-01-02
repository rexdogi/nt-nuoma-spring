package com.nt.app.persistence.elastic;

import com.nt.app.persistence.model.Property;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PropertyRepository extends ElasticsearchRepository<Property, Long> {
}
