import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

//jframe that holds game panel
public class ch2 extends JFrame{
  
  private JButton button;
  cf panel = new cf();
  
  public ch2(){
    setTitle("Platekians");
    setResizable(false);
    setSize(400,700);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    setVisible(true);
  }
  
  public void gui(){
    this.add(panel);
  }
  
  public static void main(String [] args){
    ch2 im = new ch2();
    im.gui();
  }
  
}

//actual game panel
class cf extends JPanel{
  
  Image background = new ImageIcon("background.png").getImage();
  ArrayList<Bullet> bullets = new ArrayList<Bullet>();
  ArrayList<HomingBullet> homingbullets = new ArrayList<HomingBullet>();
  ArrayList<Enemy> enemies = new ArrayList<Enemy>();
  ArrayList<EnemyBullet> enemybullets = new ArrayList<EnemyBullet>();
  ArrayList<PowerUp> powerups = new ArrayList<PowerUp>();
  ArrayList<Integer> scores = new ArrayList<Integer>();
  ArrayList<Laser> lasers = new ArrayList<Laser>();
  ArrayList<ShoddyBullet> shoddybullets = new ArrayList<ShoddyBullet>();
  ArrayList<Enemy2> enemies2 = new ArrayList<Enemy2>();
  ArrayList<Boss> boss = new ArrayList<Boss>();
  ArrayList<Java> java = new ArrayList<Java>();
  Sprite sprite = new Sprite();
  JLabel label = new JLabel("0");
  int gametime = 0;
  int score = 0;
  int locx = 700;
  int locy = 400;
  
  cf(){
    label.setForeground(Color.YELLOW);
    label.setFont(new Font("Courier New", Font.BOLD, 24));
    add(label);
    
    addMouseMotionListener(new MouseAdapter(){
      public void mouseMoved(MouseEvent e){
        locx = e.getX();
        locy = e.getY();
        sprite.setX(locx - 16);
        sprite.setY(locy - 16);
        repaint();
      }
      public void mouseDragged(MouseEvent e){
        locx = e.getX();
        locy = e.getY();
        sprite.setX(locx - 16);
        sprite.setY(locy - 16);
        repaint();
      }
    });
    
    addMouseListener(new MouseAdapter(){
      public void mousePressed(MouseEvent evt){
        if(sprite.getPower().equals("homing"))
          homingbullets.add(new HomingBullet(locx,locy));
        else if(sprite.getPower().equals("laser")) lasers.add(new Laser(locx,locy));
        else bullets.add(new Bullet(locx,locy));
      }
    });
    gameLoop();
  }
  
