package leetcode;

import java.lang.ref.WeakReference;

/**
 * Created by haodongl on 12/10/15.
 */
public class WeakRefTest {
    public static void main(String[] args){
        WeakReference<String> test = new WeakReference<String>(new String("abcdefg"));
        System.out.println(test.get());
        System.gc();
        System.out.println(test.get());
    }
}
