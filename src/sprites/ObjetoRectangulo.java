package sprites;

import java.awt.Rectangle;

public class ObjetoRectangulo {
	
	private Rectangle rectangle;
	private Tipos tipo;
	
	public ObjetoRectangulo(Rectangle rectangle, Tipos tipo){
		this.rectangle = rectangle;
		this.tipo = tipo;
	}
	
	public Rectangle getRectangle()
	{
		return this.rectangle;
	}
	
	public Tipos getTipo()
	{
		return this.tipo;
	}
}

enum Tipos
{
	Jugador,
	Enemigo
}
