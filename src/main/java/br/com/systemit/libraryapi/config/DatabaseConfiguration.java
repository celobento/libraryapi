package br.com.systemit.libraryapi.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    @Value("${spring.datasource.url}")
    String url;

    @Value("${spring.datasource.username}")
    String username;

    @Value("${spring.datasource.password}")
    String password;

    @Value("${spring.datasource.driver-class-name}")
    String driver;


    // isn't optimized to use in production environment
    /*@Bean
    public DataSource dataSource(){
        DriverManagerDataSource  ds = new DriverManagerDataSource();
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setDriverClassName(driver);
        return ds
    }*/

    // https://github.com/brettwooldridge/HikariCP
    @Bean
    public DataSource hikariDataSource(){
        HikariConfig ds = new HikariConfig();
        ds.setJdbcUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setDriverClassName(driver);

        ds.setMaximumPoolSize(10); // max connections
        ds.setMinimumIdle(1); // min connections started
        ds.setPoolName("library-db-pool");
        ds.setMaxLifetime(600000); // 10 min -> 600000 ms
        ds.setConnectionTimeout(10000); // 10s
        ds.setConnectionTestQuery("select 1");

        return new HikariDataSource(ds);
    }
}
