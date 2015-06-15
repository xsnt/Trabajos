package animator;

import java.awt.Dimension;
import java.awt.Point;

/* Tentativa de fazer um caminho em "zigzague" */
public class camZigZag {
    Point pos;
    int addY = 3;
    int pInicial;
    Dimension dim;
    
    public camZigZag(Point pos, Dimension dim){
        this.pos = pos;
        this.pInicial = pos.y;
        this.dim = dim;
    }
    
    public void mover(){
        pos.x += 3;
        if(pos.x > dim.width)
            pos.x = 0;
        pos.y = pos.y + addY;
        if(pos.y > pInicial + 30 || pos.y < pInicial - 30)
            addY = addY - (2*addY);
        
    }
}