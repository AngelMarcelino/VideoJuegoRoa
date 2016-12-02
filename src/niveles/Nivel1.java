package niveles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.List;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import controles.Teclado;
import menu.Menu;
import paquete_principal.Lienzo;
import paquete_principal.Marco;
import sprites.Cuadro;
import sprites.Enemigo;
import sprites.Jugador;

public class Nivel1 implements ActionListener
{
	private Lienzo lienzo;
	
	public static final int inicioCuadroX=10;
	public static final int inicioCuadroY=470;
	public final int numero_cuadros=20;
	public final int numero_cuadros_sprites=2;
	public static int finalScreen = Marco.FrameWidth - 200;
	public Image imgback1;
	public Image imgback2;
	private int img1X;
	private String escenario;
	private int img2X;
	public Jugador cuadro[] = new Jugador[numero_cuadros_sprites];
	public Jugador cuadro2;
	private ArrayList<Enemigo> enemigos = new ArrayList<Enemigo>();
	private Timer tim = new Timer(20, this);
	
	
	public Nivel1(Lienzo lienzo)
	{
		this.lienzo=lienzo;
		img2X = 0 + lienzo.ancho_lienzo;
		img1X =0;
		for(int x=0;x<numero_cuadros_sprites;x++)
		{
			cuadro[x]=new Jugador(inicioCuadroX, inicioCuadroY + 200, "Sprites/Caminar/2cv" + x + ".png", this, x);
			if(x==1)
			{
				cuadro[1].x=100;
				cuadro[1].y=600;
				cuadro[1].setColor(Color.RED);
			}
			//cuadros.add(new Cuadro(inicioCuadroX + 200 + x * 100, inicioCuadroY + 200));
			enemigos.add(new Enemigo(1, 2, "Sprites/Caminar/2cv" + 1 + ".png", this, 1));
		}
		try
		{
			imgback1 = ImageIO.read(new File("ESCENARIOS/1.jpg"));
			imgback2 = ImageIO.read(new File("ESCENARIOS/1.jpg"));
		}
		catch(Exception ex)
		{
			imgback1 = null;
		}
		
		
		tim.start();
		
	}
	boolean moveScenario = true;
	public void paint(Graphics2D g2)
	{
		g2.drawImage(imgback1, img1X, 0, lienzo);
		g2.drawImage(imgback2, img2X, 0, lienzo);
		if(img1X + lienzo.ancho_lienzo < 0)
		{
			img1X = + lienzo.ancho_lienzo -10;
		}
		if(img2X  + lienzo.ancho_lienzo < 0)
		{
			img2X = lienzo.ancho_lienzo - 10;
		}
		
		for(int x=0;x<numero_cuadros_sprites;x++)
		{
			moveScenario &= (cuadro[x].x > Nivel1.finalScreen - Cuadro.height) && !cuadro[x].stop && cuadro[x].direccionCuadro == Cuadro.RIGHT;
			
			cuadro[x].paint(g2, this.lienzo);
			
			if(moveScenario && x >= 1){
				img1X -= 5;
				img2X -=5;
			}
			else if(x >= 1)
			{
				moveScenario = true;
			}
		}
		for(Enemigo en : enemigos)
		{
			en.paint(g2, lienzo);
		}
		
		

	}
	
	public void comprobarEventos()
	{
		for(int x = 0; x < this.numero_cuadros_sprites; x++){
			cuadro[x].comprobarEventos();
		}
		for(Enemigo en : enemigos)
		{
			en.comprobarEventos();
		}
	}
	
	public int colision()
	{
		/*for (int a=0; a<numeroRect; a++)
		{
			//for (int x=0;x<lienzo.numeroCuadros;x++)
				if (lienzo.getRectangle()[0].intersects(rectangulo[a]))
				{
				
					return 0;
				}
				if (lienzo.getRectangle()[1].intersects(rectangulo[a]))
				{
				
					return 1;
				}
			
		}*/
		return -1;
	}
	int cont = 0;
	public void actionPerformed(ActionEvent e)
	{
		cont++;
		for(int x = 0; x < this.numero_cuadros_sprites; x++)
		{
			cuadro[x].animacion();
		}
		for(Enemigo en : enemigos)
		{
			en.animacion();
		}
		if(cont % 200 == 0)
		{
			enemigos.add(new Enemigo(1, 2, "Sprites/Caminar/2cv" + 1 + ".png", this, 1));
		}
		
	}
	public boolean perdiste()
	{
		/*for(int x=0;x<numero_cuadros;x++)
		{
			/* if(lineas[x].colision()|| nivel1.colision())
			{
				JOptionPane.showMessageDialog(null, "Perdiste");
				return true;
			}
			
		}*/
		if (cuadro[0].getVida()<=0)
		{
			JOptionPane.showMessageDialog(null, "Gana ROJO");
			return true;
		}
		if (cuadro[1].getVida()<=0)
		{
			JOptionPane.showMessageDialog(null, "Gana NEGRO");
			return true;
		}
		return false;
	}
}
