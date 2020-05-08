import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class moblin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class moblin extends Enemy
{
    /**
     * Act - do whatever the moblin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GifImage gifImage = new GifImage("moblin_back.gif");
    GifImage gifImage1 = new GifImage("moblin_front.gif");
    GifImage gifImage2 = new GifImage("moblin_left.gif");
    GifImage gifImage3 = new GifImage("moblin_right.gif");
    private int timerUp=20;
    
    private   int RandomNumber=((int)(Math.random()*4));
    private int dir;
    private int check;
    public moblin()
    {
        check = 0;
    }

    public void act() 
    {
        int RandomNumber1=((int)(Math.random()*24));
        if(RandomNumber==0){
            setImage(gifImage.getCurrentImage());
            setLocation(getX() , getY()- 4);//moves up
            checkM1();// checks so that if it is touching a wall dont let it move
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
            setLocation(getX() , getY()+ 4);
            if(check == 0)
            {
                setLocation(getX() , getY()-1);
            }
            check = 0;
            //moves down and sends direction to boomerang
            if(RandomNumber1==0){// adds a boomerang
                dir=1;
                getWorld().addObject(new boomerang(dir),getX(),getY());

            }
        }
        else if(RandomNumber==1){
            setImage(gifImage1.getCurrentImage());
            setLocation(getX(), getY() + 4);//moves down
            checkM1();//checks so that if it its touching dont move in that direction
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
                setLocation(getX() , getY()+1);
            }
            check = 0;//moves up
            if(RandomNumber1==1){
                dir=0;
                getWorld().addObject(new boomerang(dir),getX(),getY());

            }
        }
        else if(RandomNumber==2){
            setImage(gifImage2.getCurrentImage());
            setLocation(getX() - 4, getY());//moves left
            checkM1();//checks so that if it is touching a wall dont movein that direction
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
                setLocation(getX()-1 , getY());
            }
            check = 0;
            //moves left
            if(RandomNumber1==2){
                dir=3;
                getWorld().addObject(new boomerang(dir),getX(),getY());

            }
        }
        else if(RandomNumber==3){
            setImage(gifImage3.getCurrentImage());
            setLocation(getX() + 4, getY());//moves right 
            checkM1();//checks that if it is touching a wall move right
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
                setLocation(getX()+1 , getY());
            }
            check = 0;//moves right
            if(RandomNumber1==3){
                dir=2;
                getWorld().addObject(new boomerang(dir),getX(),getY());

            }
        }
        if (timerUp>0)// this ensure that the moblin moves in a direction for a set amount of timer before chaging direction
        {

            timerUp--;
            if(timerUp == 0) {
                //assignns a new direction to the moblin
                RandomNumber=((int)(Math.random()*4));
                timerUp=60;

            }
        }
        remove();

    }      
    private int moblinHealth;
    private int moblinCount=10;
    private int moblinFlag;
    private int nullCheck;
    public void remove(){
        if(isTouching(link.class)&&Greenfoot.isKeyDown("a")){//is link attack the moblin increase moblin health than increase moblin flag which triggers the timer, the next time link attacks remove the moblin and add a heart if the randome number is 0
            if(moblinFlag==0){
                moblinHealth++;
                if(moblinHealth==3){
                    int heart=((int)(Math.random()*6));
                    if(heart==0){
                        getWorld().addObject(new heart(),getX(),getY());
                    }
                    getWorld().removeObject(this);
                    nullCheck++;
                }

                moblinFlag=1;
            }
        }
        if(nullCheck==0){//cheks to see if the object is still alive and then checks to see if the object has hit the sword
            if(isTouching(sword.class)){
                int heart=((int)(Math.random()*6));
                if(heart==0){
                    getWorld().addObject(new heart(),getX(),getY());

                }
                getWorld().removeObject(this);
            }
        }
        if(moblinFlag==1){// this is so that the mobln has a breif period of invanurability
            if (moblinCount>0)
            {

                moblinCount--;
                if(moblinCount == 0) {

                    moblinCount=10;
                    moblinFlag=0;
                }

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
