package it.unibs.ing.asteroids;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.geom.Area;

public class SpaceShip extends SpaceObject{
	
	public SpaceShip(Space space){
		super(space);
		this.shape= new Area(new Polygon(
			new int[] {-30, 30, -30},
			new int[] {15, 0, -15},

				3));
	    this.setR((float) Math.PI/2);
		this.color=Color.WHITE;
		this.isShip=true;
	}
	
	public void fire(){
		Bullet b = new Bullet(this, 5 , 100);
		space.add(b);
	}
	
	
	public boolean checkCollision(SpaceObject o){
		return (o instanceof Bullet&& this.equals(((Bullet)o).ship))? false: super.checkCollision(o);
	}
	

}
