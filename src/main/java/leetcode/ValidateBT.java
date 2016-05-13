package leetcode;

/**
 * Created by haodongl on 4/28/16.
 */
public class ValidateBT {
    public boolean isValidSerialization(String preorder) {
        if(preorder == null) return false;
        String[] chars = preorder.split(",");
        char[] test = new char[chars.length];
        for(int i=0; i<chars.length; i++){
            test[i] = chars[i].charAt(0);
        }
        return isValidSerialization(test);
    }

    public boolean isValidSerialization(char[] preorder){
        if(preorder.length == 1 && preorder[0]=='#') return true;
        if(preorder.length < 3) return false;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<preorder.length; i++){
            char c1 = preorder[i];
            if(i<preorder.length - 2){
                char c2 = preorder[i+1];
                char c3 = preorder[i+2];
                if(c1!='#' && c2=='#' && c3=='#'){
                    sb.append("#");
                    i+=2;
                }else{
                    sb.append(c1);
                }
            }else{
                sb.append(c1);
            }
        }
        String after = sb.toString();
        if(after.length() == preorder.length) return false;
        char[] next = after.toCharArray();
        return isValidSerialization(next);
    }

    public static void main(String[] args){
        System.out.println(new ValidateBT().isValidSerialization(""));
    }
}
