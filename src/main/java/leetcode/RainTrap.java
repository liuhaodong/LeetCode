package leetcode;

/**
 * Created by haodongl on 4/19/16.
 */
public class RainTrap {
    public int trap(int[] height) {
        if(height == null || height.length <=3) return 0;
        int[] lMax = new int[height.length];
        int[] rMax = new int[height.length];
        lMax[0] = 0;
        rMax[height.length-1] = 0;
        for(int i=1; i<height.length; i++){
            lMax[i] = Math.max(lMax[i-1], height[i-1]);
        }
        for(int i=height.length-2; i>=0; i--){
            rMax[i] = Math.max(rMax[i+1], height[i+1]);
        }
        int sum = 0;
        for(int i=1; i<height.length-1; i++){
            int minHeight = Math.min(lMax[i], rMax[i]);
            sum += (height[i] < minHeight) ? (minHeight - height[i]) : 0;
        }
        return sum;
    }

    public static void main(String[] args){
        int[] test = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new RainTrap().trap(test));
    }
}
