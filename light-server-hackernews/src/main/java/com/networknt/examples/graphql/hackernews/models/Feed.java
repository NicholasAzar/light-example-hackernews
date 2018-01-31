package com.networknt.examples.graphql.hackernews.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

/**
 * @author Nicholas Azar
 */

@Data
@NoArgsConstructor
public class Feed {
    private Set<Link> links;
    private int count;

    public Feed(Set<Link> links) {
        this.links = links;
        if (links != null) {
            this.count = links.size();
        }
    }
}
