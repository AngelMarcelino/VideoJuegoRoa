package sprites;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import paquete_principal.*;

public class Colisiones implements ActionListener {
	public ArrayList<Colisionable> Colisionables = new ArrayList<Colisionable>();
	
	public Colisiones()
	{
		Marco.temporizador.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
}
