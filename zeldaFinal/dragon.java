import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class dragon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class dragon extends Enemy
{
    /**
     * Act - do whatever the dragon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int timerUp=40;
    private int drogoHealth;
    GifImage gifImage = new GifImage("drago.gif");
    private int count;
    private int timer=180;
    private int sCounter;
    private int sCounterT=10;
    public void act() 
    {
        setImage(gifImage.getCurrentImage());
      
        shooter();
        health();
    }

    public void shooter(){
        if(count==0){
            getWorld().addObject(new boss_shot(),getX()-19,getY()-20);// adds all of the boss shots
            getWorld().addObject(new boss_shot1(),getX()-19,getY()-20);
            getWorld().addObject(new boss_shot2(),getX()-19,getY()-20);
            getWorld().addObject(new boss_shot3(),getX()-19,getY()-20);
            count++;
        }
        if(count==1){//makes it so that the shots dont spamm out
            if (timer>0)
            {

                timer--;
                if(timer == 0) {
                    count=0;
                    timer=180;
                }
            }
        }
    }

    public void health()
    {
        if(isTouching(sword.class)){// chekcs to see if it hits swod or zelda is attacking it and decreases health
            if(sCounter==0){
                drogoHealth++;
                sCounter++;
            }
            if(drogoHealth==10){
                getWorld().removeObject(this);
            }
        }
        else if(Greenfoot.isKeyDown("a")){// makes sure that if the dragon is touching link and is attacking decrease health
            if(isTouching(link.class)){
                if(sCounter==0){
                    drogoHealth++;
                    sCounter++;
                }
                if(drogoHealth==10){
                    getWorld().removeObject(this);
                }
            }
        }
        if(sCounter==1){// makes it so that the dragon cannot be spammed to death
            if (sCounterT>0)
            {

                sCounterT--;
                if(sCounterT == 0) {
                    sCounter=0;
                    sCounterT=20;
                }
            }
        }
    } 
}
