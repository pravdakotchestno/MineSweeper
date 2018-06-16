package minesweeper;

import java.util.Random;
import javax.swing.JOptionPane;

public class GameLogic {
    
    public static GameFrame game;
    public static YouLoseFrame youLoseFrame;
    public static YouWinFrame youWinFrame;
    
    private static int[][] field=new int[10][10];
    private static int[][] visibleField=new int[10][10];
    
    
    private static int COUNTOFMINES;
    
    
    private static Random rand=new Random();
    
    //    -1 0 1
    //
    //-1   # # #
    // 0   # @ #
    // 1   # # #
    //
    //
    private static final int[] PROVERKI={-1, -1,   -1, 0,   -1, 1,   0, 1,   1, 1,   1, 0,   1, -1,   0, -1};
    
    public static void init(){
        
        youWinFrame=new YouWinFrame();
        youLoseFrame=new YouLoseFrame();
        game=new GameFrame();
        startGame();
    }
    public static void startGame(){
        boolean flag;
        do{
            flag=false;
            try{
                COUNTOFMINES=Integer.parseInt(JOptionPane.showInputDialog("Enter number of mines please:"));
                fillField(COUNTOFMINES);
            }catch(Exception e){
                flag=true;
            }
        }while(flag);
        
        visibleField=new int[10][10];
        game.repaint();
        
        
        
        game.setVisible(true);
        
        
    }
    
    public static void gameOver(){
        game.setVisible(false);
        youLoseFrame.setVisible(true);
    }
    
    
    public static void fillField(int countOfMines)throws Exception{
        
        if(countOfMines>=100||countOfMines<1){
            throw new Exception("uncorrect number of mines!");
        }
        
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                field[i][j]=0;
            }
        }
        
        
        
        for(;countOfMines>0;countOfMines--){
            int mineX=rand.nextInt(10);
            int mineY=rand.nextInt(10);
            while(field[mineX][mineY]==9){
                mineX=rand.nextInt(10);
                mineY=rand.nextInt(10);
            }
            field[mineX][mineY]=9;
            
        }
        
        
        
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                int countofmines=0;
                if(field[i][j]==0){
                
                    for(int u=0;u<=14;u+=2){
                    
                        int xcord=PROVERKI[u]+i;
                        int ycord=PROVERKI[u+1]+j;
                    
                        if (!(xcord<0||ycord<0||xcord>9||ycord>9)&&field[xcord][ycord]==9) countofmines++;
                    }
                    if (countofmines>0) field[i][j]=countofmines;
                }
                
            }
        }
        
        
        
    }
    public static void fillVisibleField(int y,int x){
        if(field[x][y]!=0){
            visibleField[x][y]=field[x][y];
            
        }else{
            visibleField[x][y]=10;
            for(int u=0;u<=14;u+=2){
                    
                int xcord=PROVERKI[u]+x;
                int ycord=PROVERKI[u+1]+y;
                    
                if (!(xcord<0||ycord<0||xcord>9||ycord>9)&&visibleField[xcord][ycord]==0){
                    fillVisibleField(ycord,xcord);
                }
             }
        }
    }
    
    
    public static void click(int x, int y, int button){
        switch(button){
            case 1:{
                openCell(x,y);
                break;
            }
            case 3:{
                setMine(x,y);
                break;
            }default:{
                
            }
        }
        
        checkMines();
        
    }
    
    public static void checkMines(){
        int countofmines=0;
        int countoffoundedmines=0;
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(visibleField[i][j]==9){
                    countoffoundedmines++;
                }
                if(visibleField[i][j]==9&&field[i][j]==9){
                    
                    countofmines++;
                    
                    
                }
            }
        }
        if(countofmines==COUNTOFMINES&&countoffoundedmines==COUNTOFMINES){
            win();
        }
    }
    
    public static void win(){
        
        game.setVisible(false);
        
        youWinFrame.setVisible(true);
    }
    
    public static void setMine(int x, int y){
        
        if(visibleField[y][x]==9){
            visibleField[y][x]=0;
        }else if(visibleField[y][x]==0){
            visibleField[y][x]=9;
        }
    }
    public static void openCell(int x, int y){
        
        if(visibleField[y][x]==9){
            
        }else if(field[y][x]==9){
            gameOver();
        }else{
            fillVisibleField(x,y);
        }
    }
    public static int[][] getVisibleField(){
        return visibleField;
    }
    public static int[][] getField(){
        return field;
    }
}
