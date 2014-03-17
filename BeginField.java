
public class BeginField implements State {
	private CSVStateMachine machine;
	
	public BeginField(CSVStateMachine machine) {
		this.machine = machine;
	}
	
	public void foundQuote() {
		machine.setState(machine.getQuotedField());
	}
	
	public void foundComma() {
		foundOther();
	}
	
	public void foundOther() {
		machine.setState(machine.getUnquotedField());
	}
	
	
}
