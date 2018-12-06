package guru.springframework.spring5webapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import guru.springframework.spring5webapp.model.FakeDataSource;

@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertyConfig {

	@Value("${guru.user}")
	String user;
	
	@Value("${guru.pwd}")
	String password;
	
	@Value("${guru.dburl}")
	String url;
	
	
	@Bean
	public FakeDataSource fakeDataSource() {
		FakeDataSource fake = new FakeDataSource();
		fake.setUser(user);
		fake.setPwd(password);
		fake.setUrl(url);
		return fake;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer properties = new PropertySourcesPlaceholderConfigurer();
		return properties;
	}
}
