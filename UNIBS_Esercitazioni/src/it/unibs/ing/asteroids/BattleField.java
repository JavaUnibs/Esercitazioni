package it.unibs.ing.asteroids;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class BattleField implements Space {

	protected ArrayList<SpaceObject> objects;
	protected SpaceShip ship;
	protected Rectangle2D.Float borders;
	
	public BattleField(){
		objects= new ArrayList<SpaceObject>();
		this.borders = new Rectangle2D.Float(-500f, -500f, 1000f, 1000f);
		ship= new SpaceShip();
		objects.add(ship);
		
	}
	
	void stepNext(){
		for(SpaceObject o: objects){
			o.stepNext();
			applyClosedUniverse(o);
		}
	}
	
	private void applyClosedUniverse(SpaceObject o){
		
	}
	
}
