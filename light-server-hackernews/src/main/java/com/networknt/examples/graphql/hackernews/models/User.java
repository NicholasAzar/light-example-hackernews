package com.networknt.examples.graphql.hackernews.models;

import lombok.Data;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author Nicholas Azar
 */

@Data
public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private List<Link> links;
    private List<Vote> votes;

    static MessageDigest messageDigest;

    static {
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public User(String name, String email, String plaintextPassword) {
        messageDigest.update(email.getBytes(UTF_8));
        this.id = new String(messageDigest.digest(), UTF_8);
        this.name = name;
        this.email = email;
        messageDigest.update(plaintextPassword.getBytes());
        this.password = new String(messageDigest.digest(), UTF_8);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof User && ((User) obj).id.equals(this.id);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
}
