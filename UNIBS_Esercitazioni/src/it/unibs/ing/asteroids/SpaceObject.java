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
		speed[0] = (float)(speed[0]+ linearAcc * Math.cos(position[2]));
		speed[1] = (float)(speed[1]+ linearAcc * Math.sin(position[2]));
	}
	
	public void move(){
		for(int i=0;i<3;i++){
			position[i]+=speed[i];
		}
		
	}
	
	public void turn(float d){
		position[2]+=d;
	}
	
	public String toString(){
		return String.format("Pos: %f, %f -Speed: %f, %f - Dir: %f", getX(), getY(), getSpeedX(), getSpeedY(), getR());
	}
	
	public Shape getShape(){
		AffineTransform t =new AffineTransform();
		t.translate(position[0], position[1]);
		t.rotate(position[2]);
		return t.createTransformedShape(shape);
		
	}
	
	public void stepNext(){
		move();
		
	}
	
	public void setSpeed(float[] speed) {
		this.speed = speed;
	}
	
}










