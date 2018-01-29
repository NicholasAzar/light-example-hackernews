package com.networknt.examples.graphql.hackernews.models;

import lombok.Data;

import java.util.List;

/**
 * @author Nicholas Azar
 */

@Data
public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private List<Link> links;
    private List<Vote> votes;
}
