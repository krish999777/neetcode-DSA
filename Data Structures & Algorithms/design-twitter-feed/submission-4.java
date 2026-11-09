class Twitter {
    List<List<Integer>> tweets;
    Map<Integer,Set<Integer>> following;
    public Twitter() {
        tweets=new ArrayList<>();
        following=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.add(new ArrayList<>(List.of(userId,tweetId)));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // System.out.println(tweets);
        // System.out.println(following);
        List<Integer> result=new ArrayList<>();
        Set<Integer> followingSet=following.get(userId);
        for(int i=tweets.size()-1;i>=0&&result.size()<10;i--){
            List<Integer> tweet=tweets.get(i);
            int tweetAuthorId=tweet.get(0);
            if(userId==tweetAuthorId||
                (followingSet!=null&&followingSet.contains(tweetAuthorId))
            ){
                result.add(tweet.get(1));
            }
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> followingSet=
        following.computeIfAbsent(followerId,(k)->new HashSet<>());
        followingSet.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set=following.get(followerId);
        // if(set==null){
        //     return;
        // }
        set.remove(followeeId);
    }
}
