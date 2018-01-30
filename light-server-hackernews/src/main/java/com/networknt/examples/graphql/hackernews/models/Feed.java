package com.networknt.examples.graphql.hackernews.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Nicholas Azar
 */

@Data
@NoArgsConstructor
public class Feed {
    private List<Link> links;
    private int count;

    public Feed(List<Link> links) {
        this.links = links;
        if (links != null) {
            this.count = links.size();
        }
    }
}
