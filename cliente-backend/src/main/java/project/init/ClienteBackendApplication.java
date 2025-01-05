package project.init;

import graphql.scalars.ExtendedScalars;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClienteBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClienteBackendApplication.class, args);
    }

    @Bean
    public graphql.schema.GraphQLScalarType extendedScalarLong() {
        return ExtendedScalars.GraphQLLong;
    }
}
