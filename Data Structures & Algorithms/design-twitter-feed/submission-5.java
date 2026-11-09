class Twitter {
    Map<Integer,List<List<Integer>>> posts;
    Map<Integer,Set<Integer>> following;
    int count;
    public Twitter() {
        count=0;
        posts=new HashMap<>();
        following=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        List<List<Integer>> userPosts=posts.computeIfAbsent(userId,
        (k)->new ArrayList<>());
        userPosts.add(new ArrayList<>(List.of(tweetId,count++)));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> set=following.get(userId);
        List<Integer> res=new ArrayList<>();
        List<List<List<Integer>>> followingPosts=new ArrayList<>();
        if(set==null){
            List<List<Integer>> userPosts=posts.computeIfAbsent(userId,
            (k)->new ArrayList<>());
            for(int i=userPosts.size()-1;i>=0&&res.size()<10;i--){
                res.add(userPosts.get(i).get(0));
            }
            return res;
        }
        followingPosts.add(
            new ArrayList<>(posts.computeIfAbsent(userId,(k)->new ArrayList<>()))
        );
        for(int followeeId:set){
            followingPosts.add(
                new ArrayList<>(posts.computeIfAbsent(followeeId,(k)->new ArrayList<>()))
            );
        }
        while(res.size()<10){
            int max=-1;
            for(int i=0;i<followingPosts.size();i++){
                List<List<Integer>> userPosts=followingPosts.get(i);
                List<List<Integer>> maxPosts=max!=-1?followingPosts.get(max):null;
                if(userPosts.size()>0&&(max==-1||
                userPosts.get(userPosts.size()-1).get(1)
                >
                maxPosts.get(maxPosts.size()-1).get(1)
                )){
                    max=i;
                }
            }
            if(max==-1){
                break;
            }
            List<List<Integer>> maxPosts=followingPosts.get(max);
            res.add(maxPosts.remove(maxPosts.size()-1).get(0));
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> followingSet=
        following.computeIfAbsent(followerId,(k)->new HashSet<>());
        followingSet.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set=following.get(followerId);
        if(set==null){
            return;
        }
        set.remove(followeeId);
    }
}