  public void level1(){
     gametime++;
    /*if(gametime == 600)
     for(int i = -6; i < 7; i++){
     enemies.add(new Enemy(i*30 + 188, 6* -i * i));
     gametime = 0;
     }*/
    if (gametime == 50){
      enemies.add(new Enemy(50, 0));
      enemies.add(new Enemy(350, 0));
      enemies2.add(new Enemy2(200, 0));
    }
    if (gametime == 70){
      enemies.add(new Enemy(100, 0));
      enemies.add(new Enemy(300, 0));
    }
    if (gametime == 90){
      enemies.add(new Enemy(150, 0));
      enemies.add(new Enemy(250, 0));
    }
    if (gametime == 110){
      enemies.add(new Enemy(200, 0));
    }
    if (gametime == 310){
      enemies.add(new Enemy(100, 0));
      enemies.add(new Enemy(200, 0));
      enemies.add(new Enemy(300, 0));
      enemies2.add(new Enemy2(150, 0));
      enemies2.add(new Enemy2(250, 0));
    }
    if (gametime == 350){
      enemies.add(new Enemy(100, 0));
      enemies.add(new Enemy(200, 0));
      enemies.add(new Enemy(300, 0));
    }
    if (gametime == 390){
      enemies.add(new Enemy(100, 0));
      enemies.add(new Enemy(200, 0));
      enemies.add(new Enemy(300, 0));
    }
    if (gametime == 430){
      enemies.add(new Enemy(100, 0));
      enemies.add(new Enemy(200, 0));
      enemies.add(new Enemy(300, 0));
    }
    if (gametime == 470){
      enemies.add(new Enemy(100, 0));
      enemies.add(new Enemy(200, 0));
      enemies.add(new Enemy(300, 0));
    }
    if (gametime == 510){
      enemies.add(new Enemy(100, 0));
      enemies.add(new Enemy(200, 0));
      enemies.add(new Enemy(300, 0));
    }
    if (gametime == 710){
      enemies.add(new Enemy(200, 0));
    }
    if (gametime == 730){
      enemies.add(new Enemy(150, 0));
      enemies.add(new Enemy(250, 0));
    }
    if (gametime == 750){
      enemies.add(new Enemy(100, 0));
      enemies.add(new Enemy(300, 0));
    }
    if (gametime == 770){
      enemies.add(new Enemy(50, 0));
      enemies.add(new Enemy(350, 0));
    }
    if (gametime == 970){
      enemies.add(new Enemy(200, 0));
    }
    if (gametime == 1010){
      enemies.add(new Enemy(150, 0));
      enemies.add(new Enemy(200, 0));
      enemies.add(new Enemy(250, 0));
    }
    if (gametime == 1050){
      enemies.add(new Enemy(100, 0));
      enemies.add(new Enemy(150, 0));
      enemies.add(new Enemy(200, 0));
      enemies.add(new Enemy(250, 0));
      enemies.add(new Enemy(300, 0));
    }
    if (gametime == 1090){
      enemies.add(new Enemy(50, 0));
      enemies.add(new Enemy(100, 0));
      enemies.add(new Enemy(150, 0));
      enemies.add(new Enemy(200, 0));
      enemies.add(new Enemy(250, 0));
      enemies.add(new Enemy(300, 0)); 
      enemies.add(new Enemy(350, 0));
    }
    if (gametime == 1390){
      enemies.add(new Enemy(25, 0));
      enemies.add(new Enemy(375, 0));
    }
    if (gametime == 1430){
      enemies.add(new Enemy(50, 0));
      enemies.add(new Enemy(350, 0));
    }
    if (gametime == 1470){
      enemies.add(new Enemy(75, 0));
      enemies.add(new Enemy(325, 0));
    }
    if (gametime == 1510){
      enemies.add(new Enemy(100, 0));
      enemies.add(new Enemy(300, 0));
    }
    if (gametime == 1550){
      enemies.add(new Enemy(125, 0));
      enemies.add(new Enemy(275, 0));
    }
    if (gametime == 1590){
      enemies.add(new Enemy(150, 0));
      enemies.add(new Enemy(250, 0));
    }
    if (gametime == 1630){
      enemies.add(new Enemy(175, 0));
      enemies.add(new Enemy(225, 0));
    }
    if (gametime == 1670){
      enemies.add(new Enemy(200, 0));
    }
    if (gametime == 1710){
      enemies.add(new Enemy(175, 0));
      enemies.add(new Enemy(225, 0));
    }
    if (gametime == 1750){
      enemies.add(new Enemy(150, 0));
      enemies.add(new Enemy(250, 0));
    }
    if (gametime == 1790){
      enemies.add(new Enemy(125, 0));
      enemies.add(new Enemy(275, 0));
    }
    if (gametime == 1830){
      enemies.add(new Enemy(100, 0));
      enemies.add(new Enemy(300, 0));
    }
    if (gametime == 1870){
      enemies.add(new Enemy(75, 0));
      enemies.add(new Enemy(325, 0));
    }
    if (gametime == 1910){
      enemies.add(new Enemy(50, 0));
      enemies.add(new Enemy(350, 0));
    }
    if (gametime == 1950){
      enemies.add(new Enemy(25, 0));
      enemies.add(new Enemy(375, 0));
    }
    if (gametime == 1990){
      enemies.add(new Enemy(25, 0));
      enemies.add(new Enemy(375, 0));
    }
    if (gametime == 2030){
      enemies.add(new Enemy(50, 0));
      enemies.add(new Enemy(350, 0));
    }
    if (gametime == 2070){
      enemies.add(new Enemy(75, 0));
        enemies.add(new Enemy(325, 0));
      }
      if (gametime == 2110){
        enemies.add(new Enemy(100, 0));
        enemies.add(new Enemy(300, 0));
      }
      if (gametime == 2150){
        enemies.add(new Enemy(125, 0));
        enemies.add(new Enemy(275, 0));
      }
      if (gametime == 2190){
        enemies.add(new Enemy(150, 0));
        enemies.add(new Enemy(250, 0));
      }
      if (gametime == 2230){
        enemies.add(new Enemy(175, 0));
        enemies.add(new Enemy(225, 0));
      }
      if (gametime == 2270){
        enemies.add(new Enemy(200, 0));
      }
      if (gametime == 2310){
        enemies.add(new Enemy(175, 0));
        enemies.add(new Enemy(225, 0));
      }
      if (gametime == 2350){
        enemies.add(new Enemy(150, 0));
        enemies.add(new Enemy(250, 0));
      }
      if (gametime == 2390){
        enemies.add(new Enemy(125, 0));
        enemies.add(new Enemy(275, 0));
      }
      if (gametime == 2430){
        enemies.add(new Enemy(100, 0));
        enemies.add(new Enemy(300, 0));
      }
      if (gametime == 2470){
        enemies.add(new Enemy(75, 0));
        enemies.add(new Enemy(325, 0));
      }
      if (gametime == 2510){
        enemies.add(new Enemy(50, 0));
        enemies.add(new Enemy(350, 0));
      }
      if (gametime == 2550){
        enemies.add(new Enemy(25, 0));
        enemies.add(new Enemy(375, 0));
      }
      if (gametime == 2590){
        enemies.add(new Enemy(25, 0));
        enemies.add(new Enemy(375, 0));
      }
      if (gametime == 2630){
        enemies.add(new Enemy(50, 0));
        enemies.add(new Enemy(350, 0));
      }
      if (gametime == 2670){
        enemies.add(new Enemy(75, 0));
        enemies.add(new Enemy(325, 0));
      }
      if (gametime == 2710){
        enemies.add(new Enemy(100, 0));
        enemies.add(new Enemy(300, 0));
      }
      if (gametime == 2750){
        enemies.add(new Enemy(125, 0));
        enemies.add(new Enemy(275, 0));
      }
      if (gametime == 2790){
        enemies.add(new Enemy(150, 0));
        enemies.add(new Enemy(250, 0));
      }
      if (gametime == 2830){
        enemies.add(new Enemy(175, 0));
        enemies.add(new Enemy(225, 0));
      }
      if (gametime == 2870){
        enemies.add(new Enemy(200, 0));
      }
      if (gametime == 2910){
        enemies.add(new Enemy(175, 0));
        enemies.add(new Enemy(225, 0));
      }
      if (gametime == 2950){
        enemies.add(new Enemy(150, 0));
        enemies.add(new Enemy(250, 0));
      }
      if (gametime == 2990){
        enemies.add(new Enemy(125, 0));
        enemies.add(new Enemy(275, 0));
      }
      if (gametime == 3030){
        enemies.add(new Enemy(100, 0));
        enemies.add(new Enemy(300, 0));
      }
      if (gametime == 3070){
        enemies.add(new Enemy(75, 0));
        enemies.add(new Enemy(325, 0));
      }
      if (gametime == 3110){
        enemies.add(new Enemy(50, 0));
        enemies.add(new Enemy(350, 0));
      }
      if (gametime == 3150){
        enemies.add(new Enemy(25, 0));
        enemies.add(new Enemy(375, 0));
      }
      if (gametime > 3150 && enemies.size() == 0 && enemies2.size() == 0 && boss.size() == 0)
        boss.add(new Boss());
  }
  
