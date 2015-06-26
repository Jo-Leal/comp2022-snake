import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.io.File;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Score score;
    private Snake snake;
    private Lista lista;
    private Batata batata;
    
    private boolean isPlaying = false;
    private boolean endOfGame = false;
    private boolean intro = true;

    private Font font;
       
    public Board() {

        addKeyListener(new TAdapter());
        
        setFocusable(true);        
        setDoubleBuffered(true);
        setBackground(Color.WHITE);

        score = new Score();
        snake = new Snake();
        lista = new Lista();
        batata = new Batata();
               
        
        timer = new Timer(100, this);
        timer.start();
    }


    public void paint(Graphics g) {
        super.paint(g);
        
        if(intro){
            paintIntro(g);
        }
        
        if(endOfGame){
            gameOver(g);
        }
        
        if(isPlaying){
            newGame(g);
        }
        
        
    }
    
    public void newGame(Graphics g){
        score.paintComponent(g);
        snake.desenhaCobra(g);
        lista.desenhaLista(snake.getDX(), snake.getDY(),g, snake.getDir());
        batata.desenhaComida(g);
        
        Graphics2D g2d = (Graphics2D)g;
        
        snake.move();
        if(comeu()){
            lista.inserir(new Body());
            batata.mudaCoord();
            score.addScore(1);
        }
        //lista.moverLista();
        
        if(bateu()){
            isPlaying = false;
            endOfGame = true;
        }
        collision();
        
                

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void paintIntro(Graphics g) {
        if((!isPlaying)&&(!endOfGame)){
            isPlaying = false;
            Graphics2D g2d = (Graphics2D) g;
            try{
                File file = new File("fonts/VT323-Regular.ttf");
                font = Font.createFont(Font.TRUETYPE_FONT, file);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(font);
                font = font.deriveFont(Font.PLAIN,40);
                g2d.setFont(font);
            }catch (Exception e){
                System.out.println(e.toString());
            } 
            g2d.drawString("S N A K E", 300, 300);
            g2d.drawString("Press Enter to start", 400, 400);
        }
    }
    
    public void actionPerformed(ActionEvent e) {        
        repaint();  
    }
    
    
    public boolean comeu(){
        if(((snake.getX() <= batata.getX()+20) && (snake.getX() >= batata.getX()-20)) &&
     	       ((snake.getY() <= batata.getY()+20) && (snake.getY() >= batata.getY()-20))){
     	           return true;
     	}else {
     	    return false;
     	  }
    }
    
    public boolean bateu(){
        if((snake.getX() <= 0)||(snake.getY() <= 0)){
            return true;
        }else if((snake.getX() >= 945)||(snake.getY() >= 695)){
            return true;
        }else{
            return false;
        }
    }
    
    public void gameOver(Graphics g){
        if((!isPlaying)&&(!intro)){
            isPlaying = false;
            Graphics2D g2d = (Graphics2D) g;
            try{
                File file = new File("fonts/VT323-Regular.ttf");
                font = Font.createFont(Font.TRUETYPE_FONT, file);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(font);
                font = font.deriveFont(Font.PLAIN,40);
                g2d.setFont(font);
            }catch (Exception e){
                System.out.println(e.toString());
            } 
            g2d.drawString("GAME OVER", 300, 300);
            int y = score.getScore();
            g2d.drawString("Seu score foi: "+ y, 400, 400);
        }
    }
    
    public void collision(){
        if(lista.getSize() > 2){
            Body aux = lista.getInicio().getProximo();
            if(aux.getProximo() != null){
                aux = aux.getProximo();
                while(aux.getProximo() != null){
                    /*if(cobra.getX() == corpo.getX() && cobra.getY() == corpo.getY()){*/
                  
                
                    if(((snake.getX() <= aux.getX()+10) && (snake.getX() >= aux.getX()-10)) &&
                        ((snake.getY() <= aux.getY()+10) && (snake.getY() >= aux.getY()-10))){
                            isPlaying = false;
                            endOfGame = true;
                            intro = false;
                            break;
                        }
                        aux = aux.getProximo();   
                    } 
                }
         } 
     }
    
    private class TAdapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            
            // Obtém o código da tecla
            int key =  e.getKeyCode();

            switch (key){
                case KeyEvent.VK_ENTER:
                    if(intro){
                        isPlaying = true;
                        endOfGame = false;
                        intro = false;
                    }
                    break;
                 
                case KeyEvent.VK_LEFT:
                    if(snake.getDir() != 'L'){
                        snake.setDir('O');
                    }    
                     break;
                    
                case KeyEvent.VK_RIGHT:
                    if(snake.getDir() != 'O'){
                        snake.setDir('L');
                    }    
                    break;
                    
                case KeyEvent.VK_UP:
                    if(snake.getDir() != 'S'){
                        snake.setDir('N');
                    }    
                    break;
                    
                case KeyEvent.VK_DOWN:
                    if(snake.getDir() != 'N'){
                        snake.setDir('S');
                    }    
                    break;
            }
            
        }
    }
    
}