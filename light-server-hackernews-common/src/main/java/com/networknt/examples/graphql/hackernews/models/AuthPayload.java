package com.networknt.examples.graphql.hackernews.models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Nicholas Azar
 */

@Data
@AllArgsConstructor
public class AuthPayload {
    private String token;
    private User user;
}
