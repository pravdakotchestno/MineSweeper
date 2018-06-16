package minesweeper;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

public class GameFrame extends JFrame implements MouseListener{
    
    private GamePanel gamePanel=new GamePanel();
    
    public GameFrame(){
        this.setBounds(10,10,300,323);
        this.setTitle("Mine Sweeper");
        this.getContentPane().add(gamePanel);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addMouseListener(this);
        this.setVisible(true);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        GameLogic.click(e.getX()/30,(e.getY()-23)/30,e.getButton());
        gamePanel.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
