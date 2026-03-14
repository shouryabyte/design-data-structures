import java.util.ArrayList;

public class LRUcacheBrute {
    int capacity;
    ArrayList<int []> cache;
    public LRUcacheBrute(int capacity){
        this.capacity=capacity;
        cache=new ArrayList<>();
    }
    public int get(int key){
        for(int i=0;i<cache.size();i++){
            if(cache.get(i)[0]==key){
                int value=cache.get(i)[1];
                int [] temp = cache.remove(i);
                cache.add(temp);
                return value;
            }
        }
        return -1;
    }
    public void put(int key, int value){
        for(int i=0;i<cache.size();i++){
            if(cache.get(i)[0]==key){
                int [] temp= cache.remove(i);
                temp[1]=value;
                cache.add(temp);
                return;
            }
        }
        if(cache.size()==capacity){
            cache.remove(0);
        }
        cache.add(new int []{key,value});
    }
    public static void main(String[] args) {
        LRUcacheBrute lru = new LRUcacheBrute(2);
        lru.put(1,1);
        lru.put(2,2);
        System.out.println(lru.get(1));
        lru.put(3,3);
        System.out.println(lru.get(2));
        lru.put(4,4);
        System.out.println(lru.get(1));
        System.out.println(lru.get(3));
        System.out.println(lru.get(4));

    }
}
