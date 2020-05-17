package com.jordy.projetoweb.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jordy.projetoweb.entities.Order;
import com.jordy.projetoweb.entities.User;
import com.jordy.projetoweb.entities.enums.OrderStatus;
import com.jordy.projetoweb.repositories.OrderRepository;
import com.jordy.projetoweb.repositories.UserRepository;

@Configuration // fala para o spring que é para configuração
@Profile("test") // especifica para o spring que a configuração é para o perfil de testes
public class TestConfig implements CommandLineRunner {

	@Autowired // o spring automaticamento associa as dependencias e instancia userRepository
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Override // tudo q tiver nesse método executa quando a aplicação rodar
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		// o horario está padronizado no horario UTC - Greenwitch
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT , u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT,u1);

		userRepository.saveAll(Arrays.asList(u1, u2));// passa uma lista com objs e salva no bf
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));// passa uma lista de orders atrelados a clients
	}

}
