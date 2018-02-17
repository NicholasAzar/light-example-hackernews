package com.networknt.examples.graphql.hackernews;

import com.networknt.examples.graphql.hackernews.enums.LinkOrderByInput;
import com.networknt.examples.graphql.hackernews.models.Feed;
import com.networknt.examples.graphql.hackernews.models.Link;
import com.networknt.examples.graphql.hackernews.models.User;
import com.networknt.examples.graphql.hackernews.models.Vote;
import com.networknt.examples.graphql.hackernews.utils.HttpUtils;
import graphql.schema.DataFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Nicholas Azar
 */

public class HackerNewsWiring {

    private static HackerNewsDao hackerNewsDao = new HackerNewsDao();


    static DataFetcher feedDataFetcher = dataFetchingEnvironment -> {
        return hackerNewsDao.getFeed(null, 0, 0, null);
    };

    static DataFetcher createLink = dataFetchingEnvironment -> {
        String url = dataFetchingEnvironment.getArgument("url");
        String description = dataFetchingEnvironment.getArgument("description");
        Link link = new Link(description, url, "Jan 30, 2018");
        return hackerNewsDao.addLink(link);
    };

    static DataFetcher login = dataFetchingEnvironment -> {
        String email = dataFetchingEnvironment.getArgument("email");
        String password = dataFetchingEnvironment.getArgument("password");
        return hackerNewsDao.getAuthPayload(email, password);
    };

    static DataFetcher signUp = dataFetchingEnvironment -> {
        String name = dataFetchingEnvironment.getArgument("name");
        String email = dataFetchingEnvironment.getArgument("email");
        String password = dataFetchingEnvironment.getArgument("password");
        return hackerNewsDao.signUp(name, email, password);
    };

    static DataFetcher getUsers = dataFetchingEnvironment -> {
        try {
            return HttpUtils.sendGet(List.class, "localhost:80801/v1/users");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    };

}
