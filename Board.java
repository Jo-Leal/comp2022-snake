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
               
        
        timer = new Timer(5, this);
        timer.start();
    }


    public void paint(Graphics g) {
        super.paint(g);
        
        
        score.paintComponent(g);
        snake.desenhaCobra(g);
        lista.desenhaLista(snake.getX()+55, snake.getY(),g);
        batata.desenhaComida(g);
        
        snake.move();
        if(comeu()){
            lista.inserir(new Body());
            batata.mudaCoord();
            score.addScore(1);
        }
        //lista.moverLista();
        
        
        Graphics2D g2d = (Graphics2D)g;        

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
        
    }


    public void paintIntro(Graphics g) {
        if(isPlaying){
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
            g2d.drawString("S N A K E: " + this.score, 300, 300);
        }
    }
    
    public void actionPerformed(ActionEvent e) {        
        repaint();  
    }
    
    public boolean comeu(){
        if((batata.getX()-5 <= snake.getX())&&(batata.getY()-5 <= snake.getY())){
               if((snake.getX() <= batata.getX()+33)&&(snake.getY() <= batata.getY()+15)){
                   return true;
                }else{
                   return false; 
                }
        }else{
               return false;
        }
    }
    
    
    private class TAdapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            
            // Obtém o código da tecla
            int key =  e.getKeyCode();

            switch (key){
                case KeyEvent.VK_ENTER:
                    isPlaying = false;
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