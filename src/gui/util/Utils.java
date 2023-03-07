package gui.util;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

//classe utilitaria, q serve para RETORNAR o STAGE/PALCO atual
//ou SEJA em QUAL TELA esta aberta atualmente no software
public class Utils {
	
	public static Stage currentStage(ActionEvent event) {
		return (Stage)((Node)event.getSource()).getScene().getWindow();
	}
	
	public static Integer tryParseToInt(String str) {
		try {
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			return null;
		}
	}
	
}
