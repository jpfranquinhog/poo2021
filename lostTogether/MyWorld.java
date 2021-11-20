import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(667, 667, 1);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        setBackground("background.jpg");
        
        //Spawn dos jogadores
        Player player1 = new Player();
        addObject(player1,getWidth()/4,getHeight()/2);
        Player2 player2 = new Player2();
        addObject(player2,getWidth()-getWidth()/4,getHeight()-getHeight()/2);
        
        //Spawn dos contadores
        OxygenCounter counter1 = new OxygenCounter(player1);
        addObject(counter1, getWidth()/4,getHeight()/20);
        OxygenCounter counter2 = new OxygenCounter(player2);
        addObject(counter2, getWidth()-getWidth()/4,getHeight()/20);
        
    }
}
