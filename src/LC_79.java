public class LC_79{
  public static void main(){
    char temp = 'a';
    System.out.println(Integer.toBinaryString(temp));
    System.out.println(Integer.toBinaryString(temp ^ 256));



  }
  public boolean exist(char[][] board, String word){
    char[] wordArr = word.toCharArray();
    for(int r = 0; r < board.length; r++){
      for(int c = 0; c < board.length; c++){
        if(exist(board,r,c, wordArr, 0)) return true;
      }
    }
    return false;
  }

  private boolean exist(char[][] board, int r , int c, char[] wordArr, int index){
    if(index == wordArr.length) return true;
    if(r < 0 || r >= board.length || c < 0 || c >= board[0].length ) return false;
    if(board[r][c] != wordArr[index]) return false;

    board[r][c] ^= 256;
    boolean exist = exist(board, r, c-1, wordArr, index + 1 ) ||
                    exist(board, r - 1, c, wordArr, index + 1 ) ||
                    exist(board, r + 1, c , wordArr, index + 1 ) ||
                    exist(board, r, c +1, wordArr, index + 1 );

    board[r][c] ^= 256;
    return exist;
  }

}