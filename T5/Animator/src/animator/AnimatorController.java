package animator;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

enum Speed {
    High(30),
    Medium(100),
    Low(300);
    private final int millis; 

    Speed(int millis) {
        this.millis = millis;
    }

    public int getMillis() {
        return millis;
    }
}

enum ShapeType {
    Elipse,
    Rectangle,
    Circle;
}

public class AnimatorController {

    private JFrame animFrame;
    private AnimatorGUI view;
    private ObjectSet objs;
    private Thread panelThread;
    private boolean isRunning;
    private Dimension dim;
    private int millis;
    
    private static final int defaultWidth = 1280;
    private static final int defaultHeight = 720;
    private static final Speed defaultSpeed = Speed.Medium;
    private static final int defaultNumberOfObjects = 1;
    private static final String defaultFilename = "spaceship-small.png";
    
    public AnimatorController(AnimatorGUI view) {
        this.isRunning = false;
        this.view = view;
    }

    public static int getDefaultWidth() {
        return defaultWidth;
    }
    public static int getDefaultHeight() {
        return defaultHeight;
    }
    public static int getDefaultNumberOfObjects() {
        return defaultNumberOfObjects;
    }
    public static String getDefaultFilename() {
        return defaultFilename;
    }

    // Metodo chamado pelo botao Stop
    public void stop() {
        if (animFrame != null)
                animFrame.dispose();
        if (panelThread != null)
            panelThread.interrupt();
        isRunning = false;
        view.setStopped();
    }
    
    // Metodo chamado pelo botao Run
    public void run() {
        view.setRunning();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    readAnimConfig();
                    createObjectSet();
                    createAndShowAnimFrame();
                } catch (Exception e) {
                    stop();
                    view.showMessage(e.getMessage());
                    System.out.println(e.getMessage().isEmpty());
                    //if (e.getMessage().isEmpty())
                        //e.printStackTrace();
                    //else 
                    //    view.showMessage(e.getMessage());
                }
            }
        });
    }

    // Configuracao basica da animacao (tamanho e velocidade)
    private void readAnimConfig() {
        dim = new Dimension(Integer.parseInt(view.getTextWidth()),
                            Integer.parseInt(view.getTextHeight()));
        Speed s = (Speed) view.getComboSpeed().getSelectedItem();
        millis = s.getMillis();        
    }
    
    // Cria objetos da animacao conforme configurado na interface grafica
    private void createObjectSet() throws Exception {
        objs = new ObjectSet();
        
        // Inicio da criacao dos objetos Image
        int nImages = (Integer) view.getSpinnerImages().getValue();
        String imageName = view.getTextImage().getText();
        BufferedImage image = readImage(imageName);
        if (image == null) 
            throw new Exception("Error reading image file.");
        String pathImages = (String) view.getComboPathImages().getSelectedItem();
        objs.addImages(nImages, dim, image, pathImages);
        // Fim da criacao dos objetos Image

        // Inicio da criacao dos objetos com formas geometricas
        int nShapes = (Integer) view.getSpinnerShapes().getValue();
        ShapeType shapeType = (ShapeType) view.getComboShape().getSelectedItem();
        String pathShapes = (String) view.getComboPathShapes().getSelectedItem();
        switch (shapeType) {
            case Elipse: objs.addElipse(nShapes, dim, pathShapes); break;
            case Rectangle: objs.addRectangles(nShapes, dim, pathShapes); break;
            case Circle: objs.addCircles(nShapes, dim, pathShapes); break;            
        }
        // Fim da configuracao dos objetos com formas geometricas
    }
    
    private void createAndShowAnimFrame() {

        animFrame = new JFrame("Animation");
        isRunning = true;
        animFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        animFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                JFrame frame = (JFrame) e.getSource();
                frame.dispose();
                panelThread.interrupt();
                isRunning = false;
                view.setStopped();
            }
        });
                
        AnimationPanel panel = new AnimationPanel(objs, dim, millis);
        animFrame.add(panel);
        animFrame.pack();
        animFrame.setLocationRelativeTo(null);
        animFrame.setVisible(true);
        panelThread = new Thread(panel);
        panelThread.start();
    }

    // Leitura de imagem a partir de arquivo
    private BufferedImage readImage(String filename) {
        BufferedImage imgref = null;
        try {
            imgref = ImageIO.read(new File(filename));
        } catch (IOException e) {
            //return null;
        }
        return imgref;
    }    
}

