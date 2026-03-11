import java.util.*;
public class InsertDeleteGetRandom {
        private ArrayList<Integer> list;
        private HashMap<Integer,Integer> map;
        private Random random;
        public InsertDeleteGetRandom(){
            list=new ArrayList<>();
            map=new HashMap<>();
            random=new Random();
        }
        public boolean insert(int val){
            if(map.containsKey(val)){
                return false;
            }
            list.add(val);
            map.put(val,list.size()-1);
            return true;
        }
        public boolean delete(int val){
            if(!map.containsKey(val)){
                return false;
            }
            int index=map.get(val);
            int lastelement=list.get(list.size()-1);
            list.set(index,lastelement);
            map.put(lastelement,index);
            list.remove(list.size()-1);
            map.remove(val);
            return true;
        }
        public int getRandom(){
            int idx=random.nextInt(list.size());
            return list.get(idx);
        }
        public static void main(String[] args) {
            InsertDeleteGetRandom isg = new InsertDeleteGetRandom();
            System.out.println("Insert 10:"+isg.insert(10));
            System.out.println("Insert 20: " + isg.insert(20));
            System.out.println("Insert 30: " + isg.insert(30));
            System.out.println("Random Element: " + isg.getRandom());
            System.out.println("Delete 20: " + isg.delete(20));      
            System.out.println("Random Element: " + isg.getRandom());
            System.out.println("Insert 40: " + isg.insert(40));
            System.out.println("Random Element: " + isg.getRandom());

        }
}