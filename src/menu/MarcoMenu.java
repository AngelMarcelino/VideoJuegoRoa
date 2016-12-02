package menu;

import java.awt.Toolkit;

import javax.swing.*;

public class MarcoMenu extends JFrame
{
	
	public MarcoMenu()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage("Icono.gif"));
		setSize(300, 300);
		setLocationRelativeTo(null);
		setTitle("Juego River City");
		
		PanelMenu lamina = new PanelMenu();
		add(lamina);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
