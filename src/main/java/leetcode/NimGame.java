package leetcode;

/**
 * Created by haodongl on 11/23/15.
 */
public class NimGame {

    public boolean canWinNim(int n) {
        boolean[] result = new boolean[3];
        result[0] = true;
        result[1] = true;
        result[2] = true;

        for(int i=3; i<n ; i++){
            result[i%3] = !(result[(i-1)%3]&&result[(i-2)%3]&&result[(i-3)%3]);
        }

        return result[(n-1)%3];

    }

    public static void main(String[] args){
        System.out.println(new NimGame().canWinNim(6));
    }

}
