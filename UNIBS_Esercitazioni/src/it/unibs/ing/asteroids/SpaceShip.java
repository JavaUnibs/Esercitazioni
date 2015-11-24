package it.unibs.ing.asteroids;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.geom.Area;

public class SpaceShip extends SpaceObject{
	
	public SpaceShip(){
		super();
		this.shape= new Area(new Polygon(
			new int[] {-30, 30, -30},
			new int[] {15, 0, -15},

				3));
	    this.setR((float) Math.PI/2);
		this.color=Color.WHITE;
		this.isShip=true;
	}
	
	
	
	
	

}
