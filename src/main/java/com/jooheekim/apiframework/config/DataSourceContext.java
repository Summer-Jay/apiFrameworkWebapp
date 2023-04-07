package com.jooheekim.apiframework.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

@Configuration
@MapperScan(basePackages = "com.jooheekim.apiframework.mapper")
public class DataSourceContext {
	@Bean
	public DataSource dataSource() {
		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		return dataSourceLookup.getDataSource("jndi/portfolio");
	}


	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlsessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlsessionFactory);
	}
	

	// mybatis 설정
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());

		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource[] resources = resolver.getResources("classpath:/sql/mapper/*Mapper.xml");
		sqlSessionFactory.setConfigLocation(resolver.getResource("classpath:/sql/config/mybatis-config.xml"));
		sqlSessionFactory.setMapperLocations(resources);

		return sqlSessionFactory;
	}
}
