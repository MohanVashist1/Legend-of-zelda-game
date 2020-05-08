import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class zora_shot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class zora_shot extends Actor
{
     /**
     * Act - do whatever the zora_shot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int xtot;
    private int ytot;
    private int count;
    public void act() 
    {
        x1=getX();
        y1=getY();
        x2=((Overworld)getWorld()).getLink().X();//gets the x value of link
        y2=((Overworld)getWorld()).getLink().Y();// gets the y value of link
        if(count==0){// so that only 1 shot is fired
            xtot=(x2-x1)/40;// divides by 18 so that you can see the shot move and so that when you are close to the zora the shot does not fire extremely fast and makes it impossible to doge
            ytot=(y2-y1)/40;
        }
        count++;
        setLocation(getX()+xtot,getY()+ytot);// sets the location so that the shot continues untill it hits the edge
        if(isAtEdge()==true){
            getWorld().removeObject(this);
        }
        
        else if(isTouching(StatusBar.class))
        {
            getWorld().removeObject(this);
        }
    }   
}
