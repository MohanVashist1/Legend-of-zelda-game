import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class zora here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class zora extends Enemy
{
    /**
     * Act - do whatever the zora1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int timer=30;

    

    public void act() 
    {

     
        if (timer>0)// this is so that the zora appears then dissappears
        {
            
            timer--;
            if(timer == 0) {
                
                getWorld().removeObject(this);
            }
        }

    }        
}
