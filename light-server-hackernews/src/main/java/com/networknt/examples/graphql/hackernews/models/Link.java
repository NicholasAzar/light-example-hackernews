package com.networknt.examples.graphql.hackernews.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author Nicholas Azar
 */

@Data
@NoArgsConstructor
public class Link {
    private String id;
    private String createdAt;
    private String description;
    private String url;
    private User postedBy;
    private List<Vote> votes;

    static MessageDigest messageDigest;

    static {
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public Link(String description, String url, String createdAt) {
        messageDigest.update(url.getBytes(UTF_8));
        this.id = new String(messageDigest.digest(), UTF_8);
        this.description = description;
        this.url = url;
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Link && ((Link) obj).id.equals(this.id);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
}
