import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Overworld extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private link theLink;
    private zora thezora;
    private health thehealth;
    private skeleton theSkeleton;
    public Overworld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(512, 448, 1);
        Greenfoot.setSpeed(50);
        
        theLink=new link();
        addObject(theLink,250,250);
        
        addObject(new StatusBar(),256,48);
        thezora=new zora();
        thehealth=new health(); 
        addObject(new swordStatic(),312,50);
        addObject(thehealth,416,60);
        theSkeleton=new skeleton();
        
        
        setBackground("OverworldMap1.png");
        
        //bushes
        Walls w1 = new M1B1();
        addObject(w1,32,368);
        Walls w2 = new M1B2();
        addObject(w2,256,416);
        Walls w3 = new M1B3();
        addObject(w3,480,368);
        Walls w4 = new M1B4();
        addObject(w4,406,170);
        Walls w5 = new M1B5();
        addObject(w5,192,128);
        Walls w6 = new M1B6();
        Walls w7 = new M1B6();
        addObject(w6,60,208);
        addObject(w7,92,176);
        Walls w8 = new M1B7();
        Walls w9 = new M1B7();
        Walls w10 = new M1B7();
        Walls w11 = new M1B7();
        Walls w12 = new M1B7();
        Walls w13 = new M1B7();
        Walls w14 = new M1B7();
        addObject(w8,16,272);
        addObject(w9,16,304);
        addObject(w10,48,272);
        addObject(w11,48,304);
        addObject(w12,48,240);
        addObject(w13,144,144);
        addObject(w14,112,144);
        
        Transitions t1= new W2();
        Transitions t2= new W3();
        Transitions t3= new W3();
        Transitions t4= new W3();
        addObject(t1,512,272);
        addObject(t2,240,98);
        addObject(t3,272,98);
        addObject(t4,256,98);
        
    }
    
    public link getLink(){
        return theLink;
    }

    public zora getZora(){
        return thezora;
    }

    public health getHealth(){
        return thehealth;
    }

    public skeleton getSkele(){
        return theSkeleton;
    }
    
}
