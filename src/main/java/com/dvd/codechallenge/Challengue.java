/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvd.codechallenge;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author dquimbiulco
 */
public class Challengue {

    public static void main(String[] args) {
        long countHaskell = getNumberHaskell();
        System.out.println("The word Haskell appeared " + countHaskell + " times");
    }

    public static long getNumberHaskell() {
        try {

            Tweets ts = getTweets("@stackbuilders");
            return ts.wordCount("Haskell");
        } catch (TwitterException ex) {
            Logger.getLogger(Challengue.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static Tweets getTweets(String user) throws TwitterException {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("sMYxrCslzDDHGhFn5MSvPMWhw")
                .setOAuthConsumerSecret("ip8E4OoTGNQetDHz8oTereIsXAnO2cGlgs7Dd2S4lXti4weHAt")
                .setOAuthAccessToken("451175684-DBydPtZsitmr6EHPVansnVygQXRALCCKnKUqUa4W")
                .setOAuthAccessTokenSecret("prPHOfZj3IMFrW7ToFbKWJkRjWHM2qlpUdSecEZyuhLvd");        

        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        List<Status> statuses = twitter.getUserTimeline(user);

//        System.out.println("Tweets recuperados");
//        statuses.forEach(x -> System.out.println(x.getUser().getName()
//                + "-> " + x.getUser().getScreenName() + ":::"
//                + x.getText()));

        Tweets ts = new Tweets();
        statuses.forEach(x -> ts.addTweet(x.getText()));

        return ts;
    }
}
