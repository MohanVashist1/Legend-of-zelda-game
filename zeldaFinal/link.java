import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class link here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class link extends Actor
{
    int dir;
    int frame;
    private int check;
    private int track;
    private int healthCount;
    private int atCheck;
    private int octoDir;
    private int zoraHealth;
    private int hFlag=0;
    private int hCounter=20;
    private int skeletonHealth;
    private int skeleCount=10;
    private int skeleFlag;
    private int moblinHealth;
    private int moblinCount=10;
    private int moblinFlag;
    private int x2;
    public link() {
        dir = 2;
        check = 0;
        x2=0;
        track = 0;
    }

    public void act() {
        boolean left=false;
        boolean right=false;
        if(Greenfoot.isKeyDown("right")){   //sets the boolean true when the buttons are held so that you cannot go in two directions i.e diagnoally
            right=true;
        }
        if(Greenfoot.isKeyDown("left")){
            left=true;
        }
        if(Greenfoot.isKeyDown("left"))
        {
            dir=-1;
            moveLeft();
            animateWalkingLeft();
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            dir=1;
            moveRight();
            animateWalkingRight();
        }
        else if(Greenfoot.isKeyDown("up")&&right==false&&left==false)   // the boolean is used to prevent diagonal movement
        {
            dir=2;
            moveUp();
            animateWalkingUp();
        }
        else if(Greenfoot.isKeyDown("down")&&right==false&&left==false)
        {
            dir=-2;
            moveDown();
            animateWalkingDown();
        }
        else if(Greenfoot.isKeyDown("a"))       //the attack key
        {
            attack();
            if(healthCount==0&&getWorld().getObjects(sword.class).size()<1){//shoots the sword based on direction
                if(Greenfoot.getKey()!=("left")||Greenfoot.getKey()!=("right")||Greenfoot.getKey()!=("up")||Greenfoot.getKey()!=("down")){
                    getWorld().addObject(new sword(dir),getX(),getY());
                }
            }
        }
        health();
        if(isTouching(W1.class))        //when link contacts any of the different transition objects it:
        {
            getWorld().removeObjects(getWorld().getObjects(Walls.class));       // clears the world of all walls
            getWorld().removeObjects(getWorld().getObjects(Transitions.class));  // clears the world of all transitions
            getWorld().removeObjects(getWorld().getObjects(Enemy.class));   // clears the world of all enemies
            setOverworld1();    // runs the method that sets the objects for the next world
        }
        else if(isTouching(W2.class))
        {
            getWorld().removeObjects(getWorld().getObjects(Walls.class));
            getWorld().removeObjects(getWorld().getObjects(Transitions.class));
            getWorld().removeObjects(getWorld().getObjects(Enemy.class));
            setOverworld2();
        }
        else if(isTouching(W3.class))
        {
            getWorld().removeObjects(getWorld().getObjects(Walls.class));
            getWorld().removeObjects(getWorld().getObjects(Transitions.class));
            getWorld().removeObjects(getWorld().getObjects(Enemy.class));
            setOverworld3();
        }
        else if(isTouching(W4.class))
        {
            getWorld().removeObjects(getWorld().getObjects(Walls.class));
            getWorld().removeObjects(getWorld().getObjects(Transitions.class));
            getWorld().removeObjects(getWorld().getObjects(Enemy.class));
            setOverworld4();
        }
        else if(isTouching(W5.class))
        {
            getWorld().removeObjects(getWorld().getObjects(Walls.class));
            getWorld().removeObjects(getWorld().getObjects(Transitions.class));
            getWorld().removeObjects(getWorld().getObjects(Enemy.class));
            setOverworld5();
        }
        else if(isTouching(W6.class))
        {
            getWorld().removeObjects(getWorld().getObjects(Walls.class));
            getWorld().removeObjects(getWorld().getObjects(Transitions.class));
            getWorld().removeObjects(getWorld().getObjects(Enemy.class));
            setOverworld6();
        }
        else if(isTouching(W7.class))
        {
            getWorld().removeObjects(getWorld().getObjects(Walls.class));
            getWorld().removeObjects(getWorld().getObjects(Transitions.class));
            getWorld().removeObjects(getWorld().getObjects(Enemy.class));
            setOverworld7();
        }
        else if(isTouching(W8.class))
        {
            getWorld().removeObjects(getWorld().getObjects(Walls.class));
            getWorld().removeObjects(getWorld().getObjects(Transitions.class));
            getWorld().removeObjects(getWorld().getObjects(Enemy.class));
            setOverworld8();
        }
        else if(isTouching(W9.class))
        {
            getWorld().removeObjects(getWorld().getObjects(Walls.class));
            getWorld().removeObjects(getWorld().getObjects(Transitions.class));
            getWorld().removeObjects(getWorld().getObjects(Enemy.class));
            setOverworld9();
        }
        else if(isTouching(W10.class))
        {
            getWorld().removeObjects(getWorld().getObjects(Walls.class));
            getWorld().removeObjects(getWorld().getObjects(Transitions.class));
            getWorld().removeObjects(getWorld().getObjects(Enemy.class));
            setOverworld10();
        }
        else if(isTouching(D1.class))
        {
            getWorld().removeObjects(getWorld().getObjects(Walls.class));
            getWorld().removeObjects(getWorld().getObjects(Transitions.class));
            getWorld().removeObjects(getWorld().getObjects(Enemy.class));
            setDungeon1();
        }
        else if(isTouching(D2.class))
        {
            getWorld().removeObjects(getWorld().getObjects(Walls.class));
            getWorld().removeObjects(getWorld().getObjects(Transitions.class));
            getWorld().removeObjects(getWorld().getObjects(Enemy.class));
            setDungeon2();
        }
        else if(isTouching(D3.class))
        {
            getWorld().removeObjects(getWorld().getObjects(Walls.class));
            getWorld().removeObjects(getWorld().getObjects(Transitions.class));
            getWorld().removeObjects(getWorld().getObjects(Enemy.class));
            setDungeon3();
        }
        else if(isTouching(D4.class))
        {
            getWorld().removeObjects(getWorld().getObjects(Walls.class));
            getWorld().removeObjects(getWorld().getObjects(Transitions.class));
            getWorld().removeObjects(getWorld().getObjects(Enemy.class));
            setDungeon4();
        }
        else if(isTouching(D5.class))
        {
            getWorld().removeObjects(getWorld().getObjects(Walls.class));
            getWorld().removeObjects(getWorld().getObjects(Transitions.class));
            getWorld().removeObjects(getWorld().getObjects(Enemy.class));
            setDungeon5();
        }
        else if(isTouching(D6.class))
        {
            getWorld().removeObjects(getWorld().getObjects(Walls.class));
            getWorld().removeObjects(getWorld().getObjects(Transitions.class));
            getWorld().removeObjects(getWorld().getObjects(Enemy.class));
            setDungeon6();
        }
        else if(isTouching(D7.class))
        {
            getWorld().removeObjects(getWorld().getObjects(Walls.class));
            getWorld().removeObjects(getWorld().getObjects(Transitions.class));
            getWorld().removeObjects(getWorld().getObjects(Enemy.class));
            setDungeon7();
        }
        else if(isTouching(D8.class))
        {
            getWorld().removeObjects(getWorld().getObjects(Walls.class));
            getWorld().removeObjects(getWorld().getObjects(Transitions.class));
            getWorld().removeObjects(getWorld().getObjects(Enemy.class));
            setDungeon8();
        }
        else if(isTouching(D9.class))
        {
            getWorld().removeObjects(getWorld().getObjects(Walls.class));
            getWorld().removeObjects(getWorld().getObjects(Transitions.class));
            getWorld().removeObjects(getWorld().getObjects(Enemy.class));
            setDungeon9();
        }
        else if(isTouching(D10.class))
        {
            getWorld().removeObjects(getWorld().getObjects(Walls.class));
            getWorld().removeObjects(getWorld().getObjects(Transitions.class));
            getWorld().removeObjects(getWorld().getObjects(Enemy.class));
            setDungeon10();
        }
        else if(isTouching(D11.class))
        {
            getWorld().removeObjects(getWorld().getObjects(Walls.class));
            getWorld().removeObjects(getWorld().getObjects(Transitions.class));
            getWorld().removeObjects(getWorld().getObjects(Enemy.class));
            setDungeon11();
        }
        else if(isTouching(D12.class))
        {
            getWorld().removeObjects(getWorld().getObjects(Walls.class));
            getWorld().removeObjects(getWorld().getObjects(Transitions.class));
            getWorld().removeObjects(getWorld().getObjects(Enemy.class));
            setDungeon12();
        }
        else if(isTouching(D13.class))
        {
            getWorld().removeObjects(getWorld().getObjects(Walls.class));
            getWorld().removeObjects(getWorld().getObjects(Transitions.class));
            getWorld().removeObjects(getWorld().getObjects(Enemy.class));
            setDungeon13();
        }
        else if(isTouching(D14.class))
        {
            getWorld().removeObjects(getWorld().getObjects(Walls.class));
            getWorld().removeObjects(getWorld().getObjects(Transitions.class));
            getWorld().removeObjects(getWorld().getObjects(Enemy.class));
            setDungeon14();
        }
        if (Greenfoot.isKeyDown("enter")==true)
        {
            x2++;
        }

    }    

    public void health(){

        if(healthCount==6){
            getWorld().addObject(new loose(),243,233);
            Greenfoot.stop();

            
        }
        if(Greenfoot.isKeyDown("a")){// if attack remove these classes
            if(isTouching(octorock.class)||isTouching(bat.class)||isTouching(blob.class)){
                removeTouching(octorock.class);
                removeTouching(bat.class);
                removeTouching(blob.class);
            }
        }
        else {// if touching but not attacking decrease health
            if(isTouching(shot.class)||isTouching(octorock.class)||isTouching(zora_shot.class)||isTouching(bat.class)||isTouching(bat.class)||isTouching(boomerang.class)||isTouching(blob.class)||isTouching(skeleton.class)||isTouching(moblin.class)||isTouching(boss_shot.class)||isTouching(boss_shot1.class)||isTouching(boss_shot2.class)||isTouching(boss_shot3.class)||isTouching(dragon.class)){
                ((Overworld)getWorld()).getHealth().img();
                if(hFlag==0){

                    healthCount++;

                    hFlag=1;
                }

            }

        }
        if(hFlag==1){// used for health so that you have a period on invanurability
            if (hCounter>0)
            {

                hCounter--;
                if(hCounter == 0) {

                    hCounter=20;

                    hFlag=0;
                }

            }
        }
        if(skeleFlag==1){// for the skeleton so it has a period of invanurability
            if (skeleCount>0)
            {

                skeleCount--;
                if(skeleCount == 0) {

                    skeleCount=10;
                    skeleFlag=0;
                }

            }
        }
        if(moblinFlag==1){//for the moblin so that it has a period of invanurability
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

    private boolean isAttacking =false;
    private int count = 0;
    private final String [][]images = {{"linkAtDown.png","linkStatDown.png"},{"linkAtLeft.png","linkStatLeft.png"},{"",""},{"linkAtRight.png","linkStatRight.png"},{"linkAtUp.png","linkStatUp.png"}};
    private void attack(){
        setImage(images[dir+2][0]);
        isAttacking=true;

        if(count >=5){
            count=0;
            if (Greenfoot.isKeyDown("a")){
            }
            else{
                setImage(images[dir+2][1]);
                isAttacking = false;
            }
        }
        else{
            count++;
        }
    }

    private void moveDown() //while moving link will check if there is an obsticle in front of him by:
    {
        setLocation(getX(), getY() + 4);    //moving forward in the indicated direction
        checkM1();  //running all the check methods to ensure he is not touching any objects
        checkM2();
        checkM3();
        checkM7();
        checkM8();
        checkM9();
        checkM10();
        checkD1();
        if(isTouching(StatusBar.class))     // check if it is touching the status bar across the top of the game field
        {
            check++;
        }
        setLocation(getX(), getY() - 4);    // and return to his original position
        if(check == 0)      // if he has not touched any objects it allows him to advance
        {
            setLocation(getX(), getY() + 3);
        }
        check = 0;
    }

    private void moveLeft()
    {
        setLocation(getX() - 4, getY());
        checkM1();
        checkM2();
        checkM3();
        checkM7();
        checkM8();
        checkM9();
        checkM10();
        checkD1();
        if(isTouching(StatusBar.class))//ensure you are not touching anything i.e cannot clip into anything
        {
            check++;
        }
        setLocation(getX() + 4, getY());
        if(check == 0)
        {
            setLocation(getX() - 3, getY());
        }
        check = 0;
    }

    private void moveRight()
    {
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
            setLocation(getX() + 3, getY());
        }
        check = 0;
    }

    private void moveUp()
    {
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
            setLocation(getX(), getY() - 3);
        }
        check = 0;
    }

    public void animateWalkingLeft()
    {
        if(frame == 0) {// animates walking by having two images and rotating between images as the key is pressed. As the key is pressed frame is increased, we chose five because it proved the perfect delay between key presses
            setImage("linkStatLeft.png");
        }
        if(frame == 5) {
            setImage("linkWalkLeft.png");
        }

        if(frame == 10) {

            frame = 0;
        }
        else{
            frame++;
        }
    }

    public void animateWalkingRight()
    {
        if(frame == 0) {// animates walking by having two images and rotating between images as the key is pressed. As the key is pressed frame is increased, we chose five because it proved the perfect delay between key presses
            setImage("linkStatRight.png");
        }
        if(frame == 5) {
            setImage("linkWalkRight.png");
        }

        if(frame == 10) {

            frame = 0;

        }
        else{
            frame++;
        }
    }

    public void animateWalkingUp()
    {
        if(frame == 0) {// animates walking by having two images and rotating between images as the key is pressed. As the key is pressed frame is increased, we chose five because it proved the perfect delay between key presses
            setImage("linkStatUp.png");
        }
        if(frame == 5) {
            setImage("linkWalkUp.png");
        }

        if(frame == 10) {
            frame = 0;
        }
        else{
            frame++;
        }
    }

    public void animateWalkingDown()
    {
        if(frame == 0) {// animates walking by having two images and rotating between images as the key is pressed. As the key is pressed frame is increased, we chose five because it proved the perfect delay between key presses
            setImage("linkStatDown.png");
        }
        if(frame == 5) {
            setImage("linkWalkDown.png");
        }

        if(frame == 10) {

            frame = 0;

        }
        else{
            frame++;
        }
    }

    public void checkM1()   //check methods to ensure that link is not touching any walls
    {
        if(isTouching(M1B1.class))
        {
            check++;        // if link is touching a wall the counter goes up
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

    private int x;
    private int y;
    public int X(){// this is used for the zora shot so that the zora shot can track the position that link was in
        x=getX();
        return x;
    }

    public int Y(){// this is used for the zora shot so that the zora shot can track the position that link was in
        y=getY();
        return y;
    }

    public void decrHealth(){// decreases the heatlh variable so that you have shoot your sword
        healthCount--;
        if(healthCount==-1){
            healthCount=0;
        }
    }

    // Set methods to set the new world when transitioning between game areas
    public void setOverworld1()     
    {
        getWorld().setBackground("OverworldMap1.png");      // sets the new background
        track =1;
        Walls w1 = new M1B1();      //casts and places any walls, transitions or enemies
        getWorld().addObject(w1,32,368);
        Walls w2 = new M1B2();
        getWorld().addObject(w2,256,416);
        Walls w3 = new M1B3();
        getWorld().addObject(w3,480,368);
        Walls w4 = new M1B4();
        getWorld().addObject(w4,406,170);
        Walls w5 = new M1B5();
        getWorld().addObject(w5,192,128);
        Walls w6 = new M1B6();
        Walls w7 = new M1B6();
        getWorld().addObject(w6,60,208);
        getWorld().addObject(w7,92,176);
        Walls w8 = new M1B7();
        Walls w9 = new M1B7();
        Walls w10 = new M1B7();
        Walls w11 = new M1B7();
        Walls w12 = new M1B7();
        Walls w13 = new M1B7();
        Walls w14 = new M1B7();
        getWorld().addObject(w8,16,272);
        getWorld().addObject(w9,16,304);
        getWorld().addObject(w10,48,272);
        getWorld().addObject(w11,48,304);
        getWorld().addObject(w12,48,240);
        getWorld().addObject(w13,144,144);
        getWorld().addObject(w14,112,144);

        Transitions t1= new W2();
        Transitions t2= new W3();
        Transitions t3= new W3();
        Transitions t4= new W3();
        getWorld().addObject(t1,512,272);
        getWorld().addObject(t2,240,98);
        //addObject(new W1W3(),254,96);
        getWorld().addObject(t3,272,98);
        getWorld().addObject(t4,256,98);
        if(getX() > 480 || getX() < 20)     //changes links position to simulate movement through a doorway
        {
            setLocation((512-getX()), getY());
        }
        else if(getY() > 420 || getY() < 120)
        {
            setLocation(getX(), (448-getY()+96));
        }
    }

    public void setOverworld2()
    {
        getWorld().setBackground("OverworldMap2.png");
        track =2;
        Walls w1 = new M2B5();
        Walls w2 = new M2B5();
        Walls w3 = new M2B5();
        Walls w4 = new M2B5();
        Walls w5 = new M2B5();
        Walls w6 = new M2B5();
        Walls w7 = new M2B5();
        getWorld().addObject(w1,496,128);
        getWorld().addObject(w2,432,128);
        getWorld().addObject(w3,368,128);
        getWorld().addObject(w4,304,128);
        getWorld().addObject(w5,208,128);
        getWorld().addObject(w6,144,128);
        getWorld().addObject(w7,80,128);
        Walls w8 = new M2B1();
        Walls w9 = new M2B1();
        Walls w10 = new M2B1();
        Walls w11 = new M2B1();
        Walls w12 = new M2B1();
        Walls w13 = new M2B1();
        Walls w14 = new M2B1();
        Walls w15 = new M2B1();
        Walls w16 = new M2B1();
        Walls w17 = new M2B1();
        Walls w18 = new M2B1();
        Walls w19 = new M2B1();
        Walls w20 = new M2B1();
        Walls w21 = new M2B1();
        Walls w22 = new M2B1();
        Walls w23 = new M2B1();
        getWorld().addObject(w8,432,336);
        getWorld().addObject(w9,432,272);
        getWorld().addObject(w10,432,208);
        getWorld().addObject(w11,368,336);
        getWorld().addObject(w12,368,272);
        getWorld().addObject(w13,368,208);
        getWorld().addObject(w14,304,336);
        getWorld().addObject(w15,304,272);
        getWorld().addObject(w16,304,208);
        getWorld().addObject(w17,208,336);
        getWorld().addObject(w18,208,272);
        getWorld().addObject(w19,208,208);
        getWorld().addObject(w20,144,240);
        getWorld().addObject(w21,144,304);
        getWorld().addObject(w22,80,240);
        getWorld().addObject(w23,80,304);
        Walls w24 = new M2B5();
        Walls w25 = new M2B5();
        Walls w26 = new M2B5();
        Walls w27 = new M2B5();
        getWorld().addObject(w24,496,192);
        getWorld().addObject(w25,496,256);
        getWorld().addObject(w26,496,320);
        getWorld().addObject(w27,496,384);
        Walls w28 = new M2B6();
        Walls w29 = new M2B2();
        Walls w30 = new M2B4();
        Walls w31 = new M2B3();
        getWorld().addObject(w28,288,416);
        getWorld().addObject(w29,16,368);
        getWorld().addObject(w29,48,400);
        getWorld().addObject(w30,48,160);
        getWorld().addObject(w31,16,172);
        Transitions t1 = new W1();
        getWorld().addObject(t1,0,272);
        Transitions t2 = new W4();
        getWorld().addObject(t2,112,98);
        Transitions t3 = new W4();
        getWorld().addObject(t3,176,98);
        Transitions t4 = new W4();
        getWorld().addObject(t4,240,98);
        Transitions t5 = new W4();
        getWorld().addObject(t5,272,98);
        Transitions t6 = new W4();
        getWorld().addObject(t6,336,98);
        Transitions t7 = new W4();
        getWorld().addObject(t7,400,98);
        Transitions t8 = new W4();
        getWorld().addObject(t8,464,98);

        Enemy e1 = new octorock();
        getWorld().addObject(e1,256,192);
        Enemy e2 = new octorock();
        getWorld().addObject(e2,465,275);

        if(getX() > 480 || getX() < 20)
        {
            setLocation((512-getX()), getY());
        }
        else
        {
            setLocation(getX(), (448-getY()+96));
        }
    }

    public void setOverworld3()
    {
        getWorld().setBackground("OverworldMap3.png");
        track =3;
        Walls w1 = new M3B1();
        Walls w2 = new M3B1();
        Walls w3 = new M3B1();
        Walls w4 = new M3B1();
        Walls w5 = new M3B1();
        Walls w6 = new M3B1();
        Walls w7 = new M3B1();
        Walls w8 = new M3B1();
        Walls w9 = new M3B1();
        getWorld().addObject(w1,112,208);
        getWorld().addObject(w2,112,272);
        getWorld().addObject(w3,112,336);
        getWorld().addObject(w4,176,208);
        getWorld().addObject(w5,176,272);
        getWorld().addObject(w6,176,336);
        getWorld().addObject(w7,400,208);
        getWorld().addObject(w8,400,272);
        getWorld().addObject(w9,400,336);

        Walls w10 = new M3B2();
        Walls w11 = new M3B3();
        Walls w12 = new M3B3();
        getWorld().addObject(w10,16,272);

        getWorld().addObject(w11,176,128);
        getWorld().addObject(w12,368,128);

        Walls w13 = new M3B4();
        Walls w14 = new M3B4();
        getWorld().addObject(w13,48,144);
        getWorld().addObject(w14,336,144);

        Walls w15 = new M3B5();
        Walls w16 = new M3B5();
        Walls w17 = new M3B5();
        getWorld().addObject(w15,304,144);
        getWorld().addObject(w16,464,144);
        getWorld().addObject(w17,496,176);

        Walls w18 = new M3B6();
        Walls w19 = new M3B6();
        getWorld().addObject(w18,145,416);
        getWorld().addObject(w19,368,416);

        Walls w20 = new M3B7();
        Walls w21 = new M3B7();
        getWorld().addObject(w20,48,400);
        getWorld().addObject(w21,336,400);

        Walls w22 = new M3B8();
        Walls w23 = new M3B8();
        Walls w24 = new M3B8();
        getWorld().addObject(w22,304,400);
        getWorld().addObject(w23,464,400);
        getWorld().addObject(w24,496,368);

        Transitions t1 = new W1();
        Transitions t2 = new W1();
        getWorld().addObject(t1,240,448);
        getWorld().addObject(t2,272,448);

        Transitions t3 = new W4();
        getWorld().addObject(t3,512,240);
        Transitions t4 = new W4();
        getWorld().addObject(t4,512,272);
        Transitions t5 = new W4();
        getWorld().addObject(t5,512,304);

        Enemy e1 = new octorock();
        getWorld().addObject(e1,140,190);
        Enemy e2 = new octorock();
        getWorld().addObject(e2,355,245);
        Enemy e3 = new octorock();
        getWorld().addObject(e3,75,337);

        if(getX() > 480 || getX() < 20)
        {
            setLocation((512-getX()), getY());
        }
        else
        {
            setLocation(getX(), (448-getY()+96));
        }
    }

    public void setOverworld4()
    {
        getWorld().setBackground("OverworldMap4.png");
        track =4;
        Walls w1 = new M2B1();
        Walls w2 = new M2B1();
        Walls w3 = new M2B1();
        Walls w4 = new M2B1();
        Walls w5 = new M2B1();
        Walls w6 = new M2B1();
        Walls w7 = new M2B1();
        Walls w8 = new M2B1();
        Walls w9 = new M2B1();
        Walls w10 = new M2B1();
        Walls w11 = new M2B1();
        Walls w12 = new M2B1();
        Walls w13 = new M2B1();
        getWorld().addObject(w1,80,240);
        getWorld().addObject(w2,80,304);
        getWorld().addObject(w3,144,208);
        getWorld().addObject(w4,144,272);
        getWorld().addObject(w5,144,336);
        getWorld().addObject(w6,208,272);
        getWorld().addObject(w7,304,208);
        getWorld().addObject(w8,304,272);
        getWorld().addObject(w9,304,336);
        getWorld().addObject(w10,368,272);
        getWorld().addObject(w11,432,208);
        getWorld().addObject(w12,432,272);
        getWorld().addObject(w13,432,336);

        Walls w14 = new M2B5();
        Walls w15 = new M2B5();
        Walls w16 = new M2B5();
        Walls w17 = new M2B5();
        Walls w18 = new M2B5();
        Walls w19 = new M2B5();
        getWorld().addObject(w14,80,128);
        getWorld().addObject(w15,144,128);
        getWorld().addObject(w16,208,128);
        getWorld().addObject(w17,304,128);
        getWorld().addObject(w18,368,128);
        getWorld().addObject(w19,432,128);

        Walls w20 = new M2B5();
        Walls w21 = new M2B5();
        Walls w22 = new M2B5();
        Walls w23 = new M2B5();
        Walls w24 = new M2B5();
        Walls w25 = new M2B5();
        getWorld().addObject(w20,80,416);
        getWorld().addObject(w21,144,416);
        getWorld().addObject(w22,208,416);
        getWorld().addObject(w23,304,416);
        getWorld().addObject(w24,368,416);
        getWorld().addObject(w25,432,416);

        Walls w26 = new M2B5();
        Walls w27 = new M2B5();
        Walls w28 = new M2B5();
        Walls w29 = new M2B5();
        Walls w30 = new M2B5();
        Walls w31 = new M2B5();
        getWorld().addObject(w26,496,128);
        getWorld().addObject(w27,496,192);
        getWorld().addObject(w28,496,256);
        getWorld().addObject(w29,496,320);
        getWorld().addObject(w30,496,384);
        getWorld().addObject(w31,496,448);

        Walls w32 = new M3B4();
        Walls w33 = new M3B4();
        getWorld().addObject(w32,16,176);
        getWorld().addObject(w33,48,144);

        Walls w34 = new M3B7();
        Walls w35 = new M3B7();
        getWorld().addObject(w34,16,368);
        getWorld().addObject(w35,48,400);

        Transitions t1 = new W3();
        getWorld().addObject(t1,0,240);
        Transitions t2 = new W3();
        getWorld().addObject(t2,0,272);
        Transitions t3 = new W3();
        getWorld().addObject(t3,0,304);

        Transitions t4 = new W6();
        getWorld().addObject(t4,112,98);
        Transitions t5 = new W6();
        getWorld().addObject(t5,176,98);
        Transitions t6 = new W6();
        getWorld().addObject(t6,240,98);
        Transitions t7 = new W6();
        getWorld().addObject(t7,272,98);
        Transitions t8 = new W6();
        getWorld().addObject(t8,336,98);
        Transitions t9 = new W6();
        getWorld().addObject(t9,400,98);
        Transitions t10 = new W6();
        getWorld().addObject(t10,464,98);

        Transitions t11 = new W2();
        getWorld().addObject(t11,112,448);
        Transitions t12 = new W2();
        getWorld().addObject(t12,176,448);
        Transitions t13 = new W2();
        getWorld().addObject(t13,240,448);
        Transitions t14 = new W2();
        getWorld().addObject(t14,272,448);
        Transitions t15 = new W2();
        getWorld().addObject(t15,336,448);
        Transitions t16 = new W2();
        getWorld().addObject(t16,400,448);
        Transitions t17 = new W2();
        getWorld().addObject(t17,464,448);

        Enemy e1 = new octorock();
        getWorld().addObject(e1,467,239);
        Enemy e2 = new octorock();
        getWorld().addObject(e2,144,308);
        Enemy e3 = new octorock();
        getWorld().addObject(e3,112,240);

        if(getX() > 480 || getX() < 20)
        {
            setLocation((512-getX()), getY());
        }
        else
        {
            setLocation(getX(), (448-getY()+96));
        }
    }

    public void setOverworld5()
    {
        getWorld().setBackground("OverworldMap5.png");
        track =5;
        Walls w1 = new M2B6();
        Walls w2 = new M2B6();
        Walls w3 = new M2B6();
        Walls w4 = new M2B6();
        getWorld().addObject(w1,160,128);
        getWorld().addObject(w2,384,128);
        getWorld().addObject(w3,160,416);
        getWorld().addObject(w4,384,416);

        Walls w5 = new M2B5();
        Walls w6 = new M2B5();
        Walls w7 = new M2B5();
        Walls w8 = new M2B5();
        getWorld().addObject(w5,16,192);
        getWorld().addObject(w6,16,256);
        getWorld().addObject(w7,16,320);
        getWorld().addObject(w8,16,384);

        Walls w9 = new M2B1();
        Walls w10 = new M2B1();
        Walls w11 = new M2B1();
        Walls w12 = new M2B1();
        Walls w13 = new M2B1();
        Walls w14 = new M2B1();
        Walls w15 = new M2B1();
        Walls w16 = new M2B1();
        Walls w17 = new M2B1();
        Walls w18 = new M2B1();
        Walls w19 = new M2B1();
        Walls w20 = new M2B1();
        Walls w21 = new M2B1();
        Walls w22 = new M2B1();
        Walls w23 = new M2B1();
        getWorld().addObject(w9,112,272);
        getWorld().addObject(w10,176,272);
        getWorld().addObject(w11,240,208);
        getWorld().addObject(w12,240,272);
        getWorld().addObject(w13,240,336);
        getWorld().addObject(w14,304,208);
        getWorld().addObject(w15,304,272);
        getWorld().addObject(w16,304,336);
        getWorld().addObject(w17,368,272);
        getWorld().addObject(w18,432,208);
        getWorld().addObject(w19,432,272);
        getWorld().addObject(w20,432,336);
        getWorld().addObject(w21,496,208);
        getWorld().addObject(w22,496,272);
        getWorld().addObject(w23,496,336);

        Transitions t1 = new W6();
        getWorld().addObject(t1,512,176);
        Transitions t2 = new W6();
        getWorld().addObject(t2,512,240);
        Transitions t3 = new W6();
        getWorld().addObject(t3,512,304);
        Transitions t4 = new W6();
        getWorld().addObject(t4,512,368);

        Enemy e1 = new octorock();
        getWorld().addObject(e1,272,186);
        Enemy e2 = new moblin();
        getWorld().addObject(e2,66,272);

        if(getX() > 480 || getX() < 20)
        {
            setLocation((512-getX()), getY());
        }
        else
        {
            setLocation(getX(), (448-getY()+96));
        }
    }

    public void setOverworld6()
    {
        getWorld().setBackground("OverworldMap6.png");
        track =6;
        Walls w1 = new M2B6();
        Walls w2 = new M2B6();
        getWorld().addObject(w1,0,128);
        getWorld().addObject(w2,512,128);

        Walls w3 = new M2B5();
        Walls w4 = new M2B5();
        Walls w5 = new M2B5();
        Walls w6 = new M2B5();
        Walls w7 = new M2B5();
        Walls w8 = new M2B5();
        Walls w9 = new M2B5();
        Walls w10 = new M2B5();
        Walls w11 = new M2B5();
        Walls w12 = new M2B5();
        Walls w13 = new M2B5();
        Walls w14 = new M2B5();
        Walls w15 = new M2B5();
        getWorld().addObject(w3,16,416);
        getWorld().addObject(w4,48,416);
        getWorld().addObject(w5,80,416);
        getWorld().addObject(w6,144,416);
        getWorld().addObject(w7,208,416);
        getWorld().addObject(w8,304,416);
        getWorld().addObject(w9,368,416);
        getWorld().addObject(w10,432,416);
        getWorld().addObject(w11,496,160);
        getWorld().addObject(w12,496,224);
        getWorld().addObject(w13,496,288);
        getWorld().addObject(w14,496,352);
        getWorld().addObject(w15,496,416);

        Walls w16 = new M2B1();
        Walls w17 = new M2B1();
        Walls w18 = new M2B1();
        Walls w19 = new M2B1();
        Walls w20 = new M2B1();
        Walls w21 = new M2B1();
        Walls w22 = new M2B1();
        Walls w23 = new M2B1();
        Walls w24 = new M2B1();
        Walls w25 = new M2B1();
        Walls w26 = new M2B1();
        Walls w27 = new M2B1();
        Walls w28 = new M2B1();
        Walls w29 = new M2B1();
        Walls w30 = new M2B1();
        Walls w31 = new M2B1();
        Walls w32 = new M2B1();
        getWorld().addObject(w16,16,208);
        getWorld().addObject(w17,16,272);
        getWorld().addObject(w18,16,336);
        getWorld().addObject(w19,80,208);
        getWorld().addObject(w20,80,272);
        getWorld().addObject(w21,80,336);
        getWorld().addObject(w22,144,272);
        getWorld().addObject(w23,208,208);
        getWorld().addObject(w24,208,272);
        getWorld().addObject(w25,208,336);
        getWorld().addObject(w26,304,208);
        getWorld().addObject(w27,304,272);
        getWorld().addObject(w28,304,336);
        getWorld().addObject(w29,368,208);
        getWorld().addObject(w30,368,272);
        getWorld().addObject(w31,368,336);
        getWorld().addObject(w32,432,272);

        Transitions t1 = new W5();
        getWorld().addObject(t1,0,176);
        Transitions t2 = new W5();
        getWorld().addObject(t2,0,240);
        Transitions t3 = new W5();
        getWorld().addObject(t3,0,304);
        Transitions t4 = new W5();
        getWorld().addObject(t4,0,368);

        Transitions t5 = new W4();
        getWorld().addObject(t5,112,448);
        Transitions t6 = new W4();
        getWorld().addObject(t6,176,448);
        Transitions t7 = new W4();
        getWorld().addObject(t7,240,448);
        Transitions t8 = new W4();
        getWorld().addObject(t8,272,448);
        Transitions t9 = new W4();
        getWorld().addObject(t9,336,448);
        Transitions t10 = new W4();
        getWorld().addObject(t10,400,448);
        Transitions t11 = new W4();
        getWorld().addObject(t11,464,448);

        Transitions t12 = new W8();
        getWorld().addObject(t12,240,98);
        Transitions t13 = new W8();
        getWorld().addObject(t13,272,98);

        Enemy e1 = new octorock();
        getWorld().addObject(e1,458,217);

        if(getX() > 480 || getX() < 20)
        {
            setLocation((512-getX()), getY());
        }
        else
        {
            setLocation(getX(), (448-getY()+96));
        }
    }

    public void setOverworld7()
    {
        getWorld().setBackground("OverworldMap7.png");
        track =7;
        Walls w1 = new M2B6();
        Walls w2 = new M2B6();
        getWorld().addObject(w1,320,352);
        getWorld().addObject(w2,192,352);

        Walls w3 = new M2B5();
        getWorld().addObject(w3,16,288);

        Walls w4 = new M7B1();
        Walls w5 = new M7B1();
        getWorld().addObject(w4,128,240);
        getWorld().addObject(w5,384,240);

        Transitions t1 = new W8();
        getWorld().addObject(t1,512,272);
        Transitions t2 = new W8();
        getWorld().addObject(t2,512,304);

        Enemy e1 = new zora_water();
        getWorld().addObject(e1,467,239);
        Enemy e2 = new zora_water();
        getWorld().addObject(e2,144,308);
        Enemy e3 = new zora_water();
        getWorld().addObject(e3,112,240);

        if(getX() > 480 || getX() < 20)
        {
            setLocation((512-getX()), getY());
        }
        else
        {
            setLocation(getX(), (448-getY()+96));
        }
    }

    public void setOverworld8()
    {
        getWorld().setBackground("OverworldMap8.png");
        track =8;
        Walls w1 = new M2B6();
        Walls w2 = new M2B6();
        Walls w3 = new M2B6();
        getWorld().addObject(w1,512,128);
        getWorld().addObject(w2,0,416);
        getWorld().addObject(w3,512,416);

        Walls w4 = new M2B5();
        Walls w5 = new M2B5();
        Walls w6 = new M2B5();
        Walls w7 = new M2B5();
        Walls w8 = new M2B5();
        Walls w9 = new M2B5();
        Walls w10 = new M2B5();
        getWorld().addObject(w4,16,352);
        getWorld().addObject(w5,48,352);
        getWorld().addObject(w6,80,352);
        getWorld().addObject(w7,432,160);
        getWorld().addObject(w8,432,224);
        getWorld().addObject(w9,432,288);
        getWorld().addObject(w10,432,352);

        Walls w11 = new M8B1();
        getWorld().addObject(w11,112,248);

        Walls w12 = new M8B2();
        //replace with a shorter green water texture
        getWorld().addObject(w12,208,156);

        Transitions t1 = new W6();
        getWorld().addObject(t1,240,448);
        Transitions t2 = new W6();
        getWorld().addObject(t2,272,448);
        Transitions t3 = new W10();
        getWorld().addObject(t3,240,98);
        Transitions t4 = new W10();
        getWorld().addObject(t4,272,98);
        Transitions t5 = new W7();
        getWorld().addObject(t5,0,304);

        Enemy e1 = new zora_water();
        getWorld().addObject(e1,467,239);

        if(getX() > 480 || getX() < 20)
        {
            setLocation((512-getX()), getY());
        }
        else
        {
            setLocation(getX(), (448-getY()+96));
        }
    }

    public void setOverworld9()
    {
        getWorld().setBackground("OverworldMap9.png");
        track =9;
        Walls w1 = new M9B1();
        Walls w2 = new M9B1();
        getWorld().addObject(w1,496,236);
        getWorld().addObject(w2,496,308);

        Walls w3 = new M9B2();
        getWorld().addObject(w3,464,172);

        Walls w4 = new M9B3();
        getWorld().addObject(w4,464,372);

        Walls w5 = new M9B4();
        getWorld().addObject(w5,48,272);

        Walls w6 = new M9B5();
        getWorld().addObject(w6,256,128);

        Walls w7 = new M9B6();
        getWorld().addObject(w7,256,416);

        Walls w8 = new M9B7();
        Walls w9 = new M9B7();
        Walls w10 = new M9B7();
        Walls w11 = new M9B7();
        getWorld().addObject(w8,320,320);
        getWorld().addObject(w9,160,320);
        getWorld().addObject(w10,128,224);
        getWorld().addObject(w11,352,224);

        Walls w12 = new M9B9();
        Walls w13 = new M9B10();
        Walls w14 = new M9B11();
        getWorld().addObject(w12,270,227);
        getWorld().addObject(w13,210,227);
        getWorld().addObject(w14,240,212);

        Transitions t1 = new W10();
        getWorld().addObject(t1,512,272);

        Transitions t2 = new D2();
        getWorld().addObject(t2,240,240);

        if(getX() > 480 || getX() < 20)
        {
            setLocation((512-getX()), getY());
        }

        else if(getY() > 420 || getY() < 120)
        {
            setLocation(getX(), (448-getY()+96));
        }
        else
        {
            setLocation(240, 256);
        }
    }

    public void setOverworld10()
    {
        getWorld().setBackground("OverworldMap10.png");
        track =10;
        Walls w1 = new M10B1();
        Walls w2 = new M10B1();
        Walls w3 = new M10B1();
        getWorld().addObject(w1,400,416);
        getWorld().addObject(w2,400,128);
        getWorld().addObject(w3,336,128);

        Walls w4 = new M10B2();
        Walls w5 = new M10B2();
        Walls w6 = new M10B2();
        Walls w7 = new M10B2();
        getWorld().addObject(w4,336,368);
        getWorld().addObject(w5,400,304);
        getWorld().addObject(w6,400,240);
        getWorld().addObject(w7,336,176);

        Walls w8 = new M10B6();
        Walls w9 = new M10B7();
        getWorld().addObject(w8,96,236);
        getWorld().addObject(w9,96,308);

        Walls w10 = new M10B3();
        getWorld().addObject(w10,496,272);

        Walls w11 = new M10B4();
        getWorld().addObject(w11,208,172);

        Walls w12 = new M10B5();
        getWorld().addObject(w12,208,372);

        Transitions t1 = new W9();
        getWorld().addObject(t1,0,272);
        Transitions t2 = new W8();
        getWorld().addObject(t2,240,448);
        Transitions t3 = new W8();
        getWorld().addObject(t3,272,448);

        Enemy e1 = new zora_water();
        getWorld().addObject(e1,467,239);
        Enemy e2 = new octorock();
        getWorld().addObject(e2,425,192);

        if(getX() > 480 || getX() < 20)
        {
            setLocation((512-getX()), getY());
        }
        else
        {
            setLocation(getX(), (448-getY()+96));
        }
    }

    public void setDungeon1()
    {
        getWorld().setBackground("DungeonMap2.png");
        track =11;
        Walls w1 = new D1B5();
        getWorld().addObject(w1,480,341);
        Walls w2 = new D1B6();
        getWorld().addObject(w2,480,203);
        Transitions t1= new D2();
        getWorld().addObject(t1,480,272);

        Walls w3 = new D1B2();
        getWorld().addObject(w3,256,128);
        Walls w4 = new D1B1();
        getWorld().addObject(w4,32,272);
        Walls w5 = new D1B4();
        getWorld().addObject(w5,256,416);

        Enemy e1 = new bat();
        getWorld().addObject(e1,82,241);
        Enemy e2 = new bat();
        getWorld().addObject(e2,137,209);
        Enemy e3 = new bat();
        getWorld().addObject(e3,255,338);

        if(getX() > 350 || getX() < 150)
        {
            setLocation((512-getX()), getY());
        }
        else
        {
            setLocation(getX(), (448-getY()+96 - (dir*2)));
        }
    }

    public void setDungeon2()
    {
        getWorld().setBackground("DungeonMap1.png");
        track =12;
        Walls w1 = new D1B17();
        Walls w2 = new D1B17();
        Walls w3 = new D1B17();
        Walls w4 = new D1B17();
        Walls w5 = new D1B17();
        Walls w6 = new D1B17();
        getWorld().addObject(w1,111,208);
        getWorld().addObject(w2,111,272);
        getWorld().addObject(w3,111,336);
        getWorld().addObject(w4,207,208);
        getWorld().addObject(w5,207,272);
        getWorld().addObject(w6,207,336);
        Walls w7 = new D1B18();
        Walls w8 = new D1B18();
        Walls w9 = new D1B18();
        Walls w10 = new D1B18();
        Walls w11 = new D1B18();
        Walls w12 = new D1B18();
        getWorld().addObject(w7,303,208);
        getWorld().addObject(w8,303,272);
        getWorld().addObject(w9,303,336);
        getWorld().addObject(w10,399,208);
        getWorld().addObject(w11,399,272);
        getWorld().addObject(w12,399,336);

        Walls w13 = new D1B5();
        getWorld().addObject(w13,480,341);
        Walls w14 = new D1B6();
        getWorld().addObject(w14,480,203);
        Transitions t1= new D3();
        getWorld().addObject(t1,480,272);

        Walls w15 = new D1B8();
        getWorld().addObject(w15,365,416);
        Walls w16 = new D1B9();
        getWorld().addObject(w16,147,416);
        Transitions t2= new W9();
        getWorld().addObject(t2,256,416);

        Walls w17 = new D1B11();
        getWorld().addObject(w17,365,128);
        Walls w18 = new D1B12();
        getWorld().addObject(w18,147,128);
        Transitions t3= new D4();
        getWorld().addObject(t3,256,128);

        Walls w19 = new D1B14();
        getWorld().addObject(w19,32,203);
        Walls w20 = new D1B15();
        getWorld().addObject(w20,32,341);
        Transitions t4= new D1();
        getWorld().addObject(t4,32,272);
        if(getX() > 350 || getX() < 150)
        {
            setLocation((512-getX()), getY());
        }
        else
        {
            setLocation(getX(), (448-getY()+96 - (dir*2)));
        }
    }

    public void setDungeon3()
    {
        getWorld().setBackground("DungeonMap3.png");
        track =13;
        Walls w1 = new D1B15();
        getWorld().addObject(w1,32,341);
        Walls w2 = new D1B14();
        getWorld().addObject(w2,32,203);
        Transitions t1= new D2();
        getWorld().addObject(t1,32,272);

        Walls w3 = new D1B2();
        getWorld().addObject(w3,256,128);
        Walls w4 = new D1B3();
        getWorld().addObject(w4,480,272);
        Walls w5 = new D1B4();
        getWorld().addObject(w5,256,416);

        Walls w6 = new D1B19();
        Walls w7 = new D1B19();
        Walls w8 = new D1B19();
        Walls w9 = new D1B19();
        Walls w10 = new D1B19();
        Walls w11 = new D1B19();
        getWorld().addObject(w6,144,304);
        getWorld().addObject(w7,144,240);
        getWorld().addObject(w8,144,272);
        getWorld().addObject(w9,176,304);
        getWorld().addObject(w10,176,240);
        getWorld().addObject(w11,176,272);
        Walls w12 = new D1B19();
        Walls w13 = new D1B19();
        Walls w14 = new D1B19();
        Walls w15 = new D1B19();
        Walls w16 = new D1B19();
        Walls w17 = new D1B19();
        getWorld().addObject(w12,336,304);
        getWorld().addObject(w13,336,240);
        getWorld().addObject(w14,336,272);
        getWorld().addObject(w15,368,304);
        getWorld().addObject(w16,368,240);
        getWorld().addObject(w17,368,272);

        Enemy e1 = new skeleton();
        getWorld().addObject(e1,281,351);
        Enemy e2 = new skeleton();
        getWorld().addObject(e2,421,242);
        Enemy e3 = new skeleton();
        getWorld().addObject(e3,256,186);

        if(getX() > 350 || getX() < 150)
        {
            setLocation((512-getX()), getY());
        }
        else
        {
            setLocation(getX(), (448-getY()+96 - (dir*2)));
        }
    }

    public void setDungeon4()
    {
        getWorld().setBackground("DungeonMap4.png");
        track =14;
        Walls w5 = new D1B3();
        getWorld().addObject(w5,480,272);

        Walls w6 = new D1B1();
        getWorld().addObject(w6,32,272);

        Walls w7 = new D1B19();
        Walls w8 = new D1B19();
        Walls w9 = new D1B19();
        Walls w10 = new D1B19();
        Walls w11 = new D1B19();
        Walls w12 = new D1B19();

        getWorld().addObject(w7,240,240);
        getWorld().addObject(w8,240,272);
        getWorld().addObject(w9,240,304);
        getWorld().addObject(w10,272,240);
        getWorld().addObject(w11,272,272);
        getWorld().addObject(w12,272,304);

        Walls w13 = new D1B11();
        getWorld().addObject(w13,365,128);
        Walls w14 = new D1B12();
        getWorld().addObject(w14,147,128);
        Transitions t1= new D6();
        getWorld().addObject(t1,256,128);

        Walls w15 = new D1B8();
        getWorld().addObject(w15,365,416);
        Walls w16 = new D1B9();
        getWorld().addObject(w16,147,416);
        Transitions t2= new D2();
        getWorld().addObject(t2,256,416);

        Enemy e1 = new skeleton();
        getWorld().addObject(e1,256,188);

        if(getX() > 350 || getX() < 150)
        {
            setLocation((512-getX()), getY());
        }
        else
        {
            setLocation(getX(), (448-getY()+96 - (dir*2)));
        }
    }

    public void setDungeon5()
    {
        getWorld().setBackground("DungeonMap7.png");
        track =15;
        Walls w1 = new D1B5();
        getWorld().addObject(w1,480,341);
        Walls w2 = new D1B6();
        getWorld().addObject(w2,480,203);
        Transitions t1= new D6();
        getWorld().addObject(t1,480,272);

        Walls w3 = new D1B11();
        getWorld().addObject(w3,365,128);
        Walls w4 = new D1B12();
        getWorld().addObject(w4,147,128);
        Transitions t2= new D8();
        getWorld().addObject(t2,256,128);

        Walls w5 = new D1B4();
        getWorld().addObject(w5,256,416);

        Walls w6 = new D1B1();
        getWorld().addObject(w6,32,272);

        Walls w7 = new D1B19();
        Walls w8 = new D1B19();
        Walls w9 = new D1B19();
        Walls w10 = new D1B19();
        Walls w11 = new D1B19();
        Walls w12 = new D1B19();

        getWorld().addObject(w7,240,240);
        getWorld().addObject(w8,240,272);
        getWorld().addObject(w9,240,304);
        getWorld().addObject(w10,272,240);
        getWorld().addObject(w11,272,272);
        getWorld().addObject(w12,272,304);

        Enemy e1 = new bat();
        getWorld().addObject(e1,258,193);
        Enemy e2 = new bat();
        getWorld().addObject(e2,120,199);
        Enemy e3 = new bat();
        getWorld().addObject(e3,200,296);
        Enemy e4 = new bat();
        getWorld().addObject(e4,104,313);
        Enemy e5 = new bat();
        getWorld().addObject(e5,264,367);

        if(getX() > 350 || getX() < 150)
        {
            setLocation((512-getX()), getY());
        }
        else
        {
            setLocation(getX(), (448-getY()+96 - (dir*2)));
        }
    }

    public void setDungeon6()
    {
        getWorld().setBackground("DungeonMap5.png");
        track =16;
        Walls w1 = new D1B5();
        getWorld().addObject(w1,480,341);
        Walls w2 = new D1B6();
        getWorld().addObject(w2,480,203);
        Transitions t1= new D7();
        getWorld().addObject(t1,480,272);

        Walls w3 = new D1B8();
        getWorld().addObject(w3,365,416);
        Walls w4 = new D1B9();
        getWorld().addObject(w4,147,416);
        Transitions t2= new D4();
        getWorld().addObject(t2,256,416);

        Walls w5 = new D1B14();
        getWorld().addObject(w5,32,203);
        Walls w6 = new D1B15();
        getWorld().addObject(w6,32,341);
        Transitions t3= new D5();
        getWorld().addObject(t3,32,272);

        Walls w7 = new D1B2();
        getWorld().addObject(w7,256,128);

        Walls w8 = new D1B19();
        Walls w9 = new D1B19();
        Walls w10 = new D1B19();
        Walls w11 = new D1B19();

        getWorld().addObject(w8,144,240);
        getWorld().addObject(w9,144,304);
        getWorld().addObject(w10,368,240);
        getWorld().addObject(w11,368,304);

        Enemy e1 = new skeleton();
        getWorld().addObject(e1,421,240);
        Enemy e2 = new skeleton();
        getWorld().addObject(e2,374,190);
        Enemy e3 = new skeleton();
        getWorld().addObject(e3,114,195);
        Enemy e4 = new skeleton();
        getWorld().addObject(e4,108,281);

        if(getX() > 350 || getX() < 150)
        {
            setLocation((512-getX()), getY());
        }
        else
        {
            setLocation(getX(), (448-getY()+96 - (dir*2)));
        }
    }

    public void setDungeon7()
    {
        getWorld().setBackground("DungeonMap6.png");
        track =17;
        Walls w1 = new D1B14();
        getWorld().addObject(w1,32,203);
        Walls w2 = new D1B15();
        getWorld().addObject(w2,32,341);
        Transitions t1= new D6();
        getWorld().addObject(t1,32,272);

        Walls w4 = new D1B3();
        getWorld().addObject(w4,480,272);
        Walls w5 = new D1B4();
        getWorld().addObject(w5,256,416);
        Walls w7 = new D1B2();
        getWorld().addObject(w7,256,128);

        Walls w8 = new D1B19();
        Walls w9 = new D1B19();
        Walls w10 = new D1B19();
        Walls w11 = new D1B19();

        getWorld().addObject(w8,144,208);
        getWorld().addObject(w9,144,336);
        getWorld().addObject(w10,368,208);
        getWorld().addObject(w11,368,336);

        Enemy e1 = new bat();
        getWorld().addObject(e1,181,187);
        Enemy e2 = new bat();
        getWorld().addObject(e2,202,265);
        Enemy e3 = new bat();
        getWorld().addObject(e3,390,278);
        Enemy e4 = new skeleton();
        getWorld().addObject(e4,273,202);
        Enemy e5 = new skeleton();
        getWorld().addObject(e5,419,192);
        Enemy e6 = new skeleton();
        getWorld().addObject(e6,428,367);

        if(getX() > 350 || getX() < 150)
        {
            setLocation((512-getX()), getY());
        }
        else
        {
            setLocation(getX(), (448-getY()+96 - (dir*2)));
        }
    }

    public void setDungeon8()
    {
        getWorld().setBackground("DungeonMap8.png");
        track =18;
        Walls w1 = new D1B5();
        getWorld().addObject(w1,480,341);
        Walls w2 = new D1B6();
        getWorld().addObject(w2,480,203);
        Transitions t1= new D9();
        getWorld().addObject(t1,480,272);

        Walls w3 = new D1B8();
        getWorld().addObject(w3,365,416);
        Walls w4 = new D1B9();
        getWorld().addObject(w4,147,416);
        Transitions t2= new D5();
        getWorld().addObject(t2,256,416);

        Walls w5 = new D1B2();
        getWorld().addObject(w5,256,128);
        Walls w6 = new D1B1();
        getWorld().addObject(w6,32,272);

        Walls w7 = new D1B19();
        getWorld().addObject(w7,240,272);

        Enemy e1 = new blob();
        getWorld().addObject(e1,341,182);
        Enemy e2 = new blob();
        getWorld().addObject(e2,230,205);
        Enemy e3 = new blob();
        getWorld().addObject(e3,132,212);
        Enemy e4 = new blob();
        getWorld().addObject(e4,371,239);
        Enemy e5 = new blob();
        getWorld().addObject(e5,111,292);
        Enemy e6 = new blob();
        getWorld().addObject(e6,399,310);

        if(getX() > 350 || getX() < 150)
        {
            setLocation((512-getX()), getY());
        }
        else
        {
            setLocation(getX(), (448-getY()+96 - (dir*2)));
        }
    }

    public void setDungeon9()
    {
        getWorld().setBackground("DungeonMap9.png");
        track =19;
        Walls w1 = new D1B5();
        getWorld().addObject(w1,480,341);
        Walls w2 = new D1B6();
        getWorld().addObject(w2,480,203);
        Transitions t1= new D10();
        getWorld().addObject(t1,480,272);

        Walls w3 = new D1B14();
        getWorld().addObject(w3,32,203);
        Walls w4 = new D1B15();
        getWorld().addObject(w4,32,341);
        Transitions t2= new D8();
        getWorld().addObject(t2,32,272);

        Walls w5 = new D1B11();
        getWorld().addObject(w5,365,128);
        Walls w6 = new D1B12();
        getWorld().addObject(w6,147,128);
        Transitions t3= new D12();
        getWorld().addObject(t3,256,128);

        Walls w7 = new D1B4();
        getWorld().addObject(w7,256,416);

        Walls w8 = new D1B19();
        Walls w9 = new D1B19();
        Walls w10 = new D1B19();
        Walls w11 = new D1B19();
        Walls w12 = new D1B19();
        Walls w13 = new D1B19();
        Walls w14 = new D1B19();
        Walls w15 = new D1B19();
        Walls w16 = new D1B19();
        Walls w17 = new D1B19();

        getWorld().addObject(w8,272,272);
        getWorld().addObject(w9,240,272);
        getWorld().addObject(w10,400,336);
        getWorld().addObject(w11,368,336);
        getWorld().addObject(w12,112,336);
        getWorld().addObject(w13,144,336);
        getWorld().addObject(w14,400,208);
        getWorld().addObject(w15,368,208);
        getWorld().addObject(w16,112,208);
        getWorld().addObject(w17,144,208);

        Enemy e1 = new blob();
        getWorld().addObject(e1,144,172);
        Enemy e2 = new blob();
        getWorld().addObject(e2,209,189);
        Enemy e3 = new blob();
        getWorld().addObject(e3,337,178);
        Enemy e4 = new blob();
        getWorld().addObject(e4,418,178);
        Enemy e5 = new blob();
        getWorld().addObject(e5,112,370);
        Enemy e6 = new blob();
        getWorld().addObject(e6,275,342);
        Enemy e7 = new blob();
        getWorld().addObject(e7,384,367);
        Enemy e8 = new blob();
        getWorld().addObject(e8,431,367);

        if(getX() > 350 || getX() < 150)
        {
            setLocation((512-getX()), getY());
        }
        else
        {
            setLocation(getX(), (448-getY()+96 - (dir*2)));
        }
    }

    public void setDungeon10()
    {
        getWorld().setBackground("DungeonMap10.png");
        track =20;
        Walls w1 = new D1B5();
        getWorld().addObject(w1,480,341);
        Walls w2 = new D1B6();
        getWorld().addObject(w2,480,203);
        Transitions t1= new D11();
        getWorld().addObject(t1,480,272);

        Walls w3 = new D1B14();
        getWorld().addObject(w3,32,203);
        Walls w4 = new D1B15();
        getWorld().addObject(w4,32,341);
        Transitions t2= new D9();
        getWorld().addObject(t2,32,272);

        Walls w5 = new D1B4();
        getWorld().addObject(w5,256,416);

        Walls w6 = new D1B2();
        getWorld().addObject(w6,256,128);

        Walls w7 = new D1B19();
        Walls w8 = new D1B19();
        Walls w9 = new D1B19();
        Walls w10 = new D1B19();

        getWorld().addObject(w7,368,240);
        getWorld().addObject(w8,368,304);
        getWorld().addObject(w9,144,240);
        getWorld().addObject(w10,144,304);

        Enemy e1 = new moblin();
        getWorld().addObject(e1,401,354);
        Enemy e2 = new moblin();
        getWorld().addObject(e2,318,270);
        Enemy e3 = new moblin();
        getWorld().addObject(e3,403,198);

        if(getX() > 350 || getX() < 150)
        {
            setLocation((512-getX()), getY());
        }
        else
        {
            setLocation(getX(), (448-getY()+96 - (dir*2)));
        }
    }

    public void setDungeon11()
    {
        getWorld().setBackground("DungeonMap11.png");
        track =21;
        Walls w1 = new D1B11();
        getWorld().addObject(w1,365,128);
        Walls w2 = new D1B12();
        getWorld().addObject(w2,147,128);
        Transitions t1= new D13();
        getWorld().addObject(t1,256,128);

        Walls w3 = new D1B14();
        getWorld().addObject(w3,32,203);
        Walls w4 = new D1B15();
        getWorld().addObject(w4,32,341);
        Transitions t2= new D10();
        getWorld().addObject(t2,32,272);

        Walls w6 = new D1B3();
        getWorld().addObject(w6,480,272);

        Walls w5 = new D1B4();
        getWorld().addObject(w5,256,416);

        Walls w7 = new D1B19();
        Walls w8 = new D1B19();
        Walls w9 = new D1B19();
        Walls w10 = new D1B19();
        Walls w11 = new D1B19();
        Walls w12 = new D1B19();

        getWorld().addObject(w7,400,208);
        getWorld().addObject(w8,336,208);
        getWorld().addObject(w9,176,208);
        getWorld().addObject(w10,112,208);
        getWorld().addObject(w11,240,208);
        getWorld().addObject(w12,272,208);

        Walls w13 = new D1B19();
        Walls w14 = new D1B19();
        Walls w15 = new D1B19();
        Walls w16 = new D1B19();
        Walls w17 = new D1B19();
        Walls w18 = new D1B19();

        getWorld().addObject(w13,400,272);
        getWorld().addObject(w14,336,272);
        getWorld().addObject(w15,176,272);
        getWorld().addObject(w16,112,272);
        getWorld().addObject(w17,240,272);
        getWorld().addObject(w18,272,272);

        Walls w19 = new D1B19();
        Walls w20 = new D1B19();
        Walls w21 = new D1B19();
        Walls w22 = new D1B19();
        Walls w23 = new D1B19();
        Walls w24 = new D1B19();

        getWorld().addObject(w19,400,336);
        getWorld().addObject(w20,336,336);
        getWorld().addObject(w21,176,336);
        getWorld().addObject(w22,112,336);
        getWorld().addObject(w23,240,336);
        getWorld().addObject(w24,272,336);

        Enemy e1 = new skeleton();
        getWorld().addObject(e1,303,303);
        Enemy e2 = new skeleton();
        getWorld().addObject(e2,369,240);

        if(getX() > 350 || getX() < 150)
        {
            setLocation((512-getX()), getY());
        }
        else
        {
            setLocation(getX(), (448-getY()+96 - (dir*2)));
        }
    }

    public void setDungeon12()
    {
        getWorld().setBackground("DungeonMap13.png");
        track =22;
        Walls w1 = new D1B8();
        getWorld().addObject(w1,365,416);
        Walls w2 = new D1B9();
        getWorld().addObject(w2,147,416);
        Transitions t1= new D9();
        getWorld().addObject(t1,256,416);

        Walls w3 = new D1B2();
        getWorld().addObject(w3,256,128);
        Walls w4 = new D1B1();
        getWorld().addObject(w4,32,272);
        Walls w5 = new D1B3();
        getWorld().addObject(w5,480,272);

        Walls w6 = new D1B22();
        Walls w7 = new D1B22();
        Walls w8 = new D1B22();
        Walls w9 = new D1B22();
        Walls w10 = new D1B22();
        Walls w11 = new D1B22();
        Walls w12 = new D1B22();
        Walls w13 = new D1B22();
        Walls w14 = new D1B22();
        Walls w15 = new D1B22();
        Walls w16 = new D1B22();
        Walls w17 = new D1B22();
        Walls w18 = new D1B22();
        Walls w19 = new D1B22();
        Walls w20 = new D1B22();
        Walls w21 = new D1B22();
        Walls w22 = new D1B22();
        Walls w23 = new D1B22();
        Walls w24 = new D1B22();
        Walls w25 = new D1B22();
        Walls w26 = new D1B22();
        Walls w27 = new D1B22();
        Walls w28 = new D1B22();
        Walls w29 = new D1B22();
        Walls w30 = new D1B22();
        Walls w31 = new D1B22();
        Walls w32 = new D1B22();
        Walls w33 = new D1B22();
        Walls w34 = new D1B22();
        Walls w35 = new D1B22();
        Walls w36 = new D1B22();
        Walls w37 = new D1B22();
        Walls w38 = new D1B22();
        Walls w39 = new D1B22();
        Walls w40 = new D1B22();
        Walls w41 = new D1B22();
        Walls w42 = new D1B22();
        Walls w43 = new D1B22();
        Walls w44 = new D1B22();
        Walls w45 = new D1B22();

        getWorld().addObject(w6,240,304);
        getWorld().addObject(w7,432,208);
        getWorld().addObject(w8,432,240);
        getWorld().addObject(w9,432,304);
        getWorld().addObject(w10,432,336);
        getWorld().addObject(w11,400,368);
        getWorld().addObject(w12,400,176);
        getWorld().addObject(w13,368,208);
        getWorld().addObject(w14,368,240);
        getWorld().addObject(w15,368,272);
        getWorld().addObject(w16,368,304);
        getWorld().addObject(w17,368,368);
        getWorld().addObject(w18,336,176);
        getWorld().addObject(w19,336,368);
        getWorld().addObject(w20,304,176);
        getWorld().addObject(w21,304,240);
        getWorld().addObject(w22,304,272);
        getWorld().addObject(w23,304,304);
        getWorld().addObject(w24,304,336);
        getWorld().addObject(w25,304,368);
        getWorld().addObject(w26,80,208);
        getWorld().addObject(w27,272,240);
        getWorld().addObject(w28,208,240);
        getWorld().addObject(w29,208,304);
        getWorld().addObject(w30,208,272);
        getWorld().addObject(w31,208,368);
        getWorld().addObject(w32,208,176);
        getWorld().addObject(w33,208,208);
        getWorld().addObject(w34,176,176);
        getWorld().addObject(w35,176,368);
        getWorld().addObject(w36,144,176);
        getWorld().addObject(w37,144,240);
        getWorld().addObject(w38,144,272);
        getWorld().addObject(w39,144,304);
        getWorld().addObject(w40,144,336);
        getWorld().addObject(w41,112,176);
        getWorld().addObject(w42,112,368);
        getWorld().addObject(w43,80,240);
        getWorld().addObject(w44,80,336);
        getWorld().addObject(w45,80,304);

        Enemy e1 = new skeleton();
        getWorld().addObject(e1,112,272);
        Enemy e2 = new skeleton();
        getWorld().addObject(e2,256,193);
        Enemy e3 = new skeleton();
        getWorld().addObject(e3,401,270);

        if(getX() > 350 || getX() < 150)
        {
            setLocation((512-getX()), getY());
        }
        else
        {
            setLocation(getX(), (448-getY()+96 - (dir*2)));
        }
    }

    public void setDungeon13()
    {
        getWorld().setBackground("DungeonMap12.png");
        track =23;
        Walls w1 = new D1B5();
        getWorld().addObject(w1,480,341);
        Walls w2 = new D1B6();
        getWorld().addObject(w2,480,203);
        Transitions t1= new D14();
        getWorld().addObject(t1,480,272);

        Walls w3 = new D1B8();
        getWorld().addObject(w3,365,416);
        Walls w4 = new D1B9();
        getWorld().addObject(w4,147,416);
        Transitions t2= new D11();
        getWorld().addObject(t2,256,416);

        Walls w5 = new D1B2();
        getWorld().addObject(w5,256,128);
        Walls w6 = new D1B1();
        getWorld().addObject(w6,32,272);

        Walls w7 = new D1B19();
        Walls w8 = new D1B19();
        Walls w9 = new D1B19();
        Walls w10 = new D1B19();
        Walls w11 = new D1B19();
        Walls w12 = new D1B19();
        Walls w13 = new D1B19();
        Walls w14 = new D1B19();
        Walls w15 = new D1B19();
        Walls w16 = new D1B19();
        Walls w17 = new D1B19();
        Walls w18 = new D1B19();
        Walls w19 = new D1B19();
        Walls w20 = new D1B19();
        Walls w21 = new D1B19();
        Walls w22 = new D1B19();
        Walls w23 = new D1B19();
        Walls w24 = new D1B19();
        Walls w25 = new D1B19();
        Walls w26 = new D1B19();

        getWorld().addObject(w7,432,176);
        getWorld().addObject(w8,400,176);
        getWorld().addObject(w9,368,176);
        getWorld().addObject(w10,336,176);
        getWorld().addObject(w11,304,176);

        getWorld().addObject(w12,368,208);
        getWorld().addObject(w13,400,208);
        getWorld().addObject(w14,432,208);

        getWorld().addObject(w15,400,240);
        getWorld().addObject(w16,432,240);

        getWorld().addObject(w17,432,304);
        getWorld().addObject(w18,400,304);

        getWorld().addObject(w19,432,336);
        getWorld().addObject(w20,400,336);
        getWorld().addObject(w21,368,336);

        getWorld().addObject(w22,432,368);
        getWorld().addObject(w23,400,368);
        getWorld().addObject(w24,368,368);
        getWorld().addObject(w25,336,368);
        getWorld().addObject(w26,304,368);

        Enemy e1 = new dragon();
        getWorld().addObject(e1,336,272);

        if(getX() > 350 || getX() < 150)
        {
            setLocation((512-getX()), getY());
        }
        else
        {
            setLocation(getX(), (448-getY()+96 - (dir*2)));
        }
    }

    public void setDungeon14()
    {
        getWorld().setBackground("DungeonMap14.png");
        track =24;
        Walls w1 = new D1B14();
        getWorld().addObject(w1,32,203);
        Walls w2 = new D1B15();
        getWorld().addObject(w2,32,341);
        Transitions t1= new D13();
        getWorld().addObject(t1,32,272);

        Walls w3 = new D1B2();
        getWorld().addObject(w3,256,128);
        Walls w4 = new D1B3();
        getWorld().addObject(w4,480,272);
        Walls w5 = new D1B4();
        getWorld().addObject(w5,256,416);

        Walls w6 = new D1B19();
        Walls w7 = new D1B19();
        Walls w8 = new D1B19();
        Walls w9 = new D1B19();
        Walls w10 = new D1B19();
        Walls w11 = new D1B19();
        Walls w12 = new D1B19();
        Walls w13 = new D1B19();
        Walls w14 = new D1B19();
        Walls w15 = new D1B19();
        Walls w16 = new D1B19();
        Walls w17 = new D1B19();
        Walls w18 = new D1B19();
        Walls w19 = new D1B19();
        Walls w20 = new D1B19();
        Walls w21 = new D1B19();
        Walls w22 = new D1B19();
        Walls w23 = new D1B19();
        Walls w24 = new D1B19();
        Walls w25 = new D1B19();
        Walls w26 = new D1B19();
        Walls w27 = new D1B19();
        Walls w28 = new D1B19();
        Walls w29 = new D1B19();
        Walls w30 = new D1B20();
        Walls w31 = new D1B20();
        Walls w32 = new D1B21();
        Walls w33 = new D1B21();

        getWorld().addObject(w6,112,336);
        getWorld().addObject(w7,144,336);
        getWorld().addObject(w8,176,336);
        getWorld().addObject(w9,208,336);
        getWorld().addObject(w10,304,336);
        getWorld().addObject(w11,336,336);
        getWorld().addObject(w12,368,336);
        getWorld().addObject(w13,400,336);
        getWorld().addObject(w14,400,304);
        getWorld().addObject(w15,112,304);
        getWorld().addObject(w16,400,272);
        getWorld().addObject(w17,112,272);
        getWorld().addObject(w18,400,240);
        getWorld().addObject(w19,112,240);
        getWorld().addObject(w20,400,208);
        getWorld().addObject(w21,368,208);
        getWorld().addObject(w22,336,208);
        getWorld().addObject(w23,304,208);
        getWorld().addObject(w24,272,208);
        getWorld().addObject(w25,240,208);
        getWorld().addObject(w26,208,208);
        getWorld().addObject(w27,176,208);
        getWorld().addObject(w28,144,208);
        getWorld().addObject(w29,112,208);
        getWorld().addObject(w30,208,240);
        getWorld().addObject(w31,177,272);
        getWorld().addObject(w32,304,240);
        getWorld().addObject(w33,336,272);

        getWorld().addObject(new Triforce(),256,272);

        if(getX() > 350 || getX() < 150)
        {
            setLocation((512-getX()), getY());
        }
        else
        {
            setLocation(getX(), (448-getY()+96 - (dir*2)));
        }
    }

}