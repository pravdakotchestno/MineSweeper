/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minesweeper;

import java.awt.Graphics;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
    
    public GamePanel(){
        this.setSize(300,300);
        
        
    }
    
    public void paintComponent(Graphics g) {
        int XStep=0;
        int YStep=0;
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                
                try{
                    g.drawImage(ImageIO.read(new File("pics/"+GameLogic.getVisibleField()[i][j]+".png")),XStep,YStep,null);
                }catch(Exception e){
                    e.printStackTrace();
                }
                
                XStep+=30;
            }
            XStep=0;
            YStep+=30;
        }
    }
}
