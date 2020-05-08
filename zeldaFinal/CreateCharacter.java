import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays the Character creation screen up on the monitor
 * 
 * @author Nikola Soldatovic 
 * @version 1.0
 */
public class CreateCharacter extends World
{

    /**
     * Constructor for objects of class CreateCharacter.
     * 
     */
    public CreateCharacter()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(512, 448, 1); 
        addObject(new Heart2(),135,95);
        Greenfoot.setSpeed(40);
    }
}
