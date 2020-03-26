import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TopKFrequentElement {

    static List<Integer> getFrequent(int n, int[] arr, int k){
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        for(int a: arr) hmap.put(a, hmap.getOrDefault(a, 0)+1);

        List<Integer>[] lists = new List[n+1];
        for(Map.Entry<Integer, Integer> h: hmap.entrySet()){
            int frequency = h.getValue();
            if(lists[frequency] == null) lists[frequency] = new ArrayList<>();
            lists[frequency].add(h.getKey());
        }

        List<Integer> res = new ArrayList<>();
        for(int i= lists.length-1; i>=0; i--){
            if(lists[i] == null) continue;
            for(int j=0; j<lists[i].size() && res.size() < k; j++){
                res.add(lists[i].get(j));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,2,2,2,3};
        int k = 2;
        List<Integer> res = getFrequent(arr.length, arr, k);
        for(int r: res){
            System.out.print(r+" ");
        }
    }
}