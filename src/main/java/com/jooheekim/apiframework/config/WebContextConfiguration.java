package com.jooheekim.apiframework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.jooheekim.apiframework.common.Interceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.jooheekim"})
public class WebContextConfiguration implements WebMvcConfigurer{
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new Interceptor())
		.excludePathPatterns("/v1.0/**");


	}
	
	 /**
     * 뷰 리졸버를 설정한다.
     * @return
     */
    @Bean
    public ViewResolver getViewResolver() {
    	System.out.println("WebContextConfiguration!");
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

}
