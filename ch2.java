import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

// enemy ai
// power ups
// menu
// bosses
// player death (sort of)

public class ch2 extends JFrame{
  
  private JButton button;
  cf panel = new cf();
  
  public ch2(){
    setTitle("Ceming Huang");
    setResizable(false);
    setSize(400,700);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    setVisible(true);
  }
  
  public void gui(){
    button = new JButton("Create an enemy!");
    
    button.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        //JOptionPane.showMessageDialog(null,"Ceming is the best");
        panel.enemies.add(new Enemy());
      }
    });
    panel.add(button);
    this.add(panel);
  }
  
  public static void main(String [] args){
    ch2 im = new ch2();
    im.gui();
  }
  
}

class cf extends JPanel{
  
  Image background = new ImageIcon("background.png").getImage();
  ArrayList<Bullet> bullets = new ArrayList<Bullet>();
  ArrayList<HomingBullet> homingbullets = new ArrayList<HomingBullet>();
  ArrayList<Enemy> enemies = new ArrayList<Enemy>();
  ArrayList<EnemyBullet> enemybullets = new ArrayList<EnemyBullet>();
  ArrayList<PowerUp> powerups = new ArrayList<PowerUp>();
  ArrayList<Integer> scores = new ArrayList<Integer>();
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
      if (gametime == 200){
        enemies.add(new Enemy(100, 0));
        enemies.add(new Enemy(200, 0));
        enemies.add(new Enemy(300, 0));
      }
      if (gametime == 240){
        enemies.add(new Enemy(100, 0));
        enemies.add(new Enemy(200, 0));
        enemies.add(new Enemy(300, 0));
      }
      if (gametime == 280){
        enemies.add(new Enemy(100, 0));
        enemies.add(new Enemy(200, 0));
        enemies.add(new Enemy(300, 0));
      }
      if (gametime == 320){
        enemies.add(new Enemy(100, 0));
        enemies.add(new Enemy(200, 0));
        enemies.add(new Enemy(300, 0));
      }
      if (gametime == 360){
        enemies.add(new Enemy(100, 0));
        enemies.add(new Enemy(200, 0));
        enemies.add(new Enemy(300, 0));
      }
      if (gametime == 400){
        enemies.add(new Enemy(100, 0));
        enemies.add(new Enemy(200, 0));
        enemies.add(new Enemy(300, 0));
      }
      if (gametime == 500){
        enemies.add(new Enemy(200, 0));
      }
      if (gametime == 520){
        enemies.add(new Enemy(150, 0));
        enemies.add(new Enemy(250, 0));
      }
      if (gametime == 540){
        enemies.add(new Enemy(100, 0));
        enemies.add(new Enemy(300, 0));
      }
      if (gametime == 560){
        enemies.add(new Enemy(50, 0));
        enemies.add(new Enemy(350, 0));
      }
      if (gametime == 660){
        enemies.add(new Enemy(200, 0));
      }
      if (gametime == 700){
        enemies.add(new Enemy(150, 0));
        enemies.add(new Enemy(200, 0));
        enemies.add(new Enemy(250, 0));
      }
      if (gametime == 740){
        enemies.add(new Enemy(100, 0));
        enemies.add(new Enemy(150, 0));
        enemies.add(new Enemy(200, 0));
        enemies.add(new Enemy(250, 0));
        enemies.add(new Enemy(300, 0));
      }
      if (gametime == 780){
        enemies.add(new Enemy(50, 0));
        enemies.add(new Enemy(100, 0));
        enemies.add(new Enemy(150, 0));
        enemies.add(new Enemy(200, 0));
        enemies.add(new Enemy(250, 0));
        enemies.add(new Enemy(300, 0)); 
        enemies.add(new Enemy(350, 0));
      }
      if (gametime == 940){
        enemies.add(new Enemy(25, 0));
        enemies.add(new Enemy(375, 0));
      }
      if (gametime == 980){
        enemies.add(new Enemy(50, 0));
        enemies.add(new Enemy(350, 0));
      }
      if (gametime == 1020){
        enemies.add(new Enemy(75, 0));
        enemies.add(new Enemy(325, 0));
      }
      if (gametime == 1060){
        enemies.add(new Enemy(100, 0));
        enemies.add(new Enemy(300, 0));
      }
      if (gametime == 1100){
        enemies.add(new Enemy(125, 0));
        enemies.add(new Enemy(275, 0));
      }
      if (gametime == 1140){
        enemies.add(new Enemy(150, 0));
        enemies.add(new Enemy(250, 0));
      }
      if (gametime == 1180){
        enemies.add(new Enemy(175, 0));
        enemies.add(new Enemy(225, 0));
      }
      if (gametime == 1220){
        enemies.add(new Enemy(200, 0));
      }
      if (gametime == 1260){
        enemies.add(new Enemy(175, 0));
        enemies.add(new Enemy(225, 0));
      }
      if (gametime == 1300){
        enemies.add(new Enemy(150, 0));
        enemies.add(new Enemy(250, 0));
      }
      if (gametime == 1340){
        enemies.add(new Enemy(125, 0));
        enemies.add(new Enemy(275, 0));
      }
      if (gametime == 1380){
        enemies.add(new Enemy(100, 0));
        enemies.add(new Enemy(300, 0));
      }
      if (gametime == 1420){
        enemies.add(new Enemy(75, 0));
        enemies.add(new Enemy(325, 0));
      }
      if (gametime == 1460){
        enemies.add(new Enemy(50, 0));
        enemies.add(new Enemy(350, 0));
      }
      if (gametime == 1500){
        enemies.add(new Enemy(25, 0));
        enemies.add(new Enemy(375, 0));
      }
            if (gametime == 940){
        enemies.add(new Enemy(25, 0));
        enemies.add(new Enemy(375, 0));
      }
      if (gametime == 1540){
        enemies.add(new Enemy(50, 0));
        enemies.add(new Enemy(350, 0));
      }
      if (gametime == 1580){
        enemies.add(new Enemy(75, 0));
        enemies.add(new Enemy(325, 0));
      }
      if (gametime == 1620){
        enemies.add(new Enemy(100, 0));
        enemies.add(new Enemy(300, 0));
      }
      if (gametime == 1660){
        enemies.add(new Enemy(125, 0));
        enemies.add(new Enemy(275, 0));
      }
      if (gametime == 1700){
        enemies.add(new Enemy(150, 0));
        enemies.add(new Enemy(250, 0));
      }
      if (gametime == 1740){
        enemies.add(new Enemy(175, 0));
        enemies.add(new Enemy(225, 0));
      }
      if (gametime == 1780){
        enemies.add(new Enemy(200, 0));
      }
      if (gametime == 1820){
        enemies.add(new Enemy(175, 0));
        enemies.add(new Enemy(225, 0));
      }
      if (gametime == 1860){
        enemies.add(new Enemy(150, 0));
        enemies.add(new Enemy(250, 0));
      }
      if (gametime == 1900){
        enemies.add(new Enemy(125, 0));
        enemies.add(new Enemy(275, 0));
      }
      if (gametime == 1940){
        enemies.add(new Enemy(100, 0));
        enemies.add(new Enemy(300, 0));
      }
      if (gametime == 1980){
        enemies.add(new Enemy(75, 0));
        enemies.add(new Enemy(325, 0));
      }
      if (gametime == 2020){
        enemies.add(new Enemy(50, 0));
        enemies.add(new Enemy(350, 0));
      }
      if (gametime == 2060){
        enemies.add(new Enemy(25, 0));
        enemies.add(new Enemy(375, 0));
      }
      if (gametime == 2100){
        enemies.add(new Enemy(25, 0));
        enemies.add(new Enemy(375, 0));
      }
      if (gametime == 2140){
        enemies.add(new Enemy(50, 0));
        enemies.add(new Enemy(350, 0));
      }
      if (gametime == 2180){
        enemies.add(new Enemy(75, 0));
        enemies.add(new Enemy(325, 0));
      }
      if (gametime == 2220){
        enemies.add(new Enemy(100, 0));
        enemies.add(new Enemy(300, 0));
      }
      if (gametime == 2260){
        enemies.add(new Enemy(125, 0));
        enemies.add(new Enemy(275, 0));
      }
      if (gametime == 2300){
        enemies.add(new Enemy(150, 0));
        enemies.add(new Enemy(250, 0));
      }
      if (gametime == 2340){
        enemies.add(new Enemy(175, 0));
        enemies.add(new Enemy(225, 0));
      }
      if (gametime == 2380){
        enemies.add(new Enemy(200, 0));
      }
      if (gametime == 2420){
        enemies.add(new Enemy(175, 0));
        enemies.add(new Enemy(225, 0));
      }
      if (gametime == 2460){
        enemies.add(new Enemy(150, 0));
        enemies.add(new Enemy(250, 0));
      }
      if (gametime == 2500){
        enemies.add(new Enemy(125, 0));
        enemies.add(new Enemy(275, 0));
      }
      if (gametime == 2540){
        enemies.add(new Enemy(100, 0));
        enemies.add(new Enemy(300, 0));
      }
      if (gametime == 2580){
        enemies.add(new Enemy(75, 0));
        enemies.add(new Enemy(325, 0));
      }
      if (gametime == 2620){
        enemies.add(new Enemy(50, 0));
        enemies.add(new Enemy(350, 0));
      }
      if (gametime == 2660){
        enemies.add(new Enemy(25, 0));
        enemies.add(new Enemy(375, 0));
      }
      
  }
  
  public void gameLoop(){
    Timer j = new Timer(1000/60, new ActionListener(){
      public void actionPerformed(ActionEvent e){
        update();

      }
    });
    j.start();
  }
  
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
    for(int i = 0 ; i < powerups.size(); i++){
      PowerUp x = powerups.get(i);
      x.updateHitbox();
      x.setY(x.getY() + 2);
      if(x.isCollision(sprite)){
          sprite.setPower("homing");
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
    //For homing bullets
    for(int i = 0; i < homingbullets.size(); i++){
      HomingBullet curr = homingbullets.get(i);
      // this stupid
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
          if(powchance < 200)
            powerups.add(new PowerUp(c.getX(),c.getY(),"homing.png"));
          bullets.remove(i);
          enemies.remove(j);
          score++;
          break;
        }
      }
    }
    repaint();
  }
  
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(background,-200,-50,null);
    g.drawImage(sprite.image(),locx -16,locy -16,null);
    if(homingbullets.size() > 0)
    for(HomingBullet i: homingbullets){
      i.rotateImage();
      g.drawImage(i.image(),i.getX()-3,i.getY()-8,null);
    }
    if(bullets.size() > 0)
    for(Bullet i : bullets)
      g.drawImage(i.image(),i.getX()-3,i.getY()-8,null);
    if(enemybullets.size() > 0)
    for(EnemyBullet b : enemybullets)
      g.drawImage(b.image(),b.getX()+6,b.getY()+5,null); 
    for(Enemy x : enemies)
      g.drawImage(x.image(),x.getX(),x.getY(),null);
    for(PowerUp x : powerups)
      g.drawImage(x.image(),x.getX(),x.getY(),null);
  }
}

class PowerUp extends GameEntity{
  
  private String _identifier;
  String [] powers = {"homing.png","laser.png"};
  
  PowerUp(int x, int y, String image){
    super(x,y,image);
    String _identifier = image;
  }
  
  public void effect(Sprite x){
    if(_identifier.equals("homing.png"))
      x.setPower("homing");
  }
}

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
  }
  
  public void updateHitbox(){
    getHitbox().setLocation(getX() - 6, getY());
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
