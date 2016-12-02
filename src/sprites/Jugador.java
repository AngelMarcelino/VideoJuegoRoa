package sprites;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.ImageObserver;
import java.io.File;
import java.sql.Time;
import java.util.LinkedList;
import java.util.Queue;

import javax.imageio.ImageIO;
import javax.swing.Timer;

import controles.Teclado;
import menu.Menu;
import paquete_principal.Lienzo;
import niveles.*;



public class Jugador extends Cuadro implements TecladoEsc
{
	
	public Jugador(int x, int y, String spritePath, Nivel1 nivel, int Jugador)
	{
		super(x, y, spritePath, nivel, Jugador);
		Teclado.Escuchadores.add(this);
	}
	
	
	
	
	public int comprobarEventos()
	{
			this.caminando= (Menu.tec.teclasInterface.get(Teclado.ABAJO+nJugador) || Menu.tec.teclasInterface.get(Teclado.ARRIBA+nJugador)
					|| Menu.tec.teclasInterface.get(Teclado.IZQUIERDA+nJugador) || Menu.tec.teclasInterface.get(Teclado.DERECHA+nJugador));
			stop = !caminando;
			if(caminando)
			{
				if(this.Camina.isEmpty())
					this.Camina.add(1);
			}
			if(Menu.tec.teclasInterface.get(Teclado.IR_RAPIDO + nJugador))
			{
				
				this.velocidad=3;
				
			}
			else
			{
				this.velocidad=2;
			}
			if(Menu.tec.teclasInterface.get(Teclado.ABAJO + nJugador))
			{
				
				this.mover(Cuadro.DOWN);
				this.stop=false;

			}

			

			if(Menu.tec.teclasInterface.get(Teclado.ARRIBA + nJugador))
			{
				
				this.mover(Cuadro.UP);
				this.stop=false;

			}

			if(Menu.tec.teclasInterface.get(Teclado.IZQUIERDA + nJugador))
			{
				this.mover(Cuadro.LEFT);
				this.stop=false;

			}
	
			if(Menu.tec.teclasInterface.get(Teclado.DERECHA + nJugador))
			{
				this.mover(Cuadro.RIGHT);
				this.stop=false;
	
			}
			if(Menu.tec.teclasInterface.get(Teclado.GOLPEAR + nJugador))
			{
				if(this.Golpes.size() == 0 && allowAddHit)
				{
					this.Golpes.add(1);
					this.allowAddHit = false;
				}
				else if(this.Golpes.size() == 1 && allowAddHit)
				{
					if(this.Golpes.peek() == 2)
						this.Golpes.add(1);
					else
					{
						this.Golpes.add(2);
					}
					this.allowAddHit = false;
				}
			}
			if(Menu.tec.teclasInterface.get(Teclado.SALTAR + nJugador))
			{
				if(Dano.isEmpty() && allowRemoveLife)
				{
					allowRemoveLife = false;
					this.removeVida(10);
				}
				
				
			}
		return 0;
	}
	
	public boolean allowRemoveLife= true;

	public void accion (int code)  {
		// TODO Auto-generated method stub
		if(code == KeyEvent.VK_G ||code == KeyEvent.VK_NUMPAD3)
			allowAddHit = true;
		if(code == KeyEvent.VK_SPACE || code == KeyEvent.VK_NUMPAD1)
			allowRemoveLife = true;
	}

		
	



	@Override
	public ObjetoRectangulo getRectangle() {
		// TODO Auto-generated method stub
		Rectangle rect = new Rectangle(this.x, this.y, 150, 150);
		return new ObjetoRectangulo(rect, Tipos.Enemigo);
	}
}
