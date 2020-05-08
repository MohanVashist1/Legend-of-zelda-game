import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class boomerang here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class boomerang extends Actor
{
    /**
     * Act - do whatever the boomerang wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GifImage gifImage = new GifImage("boomerang.gif");
    private int dir;// so that the boomerang knows which direction to do sent by moblin 
    public boomerang(int dir1){
        dir=dir1;
    }

    public void act() 
    {
        setImage(gifImage.getCurrentImage());
        if(dir==1){
            setLocation(getX(),getY()-5);//moves up

        }
        else if(dir==0){
            setLocation(getX(),getY()+5);//moves down
        }
        else if(dir==2){
            setLocation(getX()+5,getY());//moves right
        }
        else if(dir==3){
            setLocation(getX()-5,getY());//moves left
        }
        if(isAtEdge()==true){
            getWorld().removeObject(this);
        }
        
        else if(isTouching(StatusBar.class))
        {
            getWorld().removeObject(this);
        }
    }     
}
