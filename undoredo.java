import java.util.*;

public class undoredo {
    char[][] copy;
    static Stack<char[][]> undo = new Stack<>();
    static Stack<char[][]> redo = new Stack<>();

    public undoredo(char[][] board){
        copy = new char[3][3];

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                copy[i][j] = board[i][j];
            }
        }

        undo.push(copy);
        if(!redo.isEmpty()){
            redo.clear();
        }
    }
    

    public char[][] undoMoves(){
        
        redo.push(undo.pop());

        return undo.pop();
        
    }

    public char[][] redoMoves(){
        
        undo.push(redo.pop());
        return undo.pop();
        
    }

    public static String stackSize(){
       String stacksize = "undo: "+undo.size()+" redu: "+redo.size();

       return stacksize;
    }

    public static boolean undoSize(){
        return undo.size()==0;
    }

    public static boolean redoSize(){
        return redo.size()==0;
    }

}