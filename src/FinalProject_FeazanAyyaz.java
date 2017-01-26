
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author ayyaf3300
 */
public class FinalProject_FeazanAyyaz extends JComponent implements KeyListener {

    // Height and Width of our game
    static final int WIDTH = 1050;
    static final int HEIGHT = 600;

    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000) / desiredFPS;

    // game variables
    Color skyColor = new Color(30, 170, 217);
    Rectangle dino1 = new Rectangle(60, 440, 150, 50);
    Rectangle dino2 = new Rectangle(750, 450, 150, 50);
    Rectangle bordors1 = new Rectangle(0, 1500, 1, 1);
    Rectangle bordors2 = new Rectangle(0, 1, 1, 1);
    Rectangle bordors3 = new Rectangle(0, 1, 1, 600);
    Rectangle bordors4 = new Rectangle(900, 1, 1, 0);
    Rectangle bullet1 = new Rectangle(50, 800, 50, 40);
    Rectangle bullet2 = new Rectangle(600, 150, 50, 40);
    Rectangle bullet3 = new Rectangle(570, 1109, 50, 40);
    Rectangle bullet4 = new Rectangle(470, 799, 50, 40);
    Rectangle bullet5 = new Rectangle(330, 930, 50, 40);
    Rectangle bullet7 = new Rectangle(630, 1140, 50, 40);
    Rectangle bullet8 = new Rectangle(350, 1300, 50, 40);
    Rectangle bullet9 = new Rectangle(400, 1110, 50, 40);
    Rectangle bullet11 = new Rectangle(450, 550, 50, 40);
    Rectangle bullet12 = new Rectangle(900, 779, 50, 40);
    Rectangle bullet13 = new Rectangle(800, 750, 50, 40);
    Rectangle bullet14 = new Rectangle(878, 766, 50, 40);
    Rectangle bullet15 = new Rectangle(200, 1100, 50, 40);
    Rectangle bullet16 = new Rectangle(70, 850, 50, 40);
    Rectangle bullet17 = new Rectangle(570, 900, 50, 40); 
    Rectangle bullet21 = new Rectangle(430, 640, 50, 40);   
    
    // get the font for the level variable so that when a certian 
    // amount of time passes the level will go up
    int level = 0;
    Font levelFont = new Font("Arial", Font.BOLD, 20);
    
    // get the font for the score of player one so that when the 
    // other player dies a point will be added to player one's score
    int score1 = 0;
    Font score1Font = new Font("Arial", Font.BOLD, 20);
    
    // get the font for the score of player two so that when the 
    // other player dies a point will be added to player two's score
    int score2 = 0;
    Font score2Font = new Font("Arial", Font.BOLD, 20);   
   
    // get pictures so that the game will look nice
    BufferedImage backround = loadImage("end.png");
    BufferedImage dinoone = loadImage("flyer.png");
    BufferedImage dinotwo = loadImage("flyer.png");
    BufferedImage platform = loadImage("platform.png");
    BufferedImage fireball1 = loadImage("firball.png");
    
    // create a variable speed that will be used to move the bullets
    int speed = 2;  

    // create boolean's for the program
    boolean left1 = false;
    boolean right1 = false;
    boolean left2 = false;
    boolean right2 = false;
    boolean start = true;
    boolean dead1 = false;
    boolean dead2 = false;
    boolean begin = true;
    // begin the game
    boolean first = true;
    
    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE 
        // change the sky color
        
        if(start){
        g.setColor(skyColor);
        // draw the sky backround
        //g.fillRect(0, 0, WIDTH, HEIGHT);
        g.drawImage(backround, 0, 0, WIDTH, HEIGHT, null);

        // create bordors for the game so that the player's will not fall out of the screen x4 don't worry i wanted to make 
        // it so that i control the position if i wanted to do it random i would but i thought this was more fun
        g.setColor(Color.RED);
        g.drawImage(platform, bordors1.x, bordors1.y, bordors1.width, bordors1.height, null);
        
        g.setColor(Color.RED);
        g.drawImage(platform, bordors2.x, bordors2.y, bordors2.width, bordors2.height, null);
        
        g.setColor(Color.RED);
        g.drawImage(platform, bordors3.x, bordors3.y, bordors3.width, bordors3.height, null);

        g.setColor(Color.RED);
        g.drawImage(platform, bordors4.x, bordors4.y, bordors4.width, bordors4.height, null);

        // create objects for the main character's to doge x16
        g.setColor(Color.RED);
        g.drawImage(fireball1, bullet1.x, bullet1.y, bullet1.width, bullet1.height, null);
        
        g.setColor(Color.RED);
        g.drawImage(fireball1, bullet2.x, bullet2.y, bullet2.width, bullet2.height, null);
        
        g.setColor(Color.RED);
        g.drawImage(fireball1, bullet3.x, bullet3.y, bullet3.width, bullet3.height, null);
        
        g.setColor(Color.RED);
        g.drawImage(fireball1, bullet4.x, bullet4.y, bullet4.width, bullet4.height, null);
        
        g.setColor(Color.RED);
        g.drawImage(fireball1, bullet5.x, bullet5.y, bullet5.width, bullet5.height, null);
        
        g.setColor(Color.RED);
        g.drawImage(fireball1, bullet7.x, bullet7.y, bullet7.width, bullet7.height, null);
        
        g.setColor(Color.RED);
        g.drawImage(fireball1, bullet8.x, bullet8.y, bullet8.width, bullet8.height, null);
        
        g.setColor(Color.RED);
        g.drawImage(fireball1, bullet9.x, bullet9.y, bullet9.width, bullet9.height, null);
 
        g.setColor(Color.RED);
        g.drawImage(fireball1, bullet11.x, bullet11.y, bullet11.width, bullet11.height, null);
        
        g.setColor(Color.RED);
        g.drawImage(fireball1, bullet12.x, bullet12.y, bullet12.width, bullet12.height, null);
        
        g.setColor(Color.RED);
        g.drawImage(fireball1, bullet13.x, bullet13.y, bullet13.width, bullet13.height, null);
        
        g.setColor(Color.RED);
        g.drawImage(fireball1, bullet14.x, bullet14.y, bullet14.width, bullet14.height, null);
        
        g.setColor(Color.RED);
        g.drawImage(fireball1, bullet15.x, bullet15.y, bullet15.width, bullet15.height, null);
        
        g.setColor(Color.RED);
        g.drawImage(fireball1, bullet16.x, bullet16.y, bullet16.width, bullet16.height, null);
        
        g.setColor(Color.RED);
        g.drawImage(fireball1, bullet17.x, bullet17.y, bullet17.width, bullet17.height, null);
           
        g.setColor(Color.RED);
        g.drawImage(fireball1, bullet21.x, bullet21.y, bullet21.width, bullet21.height, null);
        
        
        // draw player one's character
        g.setColor(Color.YELLOW);
        //g.fillRect(dino1.x, dino1.y, dino1.width, dino1.height);
        g.drawImage(dinoone, dino1.x, dino1.y, dino1.width, dino1.height, null);
        
        // draw player two's character
        g.setColor(Color.YELLOW);
        //g.fillRect(dino2.x, dino2.y, dino2.width, dino2.height);
        g.drawImage(dinotwo, dino2.x, dino2.y, dino2.width, dino2.height, null);
        
        // get the font to show on the screen for level
        g.setColor(Color.WHITE);
        g.setFont(levelFont);
        g.drawString("Level " + level, WIDTH/2, 50);
        
        // get the font to show on the screen for the first player's score
        g.setColor(Color.WHITE);
        g.setFont(score1Font);
        g.drawString("Player 1 Score " + score1, WIDTH/90, 50);
        
        // get the font to show on the screen for the second payer's score
        g.setColor(Color.WHITE);
        g.setFont(score2Font);
        g.drawString("Player 2 Score " + score2, WIDTH/4, 50);
        
        // GAME DRAWING ENDS HERE
    }}

    public BufferedImage loadImage(String filename) {
        BufferedImage img = null;
        try {
            File file = new File(filename);
            img = ImageIO.read(file);
            // if there is an error print image
        } catch (Exception e) {

            e.printStackTrace();
        }
        return img;
    }

    // create a method for the game so that when a player dies the game will reset with whatever is in the method
    public void reset() {
        // whenever the first player dies add a pont to the second player's score
        if (dead1 == true){
            score2 ++;
        }
        
        // whenever the second player dies add a pont to the first player's score
        if (dead2 == true){
            score1 ++;
        }
        
        // reset the level variable to zero after a player dies
        level = 0;
        
        // reset the speed to two after a player dies
        speed = 2;
        
        //// after the game resets reset the bullet to it's original x and y position x16
        bullet1.y = 800;
        bullet1.x = 50;
        start = true;
        dead1 = false;
        dead2 = false;
        
        bullet2.y = 450;
        bullet2.x = 600;
        start = true;
        dead1 = false;
        dead2 = false;
        
        bullet3.y = 209;
        bullet3.x = 570;
        start = true;
        dead1 = false;
        dead2 = false;
        
        bullet4.y = 509;
        bullet4.x = 170;
        start = true;
        dead1 = false;
        dead2 = false;
        
        bullet8.y = 1300;
        bullet8.x = 650;
        start = true;
        dead1 = false;
        dead2 = false;
        
        bullet9.y = 1110;
        bullet9.x = 300;
        start = true;
        dead1 = false;
        dead2 = false;
        
        bullet12.y = 209;
        bullet12.x = 75;
        start = true;
        dead1 = false;
        dead2 = false;
        
        bullet13.y = 750;
        bullet13.x = 800;
        start = true;
        dead1 = false;
        dead2 = false;
            
        bullet15.y = 1100;
        bullet15.x = 230;
        start = true;
        dead1 = false;
        dead2 = false;
        
        bullet16.y = 850;
        bullet16.x = 670;
        start = true;
        dead1 = false;
        dead2 = false;
        
        // after the game resets get the dinosaurs to their original x and y coordinate's x2
        dino1.y = 440;
        dino1.x = 60;
       
        // reset start to true and both player's to undead x2
        start = true;
        dead1 = false;

        dino2.y = 450;
        dino2.x = 750;
    
        start = true;
        dead2 = false;
    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void run() {
        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;
        
        // the main game loop section
        // game will end if you set done = false;
        boolean done = false;
        while (!done) {
            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();

            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 
            
            // if the game has started get the bullets and players moving
            if (start) {
                
                // if the bullet has passed the bottom boarder reset it to 
                // the top boarder and increase it's speed and increase the variable level x16
                if (bullet1.y == bordors1.y && bullet2.y == bordors1.y){
                    level++;
                    speed++;
                }  
                if (bullet3.y == bordors1.y){
                    level++;
                    speed++;
                }
                if (bullet4.y == bordors1.y){
                    level++;
                    speed++;
                }
                if (bullet5.y == bordors1.y){
                    level++;
                    speed++;
                }
                
                if (bullet7.y == bordors1.y){
                    level++;
                    speed++;
                }
                if (bullet8.y == bordors1.y){
                    level++;
                    speed++;
                }
                if (bullet9.y == bordors1.y){
                    level++;
                    speed++;
                }
                
                if (bullet11.y == bordors1.y){
                    level++;
                    speed++;
                }
                if (bullet12.y == bordors1.y){
                    level++;
                    speed++;
                }
                if (bullet13.y == bordors1.y){
                    level++;
                    speed++;
                }
                if (bullet14.y == bordors1.y){
                    level++;
                    speed++;
                }
                if (bullet15.y == bordors1.y){
                    level++;
                    speed++;
                }
                if (bullet16.y == bordors1.y){
                    level++;
                    speed++;
                }
                if (bullet17.y == bordors1.y){
                    level++;
                    speed++;
                }  
                if (bullet21.y == bordors1.y){
                    level++;
                    speed++;
                }     
                
                // make the dinosaur move with the speeds given x4
                if (right1) {
                    dino1.x = dino1.x + 5;
                }
                if (left1) {
                    dino1.x = dino1.x - 5;
                }
                if (right2) {
                    dino2.x = dino2.x + 5;
                }
                if (left2) {
                    dino2.x = dino2.x - 5;
                }
                
                // create the boarder's so that the player's won't fall off the screen
                if (!dead1 || !dead2) {
                    
                    if (dino1.y > bordors1.y) {
                        dino1.y = bordors1.y;             
                    }
                    if (dino2.y > bordors1.y) {
                        dino2.y = bordors1.y;        
                    }
                    if (dino1.y < bordors2.y) {
                        dino1.y = bordors2.y;        
                    }
                    if (dino2.y < bordors2.y) {
                        dino2.y = bordors2.y;             
                    }
                    if (dino1.x < bordors3.x) {
                        dino1.x = bordors3.x;                  
                    }
                    if (dino2.x < bordors3.x) {
                        dino2.x = bordors3.x;                
                    }
                    if (dino1.x > bordors4.x) {
                        dino1.x = bordors4.x;               
                    }
                    if (dino2.x > bordors4.x) {
                        dino2.x = bordors4.x;
                    }
                    
                    // if neither of the player's are dead increase the bullet's speed x16
                    if (!dead1 || !dead2){  
                        bullet1.y = bullet1.y + speed;
                        bullet2.y = bullet2.y + speed;
                        bullet3.y = bullet3.y + speed;
                        bullet4.y = bullet4.y + speed;
                        bullet5.y = bullet5.y + speed;                   
                        bullet7.y = bullet7.y + speed;
                        bullet8.y = bullet8.y + speed;
                        bullet9.y = bullet9.y + speed;
                        bullet11.y = bullet11.y + speed;
                        bullet12.y = bullet12.y + speed;
                        bullet13.y = bullet13.y + speed;
                        bullet14.y = bullet14.y + speed;
                        bullet15.y = bullet15.y + speed;
                        bullet16.y = bullet16.y + speed;
                        bullet17.y = bullet17.y + speed;  
                        bullet21.y = bullet21.y + speed;        
                    }
                    
                    // if player one intercects with any bullet make dead1 equal true x16
                   if (dino1.intersects(bullet1)){
                       dead1 = true;
                   }else if (dino1.intersects(bullet2 )){
                       dead1 = true;
                   }else if (dino1.intersects(bullet3 )){
                       dead1 = true;
                   }else if (dino1.intersects(bullet4 )){
                       dead1 = true;
                   }else if (dino1.intersects(bullet5 )){
                       dead1 = true;
                   }else if (dino1.intersects(bullet7 )){
                       dead1 = true;
                   }else if (dino1.intersects(bullet8 )){
                       dead1 = true;
                   }else if (dino1.intersects(bullet9 )){
                       dead1 = true;
                   }else if (dino1.intersects(bullet11 )){
                       dead1 = true;
                   }else if (dino1.intersects(bullet12 )){
                       dead1 = true;
                   }else if (dino1.intersects(bullet13 )){
                       dead1 = true;
                   }else if (dino1.intersects(bullet14 )){
                       dead1 = true;
                   }else if (dino1.intersects(bullet15 )){
                       dead1 = true;
                   }else if (dino1.intersects(bullet16 )){
                       dead1 = true;
                   }else if (dino1.intersects(bullet17 )){
                       dead1 = true;
                   }else if (dino1.intersects(bullet21)){
                       dead1 = true;
                   }
                   
                   // if player two intercects with any bullet make dead2 equal true x16
                    if (dino2.intersects(bullet1)){
                       dead2 = true;
                   }else if (dino2.intersects(bullet2 )){
                       dead2 = true;
                   }else if (dino2.intersects(bullet3 )){
                       dead2 = true;
                   }else if (dino2.intersects(bullet4 )){
                       dead2 = true;
                   }else if (dino2.intersects(bullet5 )){
                       dead2 = true;
                   }else if (dino2.intersects(bullet7 )){
                       dead2 = true;
                   }else if (dino2.intersects(bullet8)){
                       dead2 = true;
                   }else if (dino2.intersects(bullet9 )){
                       dead2 = true;
                   }else if (dino2.intersects(bullet11)){
                       dead2 = true;
                   }else if (dino2.intersects(bullet12)){
                       dead2 = true;
                   }else if (dino2.intersects(bullet13)){
                       dead2 = true;
                   }else if (dino2.intersects(bullet14)){
                       dead2 = true;
                   }else if (dino2.intersects(bullet15)){
                       dead2 = true;
                   }else if (dino2.intersects(bullet16)){
                       dead2 = true;
                   }else if (dino2.intersects(bullet17 )){
                       dead2 = true;
                   }else if (dino2.intersects(bullet21)){
                       dead2 = true;
                   }
                    
                   // if any of the bullet pass the y coordinate of the bottom border reset the bullet to the top border x16
                    if (bullet1.y > bordors1.y){
                    bullet1.y = bordors2.y++; 
                    }
                    if (bullet2.y > bordors1.y){
                    bullet2.y = bordors2.y++;             
                    }            
                    if (bullet3.y > bordors1.y){
                    bullet3.y = bordors2.y++;          
                    }
                    if (bullet4.y > bordors1.y){
                    bullet4.y = bordors2.y++;             
                    }
                    if (bullet5.y > bordors1.y){
                    bullet5.y = bordors2.y++;         
                    }            
                    if (bullet7.y > bordors1.y){
                    bullet7.y = bordors2.y++;             
                    }
                    if (bullet8.y > bordors1.y){
                    bullet8.y = bordors2.y++;            
                    }
                    if (bullet9.y > bordors1.y){
                    bullet9.y = bordors2.y++;           
                    }           
                    if (bullet11.y > bordors1.y){
                    bullet11.y = bordors2.y++;             
                    }
                    if (bullet12.y > bordors1.y){
                    bullet12.y = bordors2.y++;             
                    }
                    if (bullet13.y > bordors1.y){
                    bullet13.y = bordors2.y++;           
                    }
                    if (bullet14.y > bordors1.y){
                    bullet14.y = bordors2.y++;                 
                    }
                    if (bullet15.y > bordors1.y){
                    bullet15.y = bordors2.y++;                 
                    }
                    if (bullet16.y > bordors1.y){
                    bullet16.y = bordors2.y++;                
                    }
                    if (bullet17.y > bordors1.y){
                    bullet17.y = bordors2.y++;          
                    }
                    if (bullet21.y > bordors1.y){
                    bullet21.y = bordors2.y++;
                    }  
                    
                    // if the score is equal to or greater than 3 end the program
                    if (score1 > 25){    
                        start = false;
                    }
                    
                    // if the score is equal to or greater than 3 end the program
                    if (score2 > 25){    
                        start = false;
                    }

                    // if the either of the player's diead reset the game using the reset method
                    if (dead1 || dead2) {
                        reset();
                    }
                }

                // GAME LOGIC ENDS HERE 
                // update the drawing (calls paintComponent)
                repaint();

                // SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
                // USING SOME SIMPLE MATH
                deltaTime = System.currentTimeMillis() - startTime;
                try {
                    if (deltaTime > desiredTime) {
                        //took too much time, don't wait
                        Thread.sleep(1);
                    } else {
                        // sleep to make up the extra time
                        Thread.sleep(desiredTime - deltaTime);
                    }
                } catch (Exception e) {
                };
            }
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
        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
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
    // get keys for the player's to use in the game
    public void keyPressed(KeyEvent e) {
        int key = e.getExtendedKeyCode();
        if (key == KeyEvent.VK_A) {
            left1 = true;
            start = true;
        }
        
        if (key == KeyEvent.VK_D) {
            right1 = true;
            start = true;
        }
        if (key == KeyEvent.VK_LEFT) {
            left2 = true;
            start = true;
        }
        
        if (key == KeyEvent.VK_RIGHT) {
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
        if (key == KeyEvent.VK_D) {
            right1 = false;
        }
        if (key == KeyEvent.VK_LEFT) {
            left2 = false;
        }
        if (key == KeyEvent.VK_RIGHT) {
            right2 = false;
        }       
        if (key == KeyEvent.VK_ENTER) {
            begin = false;
        }
    }
}