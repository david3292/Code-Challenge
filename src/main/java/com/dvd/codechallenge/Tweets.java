/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvd.codechallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

/**
 *
 * @author david
 */
public class Tweets {
    
    private List<String> tweets;

    public Tweets() {
        this.tweets = new ArrayList<>();
    }

    public Tweets(List<String> tweets) {
        this.tweets = tweets;
    }
    
    public void addTweet(String t){
        this.tweets.add(t);
    }

    public List<String> getTweets() {
        return tweets;
    }

    public void setTweets(List<String> tweets) {
        this.tweets = tweets;
    }
    
    public long wordCount(String w){
        String low = w.toLowerCase();        
        return tweets.stream().filter(x -> x.contains(w)).count() + tweets.stream().filter(x -> x.contains(low)).count();
    }
    
}
