import java.util.*;
public class Sudoku {
    public static boolean isSafe(int sudoku[][], int row, int col , int digit){
        //column
        for( int i = 0; i<=8;i++){ // it's trevas 9 row's
            if(sudoku[i][col]==digit){// if already digit placed in col then return false
                return false;
            }
        }
        //Row
        for(int j = 0 ; j<=8; j++){ // it's trevas 9 column's 
            if(sudoku[row][j] == digit){// if already digit placed in row then return false
                return false;
            }
        }

        // Grid
         int sr = (row/3) * 3; //calculating starting row of 3*3 grid
         int sc = (col/3) * 3;  // calculating starting col of 3*3 grid
         //3x3 grid
         for(int i =sr; i<sr+3;i++){ // it's  trevas  rows of 3*3 grids
            for(int j= sc ; j<sc+3;j++){ // it's trevas columns of 3*3 grids
                if(sudoku[i][j]==digit){ // if digit is placed in 3*3 grid row and col then return false
                    return false;
                }
            }
         }
         return true; // if all condition is accept then isSafe is return true

    }
    public static boolean sudokuSolver(int sudoku[][],int row , int col){
        // Base Case
         if(row == 9){
            return true;
         }
        // Recursion

        //calculate the next row
        int nextRow = row;  // first row is constant
        int nextCol = col+1; // col is update one by one
        if(col+1 == 9){  //while col is overflow  from out side of sudoku then it update to next row
            nextRow = row+1;
            nextCol = 0;// again col is start with first box of second row
        }


        if(sudoku[row][col] !=0){  //if sudoku box is not have zero then we call next column and next rows
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        // 1 to 9 digit number need for place on sudoku
        for(int digit = 1; digit<=9 ; digit++){
              if(isSafe(sudoku, row , col, digit)){
                sudoku[row][col] = digit;  //if placing digit on row and col is  safe then place it
                if(sudokuSolver(sudoku, nextRow, nextCol)){ // if its return true then solution is exisit
                    return true;

                }
                sudoku[row][col]= 0; // if return false then solution is not exisit

              }                           
        }
        return false;
    }
    
    public static void printSudoku(int sudoku[][]){
        for(int i=0;i<9; i++){
            for(int j = 0 ; j<9;j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int sudoku[][] = {{0,0,8,0,0,0,0,0,0},
        {4,9,0,1,5,7,0,0,2},
        {0,0,3,0,0,4,1,9,0},
        {1,8,5,0,6,0,0,2,0},
        {0,0,0,0,2,0,0,6,0},
        {9,6,0,4,0,5,3,0,0},
        {0,3,0,0,7,2,0,0,4},
        {0,4,9,0,3,0,0,5,7},
        {8,2,7,0,0,9,0,1,3}};

        if(sudokuSolver(sudoku,0,0)){
            System.out.println("Solution exists");
            printSudoku(sudoku);
        }else {
            System.out.println("Solution does not exists");
        }
    }
}
