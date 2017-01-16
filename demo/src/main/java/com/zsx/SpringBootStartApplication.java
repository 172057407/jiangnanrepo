package com.zsx;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
/**
 * �޸������࣬�̳� SpringBootServletInitializer ����д configure ����
 * @author ZSX
 *
 */
public class SpringBootStartApplication extends SpringBootServletInitializer {
 
    private static final Logger logger = LoggerFactory.getLogger(SpringBootStartApplication.class);
 
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
 
}