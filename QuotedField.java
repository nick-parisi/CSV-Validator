
public class QuotedField implements State {
	private CSVStateMachine machine;
	
	public QuotedField(CSVStateMachine machine) {
		this.machine = machine;
	}
	
	public void foundQuote() {
		machine.setState(machine.getSeenAQuote());
	}
	
	public void foundComma() {
		foundOther();
	}
	
	public void foundOther() {
		machine.setState(machine.getQuotedField());
	}
	
}