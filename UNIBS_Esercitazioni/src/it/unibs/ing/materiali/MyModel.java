package it.unibs.ing.materiali;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


public class MyModel {
	Color currentColor;
	
	HashMap<String, Color> colors; 
	
	public MyModel(){
		colors = new HashMap<String, Color>();
		addColor("nero", Color.black);
		addColor("blu", Color.blue);
		addColor("verde", Color.green);
		
	}
	public Color getCurrentColor() {
		return currentColor;
	}
	
	public void setCurrentColor(String s){
		setCurrentColor(colors.get(s));
	
	}

	public void setCurrentColor(Color currentColor) {
		this.currentColor = currentColor;
		fireCurrentColorChanged();
	}
	
	public Collection<Color> getColors(){
		return colors.values();
	}
	
	public void addColor(String name, Color value){
		colors.put(name, 
				new Color(value.getRGB()){
			public String toString(){
				return name;
			}
		});
	}
	
	private ArrayList<CurrentColorChangeListener> currentColorChangeListeners= new ArrayList<CurrentColorChangeListener>();
	
	public void addCurrentColorChangeListener(
			CurrentColorChangeListener listener){
		    currentColorChangeListeners.add(listener);
	}
	
	private void fireCurrentColorChanged(){
			for(CurrentColorChangeListener l: currentColorChangeListeners)
				l.currentColorChanged(currentColor);
	}
	
	
}
