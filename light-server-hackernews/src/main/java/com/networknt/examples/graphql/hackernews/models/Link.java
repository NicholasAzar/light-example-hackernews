package com.networknt.examples.graphql.hackernews.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Nicholas Azar
 */

@Data
@NoArgsConstructor
public class Link {
    private String id;
    private String createdAt;
    private String description;
    private String url;
    private User postedBy;
    private List<Vote> votes;

    public Link(String id, String description, String url, String createdAt) {
        this.id = id;
        this.description = description;
        this.url = url;
        this.createdAt = createdAt;
    }
}
