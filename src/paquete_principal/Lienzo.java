package paquete_principal;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import niveles.Nivel1;
import sprites.Cuadro;

public class Lienzo extends Canvas
{
	public static final int ancho_lienzo=1024;
	public static final int alto_lienzo=800;
	
	
	public Nivel1 nivel1;
	
	public int numeroCuadros=2;
	//public LineaCuadros[] lineas = new LineaCuadros[numero_cuadros];
	
	public int contador=1;
	Rectangle meta = new Rectangle(980, 100, 20, 300);
	public int masCuadros=0;

	Graphics g;
	
	public Lienzo()
	{
		nivel1 = new Nivel1(this);
		
		
		setBackground(Color.white);
		setSize(ancho_lienzo, alto_lienzo);
		/*for (int x=1;x<numero_cuadros+1;x++)
		{
			lineas[x-1] = new LineaCuadros(this, x*-100);
		}*/

	}
	public void actualizar()
	{
		nivel1.comprobarEventos();
	}
	public void paint(Graphics g)
	{

		Graphics buffer;
		Image img;
		img=createImage(ancho_lienzo, alto_lienzo);
		buffer=img.getGraphics();
		
		Graphics2D g2 = (Graphics2D) buffer;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		super.paint(g2);
		
		/*for(int x=0;x<numero_cuadros;x++)
		{
			lineas[x].paint(g2);
		}*/

		
		nivel1.paint(g2);
		
		//nivel1.paint(g2);
		/*
		g2.setColor(Color.red);
		g2.setColor(Color.BLACK);
		g2.fill(meta);
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 500, 1000, 100);
		g2.setColor(Color.white);
		g2.setFont(new Font("Arial", Font.BOLD, 15));
		g2.drawString("Nivel: " + contador + "   Angel Marcelino González Mayoral 13300493 5B1", 10, 550);
		g2.setColor(Color.black);*/
		
		//nivel1.paint(g2);
		//nivel1.colision();
		
		g.drawImage(img, 0, 0, this);
		
		buffer.dispose();
		
	}
	
	/*public void paint(Graphics g)
	{
		
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(meta);
		
		lineas.paint(g2);
		cuadro.paint(g2);
		addMouseMotionListener(lamina);
		
	}*/
	
	
	/*public Rectangle[] getRectangle()
	{
		Rectangle[] cuadros =new Rectangle[numero_cuadros_sprites];
		for(int x=0;x<numero_cuadros_sprites;x++)
		{
			cuadros[x]=new Rectangle(cuadro[x].x, cuadro[x].y, Cuadro.height, Cuadro.width);
		}
		return cuadros;
	}
	public Rectangle[] getRectanglePared()
	{
		Rectangle[] cuadros =new Rectangle[numero_cuadros_sprites];
		for(int x=0;x<numero_cuadros_sprites;x++)
		{
			cuadros[x]=new Rectangle(cuadro[x].x+2, cuadro[x].y+2, Cuadro.height+2, Cuadro.width+2);
		}
		return cuadros;
	}*/
	
	/*public boolean ganaste()
	{
		for(int x=0;x<numero_cuadros_sprites;x++)
		{
			if(getRectangle()[x].intersects(meta))
			{
				
				int y=cuadro[x].y;
				contador++;

				
				cuadro[x].regresarAlInicio(y);
				/*for (int x2=0; x2<20 ; x2++)
				{
					lineas[x2].height+=5;
					lineas[x2].width+=5;
				}
				System.out.println(contador);
				return true;
				
			}
		}
		
		
		return false;
	}*/
	
	
	public void update (Graphics g) 
	{ 
		paint(g);
	} 
}
