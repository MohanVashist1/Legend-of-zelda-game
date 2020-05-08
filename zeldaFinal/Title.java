import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Plays the music for the entire game and puts the title screen up on the monitor
 * 
 * @author Nikola Soldatovic 
 * @version 1.0
 */
public class Title extends World
{
    private int transferFromTitle;
    private GreenfootSound background;
    private int vol;
    private int Var = 0;
    /**
     * Constructor for objects of class Title.
     * 
     */
    public Title()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(512, 448, 1);
        setBackground("Title.png");
        addObject (new Transition(), 0, 0);
        background = new GreenfootSound("02-overworld.mp3");
        startmusic();
    }
    /**
     * loops and sets the volume for the music
     */
    public void startmusic() {
        vol = 100;
        background.setVolume(vol);
        background.playLoop();
    }
    
}
