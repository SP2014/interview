import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {

    public static List<List<Integer>> getSum(int[] arr){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=0; i< arr.length-2; ++i){
            if(i>0 && arr[i] == arr[i-1]) continue;

            int target  = -arr[i];
            int j = i+1;
            int k = arr.length-1;

            while(j<k){
                if(arr[j]+arr[k] == target){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    temp.add(arr[k]);
                    result.add(temp);
                    j++;
                    k--;

                    while(j<k && arr[j] == arr[j-1]) j++;
                    while(j<k && arr[k] == arr[k+1]) k--;
                }
                else if(arr[j]+arr[k] < target){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,1,2,-1,-4};
        System.out.println(getSum(arr));
    }
}