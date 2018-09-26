package wordSearch;

public class wordSearch {
	public static boolean exist(char[][] board, String word) {
        
       for (int x=0;x<board.length;x++){
    	   for (int y=0;y<board[0].length;y++){
    		   if(findWord(x,y,0,word,board)){return true;}
    	   }
       }
       return false;
    }
    
    public static boolean findWord(int x, int y, int movei, String word, char[][] board){
    	int xMove[]={1,-1,0,0};
        int yMove[]={0,0,1,-1};
    	int next_x,next_y;
        if (movei==word.length()){return true;}
        if (!isAvailable(x,y,board)||board[x][y]!=word.charAt(movei)){return false;}
        char temp=board[x][y];
        board[x][y]='@';
        
        for (int k=0;k<4;k++){
            next_x=x+xMove[k];
            next_y=y+yMove[k];
            if (findWord(next_x,next_y,movei+1,word,board)){
            	return true;
            }
        }
        board[x][y]=temp;
        return false;
    }
    
    public static boolean isAvailable(int x, int y, char[][] board){
        return (x>=0 && x<board.length && y>=0 && y<board[0].length && board[x][y]>=65);
    }

	public static void main(String[] args) {
		char[][] board={
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};
		String word="ABCCED";
		//String word="SEE";
		//String word="ABCB";
		System.out.println(exist(board,word));
	}

}
