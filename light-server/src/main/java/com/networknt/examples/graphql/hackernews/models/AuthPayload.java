package com.networknt.examples.graphql.hackernews.models;

import lombok.Data;

/**
 * @author Nicholas Azar
 */

@Data
public class AuthPayload {
    private String token;
    private User user;
}
