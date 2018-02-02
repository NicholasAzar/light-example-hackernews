package com.networknt.examples.graphql.hackernews.models;

import lombok.Data;

import java.util.Set;

@Data
public class VoteWhereInput {
    private Set<VoteWhereInput> AND;
    private Set<VoteWhereInput> OR;
    private String id;
    private String id_not;
    private Set<String> id_in;
    private Set<String> id_not_in;
    private String id_lt;
    private String id_lte;
    private String id_gt;
    private String id_gte;
    private String id_contains;
    private String id_not_contains;
    private String id_starts_with;
    private String id_not_starts_with;
    private String id_ends_with;
    private String id_not_ends_with;
    private LinkWhereInput link;
    private UserWhereInput user;
}
