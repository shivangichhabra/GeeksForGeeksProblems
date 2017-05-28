package StringAndArray;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by FS047207 on 5/23/2017.
 */
public class MaxProfit {

    /*
    O(n)
    If you buy and sell one time
     */
    public int[] getProfit(int[] prices){
        int[] result = new int[2];
        if(prices.length == 0)
            return new int[2];
        int min = prices[0];
        int max = 0;
        for(int i=1; i<prices.length; i++){
            if(prices[i] < min) {
                min = prices[i];
            } else {
                if(prices[i] - min > max) {
                    max = prices[i] - min;
                    result[0] = prices[i];
                    result[1] = min;
                }
            }
        }
        return result;
    }

    /*
    O(n)
    Find local mazima and minima and
     */
    public void getP(int[] prices){
        Map<Integer, Integer> map = new HashMap<>();

        int i=0; int n = prices.length-1;
        while ((i<n)){
            while(i<n && prices[i] >= prices[i+1])
                i++;

            if(i == n)
                break;
            //local minima
            int key = i++;

            while(i<n+1 && prices[i] >= prices[i-1])
                i++;

            //local maxima
            int value = i-1;
            map.put(key, value);
        }

        if(map.size() > 0){
            for(Map.Entry<Integer, Integer> entry : map.entrySet())
                System.out.println(entry.getKey() + "  " + entry.getValue());
        }
    }

    public static void main(String args[]){
        MaxProfit mp = new MaxProfit();
        int price[] = {100, 180, 260, 310, 40, 535, 695};
        int[] result = mp.getProfit(price);
        System.out.println(result[0] + "  " + result[1]);

        mp.getP(price);
    }

}
