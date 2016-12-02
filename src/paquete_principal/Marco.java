package paquete_principal;

import javax.swing.*;

import controles.Teclado;
import sprites.Cuadro;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.*;


import javax.swing.*;

public class Marco extends JFrame implements ActionListener
{
	
	public static final int FrameWidth = 1024;
	public static final int FrameHeight = 800;
	public static int delay = 15;
	public static boolean pause=false;
	public int nJugadores = 2;
	public static Timer temporizador;
	Lamina panel = new Lamina();
	public static Teclado tec = new Teclado();
	public Marco() 
	{
		
		
		setSize(FrameWidth, FrameHeight + 100);
		setLocationRelativeTo(null);
		setTitle("Mover Figuras");
		add(panel);
		setResizable(false);
		setFocusable(true);
		addKeyListener(tec);
		this.addFocusListener(new FocusListener()
				{

					@Override
					public void focusGained(FocusEvent arg0) {
						// TODO Auto-generated method stub
						Marco.this.setEnabled(true);
					}

					@Override
					public void focusLost(FocusEvent arg0) {
						// TODO Auto-generated method stub
						
					}
			
		});
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("Icono.gif"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);

	}
	


	
	public void actualizar() 
	{
		tec.actualizar();
		comprobarEventos();
		//estadoPartida();  
		//panel.superficie.ganaste();
		panel.superficie.repaint();
		//panel.superficie.nivel1.colision();
	}
	
	private int comprobarEventos()
	{

		panel.superficie.actualizar();
		return 0;
	}
	
	/*private void estadoPartida()
	{
		if(panel.superficie.perdiste())
		{
			dispose();
			temporizador.stop();
		}
		
	}*/
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		actualizar();
	}
	
	

}


