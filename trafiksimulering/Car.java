import java.io.IOException;



public class Car {

    private int bornTime;
    private CarPosition destination; 

    private CarPosition currentPosition;
    
   
    public void step(){
      	// Uppdatera bilen ett tidssteg
    }
    public Car(int Time, CarPosition dest, CarPosition startingPos){
    	this.bornTime = Time;
    	this.destination = dest;
    	this.currentPosition = startingPos; 
    			
    }
    public CarPosition getDestination() {
    	return this.destination;
    }
    public CarPosition getCurrent_position(){
    	return this.currentPosition;
    }
    public void setDestination(CarPosition dest) throws Exception{
    	if(dest == null){
    		throw new Exception("Must have a valid destination");
    		}
    	this.destination = dest;
    }
    public void setPos(CarPosition pos) throws Exception{
    	if(pos == null){
    		throw new Exception("Must have a valid Position");
    		}
    	this.currentPosition = pos;
    }
    // konstruktor och get- oct set-metoder
    //...

    public String toString(){
    	
    	return "Car(Destination: " + this.destination + " \n Car(current position: " + this.currentPosition + ")\n";
    	}

}
