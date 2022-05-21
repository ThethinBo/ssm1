package com.gzeic.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
@PropertySource( "classpath:jdbc.properties")
public class JdbcConfig {
    @Value( "${jdbc.driverClassName}" )
    private String driverClassName;
    @Value( "${jdbc.url}" )
    private String url;
    @Value( "${jdbc.username}")
    private String username;
    @Value( "${jdbc.password}")
    private String password;
    /*
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource" >
        <property name="driverClassName" value="${jdbc.driverClassName}" />
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}" />
        <property name="password" value="${jdbc.password}" />
    </bean>
    * */
    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl( url );
        dataSource.setDriverClassName( driverClassName );
        dataSource.setUsername( username );
        dataSource.setPassword( password );
        return dataSource;
    }

    /*
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager" >
        <property name="dataSource" ref="dataSource" />
    </bean>
    * */
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(@Autowired DataSource dataSource){
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource( dataSource );
        return manager;
    }

}
