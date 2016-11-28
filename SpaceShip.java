import greenfoot.*; 
 import java.util.*;
/**
 * Write a description of class SpaceShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpaceShip extends Actor implements movableObjects
{
   int start;
    int end;
    public boolean move;
    int mouseX, mouseY ;
    int dX;
    int dY;
    GameWorld g=(GameWorld) getWorld();
    boolean signal=true;
    public SpaceShip()
    {   
        GreenfootImage image = getImage() ;
        image.scale(50,50) ;
       
        dX=120;
        dY=400;
    }
    public void act() 
    {
        while(this.getX()!=this.dX || this.getY()!=dY){
                if(this.dX>this.getX()){
                     
                    setLocation(getX()+1,getY());
                    }
                    if(this.dX<this.getX()){
                    setLocation(getX()-1,getY());
                    }
                   if(this.dY>this.getY()){
                    setLocation(getX(),getY()+1);
                    }
                    if(this.dY<this.getY()){
                    setLocation(getX(),getY()-1);
                    }
                    if(this.getX()==this.dX && this.getY()==dY){
                        signal=false;
                    }
                    Greenfoot.delay(1);
               }
    //
       
    }  
    public void setDestination(ArrayList<Planet> a,Planet from,Planet to){
        boolean start=false;
        for(Planet p:a){
            if(from.getName().equals(p.getName())){
                start=true;
            }
            if(start){
            while(signal){
                dX=p.getX();
                dY=p.getY();
                act();
                if(this.getX()==this.dX && this.getY()==dY){
                        signal=false;
                    }
            }
            
            Greenfoot.delay(10);
            signal=true;
            if(to.getName().equals(p.getName())){
                return;
            }
        }
    }
    }
    
    public void setDestination(Planet p){
       /*for(Planet p:a){
            while(signal){
                dX=p.getX();
                dY=p.getY();
                act();
                if(this.getX()==this.dX && this.getY()==dY){
                        signal=false;
                    }
            }
            
            Greenfoot.delay(10);
            signal=true;
        }*/
        dX=p.getX();
        dY=p.getY();
       /*  for(int i=a.size()-2;i>=0;i--){
            while(signal){
                dX=a.get(i).getX();
                dY=a.get(i).getY();
                act();
                if(this.getX()==this.dX && this.getY()==dY){
                        signal=false;
                    }
            }
            Greenfoot.delay(10);
            signal=true;
        } */
    }
    public void setDestination(ArrayList<Planet> a,Planet p){
    for(int i=a.size()-1;i>=0;i--){
            while(signal){
                dX=a.get(i).getX();
                dY=a.get(i).getY();
                act();
                if(this.getX()==this.dX && this.getY()==dY){
                        signal=false;
                    }
            }
            Greenfoot.delay(10);
            signal=true;
            if(p.getName().equals(a.get(i).getName())){
                break;
            }
        }
    }
    public void setDestination(ArrayList<Planet> a){
        for(Planet p:a){
            while(signal){
                dX=p.getX();
                dY=p.getY();
                act();
                if(this.getX()==this.dX && this.getY()==dY){
                        signal=false;
                    }
            }
            
            Greenfoot.delay(10);
            signal=true;
        }
    }
    public void setEarth(ArrayList<Planet> a){
        for(int i=a.size()-1;i>=0;i--){
            while(signal){
                dX=a.get(i).getX();
                dY=a.get(i).getY();
                act();
                if(this.getX()==this.dX && this.getY()==dY){
                        signal=false;
                    }
            }
            Greenfoot.delay(10);
            signal=true;
    }
}
    public void appear()
    {
        
    }
    
    public void disappear()
    {
        //To do code
    }
    
    public void travel(int xLoc,int yLoc)
    {
        
     
    }
    
}
