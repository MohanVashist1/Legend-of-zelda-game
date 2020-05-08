import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class boss_shot3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class boss_shot3 extends Enemy
{
    /**
     * Act - do whatever the boss_shot3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */private int x1;
    private int x2=138;
    private int y1;
    private int y2=389;
    private int xtot;
    private int ytot;
    private int count;
    public void act() 
    {
        setImage("shot_boss.png");
        if(count==0){//makes sure the calculation is only done once
            x1=getX();
            y1=getY();

            xtot=(x2-x1)/36;
            ytot=(y2-y1)/36;
         
        }
        count++;
        setLocation(getX()+xtot,getY()+ytot);
        if(isAtEdge()==true||isTouching(StatusBar.class)){
            getWorld().removeObject(this);
        }
        
    }    
}
