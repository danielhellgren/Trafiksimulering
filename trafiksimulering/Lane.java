public class Lane {

    public static class OverflowException extends RuntimeException {
       public OverflowException() { 
    	   super();
       }
       public OverflowException(String message) { 
    	   super(message); 
       }
  
       
        // Undantag som kastas när det inte gick att lägga 
        // in en ny bil på vägen
    }

    protected CarPosition[] theLane;

    public Lane(int n) {
    	theLane = new CarPosition[n];
    	for(int i = n; i > 0; i--){
    		theLane[i].setForward(theLane[i-1]);
    	}
	// Konstruerar ett Lane-objekt med plats för n fordon
    // Samt länker ihop varje CarPosition med forward för den framför
    }
    
    public boolean matchEnd(CarPosition target)
    {
    	if(theLane[0] == target)
    		return true;
    	else
    		return false;
    }
    
    public int getLength(){
    	return theLane.length;
    }
    
    public void setParallel(Lane sideLane)
    {
    	int i = 0;
    	
    	while(i < sideLane.getLength() && i < theLane.length)
    	{
    		theLane[i].setTurn(sideLane.theLane[i]);
    		i++;
    	}
    }

    public void step() {
    	
    	int i = 1;
    	if(theLane[0].getCurrentCar() != null){
    		getFirst();
    	}
    	while(i <= getLength()){
    		if(theLane[i].getCurrentCar() != null && theLane[i].moveForward()){
    			theLane[i].getCurrentCar().step();
    			theLane[i].setCurrentCar(null);
    		}
    		i++;
    	}
    	
	// Stega fram alla fordon (utom det på plats 0) ett steg 
        // (om det går). (Fordonet på plats 0 tas bort utifrån 
	// mm h a metoden nedan.)
    }
    public CarPosition firstSpot(){
    	CarPosition first = theLane[0];
    	return first;
    }
    
    public CarPosition lastSpot(){
    	int i = getLength();
    	return theLane[i];
    }
    
    public Car getFirst() {
    	Car First = theLane[0].getCurrentCar();
    	theLane[0].setCurrentCar(null);
    	return First;
	// Returnera och tag bort bilen som står först
    }

    public Car firstCar() {
    	return theLane[0].getCurrentCar();
	// Returnera bilen som står först utan att ta bort den
    }

   
    
    public boolean lastFree() {
    	int i = getLength();
    	return (theLane[i].getCurrentCar() == null);
	// Returnera true om sista platsen ledig, annars false
    }

    public void putLast(Car c) throws OverflowException {
    	if(!lastFree()){ 
    		throw new OverflowException("The position is occupied"); 
    	} else {
    		int i = getLength();
    		theLane[i].setCurrentCar(c);
    	}
    	// Ställ en bil på sista platsen på vägen
    	// (om det går).
    }			

    public String toString() {
    	int i = getLength();
    	String s = null;
    	while(i>=0){
    		s =  s + "theLane(" + theLane[i].getCurrentCar().toString() + ")\n";
    		i++;
    	}
    	return s;
    	//...
    	}

}