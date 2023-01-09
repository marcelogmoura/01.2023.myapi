package br.com.mgmoura.myapi;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.mgmoura.myapi.domain.Usuario;
import br.com.mgmoura.myapi.repositories.UsuarioRepository;

@SpringBootApplication
public class MyapiApplication implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Usuario u1 = new Usuario(1, "ana", "ana@email.com", "123");
		Usuario u2 = new Usuario(2, "ted", "ted@email.com", "123");
		
		usuarioRepository.saveAll(Arrays.asList(u1 ,u2));
	
	
	}

}
