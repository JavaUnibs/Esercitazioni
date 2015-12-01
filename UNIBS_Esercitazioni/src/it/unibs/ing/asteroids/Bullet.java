package it.unibs.ing.asteroids;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Bullet extends SpaceObject{
	
	SpaceShip ship;
	float fuel;
	
	public Bullet(SpaceShip ship, float acceleration, float fuel){
		super(ship.space);
		maxSpeed= new float[]{20, 20, 20};
		this.fuel=fuel;
		this.ship=ship;
		this.shape=new Area(new Polygon(
				new int[]{-5, 0, 5, 0, -5},
				new int[]{3, 3, 0, -3, -3}, 5));
					
		this.setPosition(ship.getX(), ship.getY(), ship.getR());	
		this.setSpeed(ship.getSpeedX(), ship.getSpeedY(), 0);
		this.accelerate(acceleration);
		this.color=Color.RED;
		}

      public boolean checkCollision(SpaceObject o){

    	  return (ship!=null && ship.equals(o)) ? false:
    		  o instanceof Bullet? false: super.checkCollision(o);
      }
      
      public void stepNext(){
    	  super.stepNext();
    	  if(--fuel<=0) isAlive=false;
      }
}
