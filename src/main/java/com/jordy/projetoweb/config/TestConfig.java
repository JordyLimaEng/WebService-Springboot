package com.jordy.projetoweb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jordy.projetoweb.entities.User;
import com.jordy.projetoweb.repositories.UserRepository;

@Configuration // fala para o spring que é para configuração
@Profile("test") // especifica para o spring que a configuração é para o perfil de testes
public class TestConfig implements CommandLineRunner{
	
	@Autowired//o spring automaticamento associa as dependencias e instancia userRepository
	private UserRepository userRepository;

	@Override// tudo q tiver nesse método executa quando a aplicação rodar
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		userRepository.saveAll(Arrays.asList(u1,u2));//passa uma lista com objs e salva no bf
	}
	
		
}
