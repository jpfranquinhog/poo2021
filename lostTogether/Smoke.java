import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Smoke here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Smoke extends Actor
{
    private GreenfootImage smokeImage;
    private String imagename;
    private int i = 2;
    private int counter = 0;
    public Smoke(){
        smokeImage = new GreenfootImage("smoke1.png");
        setImage(smokeImage);
    }
    
    public void act()
    {
        dissipate();
    }
    
    public void dissipate(){
        counter++;
        if(i < 41 && counter == 2){
            imagename = "smoke" + i + ".png";
            smokeImage = new GreenfootImage(imagename);
            setImage(smokeImage);
            i++;
            counter = 0;
        }
        
        if(i == 40){
            getWorld().removeObject(this);
        }
    }
}
