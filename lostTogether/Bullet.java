import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    private int moveSpeed;
    
    public Bullet(int speed){
        getImage().scale(getImage().getWidth()/15,getImage().getHeight()/15);
        moveSpeed = speed;
    }
    
    public void act() 
    {
        // Add your action code here.
        move(moveSpeed);
        ifEdje();
    }    
    
    public void ifEdje(){
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
    
}
