package com.example.welltok.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.util.Collections;
import java.util.List;

@Configuration
@PropertySource(value = {"classpath:application.properties"})
@EnableCassandraRepositories
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Value("${spring.data.cassandra.contact-points}")

    private String contactPoints;

    @Value("${spring.data.cassandra.port}")

    private int port;

    @Value("${spring.data.cassandra.keyspace-name}")

    private String keySpace;

    @Override

    protected String getKeyspaceName() {

        return keySpace;

    }

    @Override

    protected String getContactPoints() {

        return contactPoints;

    }

    @Override

    protected int getPort() {

        return port;

    }

    @Override

    public SchemaAction getSchemaAction() {

        return SchemaAction.CREATE_IF_NOT_EXISTS;

    }

    @Override
    protected boolean getMetricsEnabled() { return false; }

}