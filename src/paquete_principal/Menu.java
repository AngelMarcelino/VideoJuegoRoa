package paquete_principal;

import javax.swing.*;

public class Menu extends JFrame{

	public Menu()
	{
		LaminaMenu lamina = new LaminaMenu();
		setSize(300, 200);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class LaminaMenu extends JPanel
{
	public LaminaMenu()
	{
		
	}
}