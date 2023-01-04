package br.com.qintess.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.qintess.service.DBService;

@Configuration
@Profile(value = {"dev"})
public class DevConfig {

	
	@Autowired
	private DBService service;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String value;
	
	
	@Bean
	public boolean initDB() {
		//if(value.equalsIgnoreCase("update")|| value.equalsIgnoreCase("none")) {
			
		//}
		if(value.equals("create")) {
			this.service.initDB();
		}
		return false;
	}
	
}
