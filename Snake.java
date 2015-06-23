import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
/**
 * Write a description of class Snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snake extends JPanel
{
    private String snake = "images/head.png";

    private int dx;
    private int dy;
    private int x;
    private int y;
    private Image image;
    private char dir;
    
    public Snake() {
        ImageIcon ii = new ImageIcon(snake);
        image = ii.getImage();
        x = 40;
        y = 60;
    }
    
    public void move() {
        switch(dir){
            case 'N':
                y = y - 1;
                break;
                
            case 'S':
                y = y + 1;
                break;
                
            case 'O':
                x = x - 1;
                break;
            
            case 'L':
                x = x + 1;
                break;
                
            default:
                break;
                
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }
    
    public void desenhaCobra(Graphics g){
        g.drawImage(getImage(),getX(),getY(), null);
        
    }
    
    public void setDir(char dir){
        this.dir = dir;
    }
    
    

}