  //rendition of a game loop using swing timer
  public void gameLoop(){
    Timer j = new Timer(1000/60, new ActionListener(){ // bottom number represents fps
      public void actionPerformed(ActionEvent e){
        update();

      }
    });
    j.start();
  }
  
  //checks everything at every tick.
  public void update(){
    level1();
    label.setText("SCORE:" + score);
    sprite.updateHitbox();
    int ptime = sprite.getTime();
    if(ptime > 0){
      sprite.setTime(--ptime);
      if(ptime == 0)
        sprite.setPower("");
    }
    //chance of spawn
    //int chance = (int)(Math.random() * 10000);
    //if (chance < 100){
     // enemies.add(new Enemy());
      //for(int i = 0; i < 10; i++){
        //enemies.add(new Enemy(i * 40,i * -5));
     // }
  //  }
    //Power collision with player
    for(Boss x : boss){
      x.move();
      x.updateHitbox();
      if(x.interval() % 25 == 0){
        java.add(new Java(x.getX(),x.getY() + x.image().getHeight(null)/ 2, sprite));
        java.add(new Java(x.getX(),x.getY() - x.image().getHeight(null)/ 2, sprite));
        java.add(new Java(x.getX() + x.image().getWidth(null)/2, x.getY(), sprite));
        java.add(new Java(x.getX() - x.image().getWidth(null)/2, x.getY(), sprite));
        java.add(new Java(x.getX() - x.image().getWidth(null)/2, x.getY() - x.image().getHeight(null) / 4, sprite));
        java.add(new Java(x.getX() - x.image().getWidth(null)/2, x.getY() + x.image().getHeight(null) / 4, sprite));
        java.add(new Java(x.getX() + x.image().getWidth(null)/2, x.getY() - x.image().getHeight(null) / 4, sprite));
        java.add(new Java(x.getX() + x.image().getWidth(null)/2, x.getY() + x.image().getHeight(null) / 4, sprite));
      }
    }
    for(int i = 0 ; i < powerups.size(); i++){
      PowerUp x = powerups.get(i);
      x.updateHitbox();
      x.setY(x.getY() + 2);
      if(x.isCollision(sprite)){
          x.effect(sprite);
          sprite.setTime(600);
          powerups.remove(x);
      }
    }
    for(int k = 0; k < enemies.size(); k++){
      Enemy o = enemies.get(k);
      if (o.out())
        enemies.remove(o);
      //won't execute based on local variable
      else{
        if (o.interval() == 200){
          enemybullets.add(new EnemyBullet(o.getX(),o.getY()));
          o.addInterval(-200);
        }
        o.setY(o.getY() + 1);
        o.updateHitbox();
        o.addInterval(1);
      }
    }
    //java projectiles
    for (int y = 0; y < java.size(); y++){
      Java bo = java.get(y);
      bo.setX(bo.getX() + bo.getXSpeed());
      bo.setY(bo.getY() + bo.getYSpeed());
      bo.updateHitbox();
      if (bo.out())
        java.remove(y);
      if (bo.isCollision(sprite)){
        JOptionPane.showMessageDialog(null,"You were this close to slaying the mythical beast!");
        System.exit(0);
      }
    }
    //For regular enemy bullets
    for(int f = 0; f < enemybullets.size(); f++){
      EnemyBullet bo = enemybullets.get(f);
      bo.setY(bo.getY() + 2);
      bo.updateHitbox();
      if(bo.out())
        enemybullets.remove(f);
      if(bo.isCollision(sprite)){
        JOptionPane.showMessageDialog(null,"You have died");
        System.exit(0);
      }
    }
    //enemy2 check
    for (int z = 0; z < enemies2.size(); z++){
      Enemy2 o = enemies2.get(z);
      if ((o.interval() % 10 == 0) && (o.interval() < 50)){
        shoddybullets.add(new ShoddyBullet(o.getX(),o.getY(),sprite));
      }
      if (o.interval() == 150)
        o.addInterval(-150);
      if (o.getY() < 300)
        o.setY(o.getY() + 1);
      o.updateHitbox();
      o.addInterval(1);
      
    }
    // For enemy targeting bullets
    for (int y = 0; y < shoddybullets.size(); y++){
      ShoddyBullet bo = shoddybullets.get(y);
      bo.setX(bo.getX() + bo.getXSpeed());
      bo.setY(bo.getY() + bo.getYSpeed());
      bo.updateHitbox();
      if (bo.out())
        shoddybullets.remove(y);
      if (bo.isCollision(sprite)){
        JOptionPane.showMessageDialog(null,"You have died");
        System.exit(0);
      }
    }
    //For lasers
    for(int i = 0; i < lasers.size(); i++){
      Laser curr = lasers.get(i);
      curr.setY(curr.getY() - 8);
      curr.updateHitbox();
      if(curr.out()){
        lasers.remove(i);
        //i--;
      }
      for(int j = 0; j < enemies.size(); j++){
        Enemy c = enemies.get(j);
        if(curr.isCollision(c)){
          enemies.remove(j);
          score++;
          break;
        }
      }
      for (int a = 0; a < enemies2.size(); a++){
        Enemy2 b = enemies2.get(a);
        if (curr.isCollision(b)){
          lasers.remove(i);
          if (b.getHealth() > 0)
            b.removeHealth();
          else{
            enemies2.remove(a);
            score++;
            break;
          }
        }
      }
    }
    //Homing Check
    for(int i = 0; i < homingbullets.size(); i++){
      HomingBullet curr = homingbullets.get(i);
      if(enemies.size() > 0 && curr.getTarget() == null) curr.refresh(enemies.get((int)(Math.random() * enemies.size())));
      else if(enemies.size() > 0 && curr.getTarget() != null && enemies.indexOf(curr.getTarget()) != -1) curr.refresh(curr.getTarget());
      curr.setY(curr.getY() - (int)(8 * Math.sin(curr.getAngle())));
      curr.setX(curr.getX() + (int)(4 * Math.cos(curr.getAngle())));
      curr.updateHitbox();
      if(curr.out()){
        homingbullets.remove(i);
        //i--;
      }
      for(int j = 0; j < enemies.size(); j++){
        Enemy c = enemies.get(j);
        if(curr.isCollision(c)){
          homingbullets.remove(i);
          enemies.remove(j);
          score++;
          break;
        }
      }
      for (int a = 0; a < enemies2.size(); a++){
        Enemy2 b = enemies2.get(a);
        if (curr.isCollision(b)){
          homingbullets.remove(i);
          if (b.getHealth() > 0){
            b.removeHealth();
            break;
          }
          else{
            enemies2.remove(a);
            score++;
            break;
          }
        }
      }
    }
    //For regular bullets
    for(int i = 0; i < bullets.size(); i++){
      Bullet curr = bullets.get(i);
      curr.setY(curr.getY() - 8);
      curr.updateHitbox();
      if(curr.out()){
        bullets.remove(i);
        //i--;
      }
      for(int j = 0; j < enemies.size(); j++){
        Enemy c = enemies.get(j);
        if(curr.isCollision(c)){
          int powchance = (int)(Math.random() * 10000);
          if(powchance < 1012)
            powerups.add(new PowerUp(c.getX(),c.getY()));
          bullets.remove(i);
          enemies.remove(j);
          score++;
          break;
        }
      }
      for(int a = 0; a < enemies2.size(); a++){
        Enemy2 b = enemies2.get(a);
        if (curr.isCollision(b)){
          bullets.remove(i);
          if (b.getHealth() > 0){
            b.removeHealth();
            break;
          }
          else{
            enemies2.remove(a);
            score++;
            break;
          }
        }
      }
      for(int d = 0 ; d < boss.size(); d++){
        Boss x = boss.get(d);
        if(curr.isCollision(x)){
          x.removeHealth();
          bullets.remove(curr);
          if(x.getHealth() == 0){
            boss.remove(x);
            JOptionPane.showMessageDialog(null,"Good job. Thanks for playing.");
          }
        }
      }
    }
    repaint();
  }
  
