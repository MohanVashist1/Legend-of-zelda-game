import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class zora_water here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class zora_water extends Enemy
{
    GifImage gifImage = new GifImage("w.gif");

    private int timer=160;
    private int RandomNumber=((int)(Math.random()*7));
    private int count;
    private int timerUp=20; 
    private int zoraHealth;
    public void act() 
    {
          setImage(gifImage.getCurrentImage());
        if(RandomNumber==0){
            setLocation(48,131);
            if (timerUp>0)// this is here because i want the animation to play for a period of timer before the zora and his shot appear
            {
                timerUp--;
                if(timerUp == 0) {
              

                    timerUp=40;
                    if(count==0){// once the timer reaches zero add the zora and zora shot and the if statement ensures that it doesnt add it multiple times
                        getWorld().addObject(new zora(),getX(),getY());
                        getWorld().addObject(new zora_shot(),getX(),getY());
                    }
                    count++;

                }
            }

        }
        else if(RandomNumber==1){
            setLocation(204,138);// note the logic is the same with all of these if statements, except the postioning
            
  
            if (timerUp>0)
            {
          
                timerUp--;
                if(timerUp == 0) {
              

                    timerUp=40;
                    if(count==0){
                        getWorld().addObject(new zora(),getX(),getY());
                        getWorld().addObject(new zora_shot(),getX(),getY());
                    }
                    count++;

                }
            }
        }
        else if(RandomNumber==2){
            setLocation(107,105);
   
            if (timerUp>0)
            {
              
                timerUp--;
                if(timerUp == 0) {
                 

                    timerUp=40;
                    if(count==0){
                        getWorld().addObject(new zora(),getX(),getY());
                        getWorld().addObject(new zora_shot(),getX(),getY());
                    }
                    count++;

                }
            }
        }
        else if(RandomNumber==3){
            setLocation(202,103);
     
            if (timerUp>0)
            {
              
                timerUp--;
                if(timerUp == 0) {
                

                    timerUp=40;
                    if(count==0){
                        getWorld().addObject(new zora(),getX(),getY());
                        getWorld().addObject(new zora_shot(),getX(),getY());
                    }
                    count++;

                }
            }
        }
        else if(RandomNumber==4){
            setLocation(27,162);
         
            if (timerUp>0)
            {
           
                timerUp--;
                if(timerUp == 0) {
                  

                    timerUp=40;
                    if(count==0){
                        getWorld().addObject(new zora(),getX(),getY());
                        getWorld().addObject(new zora_shot(),getX(),getY());
                    }
                    count++;

                }
            }
        }
        else if(RandomNumber==5){
            setLocation(144,140);
          
            if (timerUp>0)
            {
             
                timerUp--;
                if(timerUp == 0) {
                  

                    timerUp=40;
                    if(count==0){
                        getWorld().addObject(new zora(),getX(),getY());
                        getWorld().addObject(new zora_shot(),getX(),getY());
                    }
                    count++;

                }
            }
        }
        else if(RandomNumber==6){
            setLocation(168,127);
      
            if (timerUp>0)
            {
               
                timerUp--;
                if(timerUp == 0) {
                   
                    timerUp=40;
                    if(count==0){
                        getWorld().addObject(new zora(),getX(),getY());
                        getWorld().addObject(new zora_shot(),getX(),getY());
                    }
                    count++;

                }
            }
        }
        if (timer>0)// this timer is used so that the zora appears on the screen fo a period of timer before dissappearing
        {
            
            timer--;
            if(timer == 0) {
               
                RandomNumber=((int)(Math.random()*7));// recalculates the number so that a new location can be determined, this is here because the current location if statement would just be repeated
                timer=160;
                count=0;
            }
        }
        health();
    }       

    public void health(){
        if(isTouching(sword.class)){// creates the health of the zora and checks if it has hit twice
            zoraHealth++;
            if(zoraHealth==2){
                removeTouching(zora.class);
                getWorld().removeObject(this);
            }
        }
    } 
}
