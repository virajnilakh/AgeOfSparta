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
    public HomePlanet(String s)
    {
       super.path.add(this);
        name=s;
       
     //   this.getImage().scale(2000,2000);
    }
    
    /**
     * Act - do whatever the HomePlanet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
        // Add your action code here.
       // getWorld().addObject(new Marker(),550,100);
        setImage(planet.getCurrentImage());
    }    
}
