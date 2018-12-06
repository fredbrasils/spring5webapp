package guru.springframework.spring5webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import guru.springframework.spring5webapp.model.FakeDataSource;

@SpringBootApplication
public class Spring5webappApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Spring5webappApplication.class, args);
		
		FakeDataSource fk = (FakeDataSource) ctx.getBean(FakeDataSource.class);
		
		System.out.println(fk.getUser());
	}
}
