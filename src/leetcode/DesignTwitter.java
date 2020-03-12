package leetcode;

import java.util.*;

// https://leetcode.com/problems/design-twitter/
public class DesignTwitter {

    public static void main(String[] args) {
        // CASE 1
        Twitter twitter = new Twitter();

        // User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 5);

        // User 1's news feed should return a list with 1 tweet id -> [5].
        twitter.getNewsFeed(1);

        // User 1 follows user 2.
        twitter.follow(1, 2);

        // User 2 posts a new tweet (id = 6).
        twitter.postTweet(2, 6);

        // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
        // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.getNewsFeed(1);

        // User 1 unfollows user 2.
        twitter.unfollow(1, 2);

        // User 1's news feed should return a list with 1 tweet id -> [5],
        // since user 1 is no longer following user 2.
        twitter.getNewsFeed(1);

        // CASE 2
        twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        twitter.getNewsFeed(1);

        // CASE 3
        twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.follow(1, 1);
        twitter.getNewsFeed(1);
    }

    private static class Twitter {

        private final Map<Integer, User> users;
        private int tweetsCount = 0;

        /** Initialize your data structure here. */
        public Twitter() { this.users = new HashMap<>(); }


        /** Compose a new tweet. */
        // O(1)
        public void postTweet(int userId, int tweetId) {
            User u = getUser(userId);
            Tweet t = new Tweet(tweetId, ++tweetsCount);
            u.addTweet(t);
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            final int newsSize = 10;
            List<Integer> news = new ArrayList<>(newsSize);
            User u = getUser(userId);

            // heapify
            PriorityQueue<Tweet> feed = new PriorityQueue<>(u.tweets);
            for (User followee : u.followees) {
                feed.addAll(followee.getLastTweets(newsSize));
            }

            // find 10 most recent news
            for (int i = 0; i < newsSize; i++) {
                Tweet t = feed.poll();
                if (t == null) {
                    break;
                }
                news.add(t.id);
            }
            return news;
        }

        // O(1)
        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if (followerId == followeeId) {
                return;
            }
            User follower = getUser(followerId);
            User followee = getUser(followeeId);
            follower.follow(followee);
        }

        // O(1)
        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            User follower = getUser(followerId);
            User followee = getUser(followeeId);
            follower.unfollow(followee);
        }

        private User getUser(int id) {
            return users.computeIfAbsent(id, User::new);
        }

        private final class User {
            private final int id;
            private final Set<User> followees = new HashSet<>();
            private final List<Tweet> tweets = new ArrayList<>();

            public User(int id) { this.id = id; }

            public void addTweet(Tweet t) { tweets.add(t); }

            public List<Tweet> getLastTweets(int count) {
                return count < tweets.size()
                        ? tweets.subList(tweets.size() - count - 1, tweets.size())
                        : tweets;
            }

            public void follow(User u) { followees.add(u); }

            public void unfollow(User u) { followees.remove(u); }

            @Override
            public int hashCode() { return Integer.hashCode(id); }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                User user = (User) o;
                return id == user.id;
            }
        }

        private final class Tweet implements Comparable<Tweet> {
            private final int id;
            private final int number;

            public Tweet(int id, int number) {
                this.id = id;
                this.number = number;
            }

            @Override
            public int compareTo(Tweet o) {
                return Long.compare(number, o.number) * -1;
            }
        }
    }
}
