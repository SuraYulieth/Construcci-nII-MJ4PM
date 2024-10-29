package club;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@SpringBootApplication
public class App {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}
} 
