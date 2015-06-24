
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
/**
 * Write a description of class Body here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Body
{
    // instance variables - replace the example below with your own
    private String name_body = "images/body.png";
    private Image body;
    private Body proximo;
    private int x;
    private int y;
    private char dir;

    /**
     * Constructor for objects of class Body
     */
    public Body()
    {
        ImageIcon aa = new ImageIcon(name_body);
        body = aa.getImage();
        
    }
    
    public void setProximo(Body proximo){
        this.proximo = proximo;
    }
    
    public Body getProximo(){
        return this.proximo;
    }
    
    public Image getImage(){
        return this.body;
    }
    
    public void desenhaCorpo(int x ,int y, Graphics g){
        g.drawImage(getImage(), x, y, null);
    }

    public void move(){
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
}
