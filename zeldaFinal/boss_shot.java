import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class boss_shot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class boss_shot extends Enemy
{
    /**
     * Act - do whatever the boss_shot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int x1=423;
    private int x2=173;
    private int y1=173;
    private int y2=21;
    private int xtot=x2-x1;
    private int ytot=y2-y1;
    private int count;
    public void act() 
    {
        if(count==0){//makes sure the calculation is only done once
            xtot=xtot/36;
            ytot=ytot/36;

        }
        count++;
        setLocation(getX()+xtot,getY()+ytot);
        if(isAtEdge()==true){
            getWorld().removeObject(this);
        }
        else if(isTouching(StatusBar.class)){
            getWorld().removeObject(this);
        }
    }    
}
