package it.unibs.ing.asteroids;

import java.awt.*;
import java.awt.geom.*;

public class SpaceObject {

	public Color color;
	public String name;
	public Area shape;
	float[] position ={0, 0, 0}; //x, y, r
	float[] speed ={0, 0, 0}; //x, y, r
	float[] maxSpeed ={10, 10, 1}; //x, y, r
	
	public float getX(){ return position[0];}
	public float getY(){ return position[1];}
	public float getR(){ return position[2];}
	
	public void setX(float x){ position[0]=x;}
	public void setY(float y){ position[1]=y;}
	public void setR(float r){ position[2]=r;}
	
	
	public void setPosition(float x, float y, float r){
		position[0] = x;
		position[1] = y;
		position[2] = r;
	}
	
	public float getSpeedX(){ return speed[0];}
	public float getSpeedY(){ return speed[1];}
	public float getSpeedR(){ return speed[2];}
	
	
	
	
	public void accelerate(float linearAcc){
		
	}
	
	public void move(){
		for(int i=0;i<3;i++){
			position[i]+=speed[i];
		}
		
	}
	
	
}









