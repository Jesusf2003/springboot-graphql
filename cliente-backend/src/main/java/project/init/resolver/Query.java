package project.init.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Component;
import project.init.model.Cliente;
import project.init.repository.ClienteRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private ClienteRepository repo;

    @QueryMapping
    public List<Cliente> findAll() {
        return repo.findAll();
    }

    @QueryMapping
    public Cliente findById(@Argument Integer id) {
        return repo.findById(id).orElse(null);
    }
}