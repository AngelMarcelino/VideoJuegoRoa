package sprites;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

import javax.imageio.ImageIO;
import javax.swing.Timer;

import controles.Teclado;
import menu.Menu;
import niveles.Nivel1;
import paquete_principal.Lienzo;

public class Cuadro implements Colisionable {
public boolean arriba, abajo, derecha, izquierda;
	
	//constantes 
	public int velocidad=2;
	public static final int UP=1, LEFT=2, DOWN=3, RIGHT=4;
	boolean up, down, left, right;
	public boolean stop;
	public boolean disparo;
	public Rectangle barraVida =new Rectangle();
	public int x, y;
	public static final int width=150;
	public static final int height=150;
	public int direccion;
	public int direccionCuadro;
	public Color miColor;
	public int numeroBalas=0;
	public int daño=5;
	public Image img;
	private int vida = 100;
	private int cont = 0;
	
	protected int nJugador;
	public boolean golpeando;
	public boolean caminando;
	private String spritePath;
	private int secuanciaGolpear[] = {4, 4, 1, 1, 2, 2, 3, 3, 3, 3, 3, 2, 2, 1, 1, 4, 4, 4, 4};
	private int secuanciaGolpear2[] = {4, 4, 4, 4, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 8, 8, 8, 8, 7, 7, 7, 7, 4, 4, 4, 4};
	private int secuanciaCaminar[] = {2, 2, 3, 3, 1, 1};
	private int secuanciaDano[] = {1, 1, 1, 1, 1};
	private int secuanciaMuerte[] = {2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
	protected Queue<Integer> Golpes = new LinkedList<Integer>();
	protected Queue<Integer> Camina = new LinkedList<Integer>();
	protected Queue<Integer> Dano = new LinkedList<Integer>();
	protected Queue<Integer> Muerte = new LinkedList<Integer>();
	protected boolean allowAddHit = true;
	public Nivel1 nivel;
	
	public boolean dir=true;
	public Cuadro(int x, int y,  String spritePath, Nivel1 nivel, int Jugador)
	{
		this.x=x;
		this.y=y;
		this.nJugador = Jugador;
		this.nivel = nivel;
		miColor=Color.BLACK;
		try{
			img = ImageIO.read(new File(spritePath));
			this.spritePath = spritePath;
		}
		catch(Exception ex)
		{
			img = null;
		}
		
		
	}
	
	public void removeVida(int value)
	{

		if(this.Dano.isEmpty())
		{
			this.Dano.add(1);
		}
		this.vida -= value;
		if(vida <= 0)
		{
			if(this.Muerte.isEmpty())
			{
				this.Muerte.add(1);
			}
			
		}
	}
	
	public int comprobarEventos()
	{
		return 0;
	}
	
	public int getVida()
	{
		return vida;
	}
	int izq = 0;
	int der = 0;
	public void paint(Graphics g, Lienzo lienzo)
	{
		
		AffineTransform identity = new AffineTransform();
		Graphics2D g2 = (Graphics2D)g;
		AffineTransform trans = new AffineTransform();
		trans.setTransform(identity);
		//trans.rotate( Math.toRadians(x) );
		trans.translate(x, y);
		if(direccionCuadro == Cuadro.RIGHT)
		{
			trans.scale(1, 1);
			dir = true;
			if(der == 0)
			{
				this.x -= 75;
			}
			der++;
			izq = 0;
			
		}
			
		else if(direccionCuadro == Cuadro.LEFT)
		{
			dir = false;
			trans.scale(-1, 1);
			if(izq == 0)
			{
				this.x += 75;
			}
			izq++;
			der = 0;
		}
		else if(direccionCuadro == Cuadro.DOWN)
		{
			if (dir)
				trans.scale(1, 1);
			else
				trans.scale(-1, 1);
		}
			
		else if(direccionCuadro == Cuadro.UP)
		{
			if (dir)
				trans.scale(1, 1);
			else
				trans.scale(-1, 1);
		}

		g2.setColor(Color.GREEN);
		g2.fill(barraVida);
		g.setColor(miColor);
		
		
		if(img != null)
		{
			g2.drawImage(img, trans, lienzo);
		}
		else
		{
			g.fillRect(x, y, width, height);
		}
		
		mover(direccionCuadro);
	}
	
	
	
	public int mover(int direccion)
	{
		boolean seMovio = false;
		this.direccionCuadro=direccion;
		if(!stop)
		{
			
			if(direccionCuadro==1)//arriba
			{
				if (y<350);
				else
				{
					y-=velocidad;
				}
				
			}
			if(direccionCuadro==2)//izquierda
			{
				
				if (x<=80);
				else
				{
					x-=velocidad;
				}
				
			}
			if(direccionCuadro==4)//derecha
			{
				
				if (x+80>=Nivel1.finalScreen);
				else
				{
					x+=velocidad;
				}
				
			}
			if(direccionCuadro==3)//abajo
			{
				
				if (y+50>Lienzo.alto_lienzo-110);
				else
				{
					y+=velocidad;
				}
				
			}
		}
		else if(!seMovio)
		{
		}
		return 0;
	}
	
	
	
	public void setColor(Color a)
	{
		miColor=a;
	}
	
	/*public void disparo()
	{
		if(numeroBalas==0)
		{
			miBala[numeroBalas] = new Bala(this, lienzo);
			numeroBalas++;
		}
		else 
		{
			if(miBala[numeroBalas-1].direccion==Cuadro.UP)
			{
				if (miBala[numeroBalas-1].distanciaBalaBala()==1)
				{
					miBala[numeroBalas] = new Bala(this, lienzo);
					numeroBalas++;
				}
			}
			if(miBala[numeroBalas-1].direccion==Cuadro.LEFT)
			{
				if (miBala[numeroBalas-1].distanciaBalaBala()==1)
				{
					miBala[numeroBalas] = new Bala(this, lienzo);
					numeroBalas++;
				}
			}
			if(miBala[numeroBalas-1].direccion==Cuadro.DOWN)
			{
				if (miBala[numeroBalas-1].distanciaBalaBala()==1)
				{
					miBala[numeroBalas] = new Bala(this, lienzo);
					numeroBalas++;
				}
			}
			if(miBala[numeroBalas-1].direccion==Cuadro.RIGHT)
			{
				if (miBala[numeroBalas-1].distanciaBalaBala()==1)
				{
					miBala[numeroBalas] = new Bala(this, lienzo);
					numeroBalas++;
				}
			}
			
			if(numeroBalas>=90)
			{
				numeroBalas=0;
			}
			
		}
		
		disparo=true;
	}*/
	
	public void setImg(String path)
	{
		try{
			img = ImageIO.read(new File(path));
		}
		catch(Exception ex){
			
		}
	}
	private int contAux = 0;
	private int contCamina = 0;
	private int contDano = 0;
	private int contMuerte = 0;
	private int velAux = 0;
	public void animacion()
	{
		cont ++;
		
		
		
		if(velocidad == 2)
		{
			velAux = 4;
		}
		else
		{
			velAux = 2;
		}
		
		if(!Camina.isEmpty() && cont % velAux == 0)
		{

			setImg("Sprites/Caminar/" + secuanciaCaminar[((contCamina % secuanciaCaminar.length) ) ] + "cv" + nJugador + ".png");
			contCamina ++;
			if(contCamina > secuanciaCaminar.length)
			{
				contCamina = 0;
				Camina.poll();
				setImg(spritePath);
			}
		}
		if(!Dano.isEmpty() && cont % 2 == 0)
		{

			setImg("Sprites/Muerte/" + secuanciaDano[((contDano % secuanciaDano.length) ) ] + "mv" + nJugador + ".png");
			contDano ++;
			if(contDano > secuanciaDano.length)
			{
				contDano = 0;
				Dano.poll();
				setImg(spritePath);
			}
		}
		
		if(!Muerte.isEmpty() && cont % 2 == 0)
		{

			setImg("Sprites/Muerte/" + secuanciaMuerte[((contMuerte % secuanciaMuerte.length) ) ] + "mv" + nJugador + ".png");
			contMuerte ++;
			if(contMuerte > secuanciaMuerte.length)
			{
				contMuerte = 0;
				Muerte.poll();
				setImg("Sprites/Muerte/" + 4 + "mv" + nJugador + ".png");
			}
		}
		
		
		
		if(!Golpes.isEmpty())
		{

			int cual = Golpes.peek();
			if(cual == 1)
				setImg("Sprites/Golpear/" + this.secuanciaGolpear[((contAux % secuanciaGolpear.length))] + "g" + nJugador + ".png");
			if(cual == 2)
				setImg("Sprites/Golpear/" + this.secuanciaGolpear2[((contAux % secuanciaGolpear2.length))] + "g" + nJugador + ".png");
			
			contAux ++;
			if(contAux > secuanciaGolpear.length)
			{
				contAux = 0;
				Golpes.poll();
				setImg(spritePath);
			}
		}
		
	}

	@Override
	public void onColision() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ObjetoRectangulo getRectangle() {
		// TODO Auto-generated method stub
		return null;
	}
	
	}	
