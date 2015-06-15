package animator;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Random;

// Conjunto de objetos da animacao.
class ObjectSet {
    
   private Image[] images;
   private Rectangle[] rectangles;
   private Circle[] circles;
   private Elipse[] elipse;
   int nShapes;
   String shapeType;
   Random x = new Random();
    
    // Adiciona objetos da classe Image ao ObjectSet.
    void addImages(int n, Dimension dim, BufferedImage image, String path) {
        nShapes = n;
        images = new Image[n];
        for (int i = 0; i < images.length; i++) {
            Point p = new Point(x.nextInt(dim.width),x.nextInt(dim.height));
            images[i] = new Image(p, image, path, dim);
        }
    }
    
    
    /*Não, não existe a class star aqui, move along*/
    
    
    // Adiciona objetos da classe RoundedRectangle ao ObjectSet.
    void addElipse(int n, Dimension dim, String path) {
        nShapes = n;
        elipse = new Elipse[n];
        shapeType = "elipse";
        for (int i = 0; i < elipse.length; i++) {
            Point p = new Point(x.nextInt(dim.width),x.nextInt(dim.height));
            elipse[i] = new Elipse(p, path, dim);
        }
    }
    
    // Adiciona objetos da classe Rectangle ao ObjectSet.
    void addRectangles(int n, Dimension dim, String path) {
        nShapes = n;
        rectangles = new Rectangle[n];
        shapeType = "rectangle";
        for (int i = 0; i < rectangles.length; i++) {
            Point p = new Point(x.nextInt(dim.width),x.nextInt(dim.height));
            rectangles[i] = new Rectangle(p, path, dim);
        }
    }
    
    // Adiciona objetos da classe Circle ao ObjectSet.
    void addCircles(int n, Dimension dim, String path) {
        nShapes = n;
        circles = new Circle[n];
        shapeType = "circle";
        for (int i = 0; i < circles.length; i++) {
            Point p = new Point(x.nextInt(dim.width),x.nextInt(dim.height));
            circles[i] = new Circle(p, path, dim);
        }
    }
    
    // Desenha cada um dos objetos da animacao.
    void drawAll(Graphics g) {
       for (Image image : images) {
           image.draw(g);
       }
        for(int i=0;i<nShapes;i++){
            if("rectangle".equals(shapeType)){
                rectangles[i].draw(g);
            }
            else if("circle".equals(shapeType))
                    circles[i].draw(g);
            else if("elipse".equals(shapeType))
                    elipse[i].draw(g);
        }
        System.out.println("drawAll");
    }

    // Move cada um dos objetos da animacao.
    void moveAll() {
       for (Image image : images) {
           image.move();
       }
        for(int i =0;i<nShapes; i++){
            if("rectangle".equals(shapeType)){
                rectangles[i].mover();
            }
            else if("circle".equals(shapeType))
                    circles[i].mover();
            else if("roundedRectangle".equals(shapeType))
                    elipse[i].mover();
        }
        System.out.println("moveAll");
    }
}