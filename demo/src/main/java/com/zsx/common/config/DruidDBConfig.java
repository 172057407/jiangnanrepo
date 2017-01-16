package com.zsx.common.config;
 
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;
 
/**
 * DruidDBConfig类被@Configuration标注，用作配置信息； 
 * DataSource对象被@Bean声明，为Spring容器所管理， 
 * @Primary表示这里定义的DataSource将覆盖其他来源的DataSource。
 * @author ZSX
 *jdbc.url=${jdbc.url} 
 *最新的支持方式如下: 
 *jdbc.url=@jdbc.url@  
 */
@ConfigurationProperties(prefix = "spring.datasource")
public class DruidDBConfig implements BeanClassLoaderAware, EnvironmentAware, InitializingBean{
//  private Logger logger = LoggerFactory.getLogger(DruidDBConfig.class);
	
	private ClassLoader classLoader;

	private Environment environment;
	
	private EmbeddedDatabaseConnection embeddedDatabaseConnection = EmbeddedDatabaseConnection.NONE;
	
    private String url;
 
    private String username;
 
    private String password;
 
    private String driverClassName;
 
    private int initialSize;
 
    private int minIdle;
 
    private int maxActive;
 
    private int maxWait;
 
    private int timeBetweenEvictionRunsMillis;
 
    private int minEvictableIdleTimeMillis;
 
    private String validationQuery;
 
    private boolean testWhileIdle;
 
    private boolean testOnBorrow;
 
    private boolean testOnReturn;
 
    private boolean poolPreparedStatements;
 
    private int maxPoolPreparedStatementPerConnectionSize;
 
    private String filters;
 
    private String connectionProperties;
    
    
    @Bean // 声明其为Bean实例
    @Primary // 在同样的DataSource中，首先使用被标注的DataSource
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(url);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
 
        // configuration
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
 
        }
        datasource.setConnectionProperties(connectionProperties);
 
        return datasource;
    }


	public void afterPropertiesSet() throws Exception {
		this.embeddedDatabaseConnection = EmbeddedDatabaseConnection
				.get(this.classLoader);
		
	}


	public void setEnvironment(Environment environment) {
		this.environment = environment;
		
	}


	public void setBeanClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
		
	}
}