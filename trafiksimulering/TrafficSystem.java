import java.util.Random;

public class TrafficSystem {
    // Definierar de vägar och signaler som ingår i det 
	private int TotalCarTime = 0;
	private int AvarageCarTime = 0; // system som skall studeras.
	private int Cars = 0;
	private int lowTime;
	private int longTime = 0;
   // Samlar statistik
    
    // Attribut som beskriver beståndsdelarna i systemet
    private Lane  r0;
    private Lane  r1;
    private Lane  r2;
    private Light s1;
    private Light s2;
    private int Ankomstintesitet;
    private int NextCar = 0;
    // Diverse attribut för simuleringsparametrar (ankomstintensiteter,
    // destinationer...)

    // Diverse attribut för statistiksamling
    //....    
    
    private int time = 0;
    
    
    public void nextcar(int n){
    	Random rand = new Random();
		int Ai = rand.nextInt(n)+1;
		this.NextCar = Ai;
	}
	public TrafficSystem(int r0,  int r, int s1Period, int s1Green, int s2Period, int s2Green, int Ankomstintensitet){
		
    	this.r0 = new Lane(r0);
    	this.r1 = new Lane(r);
    	this.r2 = new Lane(r);
    	this.r2.firstSpot().setTurn(1);
    	this.s1 = new Light(s1Period,s1Green);
    	this.s2 = new Light(s2Period,s2Green);
    	this.Ankomstintesitet = Ankomstintensitet;
    	nextcar(this.Ankomstintesitet);
    	
    	
    	//...
    	}
	
	
	public Car CreateCar(){
		Random rand = new Random();
		int Dest = rand.nextInt(2);
		
		if(Dest == 1){
			return  new Car(time, 1, r0.lastSpot());
		}else {
			return  new Car(time, 0, r0.lastSpot());
		}	
	}
	public void AvarageTime(){
		AvarageCarTime = TotalCarTime/getCars();
	}
	public int carTime(Car c){
		return this.time - c.getBornTime(); 
	} 
    public void readParameters() {
	// Läser in parametrar för simuleringen
	// Metoden kan läsa från terminalfönster, dialogrutor
	// eller från en parameterfil. Det sista alternativet
	// är att föredra vid uttestning av programmet eftersom
	// man inte då behöver mata in värdena vid varje körning.
        // Standardklassen Properties är användbar för detta. 
    }

    public void step() {
    	if(s1.isGreen()){
    		Car tmp1 = r1.getFirst();
    		if(tmp1 != null){
    			setCars(getCars() + 1);
    			TotalCarTime = TotalCarTime + carTime(tmp1);
    			
    			if(getCars() == 0 || carTime(tmp1) < lowTime){
    				lowTime = carTime(tmp1);
    				
    			}
    			if(carTime(tmp1) > longTime){
        			longTime = carTime(tmp1);
        			
    			}
    		}
    	}
    	if(s2.isGreen()){
    		Car tmp2 = r2.getFirst();
    		if(tmp2 != null){
    			setCars(getCars() + 1);
    			TotalCarTime = TotalCarTime + carTime(tmp2);
    			if(getCars() == 0 || carTime(tmp2) < lowTime){
    				lowTime = carTime(tmp2);
    			}
    			if(carTime(tmp2) > longTime){
    			longTime = carTime(tmp2);	
    			}
    		}
    	}
    	
    	r1.step();
    	r2.step();
    	
    	if(r0.firstCar() != null){
    		if(r0.firstCar().getDestination() <= 0){
    		r1.putLast(r0.getFirst());
    		}
    	
    		else{    		
    			r2.putLast(r0.getFirst());
    			}
    		}
    	
    	
    	r0.step();
    	
    	if(this.NextCar != 0){
    		this.NextCar--;
    	}else{ 
    		if(r0.lastFree()){
    		r0.putLast(CreateCar());
    		nextcar(Ankomstintesitet);
    		}
    	}
    	
    	
    	
    	
    	s1.step();
    	s2.step();
    	this.time++;
    	
    }
    	
	// Stega systemet ett tidssteg m h a komponenternas step-metoder
	// Skapa bilar, lägg in och ta ur på de olika Lane-kompenenterna
    

    public void printStatistics() {
	// Skriv statistiken samlad så här långt
    }

    public void print() {
    	String s =r1.toString() + r0.toString() + "\n" + r2.toString();
    	System.out.println(s);
	// Skriv ut en grafisk representation av kösituationen
	// med hjälp av klassernas toString-metoder
    }
	public int getCars() {
		return Cars;
	}
	public void setCars(int cars) {
		Cars = cars;
	}

}