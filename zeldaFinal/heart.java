import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class heart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class heart extends Actor
{
    /**
     * Act - do whatever the heart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(isTouching(link.class)){
            ((Overworld)getWorld()).getHealth().decr();//adds a heart back to health
            ((Overworld)getWorld()).getLink().decrHealth();// removes a value from healthCounter so that you can fire your sword
            getWorld().removeObject(this);
        }
    }    
}
