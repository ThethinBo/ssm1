package com.gzeic.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration ///这是一个配置类
@ComponentScan( "com.gzeic.service" )
@Import( {MyBatisConfig.class, JdbcConfig.class} ) //导入配置文件
public class SpringConfig {
    //  <context:component-scan base-package="com.gzeic.service" />

}
