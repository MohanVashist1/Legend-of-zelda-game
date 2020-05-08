import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class octorock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class octorock extends Enemy
{
    /**
     * Act - do whatever the octorock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GifImage gifImage = new GifImage("OctorockToDown.gif");
    GifImage gifImage1 = new GifImage("OctorockToUp.gif");
    GifImage gifImage2 = new GifImage("OctorockToLeft.gif");
    GifImage gifImage3 = new GifImage("OctorockToRight.gif");
    private int timerUp=20;
    private   int RandomNumber=((int)(Math.random()*4));
    private int dir;
    private int nullCheck;
    private int check;
    public octorock()
    {
        check = 0;
    }

    public void act() 
    {

        int RandomNumber1=((int)(Math.random()*240));
        if(RandomNumber==0){
            setImage(gifImage.getCurrentImage());
            setLocation(getX(), getY() + 4);
            checkM1();
            checkM2();
            checkM3();
            checkM7();
            checkM8();
            checkM9();
            checkM10();
            checkD1();
            if(isTouching(StatusBar.class))
            {
                check++;
            }
            setLocation(getX(), getY() - 4);
            if(check == 0)
            {
                setLocation(getX() , getY()+2);
            }
            check = 0;
            //moves down and displays the appropriate gif
            if(RandomNumber1==0){
                dir=1;// sends the current direction to shot so it moves in the appropriate direction
                getWorld().addObject(new shot(dir),getX(),getY());

            }
        }
        else if(RandomNumber==1){
            setImage(gifImage1.getCurrentImage());
            setLocation(getX(), getY() - 4);
            checkM1();
            checkM2();
            checkM3();
            checkM7();
            checkM8();
            checkM9();
            checkM10();
            checkD1();
            if(isTouching(StatusBar.class))
            {
                check++;
            }
            setLocation(getX(), getY() + 4);
            if(check == 0)
            {
                setLocation(getX() , getY()-2);
            }
            check = 0;//moves up
            if(RandomNumber1==1){
                dir=0;
                getWorld().addObject(new shot(dir),getX(),getY());
            }
        }
        else if(RandomNumber==2){
            setImage(gifImage2.getCurrentImage());
            setLocation(getX() - 4, getY());
            checkM1();
            checkM2();
            checkM3();
            checkM7();
            checkM8();
            checkM9();
            checkM10();
            checkD1();
            if(isTouching(StatusBar.class))
            {
                check++;
            }
            setLocation(getX() + 4, getY());
            if(check == 0)
            {
                setLocation(getX()-2 , getY());
            }
            check = 0;//moves left
            if(RandomNumber1==2){
                dir=3;
                getWorld().addObject(new shot(dir),getX(),getY());

            }
        }
        else if(RandomNumber==3){
            setImage(gifImage3.getCurrentImage());
            setLocation(getX() + 4, getY());
            checkM1();
            checkM2();
            checkM3();
            checkM7();
            checkM8();
            checkM9();
            checkM10();
            checkD1();
            if(isTouching(StatusBar.class))
            {
                check++;
            }
            setLocation(getX() - 4, getY());
            if(check == 0)
            {
                setLocation(getX()+2 , getY());
            }
            check = 0;//moves right
            if(RandomNumber1==3){
                dir=2;
                getWorld().addObject(new shot(dir),getX(),getY());

            }
        }
        if (timerUp>0)
        {
            timerUp--;
            if(timerUp == 0) {

                RandomNumber=((int)(Math.random()*4));// if the timer is up move in a new direction
                timerUp=20;

            }
        }

        health();
    }      

    public void health(){
        if(nullCheck==0){// checks that the class has not been removed
            if(isTouching(sword.class)){// if it touches the sword remove the octorock
                int heart=((int)(Math.random()*6));// creates a random number so that the octorock could drop a heart
                if(heart==0){
                    getWorld().addObject(new heart(),getX(),getY());

                }
                getWorld().removeObject(this);
                nullCheck++;
            }
        }
        if(nullCheck==0){
            if(isTouching(link.class)&&Greenfoot.isKeyDown("a")){

                int heart=((int)(Math.random()*6));// if link has attacked the octorkc kill the octorck and drop a heart if the random number is 0
                if(heart==0){
                    getWorld().addObject(new heart(),getX(),getY());
                }
                getWorld().removeObject(this);
                nullCheck++;
            }
        }

    }

    public void checkM1()
    {
        if(isTouching(M1B1.class))
        {
            check++;
        }
        if(isTouching(M1B2.class))
        {
            check++;
        }
        if(isTouching(M1B3.class))
        {
            check++;
        }
        if(isTouching(M1B4.class))
        {
            check++;
        }
        if(isTouching(M1B5.class))
        {
            check++;
        }
        if(isTouching(M1B6.class))
        {
            check++;
        }
        if(isTouching(M1B7.class))
        {
            check++;
        }
    }

    public void checkM2()
    {
        if(isTouching(M2B1.class))
        {
            check++;
        }
        if(isTouching(M2B2.class))
        {
            check++;
        }
        if(isTouching(M2B3.class))
        {
            check++;
        }
        if(isTouching(M2B4.class))
        {
            check++;
        }
        if(isTouching(M2B5.class))
        {
            check++;
        }
        if(isTouching(M2B6.class))
        {
            check++;
        }
    }

    public void checkM3()
    {
        if(isTouching(M3B1.class))
        {
            check++;
        }
        if(isTouching(M3B2.class))
        {
            check++;
        }
        if(isTouching(M3B3.class))
        {
            check++;
        }
        if(isTouching(M3B4.class))
        {
            check++;
        }
        if(isTouching(M3B5.class))
        {
            check++;
        }
        if(isTouching(M3B6.class))
        {
            check++;
        }
        if(isTouching(M3B7.class))
        {
            check++;
        }
        if(isTouching(M3B8.class))
        {
            check++;
        }
    }

    public void checkM7()
    {
        if(isTouching(M7B1.class))
        {
            check++;
        }
    }

    public void checkM8()
    {
        if(isTouching(M8B1.class))
        {
            check++;
        }
        if(isTouching(M8B2.class))
        {
            check++;
        }
    }

    public void checkM9()
    {
        if(isTouching(M9B1.class))
        {
            check++;
        }
        if(isTouching(M9B2.class))
        {
            check++;
        }
        if(isTouching(M9B3.class))
        {
            check++;
        }
        if(isTouching(M9B4.class))
        {
            check++;
        }
        if(isTouching(M9B5.class))
        {
            check++;
        }
        if(isTouching(M9B6.class))
        {
            check++;
        }
        if(isTouching(M9B7.class))
        {
            check++;
        }
        if(isTouching(M9B9.class))
        {
            check++;
        }
        if(isTouching(M9B10.class))
        {
            check++;
        }
        if(isTouching(M9B11.class))
        {
            check++;
        }
    }

    public void checkM10()
    {
        if(isTouching(M10B1.class))
        {
            check++;
        }
        if(isTouching(M10B2.class))
        {
            check++;
        }
        if(isTouching(M10B3.class))
        {
            check++;
        }
        if(isTouching(M10B4.class))
        {
            check++;
        }
        if(isTouching(M10B5.class))
        {
            check++;
        }
        if(isTouching(M10B6.class))
        {
            check++;
        }
        if(isTouching(M10B7.class))
        {
            check++;
        }
    }

    public void checkD1()
    {
        if(isTouching(D1B1.class))
        {
            check++;
        }
        if(isTouching(D1B2.class))
        {
            check++;
        }
        if(isTouching(D1B3.class))
        {
            check++;
        }
        if(isTouching(D1B4.class))
        {
            check++;
        }
        if(isTouching(D1B5.class))
        {
            check++;
        }
        if(isTouching(D1B6.class))
        {
            check++;
        }
        if(isTouching(D1B7.class))
        {
            check++;
        }
        if(isTouching(D1B8.class))
        {
            check++;
        }
        if(isTouching(D1B9.class))
        {
            check++;
        }
        if(isTouching(D1B10.class))
        {
            check++;
        }
        if(isTouching(D1B11.class))
        {
            check++;
        }
        if(isTouching(D1B12.class))
        {
            check++;
        }
        if(isTouching(D1B13.class))
        {
            check++;
        }
        if(isTouching(D1B14.class))
        {
            check++;
        }
        if(isTouching(D1B15.class))
        {
            check++;
        }
        if(isTouching(D1B16.class))
        {
            check++;
        }
        if(isTouching(D1B17.class))
        {
            check++;
        }
        if(isTouching(D1B18.class))
        {
            check++;
        }
        if(isTouching(D1B19.class))
        {
            check++;
        }
        if(isTouching(D1B20.class))
        {
            check++;
        }
        if(isTouching(D1B21.class))
        {
            check++;
        }
        if(isTouching(D1B22.class))
        {
            check++;
        }
        if(isTouching(D1B23.class))
        {
            check++;
        }
    }
}
