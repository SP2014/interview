import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class LexographicalOrder {

    static List<Integer> lexoOrderComaparator(int n){
        List<String> tlist = new ArrayList<String>();
        for(int i =1; i<=n; i++){
            tlist.add(String.valueOf(i));
        }

        Collections.sort(tlist, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
                int i=0;
                while(i<o1.length() && i<o2.length()){
                    if(o1.charAt(i)!=o2.charAt(i)) return o1.charAt(i) - o2.charAt(i);
                    i+=1;
                }
                if(i>=o1.length()) return -1;
				return 1;
			} 
        });

        List<Integer> result = new ArrayList<Integer>();
        for(String s: tlist){
            result.add(Integer.valueOf(s));
        }
        return result;
    }

    static List<Integer> lexoOrderOther(int n){
        int curr = 1;
        List<Integer> result = new ArrayList<Integer>();
        for(int i=1; i<=n; i++){
            result.add(curr);
            if(curr*10<=n) curr*=10;
            else if(curr+1<=n && curr%10!=9) curr+=1;
            else{
                while(curr/10%10 == 9){
                    curr/=10;
                }
                curr = curr/10+1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> res = lexoOrderOther(13);
        for(int r: res){
            System.out.print(r+" ");
        }
    }
}