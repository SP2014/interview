class StockBuy{

    static int stockSum(int[] stock){
        if(stock.length<=1) return 0;
        int min = stock[0];
        int max = 0;
        for(int i=1; i< stock.length; ++i){
            if(min < stock[i]){
                max = Math.max(max, stock[i]-min);
            }
            else{
                min = stock[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(stockSum(new int[]{7,6,4,3,1}));
    }
}