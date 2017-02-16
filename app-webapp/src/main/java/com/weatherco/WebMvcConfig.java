package com.weatherco;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    private static Logger LOGGER = LoggerFactory.getLogger(WebMvcConfig.class
            .getName());

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("WEB-INF/jsp/index.jsp");
        registry.addViewController("/error").setViewName("dynamic-error.jsp");
        registry.addViewController("/dynamic-error").setViewName(
                "dynamic-error");
        // registry.addViewController("/error9").setViewName("login-fail2");
        // registry.addViewController("/error8").setViewName(
        // "WEB-INF/jsp/search-results-page.jsp");
        registry.addViewController("/index").setViewName(
                "WEB-INF/jsp/index.jsp");
        registry.addViewController("/search-results").setViewName(
                "WEB-INF/jsp/search-results-page.jsp");

    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        // public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        // resolver.setPrefix("/jsp/");
        resolver.setPrefix("/");
        // resolver.setSuffix(".jsp");
        return resolver;
    }

}