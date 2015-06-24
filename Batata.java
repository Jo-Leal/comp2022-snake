
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.util.Random;
/**
 * Write a description of class Batata here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Batata
{
    private String batata = "images/fries.png";
    private int x;
    private int y;
    private Image comida;
    private Random num;

    /**
     * Constructor for objects of class Batata
     */
    public Batata()
    {
        ImageIcon bb = new ImageIcon(batata);
        comida = bb.getImage();
        num = new Random();
        this.x = num.nextInt(950);
        this.y = num.nextInt(700);
    }

    public Image getImage(){
        return comida;
    }
    
    public void desenhaComida(Graphics g){
        g.drawImage(getImage(), this.x, this.y, null);
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public void mudaCoord(){
        this.x = num.nextInt(950);
        this.y = num.nextInt(700);
    }
}