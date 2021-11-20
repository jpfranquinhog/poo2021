import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OxygenCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OxygenCounter extends Actor
{
    private GreenfootImage counterImage;
    private Player player;
    private int oxygenLevel;
    
    public OxygenCounter(Player player){
        counterImage = new GreenfootImage("oxygencounter100.png");
        counterImage.scale(counterImage.getWidth()-counterImage.getWidth()/4, counterImage.getHeight()-counterImage.getHeight()/4);
        setImage(counterImage);
        this.player = player;
        oxygenLevel = 100;
    }
    
    public void act()
    {
        changePercent();
    }
    
    public void changePercent(){
        oxygenLevel = player.getOxygen();
        
        if(oxygenLevel > 90){
            counterImage = new GreenfootImage("oxygencounter100.png");
            counterImage.scale(counterImage.getWidth()-counterImage.getWidth()/4, counterImage.getHeight()-counterImage.getHeight()/4);
            setImage(counterImage);
        }
        else if(oxygenLevel < 90 && oxygenLevel > 75){
            counterImage = new GreenfootImage("oxygencounter75.png");
            counterImage.scale(counterImage.getWidth()-counterImage.getWidth()/4, counterImage.getHeight()-counterImage.getHeight()/4);
            setImage(counterImage);
        }
        else if(oxygenLevel < 75 && oxygenLevel > 50){
            counterImage = new GreenfootImage("oxygencounter50.png");
            counterImage.scale(counterImage.getWidth()-counterImage.getWidth()/4, counterImage.getHeight()-counterImage.getHeight()/4);
            setImage(counterImage);
        }
        else if(oxygenLevel < 50 && oxygenLevel > 25){
            counterImage = new GreenfootImage("oxygencounter25.png");
            counterImage.scale(counterImage.getWidth()-counterImage.getWidth()/4, counterImage.getHeight()-counterImage.getHeight()/4);
            setImage(counterImage);
        }
        else if(oxygenLevel == 0){
            counterImage = new GreenfootImage("oxygencounter0.png");
            counterImage.scale(counterImage.getWidth()-counterImage.getWidth()/4, counterImage.getHeight()-counterImage.getHeight()/4);
            setImage(counterImage);
        }
    }
}
