package org.ecopaula.ecopaula_server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "org.ecopaula.ecopaula_server.repository")
public class DatabaseConfig {
    @Bean
    public DataSource dataSource() {
        // TODO konfiguration til PostGreSQL
        return new DriverManagerDataSource();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        // Konfiguration af JPA
        return new LocalContainerEntityManagerFactoryBean();
    }


}
