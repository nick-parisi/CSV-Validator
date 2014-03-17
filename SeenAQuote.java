
public class SeenAQuote implements State {
	private CSVStateMachine machine;
	
	public SeenAQuote(CSVStateMachine machine) {
		this.machine = machine;
	}
	
	public void foundQuote() {
		machine.setState(machine.getQuotedField());
	}
	
	public void foundComma() {
		machine.setState(machine.getBeginField());
	}
	
	public void foundOther() {
		machine.setState(machine.getError());
	}
	
	
}