import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class ant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{ 
    private GreenfootImage playerImage;
    private int moveSpeed;
    private int pScale;
    private int counter, count;
    private int oxygenCount;
    private int batteryStored;
    private int fireDelay, delayStart;
    private int fireSpeed;
    private int delayStartP,fireDelayP;

    public Player(){
        /* player image source
         * /https://craftpix.net/freebies/free-citizen-artist-astrologer-4-direction-npc-character-pack/
         */
        counter= 0;
        pScale = 9;
        moveSpeed = 3;
        oxygenCount = 100;
        count = 0;
        batteryStored = 0;
        fireDelay = 0;
        delayStart = 30;
        fireSpeed=1;
        fireDelayP=0;
        delayStartP=30;
        playerImage = new GreenfootImage("0_Citizen_Walk_000.png");
        playerImage.scale(playerImage.getWidth()/pScale,playerImage.getHeight()/pScale);
        setImage(playerImage);
    }

    public void act() 
    {
        pMove();
        oxygenDrop();
        pickupBattery();
        checkTurret("f","w","s");
        fire("E");
    }    

    public void pMove(){
        if(isTouching(Turret.class) && getX() <= 360){
            if(Greenfoot.isKeyDown("d")){
                setLocation(getX()+moveSpeed, getY());
                walkAnimation();
            }
        }
        else if(isTouching(Space.class) && getX()>= 595){
            if(Greenfoot.isKeyDown("a")){
                setLocation(getX()-moveSpeed, getY());
                walkAnimation();
            }
            if(Greenfoot.isKeyDown("w")){
                setLocation(getX(), getY()-moveSpeed);
                walkAnimation();
            }
            if(Greenfoot.isKeyDown("s")){
                setLocation(getX(), getY()+moveSpeed);
                walkAnimation();
            }
        }else if(isTouching(Space.class) && getX()== 340){
            if(Greenfoot.isKeyDown("d")){
                setLocation(getX()+moveSpeed, getY());
                walkAnimation();
            }
            if(Greenfoot.isKeyDown("w")){
                setLocation(getX(), getY()-moveSpeed);
                walkAnimation();
            }
            if(Greenfoot.isKeyDown("s")){
                setLocation(getX(), getY()+moveSpeed);
                walkAnimation();
            }
        }else {
            if(Greenfoot.isKeyDown("a")){
                setLocation(getX()-moveSpeed, getY());
                walkAnimation();
            }
            if(Greenfoot.isKeyDown("d")){
                setLocation(getX()+moveSpeed, getY());
                walkAnimation();
            }
            if(Greenfoot.isKeyDown("w")){
                setLocation(getX(), getY()-moveSpeed);
                walkAnimation();
            }
            if(Greenfoot.isKeyDown("s")){
                setLocation(getX(), getY()+moveSpeed);
                walkAnimation();
            }
        }

    }

    public void walkAnimation(){
        switch(counter){
            case 0:
                playerImage = new GreenfootImage("0_Citizen_Walk_000.png");
                playerImage.scale(playerImage.getWidth()/pScale,playerImage.getHeight()/pScale);
                setImage(playerImage);
                break;

            case 10:
                playerImage = new GreenfootImage("0_Citizen_Walk_008.png");
                playerImage.scale(playerImage.getWidth()/pScale,playerImage.getHeight()/pScale);
                setImage(playerImage);
                break;

            case 20:
                playerImage = new GreenfootImage("0_Citizen_Walk_015.png");
                playerImage.scale(playerImage.getWidth()/pScale,playerImage.getHeight()/pScale);
                setImage(playerImage);
                break;

            case 30:
                playerImage = new GreenfootImage("0_Citizen_Walk_023.png");
                playerImage.scale(playerImage.getWidth()/pScale,playerImage.getHeight()/pScale);
                setImage(playerImage);
                break;

            case 40:
                playerImage = new GreenfootImage("0_Citizen_Walk_029.png");
                playerImage.scale(playerImage.getWidth()/pScale,playerImage.getHeight()/pScale);
                setImage(playerImage);
                break;

            default:
        }

        if(counter>=40){
            counter=0;
        }else counter++;
    }

    public int getMoveSpeed(){
        return moveSpeed;
    }

    public void oxygenDrop(){

        if(count == 30 && oxygenCount > 0){
            oxygenCount--;
            count = 0;
        }
        else{
            count++;
        }

    }
    
    public void oxygenDrain(int drain){
        oxygenCount-=drain;
    }

    public int getOxygen(){
        return oxygenCount;
    }

    public void setOxygen(int val){
        if(getOxygen()<100){
            oxygenCount = oxygenCount + val;
            if(getOxygen()>100){
                oxygenCount=100;
            }
        }
    }

    public void pickupBattery(){
        if(isTouching(PowerPickup.class)){
            batteryStored = batteryStored + 20;
            removeTouching(PowerPickup.class);
        }
    }

    public int getBatteryStored(){
        return batteryStored;
    }

    public void setBatteryStored(int val){
        batteryStored = batteryStored - val;
    }

    public void checkTurret(String turretkeyfire, String keyrotateR, String keyrotateL){
        List<Turret> turrets = getIntersectingObjects(Turret.class);
        if(Greenfoot.isKeyDown(turretkeyfire) && isTouching(Turret.class) && fireDelay <= 0){
            for(Turret turret : turrets){
                turret.fireBullet();
            }
            fireDelay = delayStart;
        }
        fireDelay--;

        if(Greenfoot.isKeyDown(keyrotateR) && isTouching(Turret.class)){
            for(Turret turret : turrets){
                if(turret.getRotation() < turret.getMaxRotUp()){
                    turret.rotateTurret(5);
                }
            }
        }else if(Greenfoot.isKeyDown(keyrotateL) && isTouching(Turret.class)){
            for(Turret turret : turrets){
                if(turret.getRotation() > turret.getMaxRotDown()){
                    turret.rotateTurret(-5);
                }
            }
        }
    }

    public void fire(String fireKey){
        if(Greenfoot.isKeyDown(fireKey) && fireDelayP<=0){
            Bullet bullet = new Bullet(true,getX(),getY());
            getWorld().addObject(bullet,getX(),getY());
            fireDelayP=delayStart;
        }
        fireDelayP--;
    }
}
