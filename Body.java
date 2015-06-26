
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
    
    private String name_body = "images/body.png";
    private Image body;
    private Body proximo;
    private int x;
    private int y;
    private char dir;
    private int dx;
    private int dy;
    public Body anterior;
    private char Ddir;

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
    
    public void setAnterior(Body anterior){
        this.anterior = anterior;
    }
    
    public Body getAnterior(){
        return this.anterior;
    }
    
    public Image getImage(){
        return this.body;
    }
    
    public int getDX(){
        return this.dx;
    }
    
    public int getDY(){
        return this.dy;
    }
    
    public void setX(int x){
        this. x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public void atualizaDX(){
        dx = x;
    }
    
    public void atualizaDY(){
        dy = y;
    }
    
    public void atualizaX(){
        x = anterior.dx;
    }
    
    public void atualizaY(){
        y = anterior.dy;
    }
    
    public void desenhaCorpo(Graphics g){
        g.drawImage(getImage(), x, y, null);
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public void setDdir(){
        Ddir = dir;
    }
    
    public void setDir(char dir){
        this.dir = dir;
    }
    
    public char getDdir(){
        return this.Ddir;
    }

    public void atualiza(){
        switch(dir){
            case 'N':
                ImageIcon aa = new ImageIcon("images/body_subindo.png");
                body = aa.getImage();
                break;
                
            case 'S':
                ImageIcon ii = new ImageIcon("images/body_descendo.png");
                body = ii.getImage();
                break;
                
            case 'O':
                ImageIcon oo = new ImageIcon(name_body);
                body = oo.getImage();
                break;
            
            case 'L':
                ImageIcon uu = new ImageIcon("images/body_direita.png");
                body = uu.getImage();
                break;
                
            default:
                break;
                
        }
    }
}
