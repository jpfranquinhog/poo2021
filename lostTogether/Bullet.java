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
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * https://opengameart.org/content/bullets-game-asset art link
     */
    
    List<Enemy> enemys;
    int temp,index;
    boolean track;
    public void act() 
    {
        // Add your action code here.
        move(5);
        if(track){
            trackEnemy();
        }
        ifEdje();
    }    
    
    public Bullet(){
        getImage().scale(getImage().getWidth()/15,getImage().getHeight()/15);
    }
    
    public Bullet(Boolean trackEnemy,int x, int y){
        getImage().scale(getImage().getWidth()/15,getImage().getHeight()/15);
        temp=1000;
        index=0;
        track=trackEnemy;
    }
    
    public void ifEdje(){
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
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
}