  //inherent jpanel drawing function (draws everything!)
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(background,-200,-50,null);
    g.drawImage(sprite.image(),locx -16,locy -16,null);
    if(homingbullets.size() > 0)
    for(HomingBullet i: homingbullets){
      i.rotateImage();
      g.drawImage(i.image(),i.getX()-3,i.getY()-8,null);
    }
    for(Laser i : lasers)
      g.drawImage(i.image(),i.getX()-3,i.getY()-8,null);
    for(Bullet i : bullets)
      g.drawImage(i.image(),i.getX()-3,i.getY()-8,null);
    if(enemybullets.size() > 0)
    for(EnemyBullet b : enemybullets)
      g.drawImage(b.image(),b.getX()+6,b.getY()+5,null); 
    for(Enemy x : enemies)
      g.drawImage(x.image(),x.getX(),x.getY(),null);
    for(PowerUp x : powerups)
      g.drawImage(x.image(),x.getX(),x.getY(),null);
     for(Enemy2 x: enemies2)
      g.drawImage(x.image(),x.getX(),x.getY(),null);
    for(ShoddyBullet x: shoddybullets)
      g.drawImage(x.image(),x.getX()+6,x.getY() + 5,null);
    for(Boss x : boss)
      g.drawImage(x.image(),x.getX(),x.getY(), null);
    for(Java x : java)
      g.drawImage(x.image(),x.getX(),x.getY(),null);
  }
}

