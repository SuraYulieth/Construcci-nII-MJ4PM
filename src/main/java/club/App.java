package club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import club.controller.LoginController;

@SpringBootApplication
public class App implements CommandLineRunner{
	
	@Autowired
	LoginController controller;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try{
			controller.session();
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	} 




}

