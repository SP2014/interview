import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

class CustomDs {

    private HashMap<Integer, Integer> lookupMap;
    private List<Integer> list;
    private Random random;

    public CustomDs(){
        this.list = new ArrayList<Integer>();
        this.lookupMap = new HashMap<Integer, Integer>();
        this.random = new Random();
    }

    public boolean insert(int v){
        if(this.lookupMap.containsKey(v)) return false;
        this.lookupMap.put(v, this.list.size());
        this.list.add(v);
        return true; 
    }

    public boolean remove(int v){
        if(!this.lookupMap.containsKey(v)) return false;
        int idx = this.lookupMap.get(v);
        int lastElement = this.list.get(this.list.size()-1);
        this.lookupMap.put(lastElement, idx);
        this.list.set(idx, lastElement);
        this.list.remove(this.list.size()-1);
        this.lookupMap.remove(v);
        return true;
    }

    public int getRandom(){
        return this.list.get(this.random.nextInt(this.list.size()));
    }

    public static void main(String[] args) {
        CustomDs cds = new CustomDs();
        cds.insert(1);
        
    }
}