package com.networknt.examples.graphql.hackernews;

import com.networknt.examples.graphql.hackernews.enums.LinkOrderByInput;
import com.networknt.examples.graphql.hackernews.models.Feed;
import com.networknt.examples.graphql.hackernews.models.Link;
import com.networknt.examples.graphql.hackernews.models.User;
import com.networknt.examples.graphql.hackernews.models.Vote;
import graphql.schema.DataFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nicholas Azar
 */

public class HackerNewsWiring {
    private static Logger logger = LoggerFactory.getLogger(HackerNewsWiring.class);

    public static class Context {
        final List<Vote> votes = new ArrayList<>();
        final List<List> lists = new ArrayList<>();
        final List<User> users = new ArrayList<>();

        final Feed feed = new Feed();

        public Feed getFeed(String filter, int skip, int first, LinkOrderByInput orderBy) {
            logger.debug("Getting feed");
            return feed;
        }

        public void setLinks(List<Link> links) {
            this.feed.setLinks(links);
        }
    }

    private static Context context = new Context();

    static {
        List<Link> links = new ArrayList<>();
        links.add(new Link("cjcnfwjeif1rx012483nh6utk",
                "The best GraphQL client",
                "https://www.apollographql.com/docs/react/"));
        links.add(new Link("cjcnfznzff1w601247iili50x",
                "Prisma turns your database into a GraphQL API \uD83D\uDE0E",
                "https://www.prismagraphql.com"));
        context.setLinks(links);
    }

    static DataFetcher feedDataFetcher = dataFetchingEnvironment -> {
        return context.getFeed(null, 0, 0, null);
    };
}
