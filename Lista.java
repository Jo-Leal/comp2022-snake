
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
        this.inicio = new Body();
        
        inicio.setProximo(new Body());
        inicio.getProximo().setProximo(inicio);
    }
    
    public void inserir(Body body){
        if(isEmpty()){
            inicio = body;
            body.setProximo(inicio);
        }else{
            Body aux = inicio;
            while(aux.getProximo() != inicio){
                aux = aux.getProximo();
            }
            aux.setProximo(body);
            body.setProximo(inicio);
        }
    }
    
    public boolean isEmpty(){
        if(inicio == null){
            return true;
        }else{  
            return false;
        }
    }
    
    public int getSize(){
        int x = 1;
        Body aux = inicio;
        while(aux.getProximo() != inicio){
            aux = aux.getProximo();
            x++;
        }
        return x;
        
    }
    
    public void desenhaLista(int a, int y, Graphics g){
        Body aux = inicio;
        int x = 1;
        Body [] kids = new Body [getSize()];
        while(x <= getSize()){
            aux.desenhaCorpo(a, y, g);
            aux = aux.getProximo();
            a = a + 33;
            x++;
            /*kids[x-1] = aux;
            aux = aux.getProximo();
            x++;*/
        }
        
        /*for(int i = 0; i < kids.length; i++){
            kids[i].desenhaCorpo(a, y, g);
            a = a + 33;
        }*/
    }
    
    public void moverLista(){
        Body aux = inicio;
        int x = 1;
        Body [] kids = new Body [getSize()];
        while(x <= getSize()){
            kids[x-1] = aux;
            aux = aux.getProximo();
            x++;
        }
        
        for(int i = 0; i < kids.length; i++){
            kids[i].move();
        }
    }

  
}