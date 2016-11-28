import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import javax.swing.JOptionPane;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{   //int time;
    boolean allCaptured=false;
    int score=0;
    int noOfPlanetsCaptured=0;
    Planet home,a1,a2,a3,a4,a5,a6,a7,a8;
    HashMap<Integer,Planet> universeMatrix = new HashMap<Integer,Planet>();
    int maxFuel=22;
    int selectedPlanetId=0;
    boolean isSourceSelected=true;
    Message currentScore= new Message();
    SpaceShip spaceship=new SpaceShip();
    String atPlanet="10";
   int currentX;
   int currentY;
   Planet[][] planet=new Planet[3][5];
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GameWorld()
    {    
        super(1500, 750, 1);
      
         HashMap<Integer,Integer> planetmap = buildMatrix(new int[]{1,2},new int[]{2,4});
          home=new HomePlanet(0,planetmap,340,120,"10");
         planetmap = buildMatrix(new int[]{0,2,3,5},new int[]{2,3,4,1});
          a1=new AlienPlanet(1,planetmap,340,120,"01");
       
         planetmap=buildMatrix(new int[]{0,1,3,4},new int[]{4,3,5,3});
          a2=new AlienPlanet(2,planetmap,300,560,"21");
        
         planetmap = buildMatrix(new int[]{1,2,5,4},new int[]{4,5,2,2});
          a3=new AlienPlanet(3,planetmap,580,300,"02");
         
         planetmap = buildMatrix(new int[]{2,3,5,6,8},new int[]{3,2,2,3,7});
          a4=new AlienPlanet(4,planetmap,660,620,"12");
         
         planetmap = buildMatrix(new int[]{1,3,4,7},new int[]{1,2,2,7});
          a5=new AlienPlanet(5,planetmap,750,150,"22");
         
         planetmap = buildMatrix(new int[]{4,7,8},new int[]{3,2,3});
          a6=new AlienPlanet(6,planetmap,900,390,"03");
         
         planetmap = buildMatrix(new int[]{5,6,8},new int[]{7,2,4});
          a7=new AlienPlanet(7,planetmap,1100,170,"23");
          
         planetmap = buildMatrix(new int[]{7,6,4},new int[]{4,3,7});
          a8=new AlienPlanet(8,planetmap,1200,650,"14");
           planet[1][0] =home;
         planet[0][1]=a1;
         planet[2][1]=a2;
         planet[0][2]=a3;
         planet[1][2]=a4;
         planet[2][2]=a5;
         planet[0][3]=a6;
         planet[2][3]=a7;
         planet[1][4]=a8;
         universeMatrix.put(1,a1);
         universeMatrix.put(2,a2);
         universeMatrix.put(3,a3);
         universeMatrix.put(4,a4);
         universeMatrix.put(5,a5);
         universeMatrix.put(6,a6);
         universeMatrix.put(7,a7);
         universeMatrix.put(8,a8);    
         prepare();
       
    }
   
   //building neighbour matrix
    HashMap<Integer,Integer> buildMatrix(int a[] , int b[])
    {
         HashMap<Integer,Integer> planetMatrix = new HashMap<Integer,Integer>();
         for(int i=0;i<a.length;i++)
         { 
             planetMatrix.put(new Integer(a[i]),new Integer(b[i])); 
         }
    
         return planetMatrix;
    }
    
    void prepare()
    {
     // addObject(r,240,160);
        //adding asteroid
     String inputValue = JOptionPane.showInputDialog("Please Enter Your Name Spartan !");   
     addObject(new Asteroids(),230,180);//between home and 1
     addObject(new Asteroids(),180,230);//between home and 1
     addObject(new Asteroids(),160,270);//between home and 1
     
     addObject(new Asteroids(),430,180);
     addObject(new Asteroids(),420,190);
     addObject(new Asteroids(),440,200);
     addObject(new Asteroids(),450,210);
     addObject(new Asteroids(),550,130); ////between 5 and 1
     addObject(new Asteroids(),200,500);//between h and 2
     addObject(new Asteroids(),180,510);//between h and 2
     addObject(new Asteroids(),220,480);//between h and 2
     addObject(new Asteroids(),160,490); //between h and 2
     addObject(new Asteroids(),500,570); //between 2 and 4
     addObject(new Asteroids(),510,590); //between 2 and 4
     addObject(new Asteroids(),490,600); //between 2 and 4
     
  
     addObject(home,120,400);
            
      
     addObject(a1,340,120);
     addObject(a2,300,560);
     addObject(a3,580,300);
     addObject(a4,660,620);
     addObject(a5,750,150);
     addObject(a6,900,390);
     addObject(a7,1100,170);
     addObject(a8,1200,650);
  
    // addObject(m,670,450);
     Greenfoot.playSound("background.wav"); 

     addObject(currentScore,300,20);
     currentScore.setText(String.valueOf(maxFuel));
     addObject(spaceship,120,350); 

    }
    SpaceShip getSpaceShip(){
        return spaceship;
    }
    void submitScores(){
    //to do
    }
    public void setPlanet(String s){
        atPlanet=s;
    }
    void growSoldiers(){
    //to do
    }
    void activateNeighbour(int key){
        if (key==0){
        return;
        }
        AlienPlanet p=(AlienPlanet)universeMatrix.get(key);
        if(!p.isCaptured)
        {  
         p.isClickable=true;
         p.alienGrow();
        
        }
    }    
    public void updatePlanetCount(){
        noOfPlanetsCaptured++;
    }
  public void updateScore(int wieght){  
      score=score+wieght;
      maxFuel=maxFuel-wieght;
      String newscore=String.valueOf(maxFuel);
      currentScore.setText(""+newscore);
    }
  public boolean checkAllCaptured(){
      if(noOfPlanetsCaptured==8){
        allCaptured=true;
        }
    return allCaptured;
    }  
    
    public int getMaxFuel(){
    return maxFuel;
    }
}
