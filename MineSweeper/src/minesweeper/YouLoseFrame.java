package minesweeper;

import java.awt.FlowLayout;
import java.awt.Label;
import javax.swing.JFrame;

public class YouLoseFrame extends JFrame{
    public YouLoseFrame(){
        
        this.setResizable(false);
        
        this.setLayout(new FlowLayout());
        this.add(new Label("Game Over\n"));
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(false);
    }
}
