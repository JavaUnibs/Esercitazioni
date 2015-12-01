package it.unibs.ing.asteroids;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

public class BattleField implements Space {

	protected ArrayList<SpaceObject> objects;
	protected SpaceShip ship;
	protected Rectangle2D.Float borders;
	
	public BattleField(){
		objects= new ArrayList<SpaceObject>();
		this.borders = new Rectangle2D.Float(-500f, -500f, 1000f, 1000f);
		ship= new SpaceShip(this);
		objects.add(ship);
		objects.add(newAsteroid(50, -400, -400, 1f, 1f, 0.1f));
		objects.add(newAsteroid(60, -300, 300, 1f, -1f, -0.5f));
		objects.add(newAsteroid(80, 150, -150, -1f, 1f, -0.4f));
		objects.add(newAsteroid(40, 200, 200, -1f, -1f, 0.7f));
		
	}
	
	private Asteroid newAsteroid(int radius, int x, int y, float sx, float sy, float sr ){
		Asteroid o = new Asteroid( this, radius);
		o.setPosition(x, y, 0);
		o.setSpeed(sx, sy, sr);
		return o;
	}
	void stepNext(){
		for(SpaceObject o: objects){
			o.stepNext();
			applyClosedUniverse(o);
		}
		
		detectCollisions();
		removeDust();
	}
	
	private void removeDust(){
		ArrayList<SpaceObject> dust = new ArrayList<SpaceObject>();
		objects.forEach(o -> {if(!o.isAlive) dust.add(o); });
		dust.forEach(objects::remove);
		if(!objects.contains(ship)){
			ship=null;
		}

		
		
	}
	
	private void detectCollisions(){
		int nobjs= objects.size();
		if(nobjs <2) return;
		SpaceObject[] objs= new SpaceObject[nobjs];
		objects.toArray(objs);
		for(int i=0;i<nobjs;i++){
			for(int j=i+1;j<nobjs;j++){
			if(objs[i].checkCollision(objs[j])){
				if(objs[i] instanceof Asteroid&&objs[j] instanceof Asteroid){
					objs[i].setSpeed(-objs[i].getSpeedX(), -objs[i].getSpeedY(), objs[i].getSpeedR());
				    objs[j].setSpeed(-objs[j].getSpeedX(), -objs[j].getSpeedY(), objs[j].getSpeedR());
				}
			    else {
			objs[i].collision();
			objs[j].collision();
			
			    }
			
			}
		}
	}
		
	}
	
	private void applyClosedUniverse(SpaceObject o){
		
		if(o.getX() >borders.getMaxX()) o.setX((float)borders.getMinX());
		else if(o.getX()< borders.getMinX()) o.setX((float)borders.getMaxX());
		if(o.getY() >borders.getMaxY()) o.setY((float)borders.getMinY());
		else if(o.getY()< borders.getMinY()) o.setY((float)borders.getMaxY());
		
	}
	
	public String toString(){
		return ship !=null? ship.toString() : "";
	}

	@Override
	public void add(SpaceObject o) {
		objects.add(o);
		
	}
	
	}
	

