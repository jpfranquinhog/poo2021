import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
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
    private int batteryCount = 100;

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
        checkPlayerBattery();
    }

    public void checkClose(){
        if(isTouching(Player.class)){
            if(batteryCount > 0){
                player.setOxygen(1);
            }

            if(counter == 0){
                if(batteryCount != 0){
                    Smoke smoke = new Smoke();
                    getWorld().addObject(smoke, getX(), getY()-80);
                    batteryCount = batteryCount - 5;
                }
                counter++;

            }
            else if(counter == 40){
                counter = -1;
            }
            counter++;

        }

    }

    public void checkPlayerBattery(){
        List<Player> players = getIntersectingObjects(Player.class);
        for(Player player : players){
            if(batteryCount < 100 && player.getBatteryStored() > 0){
                int batteryNeeded = 100 - batteryCount;
                if(player.getBatteryStored() > batteryNeeded){
                    player.setBatteryStored(batteryNeeded);
                    batteryCount = batteryCount + batteryNeeded;
                }else if(player.getBatteryStored() < batteryNeeded){
                    int valor = (batteryNeeded-player.getBatteryStored());
                    player.setBatteryStored(valor);
                    batteryCount = batteryCount + valor;
                }
            }
        }

    }

    public int getBatteryCount(){
        return batteryCount;
    }

    public void setBatteryCount(int val){
        batteryCount = batteryCount + val;
    }
}
