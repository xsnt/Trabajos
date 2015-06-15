package animator;

import java.awt.Dimension;
import java.awt.Point;

public class camLinhaH {
    Dimension dim;
    Point pos;
    
    public camLinhaH(Point pos, Dimension dim){
        this.pos = pos;
        this.dim = dim;
    }
    
    public void mover(){
        pos.x += 3;
        if(pos.x > dim.width)
            pos.x = 0;
    }
}
