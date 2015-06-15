package animator;

import java.awt.Dimension;
import java.awt.Point;

public class camLinhaV {
    Dimension dim;
    Point pos;
    
    public camLinhaV(Point pos, Dimension dim){
        this.pos = pos;
        this.dim = dim;
    }
    
    public void mover(){
        pos.y += 3;
        if(pos.y > dim.height)
            pos.y = 0;
    }
}