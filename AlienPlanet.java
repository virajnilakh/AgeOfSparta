import greenfoot.*;
import java.util.*;
import java.awt.Color;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class AlienPlanet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AlienPlanet extends Planet 
{
   GreenfootImage textImage = new GreenfootImage(String.valueOf(planetNumber), 24, new Color(0, 255, 128), new Color(0, 0, 0, 0));
   GreenfootImage image = new GreenfootImage(textImage.getWidth()+12, 36);
    
  
   Rocket s=getRocket();
   Aliens alien=new Aliens();
    GifImage planet= new GifImage("alienPlanet1.gif");
     GifImage nplanet= new GifImage("nplanet.gif");
     GifImage cplanet= new GifImage("planet.gif");
    String name;
    //Actor alien = getOneObjectAtOffset(0,0, Aliens.class);  
    /**
     * Act - do whatever the AlienPlanet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    
    public AlienPlanet(int planetNumber,HashMap<Integer,Integer> adjMatrix,int xLoc,int yLoc, String s){
        super();
        this.xLoc=xLoc;
        this.yLoc=yLoc;
        this.planetNumber=planetNumber;
        this.neighbourMatrix=adjMatrix;
         image.setColor(new Color(196, 196, 0));
         image.fill();
         image.setColor(new Color(0, 0, 196));
         image.fillRect(3, 3, image.getWidth()-6, 30);
         image.drawImage(textImage, xLoc, yLoc);
         name=s;
     
    }
    public void act() 
    {  
         GameWorld g=(GameWorld) getWorld();
         if(isClickable && !isCaptured)
         {
             setImage(nplanet.getCurrentImage());
             
          }
          else if(isCaptured)
          {
              setImage(cplanet.getCurrentImage());
              
          }
          else
          {
            setImage(planet.getCurrentImage());
          }
        
        if(g.getMaxFuel()<= 0)
        {
             Greenfoot.setWorld(new Over());
        }
        else if(g.checkAllCaptured()){
             World newWorld = new WinWorld();
             Greenfoot.setWorld(newWorld);
        
        }
        else
        {
            capture();
            
            
         
        }
    }    
    
    public void capture()
    {     
     
          GameWorld g=(GameWorld) getWorld();
             SpaceShip s=g.getSpaceShip();
         if(Greenfoot.mouseClicked(this))
         {   if(isClickable){
             if(isCaptured){
              
             
             g.selectedPlanetId=planetNumber;
             g.isSourceSelected=true;
           if(g.atPlanet.equals(this.name)){}else{
           for(Planet p:g.planet[Integer.parseInt(g.atPlanet.substring(0,1))][Integer.parseInt(g.atPlanet.substring(1))].path){
                 if(p.getName().equals(this.getName())){
                    s.setDestination(g.planet[Integer.parseInt(g.atPlanet.substring(0,1))][Integer.parseInt(g.atPlanet.substring(1))].path,this);
                    g.setPlanet(name);
                    return;
                }
                
            }
                for(Planet p:this.path){
                    if(p.getName().equals(g.atPlanet)){
                    s.setDestination(this.path,g.planet[Integer.parseInt(g.atPlanet.substring(0,1))][Integer.parseInt(g.atPlanet.substring(1))],this);
                    g.setPlanet(name);
                    return;
                }
                }
                    s.setEarth(g.planet[Integer.parseInt(g.atPlanet.substring(0,1))][Integer.parseInt(g.atPlanet.substring(1))].path);
                    g.setPlanet("10");
                    s.setDestination(this.path);
            
             super.path.add(this);
                
             g.setPlanet(name);
            }
         }
             else if((!isCaptured)&&(g.isSourceSelected)&&(neighbourMatrix.containsKey(g.selectedPlanetId))){
            //GreenfootImage myImage = new GreenfootImage("BluePlanet.png");
            //setImage(myImage);
            Greenfoot.playSound("explosion.wav"); 
            isCaptured=true;
             g.removeObject(alien);
           //  g.addObject(s,xLoc,yLoc-40);
             g.updatePlanetCount();
             
             int wieght=neighbourMatrix.get(g.selectedPlanetId);
             g.updateScore(wieght);
             g.isSourceSelected=false;
            Set<Integer> keys=neighbourMatrix.keySet();
            for(Integer k:keys){
             g.activateNeighbour(k);
            
            }
             for(Planet p:g.planet[Integer.parseInt(g.atPlanet.substring(0,1))][Integer.parseInt(g.atPlanet.substring(1))].path){
                 super.path.add(p);
            }
            
             super.path.add(this);
            /* for(int i=g.planet[Integer.parseInt(g.atPlanet.substring(0,1))][Integer.parseInt(g.atPlanet.substring(1))].path.size()-1;i>=0;i--){
                 super.path.add(g.planet[Integer.parseInt(g.atPlanet.substring(0,1))][Integer.parseInt(g.atPlanet.substring(1))].path.get(i));
                } */
             s.setDestination(this);
             super.isVisited=true;
             g.setPlanet(name);
            }
            
         }
        }
        
    }
  public String getName(){
        return this.name;
    }
  public Rocket getRocket(){
    Rocket ss=new Rocket(planetNumber);
    return ss;
   
    } 
    
 public void alienGrow()
 {
    GameWorld g=(GameWorld) getWorld();
   // g.addObject(alien,xLoc, yLoc-40);
   
 }  
   

    
   
}
