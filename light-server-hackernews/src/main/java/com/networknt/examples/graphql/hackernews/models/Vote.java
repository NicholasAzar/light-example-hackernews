package com.networknt.examples.graphql.hackernews.models;

import lombok.Data;

/**
 * @author Nicholas Azar
 */

@Data
public class Vote {

    private String id;
    private Link link;
    private User user;
}
