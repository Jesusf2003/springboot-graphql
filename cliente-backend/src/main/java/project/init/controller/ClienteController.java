package project.init.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import project.init.model.Cliente;
import project.init.service.ClienteService;

import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService service;

    @QueryMapping
    public List<Cliente> findAll() {
        return service.findAll();
    }

    @MutationMapping
    public Cliente create(@Argument String names, @Argument String matLnames, @Argument String patLnames, @Argument String cellphone, @Argument String dni, @Argument String address) {
        Cliente cliente = new Cliente();
        cliente.setNames(names);
        cliente.setMatLnames(matLnames);
        cliente.setPatLnames(patLnames);
        cliente.setCellphone(cellphone);
        cliente.setDni(dni);
        cliente.setAddress(address);
        return service.create(cliente);
    }

    @MutationMapping
    public Cliente update(@Argument Integer id, @Argument String names, @Argument String matLnames, @Argument String patLnames, @Argument String cellphone, @Argument String dni, @Argument String address) {
        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNames(names);
        cliente.setMatLnames(matLnames);
        cliente.setPatLnames(patLnames);
        cliente.setCellphone(cellphone);
        cliente.setDni(dni);
        cliente.setAddress(address);
        return service.update(cliente);
    }

    @MutationMapping
    public void delete(@Argument Integer id) {
        service.delete(id);
    }
}
