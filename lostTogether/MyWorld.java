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
        /* Create a new world with 600x400 cells with a cell size of 1x1 pixels.
         * background image source
         * https://mewki.itch.io/nature-isometric-blocks
         */
        super(600, 400, 1);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        setBackground("background.png");
        Player ant = new Player();
        addObject(ant,102,201);
        player2 player2 = new player2();
        addObject(player2,400,203);
    }
}
