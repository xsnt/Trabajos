package animator;

import java.awt.Dimension;
import java.util.Random;
import java.awt.Point;

/* Tentativa de fazer um caminho random
May not make the cut*/
public class camWut {
    Point pos;
    int addY = 3;
    int pInicial;
    Dimension dim;
    
    Random rand = new Random();

    
    public camWut(Point pos, Dimension dim){
        this.pos = pos;
        this.pInicial = pos.y;
        this.dim = dim;
    }
    
    public void mover(){
        pos.x += rand.nextInt(5);
        if(pos.x > dim.width)
            pos.x = 0;
        pos.y += rand.nextInt(5);
        if(pos.y > dim.height)
            pos.y = 0;
        
    }
}