import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Music here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Music extends Actor
{
    private GreenfootSound background;
    private int vol;
    private int Var = 0;
    private int x =0;
    /**
     * Act - do whatever the Music wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       background = new GreenfootSound("02-overworld.mp3");
       startmusic();
    }
    public void startmusic() {
        vol = 100;
        background.setVolume(vol);
        background.playLoop();
    }
        
}
