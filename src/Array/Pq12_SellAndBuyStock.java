package Array;

public class Pq12_SellAndBuyStock {

    static int  maxProfit(int []arr){
        int maxPro = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int cost =arr[i]-minPrice;
            maxPro = Math.max(maxPro, cost); // profit is difference between current and minimum price
            
            minPrice = Math.min(minPrice, arr[i]); // keep track of the lowest price so far
        }  
        return maxPro;
    }
    public static void main(String[] args) {
        int arr[] = { 7, 1, 5, 3, 6, 4 };

        int maxPro = maxProfit(arr);
        System.out.println("Max profit is: " + maxPro);
    }
}
