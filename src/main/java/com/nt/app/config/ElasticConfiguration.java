package com.nt.app.config;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.File;
import java.io.IOException;

//@Configuration
//@EnableElasticsearchRepositories(basePackages = "com.nt.app.persistence.elastic")
//@EnableJpaRepositories(basePackages = "com.nt.app.persistence.jpadao")
public class ElasticConfiguration {

    @Bean
    NodeBuilder nodeBuilder() {
        return new NodeBuilder();
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws IOException {
        File file = File.createTempFile("elastic", Long.toString(System.nanoTime()));

        System.out.println("Temp directory: " + file.getAbsolutePath());
        Settings.Builder elasticsearchSettings = Settings.settingsBuilder()
                .put("http.enabled", "true")
                .put("index.number_of_shards", "1")
                .put("path.data", new File(file, "data").getAbsolutePath())
                .put("path.logs", new File(file, "logs").getAbsolutePath())
                .put("path.work", new File(file, "work").getAbsolutePath())
                .put("path.home", file);

        return new ElasticsearchTemplate(nodeBuilder()
                .local(true)
                .settings(elasticsearchSettings.build())
                .node()
                .client());
    }
}
