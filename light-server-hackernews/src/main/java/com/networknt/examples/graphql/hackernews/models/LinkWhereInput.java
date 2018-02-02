package com.networknt.examples.graphql.hackernews.models;

import lombok.Data;

import java.util.Set;

@Data
public class LinkWhereInput {
    private Set<LinkWhereInput> AND;
    private Set<LinkWhereInput> OR;
    private Integer createdAt;
    private Integer createdAt_not;
    private Set<Integer> createdAt_in;
    private Set<Integer> createdAt_not_in;
    private Integer createdAt_lt;
    private Integer createdAt_lte;
    private Integer createdAt_gt;
    private Integer createdAt_gte;
    private String description;
    private String description_not;
    private Set<String> description_in;
    private Set<String> description_not_in;
    private String description_lt;
    private String description_lte;
    private String description_gt;
    private String description_gte;
    private String description_contains;
    private String description_not_contains;
    private String description_starts_with;
    private String description_not_starts_with;
    private String description_ends_with;
    private String description_not_ends_with;
    private String url;
    private String url_not;
    private Set<String> url_in;
    private Set<String> url_not_in;
    private String url_lt;
    private String url_lte;
    private String url_gt;
    private String url_gte;
    private String url_contains;
    private String url_not_contains;
    private String url_starts_with;
    private String url_not_starts_with;
    private String url_ends_with;
    private String url_not_ends_with;
    private UserWhereInput postedBy;
    private VoteWhereInput votes_every;
    private VoteWhereInput votes_some;
    private VoteWhereInput votes_none;
}
