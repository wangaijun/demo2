package com.example.demo.repository.neo4j;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableNeo4jRepositories(basePackages = {"com.example.demo.repository.neo4j"})
public class Neo4jConfig extends Neo4jConfiguration {

    @Override
    public Neo4jServer neo4jServer() {
        return new RemoteServer("http://127.0.0.1:7474","neo4j","123456");
    }

    @Override
    public SessionFactory getSessionFactory() {
        return new SessionFactory("dbdemo.neo4j.domain");
    }
}
