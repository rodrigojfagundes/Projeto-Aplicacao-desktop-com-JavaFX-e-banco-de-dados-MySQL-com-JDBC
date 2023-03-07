package gui.util;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class Utils {

	//funcao q retorna o STAGE/PALCO/TELA atual
	public static Stage currentStage(ActionEvent event) {
		//implementacao para pegar o STAGE a partir do OBJ de EVENT
		//pegando a SCENA e dps pegando a JANELA/WINDOW
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
