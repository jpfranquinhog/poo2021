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
        playerImage = new GreenfootImage("0_Citizen_Walk_000.png");
        playerImage.scale(playerImage.getWidth()/pScale,playerImage.getHeight()/pScale);
        setImage(playerImage);
    }

    public void act() 
    {
        // Add your action code here.
        pMove();
        //zoneChange();
        oxygenDrop();
        pickupBattery();
        checkTurret("f");
    }    

    /*public void zoneChange(){
    if(isAtEdge()){
    if((getX()>100) && (getY()>10) && (getY()<660)){
    setLocation(1,getY());
    }else if((getX()<100) && (getY()>10) && (getY()<660)){
    setLocation(599,getY());
    }
    }
    }*/

    public void pMove(){
        if(isTouching(Space.class)){
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
    
    public void checkTurret(String turretkeyfire){
        if(Greenfoot.isKeyDown(turretkeyfire) && isTouching(Turret.class) && fireDelay <= 0){
            List<Turret> turrets = getIntersectingObjects(Turret.class);
            for(Turret turret : turrets){
                turret.fireBullet();
            }
            fireDelay = delayStart;
        }
        fireDelay--;
    }
    
}
