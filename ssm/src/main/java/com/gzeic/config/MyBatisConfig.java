package com.gzeic.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@MapperScan( "com.gzeic.dao" ) //配置mapscanner
public class MyBatisConfig {

    /*
    *  <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean" >
        <!-- 配置别名 -->
        <property name="typeAliasesPackage" value="com.gzeic.pojo" />
        <!--数据源-->
        <property name="dataSource" ref="dataSource" />
    </bean>
    * */
    @Bean
    public SqlSessionFactoryBean getSqlSessionFactoryBean(@Autowired DataSource dataSource) {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        //<property name="dataSource" ref="dataSource" />
        factory.setDataSource(dataSource);

        factory.setTypeAliasesPackage("com.gzeic.pojo");
        return factory;
    }

    /*
    * <bean id="mapperSanner" class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.gzeic.dao" />
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory" />
    </bean>
    * */
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer(){
//        MapperScannerConfigurer cfg = new MapperScannerConfigurer();
//        cfg.setBasePackage( "com.gzeic.dao" );
//        cfg.setSqlSessionFactoryBeanName( "getSqlSessionFactoryBean" );
//        return cfg;
//    }
}
