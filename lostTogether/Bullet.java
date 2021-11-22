import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * https://opengameart.org/content/bullets-game-asset art link
     */
    public void act() 
    {
        // Add your action code here.
        move(5);
        ifEdje();
    }    
    
    public Bullet(){
        getImage().scale(getImage().getWidth()/10,getImage().getHeight()/10);
    }
    
    public void ifEdje(){
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
