import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;


public class CSVClient {
	
	public CSVClient() throws FileNotFoundException {
		CSVStateMachine machine = new CSVStateMachine();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter comple file path to CSV text file");
		String path = sc.nextLine();
		
		File file = new File(path);
		Scanner scan = new Scanner(file);
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			List<String> list = machine.validate(line);
			System.out.println(list);
			/*for (String str : list) {
				System.out.println(str);
			}*/
			
		}
	}
}	
