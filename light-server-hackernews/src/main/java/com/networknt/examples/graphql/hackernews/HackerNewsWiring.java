package com.networknt.examples.graphql.hackernews;

import com.networknt.examples.graphql.hackernews.enums.LinkOrderByInput;
import com.networknt.examples.graphql.hackernews.models.Feed;
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

        public Feed getFeed(String filter, int skip, int first, LinkOrderByInput orderBy) {
            logger.debug("Getting feed");
            return new Feed();
        }
    }

    private static Context context = new Context();

    static DataFetcher feedDataFetcher = dataFetchingEnvironment -> {
        return context.getFeed(null, 0, 0, null);
    };
}
