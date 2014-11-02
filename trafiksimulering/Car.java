import java.io.IOException;
import java.util.Scanner;  


public class Car {

    private int bornTime;
    private CarPosition destination; 

    private CarPosition currentPosition;
    
   
    public void step(){
    	if(currentPosition.moveForward()){
    	 setCurrentPosition(currentPosition.getForward());
    	 
     }
      	// Uppdatera bilen ett tidssteg
    }
    public Car(int bornTime, CarPosition dest, CarPosition startingPos){
    	this.bornTime = bornTime;
    	destination = dest;
    	currentPosition = startingPos; 
    			
    }
    public CarPosition getDestination() {
    	return destination;
    }
    public CarPosition getCurrent_position(){
    	return currentPosition;
    }
    public void setDestination(CarPosition dest){
    	this.destination = dest;
    }
    public void setCurrentPosition(CarPosition pos){
    	this.currentPosition = pos;
    }
    // konstruktor och get- oct set-metoder
    //...

    public String toString(){
    	
    	return "Car(Born Time: " + bornTime + ") Car(Destination: " + destination + "  Car(current position: " + currentPosition + ") ";
    	}
   // public static void main(String args[]){
    //	System.out.println("Vi gör en bil");
    //	Car bob = new Car(null, null);
    //	System.out.println(bob);
   // }
}