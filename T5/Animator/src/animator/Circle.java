package animator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;


public class Circle {
    Dimension dim;
    private String path;
    Point pos;
    camLinhaH camLinhaH;
    camZigZag camZigZag;
    camLinhaV camLinhaV;
    camWut camWut;
    int width;
    int height;
    
    Random rand = new Random();
    
    public Circle(Point pos, String path, Dimension dim){
       this.pos = pos;
       this.path = path;
       this.width = 35 + rand.nextInt(180);
       this.height = width;
       camLinhaH = new camLinhaH(pos,dim);
       camLinhaV = new camLinhaV(pos,dim);
       camZigZag = new camZigZag(pos, dim);
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
        g.setColor(Color.GREEN);
        g.fillOval(pos.x, pos.y, width, height);
    }
    
    public void mover() {
        if("LinhaH".equals(path)){
           camLinhaH.mover();
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
