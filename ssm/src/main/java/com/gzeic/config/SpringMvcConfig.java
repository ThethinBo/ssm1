package com.gzeic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration //配置类
@ComponentScan( "com.gzeic.controller" )//<context:component-scan base-package="com.gzeic.controller"/>
@EnableWebMvc //<mvc:annotation-driven/>
public class SpringMvcConfig implements WebMvcConfigurer {
    /*
    <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver" >
        <property name="prefix" value="/" />
        <property name="suffix" value="" />
    </bean>
    */
    //配置视图解析器
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix( "/" );
        viewResolver.setSuffix( "" );
        return viewResolver;
    }
    /*
    * <mvc:default-servlet-handler/>
    * */
    //
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
