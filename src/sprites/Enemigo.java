package sprites;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import controles.Teclado;
import menu.Menu;
import niveles.Nivel1;
import paquete_principal.Lienzo;

public class Enemigo extends Cuadro{
	
	private String spritePath;

	
	public Enemigo(int x, int y, String spritePath, Nivel1 nivel, int nSprite)
	{
		super(1280 + 100, 500, spritePath, nivel, nSprite);
		
	}

	
	public int comprobarEventos()
	{
			this.caminando= true;
			stop = !caminando;
			if(nivel.cuadro[0] != null)
			{
				if(nivel.cuadro[0].x > this.x)
				{
					this.x ++;
				}
				else
				{
					this.x--;
				}
				
				if(nivel.cuadro[0].y > this.y)
				{
					this.y++;
				}
				else
				{
					this.y--;
				}
				//System.out.println("EnemigoX: " + this.x + "    Jugador0X: " + nivel.cuadro[0].x);
			}
			
			
			
			if(caminando)
			{
				if(this.Camina.isEmpty())
					this.Camina.add(1);
			}
			
			
		return 0;
	}


	@Override
	public ObjetoRectangulo getRectangle() {
		// TODO Auto-generated method stub
		Rectangle rect = new Rectangle(this.x, this.y, 150, 150);
		return new ObjetoRectangulo(rect, Tipos.Enemigo);
	}
	
	
	//setImg

}
