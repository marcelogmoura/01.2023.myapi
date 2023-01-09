package br.com.mgmoura.myapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mgmoura.myapi.domain.Usuario;
import br.com.mgmoura.myapi.repositories.UsuarioRepository;
import br.com.mgmoura.myapi.resources.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario findById(Integer id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id+ " " ));
		
	}

}
