package animator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;




public class Rectangle {
    Dimension dim;
    private String path;//Não esquecer de perguntar o pq de ser final already
    Point pos;
    camLinhaH camLinha;
    camZigZag camZigZag;
    camLinhaV camLinhaV;
    camWut camWut;
    int width;
    int height;
    
    Random rand = new Random();
    
    
    public Rectangle(Point pos, String path, Dimension dim){
       this.pos = pos;
       this.path = path;
       this.dim = dim;
       /*Randomiza o tamanho da figura*/
       this.width = 25 + rand.nextInt(150);
       this.height = 25 + rand.nextInt(150);
       /*TBH, isso era uma estrutura que tinha em um forum como resposta de uma pergunta, all credits do zeb, from stack overflow
       (é uma aplicação de uma função já existente, mas, for the sake, credits were given)*/
       camLinha = new camLinhaH(pos,dim);
       camZigZag = new camZigZag(pos, dim);
       camLinhaV = new camLinhaV(pos,dim);
       camWut = new camWut(pos,dim);
       
   } 
    
    public camLinhaH getCamLinhaH(){
        return new camLinhaH(pos,dim);
    }
    
    public camLinhaV getCamLinhaV(){
        return new camLinhaV(pos,dim);
    }
    
    public camZigZag getCamZigZag(){
        return new camZigZag(pos, dim);
    }
    
    public camWut getCamWut(){
        return new camWut(pos,dim);
    }
    
    public Point getPos() {
        return pos;
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.lightGray);
        g.fillRect(pos.x, pos.y, width, height);
    }
    
    public void mover() {
        if("LinhaH".equals(path)){
           camLinha.mover();
       }
        if("ZigZag".equals(path)){
           camZigZag.mover();
       }
        if("LinhaV".equals(path)){
           camLinhaV.mover();
       }
        if("WUT".equals(path)){
           camWut.mover();
        }
    }
    
}


    
