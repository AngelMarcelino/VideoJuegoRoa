package paquete_principal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Lamina extends JPanel 
{

	Image img ;
	Lienzo superficie = new Lienzo();
	public Lamina()
	{
		setSize(1024, 800);
		add(superficie);
		

	}
	
		

	
}
