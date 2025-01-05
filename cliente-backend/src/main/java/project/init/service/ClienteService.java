package project.init.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Service;
import project.init.model.Cliente;
import project.init.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public List<Cliente> findAll() {
        return repo.findAll();
    }

    public Cliente findById(@Argument Integer id) {
        return repo.findById(id).orElse(null);
    }

    public Cliente create(Cliente data) {
        return repo.save(data);
    }

    public Cliente update(Cliente data) {
        if (repo.existsById(data.getId())) {
            return repo.save(data);
        } else {
            throw new IllegalArgumentException("Cliente no encontrado: "+ data.getId());
        }
    }

    public void delete(Integer id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new IllegalArgumentException("Cliente no encontrado: "+ id);
        }
    }
}
