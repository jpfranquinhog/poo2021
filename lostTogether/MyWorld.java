import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int score;
    private int counter;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(667, 667, 1);
        score=0;
        counter=0;
        prepare();
    }
    
    public void act(){
        increaseScore();
        showText(""+score,getWidth()-getWidth()/10,getHeight()/20);
        if(getObjects(Player.class).get(0).getOxygen()<=0){
            endgame();
        }
        if(getObjects(Player2.class).get(0).getOxygen()<=0){
            endgame();
        }
        
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
        
        //Spawn das maquinas de oxigenio
        OxygenMachine machine1 = new OxygenMachine(player2);
        addObject(machine1, getWidth()/10,getHeight()/4);
        OxygenMachine machine2 = new OxygenMachine(player1);
        addObject(machine2, getWidth()-getWidth()/10,getHeight()-getHeight()/4);
        
    }
    
    public void increaseScore(){
        if(counter==100){
            score+=10;
        }
        
        if(counter>=100){
            counter=0;
        }else counter++;
    }
    
    public int getScrore(){
        return score;
    }
    
    public void increaseScore(int amount){
        score+=amount;
    }
    
    public void endgame(){
        EndBackGround endBackGround = new EndBackGround();
        addObject(endBackGround,0,0);
        showText("",getWidth()-getWidth()/10,getHeight()/20);
        showText("GAME OVER",getWidth()/2,getWidth()/18);
        showText("Score = "+score,getWidth()-getWidth()/2,getHeight()/2);
        Greenfoot.stop();
    }
}
