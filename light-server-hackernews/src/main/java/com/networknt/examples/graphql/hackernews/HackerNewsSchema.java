package com.networknt.examples.graphql.hackernews;

import com.networknt.graphql.router.SchemaProvider;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * @author Nicholas Azar
 */

public class HackerNewsSchema implements SchemaProvider {

    private static Logger logger = LoggerFactory.getLogger(HackerNewsSchema.class);

    private RuntimeWiring buildRuntimeWiring() {
        logger.debug("Building runtime wiring");
        return RuntimeWiring.newRuntimeWiring()
                .type(TypeRuntimeWiring.newTypeWiring("Query")
                        .dataFetcher("feed", HackerNewsWiring.feedDataFetcher))
                .type(TypeRuntimeWiring.newTypeWiring("Mutation")
                        .dataFetcher("post", HackerNewsWiring.createLink )
                        .dataFetcher("login", HackerNewsWiring.login)

                )
                .build();
    }

    @Override
    public GraphQLSchema getSchema() {
        SchemaParser schemaParser = new SchemaParser();
        TypeDefinitionRegistry typeRegistry = null;

        logger.debug("Getting the graphql schema");
        try(InputStream is = getClass().getClassLoader().getResourceAsStream("schema.graphql")) {
            typeRegistry = schemaParser.parse(new InputStreamReader(is, Charset.defaultCharset()));
        } catch (IOException e) {
            logger.error("IOException:", e);
        }

        RuntimeWiring wiring = buildRuntimeWiring();
        return new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);

    }
}
