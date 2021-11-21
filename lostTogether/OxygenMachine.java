import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OxygenMachine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OxygenMachine extends Actor
{
    private GreenfootImage machineImage;
    private Player player;
    private int counter = 0;
    
    public OxygenMachine(Player player){
        machineImage = new GreenfootImage("oxygenmachine2.png");
        machineImage.scale(machineImage.getWidth()/10,machineImage.getHeight()/10);
        setImage(machineImage);
        this.player = player;
    }
    
    public OxygenMachine(Player2 player){
        machineImage = new GreenfootImage("oxygenmachine.png");
        machineImage.scale(machineImage.getWidth()/10,machineImage.getHeight()/10);
        setImage(machineImage);
        this.player = player;
    }
    
    public void act()
    {
        checkClose();
    }
    
    public void checkClose(){
        if(isTouching(Player.class)){
            player.setOxygen(1);
            
            if(counter == 0){
            Smoke smoke = new Smoke();
            getWorld().addObject(smoke, getX(), getY()-80);
            counter++;
            System.out.println("spawn");
            }
            else if(counter == 40){
                counter = -1;
            }
            counter++;
            System.out.println(counter);
        }
        
    }
}
