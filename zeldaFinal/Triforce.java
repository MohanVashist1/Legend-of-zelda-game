import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Triforce here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Triforce extends Actor
{
    /**
     * Act - do whatever the Triforce wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(isTouching(link.class)){
        getWorld().addObject(new win(),261,238);
        Greenfoot.stop();
        }
    }    
}
