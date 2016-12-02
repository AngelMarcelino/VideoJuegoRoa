package menu;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import paquete_principal.*;


import javax.swing.*;

public class PanelMenu extends JPanel
{
	JButton iniciar = new JButton("Iniciar");
	JButton salir = new JButton("Salir");
	public PanelMenu()
	{
		setLayout(new GridLayout(2, 1));
		iniciar.addActionListener(new Oyente());
		salir.addActionListener(new Oyente());
		add(salir);
		add(iniciar, FlowLayout.LEFT);
		
	}
	
	class Oyente implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(salir))
			{
				System.exit(0);
			}
			else
			{
				Marco marco = new Marco();
				Marco.temporizador = new Timer(Menu.DELAY, marco);
				Marco.temporizador.start();
				
			}
		}
		
		
	}
}

