package com.zsx.common.interceptors;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 
@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {
 
    /**
     * ����������
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // TODO Auto-generated method stub
        // ������������һ����������
        // addPathPatterns ����������ع���
        // excludePathPatterns �û��ų�����
        registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**");
 
 
        super.addInterceptors(registry);
    }
 
    /**
     * ����Զ���ľ�̬��Դӳ��
      ����ʹ�ô���ķ�ʽ�Զ���Ŀ¼ӳ�䣬����Ӱ��Spring Boot��Ĭ��ӳ�䣬����ͬʱʹ�á�
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
 
//      registry.addResourceHandler("/new/**").addResourceLocations("classpath:/new/");
//      registry.addResourceHandler("/**").addResourceLocations("/");
        super.addResourceHandlers(registry);
    }
 
}