class PowerUp extends GameEntity{
  
  private String _identifier;
  String [] powers = {"homing.png","laserpow.png"};
  
  PowerUp(int x, int y){
    super(x,y,"");
    _identifier = powers[(int)(Math.random() * 2)];
    setImage(new ImageIcon(_identifier).getImage());
    setHitbox(new Rectangle(x,y,image().getWidth(null),image().getHeight(null)));
  }
  
  public void effect(Sprite x){
    if(_identifier.equals("homing.png"))
      x.setPower("homing");
    else if(_identifier.equals("laserpow.png"))
      x.setPower("laser");
  }
}

//inherited by every game object
abstract class GameEntity{
  
  private int _x, _y;
  private Image _image;
  private Rectangle _hitbox;
  
  GameEntity(int x, int y, String image){
    _x = x;
    _y = y;
    _image = new ImageIcon(image).getImage();
    _hitbox = new Rectangle(x,y,_image.getWidth(null),_image.getHeight(null));
  }
  
  public Image image(){
    return _image;
  }
  
  public void setImage(Image image){
    _image = image;
  }
  
  public void updateHitbox(){
    _hitbox.setLocation(_x,_y);
  }
  
  public void setHitbox(Rectangle hitbox){
    _hitbox = hitbox;
  }
  
  public Rectangle getHitbox(){
    return _hitbox;
  }
  
