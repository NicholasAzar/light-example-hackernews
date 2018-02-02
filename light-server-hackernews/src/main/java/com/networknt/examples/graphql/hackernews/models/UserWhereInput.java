package com.networknt.examples.graphql.hackernews.models;

import lombok.Data;

import java.util.Set;

@Data
public class UserWhereInput {
    private Set<UserWhereInput> AND;
    private Set<UserWhereInput> OR;
    private String name;
    private String name_not;
    private Set<String> name_in;
    private Set<String> name_not_in;
    private String name_lt;
    private String name_lte;
    private String name_gt;
    private String name_gte;
    private String name_contains;
    private String name_not_contains;
    private String name_starts_with;
    private String name_not_starts_with;
    private String name_ends_with;
    private String name_not_ends_with;
    private String email;
    private String email_not;
    private Set<String> email_in;
    private Set<String> email_not_in;
    private String email_lt;
    private String email_lte;
    private String email_gt;
    private String email_gte;
    private String email_contains;
    private String email_not_contains;
    private String email_starts_with;
    private String email_not_starts_with;
    private String email_ends_with;
    private String email_not_ends_with;
    private LinkWhereInput links_every;
    private LinkWhereInput links_some;
    private LinkWhereInput links_none;
    private VoteWhereInput votes_every;
    private VoteWhereInput votes_some;
    private VoteWhereInput votes_none;
}
