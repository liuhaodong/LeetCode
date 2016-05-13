package leetcode;

/**
 * Created by haodongl on 3/5/16.
 */
public class WordSearch {

    public static void main(String[] args){
        WordSearch test = new WordSearch();
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        System.out.println(test.exist(board, "ABCCED"));
    }

    public boolean exist(char[][] board, String word) {
        if(board == null || word == null || word.isEmpty() || board.length ==0 || board[0].length == 0 ) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]!=word.charAt(0)) continue;
                if(dfsUtil(board,i,j, visited, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsUtil(char[][] board, int i, int j, boolean[][] visited, String word, int start){
        char current = word.charAt(start);
        if(start == word.length() -1){
            if(board[i][j] == current) return true;
            else return false;
        }
        if(board[i][j] == current){
            // mark current as visited
            visited[i][j] = true;

            // search for next char
            // left
            if(isValid(board, i, j-1) && !visited[i][j-1] && board[i][j-1] == word.charAt(start+1)){
                if(dfsUtil(board, i, j-1, visited, word, start + 1) ) return true;
            }
            // right
            if(isValid(board, i, j+1) && !visited[i][j+1]&& board[i][j+1] == word.charAt(start+1) ){
                if(dfsUtil(board, i, j+1, visited, word, start + 1) ) return true;
            }

            //top
            if(isValid(board, i-1, j) && !visited[i-1][j] && board[i-1][j] == word.charAt(start+1)){
                if(dfsUtil(board, i-1, j, visited, word, start + 1) ) return true;
            }

            //bot
            if(isValid(board, i+1, j) && !visited[i+1][j] && board[i+1][j] == word.charAt(start+1)){
                if(dfsUtil(board, i+1, j, visited, word, start + 1) ) return true;
            }
            visited[i][j] = false;
            return false;
        }else {
            return false;
        }
    }

    private boolean isValid(char[][] board, int i, int j){
        if(i>=0 && i<board.length && j>=0 && j<board[0].length){
            return true;
        }
        return false;
    }
}
