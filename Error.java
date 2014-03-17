
public class Error implements State {
	private CSVStateMachine machine;
	
	public Error(CSVStateMachine machine) {
		this.machine = machine;
	}
	
	public void foundComma() {
		machine.setState(machine.getBeginField());
	}
	
	public void foundQuote() {
		foundOther();
	}
	
	public void foundOther() {
		machine.setState(machine.getError());
	}
	
}