  public int getX(){
    return _x;
  }
  
  public int getY(){
    return _y;
  }
  
  public void setX(int x){
    _x = x;
  }
  
  public void setY(int y){
    _y = y;
  }
  
  public boolean isCollision(GameEntity x){
    return getHitbox().intersects(x.getHitbox());
  }
}

class Sprite extends GameEntity{
  
  private String _power;
  private int _ptime;
  
  Sprite(){
    super(400,700,"sprite.png");
    _power = "";
    _ptime = 0;
    setHitbox(new Rectangle(getX(),getY(),image().getWidth(null)/3,image().getHeight(null) - 3));
  }
  
  public void updateHitbox(){
    getHitbox().setLocation(getX() + 3, getY());
  }
      
  public String getPower(){
    return _power;
  }
    
  public void setTime(int time){
    _ptime = time;
  }
  
  public int getTime(){
    return _ptime;
  }
  
  public void setPower(String power){
    _power = power;
  }
}  

class EnemyBullet extends GameEntity{
  
  public EnemyBullet(int x, int y){
    super(x,y,"enemybullet.png");
  }
  
  public boolean out(){
    return getY() > 700;
  }
  
}

class Bullet extends GameEntity{
  
  public Bullet(int x, int y){
    super(x,y,"bullet.png");
  }
  
  public boolean out(){
    return getY() < 0;
  }
  
}

class Laser extends Bullet{

    public Laser(int x, int y){
      super(x,y);
      setImage(new ImageIcon("laser.png").getImage());
    }
    
}

