package com.facundo.javaDocker;


import com.facundo.javaDocker.models.Client;
import com.facundo.javaDocker.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class JavaDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaDockerApplication.class, args);
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public CommandLineRunner initData(ClientService clientService){
		return (args) ->{

//			Client client1 = new Client("Facundo","Navarro", "navarromedina.facundo@gmail.com", passwordEncoder.encode("123456"),35341690);
//			clientService.saveClient(client1);
//			Client client2 = new Client("Ezequiel","Navarro", "admin@admin", passwordEncoder.encode("abc123"),36012546);
//			clientService.saveClient(client2);



		};
}
}
