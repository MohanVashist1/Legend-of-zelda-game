import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class health extends Actor
{
    private int healthCount;
    String images[]=new String[]{"health-3.png","health-2.5.png","health-2.png","health-1.5.png","health-1.png","health-.5.png"};//array for the health images, health-3 is full health, health-.5 is lowest health
    private int timer=40;
    private boolean flag=true;

    public void act() 
    {
        if (flag==false){// the timer is used so that link has a short period of invulnerability, the flag varibale is used so that the timer only triggers once the health is decreased
            if (timer>0)
            {

                timer--;
                if(timer == 0) {

                    timer=20;
                    flag=true;
                }

            }
        }
        // Add your action code here.
    }   

    public void img(){// decreases the health by increasing/ going to the next image in the array

        if (flag==true){
            healthCount++;

            if(healthCount==6){//this is so that there will be no array out of bounds error
                healthCount=5;
            }
            setImage(images[healthCount]);
            flag=false;
        }

    }

    public void decr(){// increases the health by setting the images back
        healthCount--;
        if(healthCount==6){
            healthCount=5;
        }
        if(healthCount==-1){// this is so that the array does not go out of bounds 
            healthCount=0;
        }
        setImage(images[healthCount]);

    }   
}
