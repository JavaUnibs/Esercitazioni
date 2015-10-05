package it.unibs.ing.materiali;
import java.awt.Color;

public class ColorName{
		private String name;
		private Color color;
		
		public ColorName(String _name, Color _color){
		name=_name;
		color=_color;
		}
		
		public Color getColor(){
			return color;
		}
		
		public String toString(){
			return name;
		}
	}