class HomingBullet extends Bullet{
  
  private Enemy _target;
  private double _angle;
  
  public HomingBullet(int x, int y){
    super(x,y);
    _target = null;
    _angle = Math.PI/2;
  }
  
  public double getAngle(){
    return _angle;
  }
  
  public boolean out(){
    return (getX() < 0 || getX() > 400 || getY() < 0  || getY() > 700);
  }
  
  public Enemy getTarget(){
    return _target;
  }
  
  public void refresh(Enemy target){
    _target = target;
    _angle = Math.atan2(getY() - _target.getY(), _target.getX() - getX());
  }
  
  public void rotateImage(){
    ImageIcon icon = new ImageIcon(image());
    BufferedImage buff = new BufferedImage(icon.getIconWidth(),icon.getIconHeight(),BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2 = (Graphics2D)buff.getGraphics();
    g2.rotate(_angle,icon.getIconWidth() / 2, icon.getIconHeight() / 2);
    g2.drawImage(image(),0,0,null);
    setImage(buff);
  }
  
}

class ShoddyBullet extends EnemyBullet{

  private int _xspeed, _yspeed;

    public ShoddyBullet(int x, int y, Sprite target){
      super(x,y);
      setImage(new ImageIcon("shoddybullet.png").getImage());
      setHitbox(new Rectangle(getX(),getY(),image().getWidth(null),image().getHeight(null)));
      _xspeed = (target.getX() - x) / 50;
      _yspeed = (target.getY() - y) / 50;
    }

    public boolean out(){
      return (getX() < 0 || getX() > 400 || getY() > 700);
    }
    
    public int getXSpeed(){
      return _xspeed;
    }
    
    public int getYSpeed(){
      return _yspeed;
    }
    
}

class Enemy extends GameEntity{
  
  private int _intervalfire;
  
  public Enemy(){
    super((int)(Math.random() * 350) + 16,0,"enemy.png");
    _intervalfire = 200;
  }
  
  public Enemy(int x, int y){
    super(x,y,"enemy.png");
    _intervalfire = 200;
  }
  
  public int interval(){
    return _intervalfire;
  }
  
  public void addInterval(int x){
    _intervalfire += x;
  }
  
  public boolean out(){
    return getY() > 700;
  }
  
}

class Enemy2 extends GameEntity{
  
  private int _intervalfire, _health;
  
  public Enemy2(int x, int y){
    super(x, y, "enemy2.png" );
    _health = 3;
    _intervalfire = 0;
  }
  
  public int getHealth(){
    return _health;
  }
  
  public void removeHealth(){
    _health--;
  }
  
  public void setHealth(int health){
    _health = health;
  }
  
  public int interval(){
    return _intervalfire;
  }
  
  public void setInterval(int interval){
    _intervalfire = interval;
  }
  
  public void addInterval(int x){
    _intervalfire += x;
  }
  
}

class Boss extends Enemy2{
  
  public int _moveinterval;
  
  public Boss(){
   super(150,150);
   setImage(new ImageIcon("boss.png").getImage());
   setHitbox(new Rectangle(getX(),getY(),image().getWidth(null),image().getHeight(null)));
   _moveinterval = 0;
   setHealth(100);
  }  
  
  public void move(){
    if(_moveinterval < 120){
      setX(getX() - 1);
      setY(getY() + 1);
    }
    else if(_moveinterval < 360)
      setX(getX() + 1);
    else if(_moveinterval < 480){
      setY(getY() - 1);
      setX(getX() - 1);
    }
    if(_moveinterval == 480) _moveinterval = -1;
    if(interval() == 25) setInterval(0);
    _moveinterval++;
    addInterval(1);
  }
  
}

class Java extends ShoddyBullet{
  
  public Java(int x, int y, Sprite target){
    super(x,y,target);
    setImage(new ImageIcon("java.png").getImage());
    setHitbox(new Rectangle(getX(),getY(),image().getWidth(null),image().getHeight(null) - 3));
  }
  
  public boolean out(){
    return (getX() < -100 || getY() > 800);
  }
  
}