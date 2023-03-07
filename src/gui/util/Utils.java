package gui.util;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

//classe utilitaria, q serve para RETORNAR o STAGE/PALCO atual
//ou SEJA em QUAL TELA esta aberta atualmente no software
public class Utils {
	
	//funcao q retorna o STAGE/PALCO/TELA atual
	public static Stage currentStage(ActionEvent event) {
		//implementacao para pegar o STAGE a partir do OBJ de EVENT
		//pegando a SCENA e dps pegando a JANELA/WINDOW
		return (Stage)((Node)event.getSource()).getScene().getWindow();
	}
}
