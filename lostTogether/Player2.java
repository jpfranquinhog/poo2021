import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class player2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player2 extends Player
{
    /**
     * Act - do whatever the player2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        pMove();
        oxygenDrop();
        pickupBattery();
        checkTurret("0","Down","Up");
        fire(".");
    }

    @Override
    public void pMove(){
        if(isTouching(Turret.class) && getX() >= 935){
            if(Greenfoot.isKeyDown("Left")){
                setLocation(getX()-getMoveSpeed(), getY());
                walkAnimation();
            }
        }else if(isTouching(Space.class) && getX()>= 965){
            if(Greenfoot.isKeyDown("Left")){
                setLocation(getX()-getMoveSpeed(), getY());
                walkAnimation();
            }
            if(Greenfoot.isKeyDown("Up")){
                setLocation(getX(), getY()-getMoveSpeed());
                walkAnimation();
            }
            if(Greenfoot.isKeyDown("Down")){
                setLocation(getX(), getY()+getMoveSpeed());
                walkAnimation();
            } 
        }else if(isTouching(Space.class)&& getX()== 705) {
            if(Greenfoot.isKeyDown("Right")){
                setLocation(getX()+getMoveSpeed(), getY());
                walkAnimation();
            }
            if(Greenfoot.isKeyDown("Up")){
                setLocation(getX(), getY()-getMoveSpeed());
                walkAnimation();
            }
            if(Greenfoot.isKeyDown("Down")){
                setLocation(getX(), getY()+getMoveSpeed());
                walkAnimation();
            }
        }else{
            if(Greenfoot.isKeyDown("Left")){
                setLocation(getX()-getMoveSpeed(), getY());
                walkAnimation();
            }
            if(Greenfoot.isKeyDown("Right")){
                setLocation(getX()+getMoveSpeed(), getY());
                walkAnimation();
            }
            if(Greenfoot.isKeyDown("Up")){
                setLocation(getX(), getY()-getMoveSpeed());
                walkAnimation();
            }
            if(Greenfoot.isKeyDown("Down")){
                setLocation(getX(), getY()+getMoveSpeed());
                walkAnimation();
            }
        }
    }
}
