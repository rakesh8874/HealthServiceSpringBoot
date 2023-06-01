package com.healthcorporation.healthservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class HealthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthServiceApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean configuration(){
      final CorsConfiguration crs = new CorsConfiguration();
       crs.setAllowCredentials(true);
	   crs.addAllowedOrigin("http://localhost:4200/");
       crs.addAllowedHeader("*");
       crs.addAllowedMethod("*");
		final UrlBasedCorsConfigurationSource source =  new UrlBasedCorsConfigurationSource();

		source.registerCorsConfiguration("/**", crs);
		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}

}
