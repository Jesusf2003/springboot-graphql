package project.init.resolver;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;
import project.init.model.Cliente;
import project.init.repository.ClienteRepository;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private ClienteRepository repo;

    @MutationMapping
    public Cliente create(@Argument String names, @Argument String matLnames, @Argument String patLnames, @Argument String cellphone, @Argument String dni, @Argument String address) {
        Cliente cliente = new Cliente();
        cliente.setNames(names);
        cliente.setMatLnames(matLnames);
        cliente.setPatLnames(patLnames);
        cliente.setCellphone(cellphone);
        cliente.setDni(dni);
        cliente.setAddress(address);
        return repo.save(cliente);
    }

    @MutationMapping
    public Cliente update(@Argument Integer id, @Argument String names, @Argument String matLnames, @Argument String patLnames, @Argument String cellphone, @Argument String dni, @Argument String address) {
        Optional<Cliente> opt = repo.findById(id);
        if (opt.isPresent()) {
            Cliente cliente = opt.get();
            cliente.setNames(names);
            cliente.setMatLnames(matLnames);
            cliente.setPatLnames(patLnames);
            cliente.setCellphone(cellphone);
            cliente.setDni(dni);
            cliente.setAddress(address);
            repo.save(cliente);
            return cliente;
        }
        return null;
    }

    @MutationMapping
    public boolean delete(@Argument Integer id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
