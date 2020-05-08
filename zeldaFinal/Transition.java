import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Transition here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Transition extends Actor
{
    /**
     * Act - do whatever the Transition wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("space")==true){
            Greenfoot.setWorld(new CreateCharacter());
        }
    }    
}
