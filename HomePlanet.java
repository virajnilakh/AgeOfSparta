import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class HomePlanet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HomePlanet extends Planet
{
    GifImage planet= new GifImage("planet.gif");
    String name;
    public HomePlanet()
    {
       
     //   this.getImage().scale(2000,2000);
    }
    public HomePlanet(int planetNumber,HashMap<Integer,Integer> adjMatrix,int xLoc,int yLoc,String s){
     super();
        this.xLoc=xLoc;
        this.yLoc=yLoc;
        this.planetNumber=planetNumber;
        this.neighbourMatrix=adjMatrix;
        this.isClickable=true;
        this.isCaptured=true;
        super.path.add(this);
        name=s;
        super.isVisited=true;
       setImage(planet.getCurrentImage());
       
    
    }
    /**
     * Act - do whatever the HomePlanet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
        
        capture();
        setImage(planet.getCurrentImage());
    } 
    public String getName(){
        return this.name;
    }
    public void capture()
    { GameWorld g=(GameWorld) getWorld();
          SpaceShip s=g.getSpaceShip();
              if(Greenfoot.mouseClicked(this))
         {   
             s.setEarth(g.planet[Integer.parseInt(g.atPlanet.substring(0,1))][Integer.parseInt(g.atPlanet.substring(1))].path);
                  
             g.setPlanet(name);
             g.selectedPlanetId=planetNumber;
             g.isSourceSelected=true;
            
             
            
         }
            
            Set<Integer> keys=neighbourMatrix.keySet();
            for(Integer k:keys){
             g.activateNeighbour(k);
       
    }
    
 
    
    }
   
}
