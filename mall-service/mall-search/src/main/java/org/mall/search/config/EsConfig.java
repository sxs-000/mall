package org.mall.search.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sxs
 * @since 2023/1/28
 */
@Configuration
public class EsConfig {

    @Bean
    public ElasticsearchClient elasticsearchClient() {
        // Create the low-level client
        RestClient restClient = RestClient.builder(
                new HttpHost("192.168.1.100", 9200)).build();
        // Create the transport with a Jackson mapper
        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());
        // And create the API client
        ElasticsearchClient client = new ElasticsearchClient(transport);
        return client;
    }
}
