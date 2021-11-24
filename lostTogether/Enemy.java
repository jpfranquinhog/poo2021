import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * link for assets https://craftpix.net/freebies/free-wraith-tiny-style-2d-sprites/
     */
    private GreenfootImage enemyImage;
    private int counter,deathCounter;
    private int eScale;
    private int scaneArea;
    private int moveSpeed;
    private int health;
    private Player player1,player2;
    public void act() 
    {
        // Add your action code here.
        walkAnimation();
        eMove();
        move(moveSpeed);
        takeDamage();
        Death();
    }    
    
    public Enemy(){
        counter= 0;
        deathCounter=0;
        eScale = 4;
        scaneArea=50;
        moveSpeed=2;
        health=5;
        enemyImage = new GreenfootImage("Wraith_01_Moving Forward_000.png");
        enemyImage.scale(enemyImage.getWidth()/eScale,enemyImage.getHeight()/eScale);
    }
    
    public void walkAnimation(){
        switch(counter){
            case 0:
                enemyImage = new GreenfootImage("Wraith_01_Moving Forward_000.png");
                enemyImage.scale(enemyImage.getWidth()/eScale,enemyImage.getHeight()/eScale);
                setImage(enemyImage);
                break;

            case 10:
                enemyImage = new GreenfootImage("Wraith_01_Moving Forward_003.png");
                enemyImage.scale(enemyImage.getWidth()/eScale,enemyImage.getHeight()/eScale);
                setImage(enemyImage);
                break;

            case 20:
                enemyImage = new GreenfootImage("Wraith_01_Moving Forward_006.png");
                enemyImage.scale(enemyImage.getWidth()/eScale,enemyImage.getHeight()/eScale);
                setImage(enemyImage);
                break;

            case 30:
                enemyImage = new GreenfootImage("Wraith_01_Moving Forward_009.png");
                enemyImage.scale(enemyImage.getWidth()/eScale,enemyImage.getHeight()/eScale);
                setImage(enemyImage);
                break;

            case 40:
                enemyImage = new GreenfootImage("Wraith_01_Moving Forward_011.png");
                enemyImage.scale(enemyImage.getWidth()/eScale,enemyImage.getHeight()/eScale);
                setImage(enemyImage);
                break;

            default:
        }

        if(counter>=40){
            counter=0;
        }else counter++;
    }
    
    public void eMove(){
        //mover para o player mais proximo
        if(getNeighbours(scaneArea, true, Player.class).isEmpty() && getNeighbours(scaneArea, true, Player2.class).isEmpty()){
            scaneArea+=50;
        }else{
            if(getNeighbours(scaneArea, true, Player.class).isEmpty()==false){
                turnTowards(getNeighbours(scaneArea, true, Player.class).get(0).getX(), getNeighbours(scaneArea, true, Player.class).get(0).getY());
            }else if(getNeighbours(scaneArea, true, Player2.class).isEmpty()==false){
                turnTowards(getNeighbours(scaneArea, true, Player2.class).get(0).getX(), getNeighbours(scaneArea, true, Player2.class).get(0).getY());
            }
            scaneArea=50;
        }
    }
    
    public void takeDamage(){
        if(isTouching(Bullet.class) && health>0){
            removeTouching(Bullet.class);
            health--;
        }
    }
    
    public void Death(){
        if(health<=0){
            switch(deathCounter){
                case 0:
                    enemyImage = new GreenfootImage("Wraith_01_Dying_007.png");
                    enemyImage.scale(enemyImage.getWidth()/eScale,enemyImage.getHeight()/eScale);
                    setImage(enemyImage);
                    break;
    
                case 10:
                    enemyImage = new GreenfootImage("Wraith_01_Dying_009.png");
                    enemyImage.scale(enemyImage.getWidth()/eScale,enemyImage.getHeight()/eScale);
                    setImage(enemyImage);
                    break;
    
                case 20:
                    enemyImage = new GreenfootImage("Wraith_01_Dying_014.png");
                    enemyImage.scale(enemyImage.getWidth()/eScale,enemyImage.getHeight()/eScale);
                    setImage(enemyImage);
                    break;
                    
                case 30:
                    PowerPickup power = new PowerPickup();
                    ((MyWorld)getWorld()).increaseScore(500);
                    getWorld().addObject(power, this.getX(),this.getY());
                    getWorld().removeObject(this);
                    break;
                default:
            }
            deathCounter++;
        }
    }
}
