import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class sword here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class sword extends Actor
{
    /**
     * Act - do whatever the sword wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int dir;// instance variable for drection sent by link
    private int zoraHealth;
    public sword(int dir1){//retrive the variable from link
        dir=dir1;
    }

    public void act() 
    {
        if(dir==2){
            setLocation(getX(),getY()-10);// this sends the sword up

        }
        else if(dir==-2){
            setLocation(getX(),getY()+10);//this sends the sword down
            setRotation(180);
        }
        else if(dir==1){
            setLocation(getX()+10,getY());//this sends the sword to the right
            setRotation(90);
        }
        else if(dir==-1){
            setLocation(getX()-10,getY());//this sends the sword to the left
            setRotation(-90);
        }

        if(isTouching(bat.class)||isTouching(octorock.class)){// removes class if they touch
            removeTouching(bat.class);
            removeTouching(octorock.class);
   
           
        }

        if(isAtEdge()==true){ // checks if the sword is at the edge and removes it
            getWorld().removeObject(this);
        }
        
        else if(isTouching(StatusBar.class))
        {
            getWorld().removeObject(this);
        }
    }       
}
