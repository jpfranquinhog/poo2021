import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage enemyImage;
    private int counter;
    private int eScale;
    public void act() 
    {
        // Add your action code here.
        walkAnimation();
    }    
    
    public Enemy(){
        counter= 0;
        eScale = 4;
    }
    
    public void walkAnimation(){
        switch(counter){
            case 0:
                enemyImage = new GreenfootImage("Wraith_01_Moving Forward_000.png");
                enemyImage.scale(enemyImage.getWidth()/eScale,enemyImage.getHeight()/eScale);
                setImage(enemyImage);
                break;

            case 10:
                enemyImage = new GreenfootImage("Wraith_01_Moving Forward_003.png");
                enemyImage.scale(enemyImage.getWidth()/eScale,enemyImage.getHeight()/eScale);
                setImage(enemyImage);
                break;

            case 20:
                enemyImage = new GreenfootImage("Wraith_01_Moving Forward_006.png");
                enemyImage.scale(enemyImage.getWidth()/eScale,enemyImage.getHeight()/eScale);
                setImage(enemyImage);
                break;

            case 30:
                enemyImage = new GreenfootImage("Wraith_01_Moving Forward_009.png");
                enemyImage.scale(enemyImage.getWidth()/eScale,enemyImage.getHeight()/eScale);
                setImage(enemyImage);
                break;

            case 40:
                enemyImage = new GreenfootImage("Wraith_01_Moving Forward_011.png");
                enemyImage.scale(enemyImage.getWidth()/eScale,enemyImage.getHeight()/eScale);
                setImage(enemyImage);
                break;

            default:
        }

        if(counter>=40){
            counter=0;
        }else counter++;
    }
    
    public void eMove(){
        //mover para o player mais proximo
    }
}
