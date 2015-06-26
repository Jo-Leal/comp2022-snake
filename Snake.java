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
    private char Ddir;
    
    public Snake() {
        ImageIcon ii = new ImageIcon(snake);
        image = ii.getImage();
        x = 850;
        y = 650;
        dir = 'O';
    }
    
    public void move() {
        switch(dir){
            case 'N':
                ImageIcon ii = new ImageIcon("images/head_subindo.png");
                image = ii.getImage();  
                dx = x;
                dy = y;
                y = y - 20;
                break;
                
            case 'S':
                ImageIcon aa = new ImageIcon("images/head_descendo.png");
                image = aa.getImage();
                dx = x;
                dy = y;
                y = y + 20;
                break;
                
            case 'O':
                ImageIcon oo = new ImageIcon(snake);
                image = oo.getImage();
                dx = x;
                dy = y;
                x = x - 20;
                break;
            
            case 'L':
                ImageIcon yy = new ImageIcon("images/head_direita.png");
                image = yy.getImage();
                dx = x;
                dy = y;
                x = x + 20;
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
    
    public char getDir(){
        return this.dir;
    }
    
    public int getDX(){
        return this.dx;
    }
    
    public int getDY(){
        return this.dy;
    }
    
    public char getDdir(){
        return this.Ddir;
    }
    
}