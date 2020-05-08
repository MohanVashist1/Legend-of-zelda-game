import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class shot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class shot extends Actor
{
    /**
     * Act - do whatever the shot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int dir;// this is used so that the shot knows which direction to go sent by octocock
    public shot(int dir1){
        dir=dir1;
    }

    public void act() 
    {
        if(dir==0){
            setLocation(getX(),getY()-5);//moves up
            

        }
        else if(dir==1){
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
