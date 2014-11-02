


// Håller i en bil och känner till sina "grannar". 
public class CarPosition{
	
	private Car currentCar = null; // null om ingen bil finns på positionen
	
	private Lane owner;
	
	private CarPosition forward;
	private CarPosition turn;
	
	public CarPosition(Lane a_Owner){
		
		owner = a_Owner;
	}
	
	public boolean isEnd(CarPosition target){
		
		return owner.matchEnd(target);
	}
	
	public boolean moveForward(){
		
		return (getForward().getCurrentCar() == null);
	
		// Flytta bilen fram till forward
	}
	
	public boolean turn()	{
		
		return (turn.getCurrentCar() == null);
		// Flytta bilen till turn
	}

	public void setTurn(CarPosition turn) {
		this.turn = turn;
	}

	public CarPosition getTurn() {
		return this.turn;
	}

	public Car getCurrentCar() {
		return currentCar;
	}

	public void setCurrentCar(Car currentCar) {
		this.currentCar = currentCar;
	}

	public CarPosition getForward() {
		return forward;
	}

	public void setForward(CarPosition forward) {
		this.forward = forward;
	}

	
		
	
	
	
}
