package gui.listeners;

public interface DataChangeListener {
	
	//q defini uma operacao ONDATACHANGED... Q � uma operacao q � realizada
	//quando os dados mudarem... No caso vai avisar quando nos CAD um novo DEPARTMENT
	//e assim atualizar(carregar novamente) a lista dos departamentos na tela
	void onDataChanged();
}
