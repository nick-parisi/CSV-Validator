
public class UnquotedField implements State {
	private CSVStateMachine machine;
	
	public UnquotedField(CSVStateMachine machine) {
		this.machine = machine;
	}
	
	public void foundQuote() {
		machine.setState(machine.getError());
	}
	
	public void foundComma() {
		machine.setState(machine.getBeginField());
	}
	
	public void foundOther() {
		machine.setState(machine.getUnquotedField());
	}
	
}