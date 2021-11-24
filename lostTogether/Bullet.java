import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    private int moveSpeed;
    List<Enemy> enemys;
    int temp,index;
    boolean track;
    
    public Bullet(int speed){
        getImage().scale(getImage().getWidth()/15,getImage().getHeight()/15);
        moveSpeed = speed;
    }
    
    public Bullet(Boolean trackEnemy,int x, int y){
        getImage().scale(getImage().getWidth()/15,getImage().getHeight()/15);
        moveSpeed = 5;
        temp=1000;
        index=0;
        track=trackEnemy;
    }
    
    public void act() 
    {
        // Add your action code here.
        move(moveSpeed);
        if(track){
            trackEnemy();
        }
        ifEdje();
    }    
    
    public void trackEnemy(){
        if(!getWorld().getObjects(Enemy.class).isEmpty()){
            List<Enemy> enemys = getWorld().getObjects(Enemy.class);
            for(int i=0;i<=enemys.size()-1;i++){
                if((Math.abs(getX()-enemys.get(i).getX())+Math.abs(getY()-enemys.get(i).getY()))<temp){
                    temp=Math.abs(getX()-enemys.get(i).getX())+Math.abs(getY()-enemys.get(i).getY());
                    index=i;
                }
            }
            turnTowards(enemys.get(index).getX(),enemys.get(index).getY());
            track=false;
        }
    }
    
    public void ifEdje(){
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
    
}
