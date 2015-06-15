package animator;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

class Image {
    Dimension dim;
    private String path;
    BufferedImage img;
    Point pos;
    camLinhaH camLinha;
    camZigZag camZigZag;
    camLinhaV camLinhaV;
    camWut camWut;

    public Image(Point pos, BufferedImage img, String path, Dimension dim) {
        this.pos = pos;
        this.img = img;
        this.path = path;
        this.dim = dim;
        camLinha = new camLinhaH(pos,dim);
        camLinhaV = new camLinhaV(pos,dim);
        camZigZag = new camZigZag(pos,dim);
        camWut = new camWut(pos,dim);
    }
    
    public camLinhaH getCamLinhaH(){
        return new camLinhaH(pos,dim);
    }
    public camLinhaV getCamLinhav(){
        return new camLinhaV(pos,dim);
    }
    
    public camZigZag getPathZigZag(){
        return new camZigZag(pos, dim);
    }
    
    public camWut getCamWut(){
        return new camWut(pos,dim);
    }
    
    public Point getPos() {
        return pos;
    }
    
    public void draw(Graphics g) {
        g.drawImage(img, (int) pos.getX(), (int) pos.getY(), null);
    }
    
    // Move a imagem de acordo segundo a trajetoria selecionada.
    public void move() {
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
