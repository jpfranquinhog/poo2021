import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Turret here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Turret extends Actor
{

    public void act()
    {
        
    }
    
    public void fireBullet(){
        Bullet bullet = new Bullet();
        getWorld().addObject(bullet,this.getX(),this.getY());
        bullet.setRotation(this.getRotation()-90);
    }
}
