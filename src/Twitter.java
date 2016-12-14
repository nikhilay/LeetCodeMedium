import java.util.*;

/**
 * Created by Nikhil on 12/14/16.
 */
public class Twitter {
    /**
     * Design a simplified version of Twitter where users can post tweets,
     * follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed.
     * Your design should support the following methods:
     * postTweet(userId, tweetId): Compose a new tweet.
     * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
     * the news feed must be posted by users who the user followed or by the user herself. Tweets must be
     * ordered from most recent to least recent.
     * follow(followerId, followeeId): Follower follows a followee.
     * unfollow(followerId, followeeId): Follower unfollows a followee
     */
    class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.time = time;
            this.tweetId = tweetId;
        }

    }

    private HashMap<Integer, HashSet<Integer>> followers;
    private HashMap<Integer, LinkedList<Tweet>> tweets;
    private static int countTime;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        followers = new HashMap<>();
        tweets = new HashMap<>();
        countTime = 0;
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new LinkedList<Tweet>());
        }
        tweets.get(userId).add(new Tweet(tweetId, countTime));
        countTime++;

    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>(10, new Comparator<Tweet>() {
            @Override
            public int compare(Tweet o1, Tweet o2) {
                return o1.time - o2.time;
            }
        });
        List<Integer> result = new LinkedList<>();
        HashSet<Integer> followee = followers.get(userId);
        if (followee == null) {
            followee = new HashSet<>();
        }
        followee.add(userId);
        for (int i : followee) {
            LinkedList<Tweet> totalTweets = tweets.get(i);
            if (totalTweets != null) {
                for (Tweet tweet : totalTweets) {
                    pq.add(tweet);
                    if (pq.size() > 10) {
                        pq.poll();
                    }
                }
            }
        }
        while (!pq.isEmpty()) {
            result.add(0, pq.poll().tweetId);
        }
        return result;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!followers.containsKey(followerId)) {
            followers.put(followerId, new HashSet<Integer>());
        }
        followers.get(followerId).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {

        if (followers.containsKey(followerId) && followeeId != followerId && followers.get(followerId).contains(followeeId)) {
            followers.get(followerId).remove(followeeId);
        }
    }

}
