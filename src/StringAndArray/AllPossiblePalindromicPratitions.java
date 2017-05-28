package StringAndArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FS047207 on 5/23/2017.
 */
public class AllPossiblePalindromicPratitions {

    /*
    High complexity
     */
    public void printAllPalindromes(String s){
        for(int i=0; i<s.length(); i++){
            for(int j=0; j<s.length()-i; j++){
                String temp = s.substring(j, i+j+1);
                if(temp.equals(new StringBuilder(temp).reverse().toString()))
                    System.out.println(temp);
            }
        }
    }

    /*
    Using DFS
     */
    public ArrayList<List<String>> printPalindromes(String s){
        ArrayList<List<String>> result = new ArrayList<>();
        if(s == null || s.length() == 0)
            return result;

        ArrayList<String> partition = new ArrayList<>();
        addPalindrome(s, 0, partition, result);

        return result;

    }

    public void addPalindrome(String s, int start, ArrayList<String> partition, ArrayList<List<String>> result){
        if(start == s.length()){
            ArrayList<String> t = new ArrayList<>(partition);
            result.add(t);
            return;
        }

        for(int i=start+1; i<=s.length(); i++){
            String str = s.substring(start, i);
            if(isPalindrom(str)){
                partition.add(str); //add substring to result
                addPalindrome(s, i, partition, result);
                partition.remove(partition.size()-1);  //remove substring from current partition
            }
        }
    }

    public boolean isPalindrom(String s){
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String args[]){
        AllPossiblePalindromicPratitions p = new AllPossiblePalindromicPratitions();
        p.printAllPalindromes("nitin");
        ArrayList<List<String>> temp = p.printPalindromes("geeksT");
        for(List<String> s : temp){
            for(String sub : s){
                System.out.print(sub+" ");
            }
            System.out.println("");
        }

    }
}
