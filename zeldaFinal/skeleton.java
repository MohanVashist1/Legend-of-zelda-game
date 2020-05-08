import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class skeleton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class skeleton extends Enemy
{
    /**
     * Act - do whatever the skeleton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GifImage gifImage = new GifImage("skele.gif");
    int RandomNumber=((int)(Math.random()*4));
    int timerUp=10;
    private int health;
    private int check;
    public skeleton()
    {
        check = 0;
    }

    public void act() 
    {
        // Add your action code here.
        setImage(gifImage.getCurrentImage());

        if(RandomNumber==0){//moves down
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
                setLocation(getX(), getY() + 2);
            }
            check = 0;

        }
        if(RandomNumber==1){
            setLocation(getX(), getY()- 4);
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
                setLocation(getX(), getY() -2);
            }
            check = 0;
            //moves up
        }
        if(RandomNumber==2){
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
                setLocation(getX() +2, getY());
            }
            check = 0;
            //moves right
        }
        if(RandomNumber==3){
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
                setLocation(getX() -2, getY() );
            }
            check = 0;
            
            //moves left
        }
        if (timerUp>0)
        {
            check = 0;timerUp--;
            if(timerUp == 0) {

                RandomNumber=((int)(Math.random()*4));
                timerUp=30;

            }
        }
        remove();

    }    
    private int skeletonHealth;
    private int skeleCount=10;
    private int skeleFlag;
    private int nullCheck;
    public void remove(){
        if(isTouching(link.class)&&Greenfoot.isKeyDown("a")){
            if(skeleFlag==0){// checks to see if link has attacked then sees if it has been hit twice then remove it
                skeletonHealth++;
                if(skeletonHealth==2){
                    int heart=((int)(Math.random()*6));
                    if(heart==0){
                        getWorld().addObject(new heart(),getX(),getY());
                    }
                    getWorld().removeObject(this);
                    nullCheck++;
                }

                skeleFlag=1;
            }
        }
        if(nullCheck==0){
            if(isTouching(sword.class)){// checks to see if it has touched sword and adds heart and reomves it
                int heart=((int)(Math.random()*6));
                if(heart==0){
                    getWorld().addObject(new heart(),getX(),getY());

                }
                getWorld().removeObject(this);
            }

        }
        if(skeleFlag==1){
            if (skeleCount>0)// timer so that ist is invanuarble for a few seconds
            {

                skeleCount--;
                if(skeleCount == 0) {

                    skeleCount=10;
                    skeleFlag=0;
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
