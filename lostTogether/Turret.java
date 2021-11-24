import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Turret here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Turret extends Actor
{
    private int maxRotationUp, maxRotationDown;
    public Turret(int rot1, int rot2)
    {
        maxRotationUp = rot1;
        maxRotationDown = rot2;
    }
    
    public void fireBullet(){
        Bullet bullet = new Bullet(8);
        getWorld().addObject(bullet,this.getX(),this.getY());
        bullet.setRotation(this.getRotation()-90);
    }
    
    public void rotateTurret(int val){
        setRotation(getRotation()+val);
    }
    
    public int getMaxRotUp(){
        return maxRotationUp;
    }
    
    public int getMaxRotDown(){
        return maxRotationDown;
    }
}
