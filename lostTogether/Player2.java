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
        // Add your action code here.
        pMove();
        zoneChange();
    }
    
    public void pMove(){
        if(Greenfoot.isKeyDown("Left")){
            setLocation(getX()-getMoveSpeed(), getY());
            walkAnimation();
            oxygenDrop();
        }
        if(Greenfoot.isKeyDown("Right")){
            setLocation(getX()+getMoveSpeed(), getY());
            walkAnimation();
            oxygenDrop();
        }
        if(Greenfoot.isKeyDown("up")){
            setLocation(getX(), getY()-getMoveSpeed());
            walkAnimation();
            oxygenDrop();
        }
        if(Greenfoot.isKeyDown("Down")){
            setLocation(getX(), getY()+getMoveSpeed());
            walkAnimation();
            oxygenDrop();
        }
        
    }
}
