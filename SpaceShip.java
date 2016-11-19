import greenfoot.*; 
 
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
    public SpaceShip()
    {
        GreenfootImage image = getImage() ;
        image.scale(100,80) ;
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
                }
                
        
       /* if(Greenfoot.mouseDragged(this)) {          
            MouseInfo mouse = Greenfoot.getMouseInfo();  
            mouseX=mouse.getX();  
            mouseY=mouse.getY();  
            setLocation(mouseX, mouseY);  
        }
         
        if(move)
        {
             if(getY()<380 && getX()<380 )
             {
                // setRotation((int) (180*Math.atan2(380 - getY(), 380 - getX()) / Math.PI));
                 move(1);
                 setLocation(getX()+ 10, getY()-10);
             }
        }*/
    }  
    public void setDestination(int x,int y){
        dX=x;
        dY=y;
    }
    public void appear()
    {
        //To do code
       // if(getY()<560 && getX()<700 )
    
        
    }
    
    public void disappear()
    {
        //To do code
    }
    
    public void travel()
    {
        //To do code
    }
    
}
