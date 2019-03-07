package com.ocean;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class SpringdatajpaApplication {

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource druid(){
		return new DruidDataSource();
	}

	@Bean
	//注册durid后台监控界面
	public ServletRegistrationBean druidView(){
		ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
		Map<String,String> param = new HashMap<>();
		param.put("loginUsername" , "admin");
		param.put("loginPassword" , "123456");
		param.put("allow" , "");
		param.put("resetEnable","true");		//允许清空统计数据
		bean.setInitParameters(param);
		return bean;
	}

	@Bean
	//用于监听获取应用的数据
	public FilterRegistrationBean druidMonitor(){
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setFilter(new WebStatFilter());		//设置过滤器
		bean.addUrlPatterns("");		//设置监听地址
		Map<String,String> param = new HashMap<>();
		param.put("exclusions" , "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid");	//排除静态资源
		bean.setInitParameters(param);
		return bean;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpaApplication.class, args);
	}

}
