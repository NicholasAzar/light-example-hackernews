package com.networknt.examples.graphql.hackernews.user.handlers;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;

public class UserPostHandler implements HttpHandler {
    @Override
    public void handleRequest(HttpServerExchange exchange) throws Exception {

        exchange.endExchange();

    }
}
