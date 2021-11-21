import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndBackGround here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndBackGround extends Actor
{
    /**
     * Act - do whatever the EndBackGround wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public EndBackGround(){
        setImage("black.png");
        getImage().scale(getImage().getWidth()*2,getImage().getHeight()*3);
        getImage().setTransparency(200);
    }
}
