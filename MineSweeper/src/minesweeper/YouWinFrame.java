package minesweeper;


import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static minesweeper.GameLogic.game;

public class YouWinFrame extends JFrame{
    ButtonAction button1=new ButtonAction(){
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    };
    ButtonAction button2=new ButtonAction(){
        public void actionPerformed(ActionEvent e) {
            GameLogic.youWinFrame.setVisible(false);
            GameLogic.startGame();
            game.repaint();
        }
    };
    
    JButton buttonNewGame=new JButton("NEW GAME");
    JButton buttonExit=new JButton("Exit");
    
    public YouWinFrame(){
        this.add(new Label("YOU WON"));
        buttonExit.addActionListener(button1);
        buttonNewGame.addActionListener(button2);
        this.setLayout(new FlowLayout());
        this.setResizable(false);
        
        this.add(buttonNewGame);
        this.add(buttonExit);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(false);
        
    }
    class ButtonAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }
}
