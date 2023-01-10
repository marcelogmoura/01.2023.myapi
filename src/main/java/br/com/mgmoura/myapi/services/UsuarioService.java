package br.com.mgmoura.myapi.services;

import java.util.List;
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

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Usuario update(Integer id, Usuario obj) {
		Usuario newObj = findById(id);
		newObj.setNome(obj.getNome());
		newObj.setLogin(obj.getLogin());
		newObj.setSenha(obj.getSenha());
		return repository.save(newObj);
		
	}

	public Usuario create(Usuario obj) {
		obj.setId(null);
		return repository.save(obj);
		
	}

}



