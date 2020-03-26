import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

class Twitter {

    static private HashMap<Integer, Set<Integer>> fan = new HashMap<>();
    static private HashMap<Integer, List<Tweet>> tweets = new HashMap<>();
    static int count = 0;
    static class Tweet{
        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    static void addTweet(int userId, int tweetId){
        if(!fan.containsKey(userId)) fan.put(userId, new HashSet<>());
        fan.get(userId).add(userId);
        if(!tweets.containsKey(userId)) tweets.put(userId, new LinkedList<>());
        tweets.get(userId).add(new Tweet(tweetId, count++));
    }

    static List<Tweet> getNewsFeed(int userId){
        if(!fan.containsKey(userId)) return Collections.emptyList();
        PriorityQueue<Tweet> feed = new PriorityQueue<Tweet>((t1, t2) -> t2.time - t1.time);
        fan.get(userId).stream()
                       .filter(f -> tweets.containsKey(f))
                       .forEach(f -> tweets.get(f).forEach(feed::add));
        List<Tweet> result = new LinkedList<Tweet>();
        while(feed.size() > 0 && result.size() < 10) result.add(feed.poll());
        return result;               
    }

    static void follow(int followerId, int followeeId){
        if(!fan.containsKey(followerId)) fan.put(followerId, new HashSet<>());
        fan.get(followerId).add(followeeId);
    }

    static void unfollow(int followerId, int unfolloweeId){
        if(fan.containsKey(followerId) && followerId != unfolloweeId) fan.get(followerId).remove(unfolloweeId);
    }



    public static void main(String[] args) {
        addTweet(1, 5);
        addTweet(1, 9);
        //getNewsFeed(1).forEach((f) -> System.out.println(f));
        follow(1, 2);
        addTweet(2,6);
        getNewsFeed(1).forEach((f) -> System.out.println(f));
         
    }
}