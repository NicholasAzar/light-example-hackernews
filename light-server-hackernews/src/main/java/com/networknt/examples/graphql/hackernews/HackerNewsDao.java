package com.networknt.examples.graphql.hackernews;

import com.networknt.examples.graphql.hackernews.enums.LinkOrderByInput;
import com.networknt.examples.graphql.hackernews.models.AuthPayload;
import com.networknt.examples.graphql.hackernews.models.Feed;
import com.networknt.examples.graphql.hackernews.models.Link;
import com.networknt.examples.graphql.hackernews.models.User;
import com.networknt.examples.graphql.hackernews.models.Vote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HackerNewsDao {

    private static Logger logger = LoggerFactory.getLogger(HackerNewsDao.class);

    public static class Context {
        final Set<Vote> votes = new HashSet<>();
        final Set<List> lists = new HashSet<>();
        final Set<User> users = new HashSet<>();

        final Feed feed = new Feed();
    }

    private static Context context = new Context();

    static {
        Set<Link> links = new HashSet<>();
        links.add(new Link("The best GraphQL client",
                "https://www.apollographql.com/docs/react/", "Jan 30, 2018"));
        links.add(new Link("Prisma turns your database into a GraphQL API \uD83D\uDE0E",
                "https://www.prismagraphql.com", "Jan 30, 2018"));
        context.feed.setLinks(links);

        User user = new User("nick", "n@nzar.io", "password");
        context.users.add(user);
    }

    public Feed getFeed(String filter, int skip, int first, LinkOrderByInput orderBy) {
        logger.debug("Getting feed");
        return context.feed;
    }

    public Link addLink(Link link) {
        context.feed.getLinks().add(link);
        return link;
    }

    public AuthPayload getAuthPayload(String email, String password) {
        User user = new User(null, email, password);
        List<User> users = context.users.stream().filter(eachUser -> eachUser.equals(user)).collect(Collectors.toList());
        if (users != null && users.size() > 0) { // Assume there is 0 or 1 if non-null.
            return new AuthPayload("sometoken", users.get(0));
        }
        return null;
    }

    public AuthPayload signUp(String name, String email, String password) {
        User user = new User(name, email, password);
        context.users.add(user);
        return new AuthPayload("sometoken", user);
    }
}
