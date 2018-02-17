
package com.networknt.examples.graphql.hackernews.user;

import com.networknt.examples.graphql.hackernews.user.handlers.UserGetHandler;
import com.networknt.examples.graphql.hackernews.user.handlers.UserPostHandler;
import com.networknt.server.HandlerProvider;
import io.undertow.Handlers;
import io.undertow.server.HttpHandler;
import io.undertow.util.Methods;
import com.networknt.info.ServerInfoGetHandler;
import com.networknt.health.HealthGetHandler;

public class PathHandlerProvider implements HandlerProvider {
    @Override
    public HttpHandler getHandler() {
        return Handlers.routing()
        
            .add(Methods.GET, "/v1/health", new HealthGetHandler())
        
            .add(Methods.GET, "/v1/server/info", new ServerInfoGetHandler())
        
            .add(Methods.POST, "/v1/users", new UserPostHandler())
        
            .add(Methods.GET, "/v1/users", new UserGetHandler())
        ;
    }
}
