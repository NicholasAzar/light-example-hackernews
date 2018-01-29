package com.networknt.examples.graphql.hackernews.models;

import lombok.Data;
import org.joda.time.DateTime;

import java.util.List;

/**
 * @author Nicholas Azar
 */

@Data
public class Link {
    private String id;
    private DateTime createdAt;
    private String description;
    private String url;
    private User postedBy;
    private List<Vote> votes;
}
