import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version numb er or a date)
 */
public class MyWorld extends World
{
    private int score;
    private int counter,counter2,counter3;
    private SimpleTimer timer = new SimpleTimer();
    private int timeToArrive = 60;
    private List<OxygenMachine> machines;
    private int fireSpeed;
    private int delayStart,fireDelay1,fireDelay2;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(1300, 667, 1);
        score=0;
        counter=0;
        counter2=0;
        counter3=0;
        fireSpeed=1;
        fireDelay1=0;
        fireDelay2=0;
        delayStart=30;
        prepare();
        timer.mark();
        setPaintOrder(EndBackGround.class,Player.class,Turret.class,Bullet.class,Asteroid.class,Space.class);
    }

    public void act(){
        increaseScore();
        showText("Score:"+score,getWidth()/2+getWidth()/12,getHeight()/25);
        showTime();
        batteryStatus();
        fire();
        spawnAlien();
        spawnAsteroid();
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
        setBackground("background1.png");

        //Spawn dos jogadores
        Player player1 = new Player();
        addObject(player1,getWidth()/3,getHeight()/2);
        Player2 player2 = new Player2();
        addObject(player2,getWidth()-getWidth()/3,getHeight()-getHeight()/2);

        //Spawn das turrets
        Turret turret1 = new Turret(330,210);
        addObject(turret1, getWidth()/5 + (getWidth()/30),getHeight()/2);
        turret1.setRotation(270);
        Turret turret2 = new Turret(150,30);
        addObject(turret2, getWidth()-(getWidth()/5 +(getWidth()/30)),getHeight()-getHeight()/2);
        turret2.setRotation(90);

        //Spawn dos contadores
        OxygenCounter counter1 = new OxygenCounter(player1);
        addObject(counter1, getWidth()/3,getHeight()/20);
        OxygenCounter counter2 = new OxygenCounter(player2);
        addObject(counter2, getWidth()-getWidth()/3,getHeight()/20);

        //Spawn das maquinas de oxigenio
        OxygenMachine machine1 = new OxygenMachine(player2);
        addObject(machine1, getWidth()/4 + getWidth()/30,getHeight()/4);
        OxygenMachine machine2 = new OxygenMachine(player1);
        addObject(machine2, getWidth()- (getWidth()/4 + getWidth()/30),getHeight()-getHeight()/4);

        //Spawn do espaco entre os jogadores e o exterior da estacao
        Space space1 = new Space();
        addObject(space1, getWidth()/2,getHeight()/21);
        for(int i = 1; i < 11; i++){
            Space space2 = new Space();
            addObject(space2, getWidth()/2,space1.getY()+i*(2*getHeight()/21));
        }
        
        Space space3 = new Space();
        addObject(space3, getWidth()/5+getWidth()/55,getHeight()/21);
        for(int i = 1; i < 11; i++){
            Space space4 = new Space();
            addObject(space4, getWidth()/5+getWidth()/55,i*(2*getHeight()/21));
        }
        
        Space space5 = new Space();
        addObject(space5, getWidth()-(getWidth()/5+getWidth()/55),getHeight()/21);
        for(int i = 1; i < 11; i++){
            Space space6 = new Space();
            addObject(space6, getWidth()-(getWidth()/5+getWidth()/55),i*(2*getHeight()/21));
        }
        
        //enemy spawn
        /*Enemy enemy = new Enemy();
        addObject(enemy,519,122);
        Enemy enemy2 = new Enemy();
        addObject(enemy2,163,580);*/
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
        showText("",getWidth()/3+getWidth()/8,getHeight()/25);
        showText("",getWidth()-getWidth()/3,getHeight()/25);
        showText("GAME OVER",getWidth()/2,getWidth()/18);
        showText("Score : "+score,getWidth()/2+getWidth()/12,getHeight()/25);
        Greenfoot.stop();
    }

    public void showTime(){
        int time = timer.millisElapsed();
        if(time >= 1000 && timeToArrive != 0){
            timer.mark();
            timeToArrive--;
        }
        showText("Evacuation ETA:"+timeToArrive,getWidth()/3+getWidth()/8,getHeight()/25);
    }

    public void batteryStatus(){
        machines = getObjects(OxygenMachine.class);

        for(OxygenMachine machine : machines){
            int valor = 0;
            String info = "";
            valor = machine.getBatteryCount();
            info = "Battery left: " + valor;
            showText(info,machine.getX(), machine.getY()+80);
        }
    }

    public void fire(){
        if(Greenfoot.isKeyDown("e") && fireDelay1<=0){
            Bullet bullet = new Bullet(5);
            addObject(bullet,getObjects(Player.class).get(0).getX(),getObjects(Player.class).get(0).getY());
            fireDelay1=delayStart;
        }
        if(Greenfoot.isKeyDown(".") && fireDelay2<=0){
            Bullet bullet = new Bullet(5);
            addObject(bullet,getObjects(Player2.class).get(0).getX(),getObjects(Player2.class).get(0).getY());
            fireDelay2=delayStart;
        }
        fireDelay1--;
        fireDelay2--;
    }

    public void spawnAsteroid(){
        if(counter2 == 360){
            int rdmNum = Greenfoot.getRandomNumber(50);
            Asteroid asteroid = new Asteroid(1,rdmNum);
            addObject(asteroid, 0, Greenfoot.getRandomNumber(getHeight()));
            
            int rdmNum2 = 130 + Greenfoot.getRandomNumber(100);
            Asteroid asteroid2 = new Asteroid(1,rdmNum2);
            addObject(asteroid2, getWidth(), Greenfoot.getRandomNumber(getHeight()));
            counter2 = 0;
        }else{
            counter2++;   
        }
    }
    
    public void spawnAlien(){
        if(counter3 == 600){
            int rdmNumX = 330 + Greenfoot.getRandomNumber(650);
            int rdmNumY = Greenfoot.getRandomNumber(getHeight());
            Enemy enemy1 = new Enemy();
            addObject(enemy1, rdmNumX, rdmNumY);
            counter3 = 0;
        }else{
            counter3++;
        }
        
    }
}
