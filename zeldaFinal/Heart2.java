import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*; 
/**
 * Handles all the file reading and writing and sets up the transition from the game menus to the actual game
 * 
 * @author Nikola Soldatovic 
 * @version 1.0
 */
public class Heart2 extends Actor
{
    private int count = 0;  // limits the ammount of characters to be used for the player's name to 10
    int heartY [] = {95,145,195}; // sets the 3 locations for the heart to move (Y axis only, these arrow positions line up with the 3 links displayed on the screen) when the player presses the arrow keys
    int heartX [] = {135,135,135}; // sets the X location for each of the Y positions above
    int Pos [] = {0,1,2}; //will be use to keep track of which link the heart is currently located at
    int letPlace [] = {200,217,234,251,268,285,302,319,336,353}; // sets all the positions for the characters the player selects
    private int kount = 0; 
    String Player = "";// this where the user name of the player will saved
    private int flag = 0;
    private int kount2 = 0;
    private boolean flag1 = false;
    private boolean y = true;
    private String string = ""; // this will be used to determine in which file the player's username will be saved (ie. player1, player2, player3)
    String x = "";
    int length = 0;
    int count2 = 0;
    private int p = 0;
    private int count3 = 0;
    private int z = 0;
    /**
     * The act class controls the movement of the heart based on the keys the player presses
     * It also checks whether there have been any previous save files
     * 
     */
    public void act() 
    {
        try {
            selection(); //goes go the selection method  
        }
        catch (IOException e) {
                }
        if (Greenfoot.isKeyDown("enter")==true) { // if the player presses the "enter" key (which means they have selected a available position or are going to overwrite a previous save) then the variable flag1 will become true
            flag1=true;
        }
        if (flag1) { // if the variable flag1 is true then go and run the keys method which will alow the player to input their username
            Keys(); 
        }
        if (flag>=1) { // if the variable flag1 is greater than or equal to 1 then go run the selected method and create a save file for the current user
                try {
                    selected();  
                }
                catch (IOException e) {
                }
            }
        if(Greenfoot.isKeyDown("down")==true){ // moves the heart if the player presses the up or down arrow keys
            count++;
            if (count>2) {// if count is greater then 2 (meaning it has reached the third link of the 3 on the screen) this will keep the heart at the bottom position
                count = 2; 
            }
            if (count<3 && count>-1){ //if count is within 0-2 then move the heart accordingly
                setLocation(heartX[count],heartY[count]);
            }
        }
        else if (Greenfoot.isKeyDown("up")==true) {
            count--;
            if (count<-1) { // if count is less then -1 (which means its at the first link out of the three on the screen) and will keep it at the top position
                count = 0;
            }
            if (count<3 && count>-1){
                setLocation(heartX[count],heartY[count]);
            }

        }

    } 
    /**
     * Depending on the location picked by the player it will choose between player 1-3
     * It will then create a file based on location of the heart in relation to the 3 links on the screen 
     * After that it will allow the player to create a name for his/her character (the letters used are displayed on the screen as they are typed)
     */
    public void selected()throws java.io.IOException  {
        if (Pos[count]== 0) { //based on the postion in the array called "Pos" it will choose between the 3 possible options 
            string = "Player1.txt";            
        }
        else if (Pos[count]== 1) {
            string = "Player2.txt";
        }
        else if (Pos[count]==2) {
            string = "Player3.txt";
        }
        FileWriter fw = new FileWriter(string); //takes the string from above and uses it to make a file
        BufferedWriter bfw = new BufferedWriter(fw);
        bfw.write(Player); // writes the username of the player into the file
        bfw.close(); // closes the file
        count3++;
        if (count3 ==1) {// after the player presses the space key it calls the Overworld world class
            Greenfoot.setWorld(new Overworld());
        }
    }
    /**
     * Checks to see if any other save files are saved and displays them on the screen
     */
    public void selection()throws java.io.IOException {
        if (p==0) { //if the variable p (p is used to represent the location of the heart which is used to determine which save file it is in) is equal to zero and goes to check the file called "Player1.txt" to see if it is available for use
            FileReader fr = new FileReader("Player1.txt"); // opens the file called "Player1.txt"
            BufferedReader bfr = new BufferedReader(fr);
            x=bfr.readLine(); // reads the first line of the file (the first line always will contain the username)
            char name = 1;
            if (x!=null) { // if the file is not empty then call the check method and display the username saved in the file
                for (int i = 0; i<x.length(); i++) { // goes through each letter of the username and prints it out on the screen using the characters in alphabet
                    name = x.charAt(i); //takes each letter from the username and displays it onto the screen (it does this mulitple times to form the entire username)
                    check(name); // sends the current letter to the check method 
                }
            }
            bfr.close();
            
        }
        count2=0;
        p++;
        if (p==1) {
            FileReader fr = new FileReader("Player2.txt");
            BufferedReader bfr = new BufferedReader(fr);
            x=bfr.readLine();
            char name = 1;
            if (x!=null) {
                for (int i = 0; i<x.length(); i++) {
                    name = x.charAt(i);
                    check(name);
                }
            }    
            bfr.close();
            
        }
        count2=0;
        p++;
        if (p==2) {
            FileReader fr = new FileReader("Player3.txt");
            BufferedReader bfr = new BufferedReader(fr);
            x=bfr.readLine();
            char name = 1;
            if (x!=null) {
                for (int i = 0; i<x.length(); i++) {
                    name = x.charAt(i);
                    check(name);
                }
            }
            bfr.close();
            
        }
        p++;
    }
    /**
     * Keeps track of what the player is typing and displays what is being typed on the screen by the player
     */
    public void Keys() {
        if (kount2==5){
            while (y) { // while the variable y is true it will take the inputs from the player and create their username
                if (Greenfoot.isKeyDown("Q")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]); // deletes any previous characters on the screen before placing a new one
                    getWorld().addObject(new Q(),letPlace[kount],heartY[count]); // displays the letter the player press on the keyboard (in this case it is the letter Q)
                    kount++; //Count keeps track of how many times the player has pressed a key
                    y=false; // sets the variable y to false
                    Player = Player+"Q"; // adds the key pressed by player to their username (in this case its the letter "Q")
                }
                else if (Greenfoot.isKeyDown("W")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new W(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"W";
                }
                else if (Greenfoot.isKeyDown("E")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new E(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"E";
                }
                else if (Greenfoot.isKeyDown("R")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new R(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"R";
                }
                else if (Greenfoot.isKeyDown("T")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new T(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"T";
                }
                else if (Greenfoot.isKeyDown("Y")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new Y(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"Y";
                }
                else if (Greenfoot.isKeyDown("U")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new U(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"U";
                }
                else if (Greenfoot.isKeyDown("I")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new I(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"I";
                }
                else if (Greenfoot.isKeyDown("O")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new O(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"O";
                }
                else if (Greenfoot.isKeyDown("P")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new P(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"P";
                }
                else if (Greenfoot.isKeyDown("A")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new A(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"A";
                }
                else if (Greenfoot.isKeyDown("S")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new S(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"S";
                }
                else if (Greenfoot.isKeyDown("D")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new D(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"D";
                }
                else if (Greenfoot.isKeyDown("F")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new F(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"F";
                }
                else if (Greenfoot.isKeyDown("G")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new G(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"G";
                }
                else if (Greenfoot.isKeyDown("H")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new H(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"H";
                }
                else if (Greenfoot.isKeyDown("J")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new J(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"J";
                }
                else if (Greenfoot.isKeyDown("K")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new K(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"K";
                }
                else if (Greenfoot.isKeyDown("L")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new L(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"L";
                }
                else if (Greenfoot.isKeyDown("Z")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new Z(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"Z";
                }
                else if (Greenfoot.isKeyDown("X")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new X(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"X";
                }
                else if (Greenfoot.isKeyDown("C")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new C(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"C";
                }
                else if (Greenfoot.isKeyDown("V")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new V(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"V";
                }
                else if (Greenfoot.isKeyDown("B")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new B(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"B";
                }
                else if (Greenfoot.isKeyDown("N")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new N(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"N";
                }
                else if (Greenfoot.isKeyDown("M")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new M(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"M";
                }
                else if (Greenfoot.isKeyDown("0")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new Zero(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"0";
                }
                else if (Greenfoot.isKeyDown("1")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new One(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"1";
                }
                else if (Greenfoot.isKeyDown("2")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new Two(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"2";
                }
                else if (Greenfoot.isKeyDown("3")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new Three(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"3";
                }
                else if (Greenfoot.isKeyDown("4")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new Four(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player= Player+"4";
                }
                else if (Greenfoot.isKeyDown("5")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new Five(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"5";
                }
                else if (Greenfoot.isKeyDown("6")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new Six(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"6";
                }
                else if (Greenfoot.isKeyDown("7")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new Seven(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"7";
                }
                else if (Greenfoot.isKeyDown("8")==true && kount<10 ) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new Eight(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"8";
                }
                else if (Greenfoot.isKeyDown("9")==true && kount<10) {
                    getWorld().addObject(new Blank(),letPlace[kount],heartY[count]);
                    getWorld().addObject(new Nine(),letPlace[kount],heartY[count]);
                    kount++;
                    y=false;
                    Player = Player+"9";
                }
                else if (Greenfoot.isKeyDown("space")==true) { // once the player is happy with their username the press the "space" key which will close the method
                    flag++; 
                    flag1=false;
                    y=false;
                }
            }
            kount2=0;
            y=true;
        }
        else {
            kount2++;
        }
        
    }
    /**
     * Displays the saved usernames from each of the save files onto the screen
     */
    public void check(char name) {
        if (count2 < x.length()) { // as long as count2 is less than the length of the username saved it will contiue to find and display all the letters in the username saved (once the all the letters from the username are displayed, it will then stop)
            if (name == 'Q') {
                getWorld().addObject(new Q(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == 'W') {
                getWorld().addObject(new W(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == 'E') {
                getWorld().addObject(new E(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == 'R') {
                getWorld().addObject(new R(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == 'T') {
                getWorld().addObject(new T(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == 'Y') {
                getWorld().addObject(new Y(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == 'U') {
                getWorld().addObject(new U(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == 'I') {
                getWorld().addObject(new I(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == 'O') {
                getWorld().addObject(new O(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == 'P') {
                getWorld().addObject(new P(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == 'A') {
                getWorld().addObject(new A(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == 'S') {
                getWorld().addObject(new S(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == 'D') {
                getWorld().addObject(new D(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == 'F') {
                getWorld().addObject(new F(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == 'G') {
                getWorld().addObject(new G(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == 'H') {
                getWorld().addObject(new H(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == 'J') {
                getWorld().addObject(new J(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == 'K') {
                getWorld().addObject(new K(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == 'L') {
                getWorld().addObject(new L(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == 'Z') {
                getWorld().addObject(new Z(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == 'X') {
                getWorld().addObject(new X(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == 'C') {
                getWorld().addObject(new C(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == 'V') {
                getWorld().addObject(new V(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == 'B') {
                getWorld().addObject(new B(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == 'N') {
                getWorld().addObject(new N(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == 'M') {
                getWorld().addObject(new M(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == '1') {
                getWorld().addObject(new One(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == '2') {
                getWorld().addObject(new Two(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == '3') {
                getWorld().addObject(new Three(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == '4') {
                getWorld().addObject(new Four(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == '5') {
                getWorld().addObject(new Five(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == '6') {
                getWorld().addObject(new Six(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == '7') {
                getWorld().addObject(new Seven(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == '8') {
                getWorld().addObject(new Eight(),letPlace[count2],heartY[p]);
                count2++;
            }
            else if (name == '9') {
                getWorld().addObject(new Nine(),letPlace[count2],heartY[p]);
                count2++;
            }
        }
    }
}
