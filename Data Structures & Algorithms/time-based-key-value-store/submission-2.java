class TimestampData{
    int timestamp;
    String value;
    TimestampData(int t,String v){
        timestamp=t;
        value=v;
    }
}

class TimeMap {
    Map<String,List<TimestampData>> map;
    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<TimestampData> l=map.computeIfAbsent(key,k->new ArrayList<>());
        l.add(new TimestampData(timestamp,value));
        map.put(
            key,
            l
        );
    }
   
    public String get(String key, int timestamp) {
        List<TimestampData> list=map.getOrDefault(key,List.of());
        int len=list.size();
        if(len==0){
            return "";
        }
        int l=0,r=len-1;
        int index=-1;
        while(l<=r){
            int mid=(l+r)/2;
            TimestampData t=list.get(mid);
            if(t.timestamp==timestamp){
                return t.value;
            }else if(timestamp>=t.timestamp){
                index=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        if(index==-1){
            return "";
        }
        return list.get(index).value;
    }
}
