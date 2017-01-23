
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author ayyaf3300
 */


public class FinalProject_FeazanAyyaz extends JComponent implements KeyListener{

    // Height and Width of our game
    static final int WIDTH = 1050;
    static final int HEIGHT = 600;
    
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000)/desiredFPS;
    
    // game variables
    Color skyColor = new Color(30, 170, 217);
    Rectangle dino1 = new Rectangle(60, 440, 250, 100);
    Rectangle dino2 = new Rectangle(750, 450, 250, 100);
   
    BufferedImage backround = loadImage("city.jpg");
    BufferedImage dinoone = loadImage("ank.png");
    BufferedImage dinotwo = loadImage("Gorgosaurus2.png");
    
    boolean left1 = false;
    boolean jump1 = false;
    boolean right1 = false;
    boolean left2 = false;
    boolean jump2 = false;
    boolean right2 = false;
    boolean start = false;
    
    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g)
    {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);
        
        // GAME DRAWING GOES HERE 
        
        // change the sky color
        g.setColor(skyColor);
        // draw the sky backround
        //g.fillRect(0, 0, WIDTH, HEIGHT);
        g.drawImage(backround, 0, 0, WIDTH, HEIGHT, null);
        
        // draw the male dinosaur (main character)
        g.setColor(Color.YELLOW);
        //g.fillRect(bird.x, bird.y, bird.width, bird.height);
        g.drawImage(dinoone, dino1.x, dino1.y, dino1.width, dino1.height, null);
        
        g.setColor(Color.YELLOW);
        //g.fillRect(bird.x, bird.y, bird.width, bird.height);
        g.drawImage(dinotwo, dino2.x, dino2.y, dino2.width, dino2.height, null);
        
        
        // GAME DRAWING ENDS HERE
    }
   
    public BufferedImage loadImage(String filename){
        BufferedImage img = null;
        try{
            File file = new File(filename);
            img = ImageIO.read(file);
            // if there is an error print image
        }catch(Exception e ){
             
            
            e.printStackTrace();
        }
       return img;
    }
    
    // The main game loop
    // In here is where all the logic for my game will go
    public void run()
    {
        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;
        
        // the main game loop section
        // game will end if you set done = false;
        boolean done = false; 
        while(!done)
        {
            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();
            
            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 
            
            

            // GAME LOGIC ENDS HERE 
            
            // update the drawing (calls paintComponent)
            repaint();
            
            
            
            // SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
            // USING SOME SIMPLE MATH
            deltaTime = System.currentTimeMillis() - startTime;
            try
            {
               if(deltaTime > desiredTime)
               {
                   //took too much time, don't wait
                   Thread.sleep(1);
               }else{
                  // sleep to make up the extra time
                 Thread.sleep(desiredTime - deltaTime);
               }
            }catch(Exception e){};
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates a windows to show my game
        JFrame frame = new JFrame("My Game");
       
        // creates an instance of my game
        FinalProject_FeazanAyyaz game = new FinalProject_FeazanAyyaz();
        // sets the size of my game
        game.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        // adds the game to the window
        frame.add(game);
        // add key listener
        frame.addKeyListener(game);
        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);
        
        // starts my game loop
        game.run();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getExtendedKeyCode();
        if (key == KeyEvent.VK_A) {
            left1 = true;
            start = true;
        }
        if (key == KeyEvent.VK_S) {
            jump1 = true;
            start = true;
        }
        if (key == KeyEvent.VK_D) {
            right1 = true;
            start = true;
        }
        if (key == KeyEvent.VK_J) {
            left2 = true;
            start = true;
        }
        if (key == KeyEvent.VK_K) {
            jump2 = true;
            start = true;
        }
        if (key == KeyEvent.VK_L) {
            right2 = true;
            start = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getExtendedKeyCode();
        if (key == KeyEvent.VK_A) {
            left1 = false;
        }
        if (key == KeyEvent.VK_S) {
            jump1 = false;
        }
        if (key == KeyEvent.VK_D) {
            right1 = false;
        }
        if (key == KeyEvent.VK_J) {
            left2 = false;
        }
        if (key == KeyEvent.VK_K) {
            jump2 = false;
        }
        if (key == KeyEvent.VK_L) {
            right2 = false;
        }
    }
}
