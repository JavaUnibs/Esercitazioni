package it.unibs.ing.asteroids;
import java.awt.Color;
import java.awt.Polygon;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import java.util.Random;

import it.unibs.ing.myutility.*;


public class Asteroid extends SpaceObject {
	Random rdm= new Random();
	
	public Asteroid(Space space, int radius){
		super(space);
		this.shape=new Area(CreateRandomShape(radius, 10+rdm.nextInt(5)));
		this.color=Color.GREEN;
		this.isShip=false;
		
		
		
	}
	
	private GeneralPath CreateRandomShape(float radius, int nvertex){
		GeneralPath s = new GeneralPath();
		float dt= (float) Math.PI * 2/ nvertex;
		float t=0;
		for (int i=0;i<nvertex;i++){
			float r = Math.min(radius/2, radius *(1+rdm.nextFloat()/10));
			float x = (float) (r* Math.cos(t));
			float y = (float) (r* Math.sin(t));
			t+=dt;
			if(i==0)
				s.moveTo(x, y);
			else
				switch(rdm.nextInt(3)){
				case 0: s.lineTo(x, y);
				break;
				case 1: s.curveTo(
						x*(1+(2-rdm.nextDouble())/5),
						y*(1+(2-rdm.nextDouble())/5),
						x*(1+(2-rdm.nextDouble())/5),
						y*(1+(2-rdm.nextDouble())/5),
						x,
						y);
				break;
				case 2: s.quadTo(
						x*(1+(2-rdm.nextDouble())/5),
						y*(1+(2-rdm.nextDouble())/5),
						x, 
						y);
						
				}
		}
		
		s.closePath();
		return s;
		
	}

}
