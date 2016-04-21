import javax.swing.JOptionPane;

public class GetInput {

	private GetInput() {}
	
	public static String getInput(){
		return JOptionPane.showInputDialog("Enter some text:");
	}

}
