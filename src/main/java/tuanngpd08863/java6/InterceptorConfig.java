package tuanngpd08863.java6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import tuanngpd08863.java6.interceptor.GobalInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	@Autowired
	GobalInterceptor gobalInterceptor;
	
	@Override
	public void addInterceptors (InterceptorRegistry registry) {
	registry.addInterceptor(gobalInterceptor)
	.addPathPatterns("/**")
	.excludePathPatterns("/rest/**", "/admin/**", "/assets/**");
	}
	
}
