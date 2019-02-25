package com.example.spring03_boot;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.example.spring03_boot.model")
public class Spring03BootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring03BootApplication.class, args);
	}
//javax.sql.DataSource 	
// DataSource =>	SqlSessionFactory 
//   => SqlSessionTemplate => SqlSession	
	@Bean //자바코드로 bean을 등록
	public SqlSessionFactory sqlSessionFactory(
			DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
		bean.setDataSource(dataSource); //데이터소스 설정
		return bean.getObject();
	}
	@Bean
	public SqlSessionTemplate sqlSession(
			SqlSessionFactory factory) {
		return new SqlSessionTemplate(factory);
	}
}





