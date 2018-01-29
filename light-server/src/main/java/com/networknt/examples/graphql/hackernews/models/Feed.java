package com.networknt.examples.graphql.hackernews.models;

import lombok.Data;

import java.util.List;

/**
 * @author Nicholas Azar
 */

@Data
public class Feed {
    private List<Link> links;
    private int count;
}
