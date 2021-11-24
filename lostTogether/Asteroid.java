import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Asteroid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Asteroid extends Actor
{
    private int moveSpeed, rot;
    public Asteroid(int speed, int rotation){
        moveSpeed = 1;
        setRotation(rotation);
    }
    public void act()
    {
        move(moveSpeed);
        checkCollision();
    }
    
    public void checkCollision(){
        if(isTouching(Bullet.class) || isTouching(Space.class)){
            getWorld().removeObject(this);
        }
    }

}
