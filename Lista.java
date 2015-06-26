
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
/**
 * Write a description of class Lista here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lista
{
    
    private Body inicio;

    /**
     * Constructor for objects of class Lista
     */
    public Lista()
    {
        
    }
    
    public void inserir(Body body){
        if(isEmpty()){
            inicio = body;
        }else{
            Body aux = inicio;
            while(aux.getProximo() != null){
                aux = aux.getProximo();
            }
            aux.setProximo(body);
            body.setAnterior(aux);
        }
    }
    
    public Body getInicio(){
        return this.inicio;
    }
    
    public boolean isEmpty(){
        if(inicio == null){
            return true;
        }else{  
            return false;
        }
    }
    
    public int getSize(){
        if(!isEmpty()){
            int x = 1;
            Body aux = inicio;
            while(aux.getProximo() != null){
                aux = aux.getProximo();
                x++;
            }
            return x;
        }else{
            return 0;
        }
    }
    
    
    public void desenhaLista(int a, int y, Graphics g, char dir){
        if(!isEmpty()){
            inicio.atualizaDX();
            inicio.atualizaDY();
            inicio.setX(a);
            inicio.setY(y);
            inicio.setDdir();
            inicio.setDir(dir);
            inicio.atualiza();
            inicio.desenhaCorpo(g); 
            
            Body aux = inicio.getProximo();
            int x = 2;
            while(x <= getSize()){
                aux.atualizaDX();
                aux.atualizaDY();
                aux.setX(aux.anterior.getDX());
                aux.setY(aux.anterior.getDY());
                aux.setDdir();
                aux.setDir(aux.anterior.getDdir());
                aux.atualiza();
                
                aux.desenhaCorpo(g);
                aux = aux.getProximo();
                x++;
                
                }
             
       }
    }
    
}
