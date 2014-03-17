import java.util.ArrayList;
import java.util.List;


public class CSVStateMachine {
	private State BeginField;
	private State UnquotedField;
	private State Error;
	private State SeenAQuote;
	private State QuotedField;
	
	private State state;
	
	
	
	
	public CSVStateMachine() {
		BeginField = new BeginField(this);
		UnquotedField = new UnquotedField(this);
		Error = new Error(this);
		SeenAQuote = new SeenAQuote(this);
		QuotedField = new QuotedField(this);
		state = BeginField;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public List<String> validate(String str) {
		//List of valid values
		List<String> list = new ArrayList<String>();
		
		//List of currently constructed value
		List<Character> chars = new ArrayList<Character>();
		
		
		
		//now loop
		for (int i = 0; i < str.length(); i++) {
			boolean err = true; //error state not visited
			if (state == Error) { err = false; } //we are in the error state
			
			Character c = str.charAt(i);
			if (c.equals(',')) { state.foundComma(); }
			else if (c.equals('"')) { state.foundQuote(); }
			else { state.foundOther(); }
			
			
			if (state == BeginField) {
				//end of word, if error state not visited then keep
				if (err) {
					String valid = generateString(chars);
					list.add(valid);
				}
				chars = new ArrayList<Character>(); //flush the list
			}
			else {
				chars.add(c);
			}
			
			//write in last string (won't have a comma at end to bring back to begin state)
			if (i == str.length() - 1) {
				if (err) {
					String valid = generateString(chars);
					list.add(valid);
				}
				//reset state
				state = getBeginField();
			}
			
		}
		return list;
		
		
		
	}
	
	public String generateString(List<Character> chars) {
		StringBuilder builder = new StringBuilder(chars.size());
		for (Character ch : chars) {
			builder.append(ch);
		}
		return builder.toString();
	}
	
	
	public State getState() { return state; }
	public State getBeginField() { return BeginField; }
	public State getUnquotedField() { return UnquotedField; }
	public State getError() { return Error; }
	public State getSeenAQuote() { return SeenAQuote; }
	public State getQuotedField() { return QuotedField; }
	//public List<String> getValues() { return list; }
}
