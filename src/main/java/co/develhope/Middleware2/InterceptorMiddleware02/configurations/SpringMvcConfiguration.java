package co.develhope.Middleware2.InterceptorMiddleware02.configurations;

import co.develhope.Middleware2.InterceptorMiddleware02.interceptors.MonthInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class SpringMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MonthInterceptor());
    }
}