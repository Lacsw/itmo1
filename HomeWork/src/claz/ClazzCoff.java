package claz;

import java.io.IOException;
import javax.servlet.http.*;

public class ClazzCoff {

	public String name;			
	public double cost;				
	public double volume;			

	public ClazzCoff() {
	}

	public String getName() {
		return name;
	}
	
	public double getCost() {
		return cost;
	}
	
	public double getVolume() {
		return volume;
	}
	
	public void setName(String iName) {
		name = iName;
	}
	
	public void setCost(double iCost) {
		cost = iCost;
	}
	
	public void setVolume(double iVolume) {
		volume = iVolume;
	} 
	
}