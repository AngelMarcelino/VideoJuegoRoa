package controles;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import paquete_principal.Marco;
import sprites.TecladoEsc;


public class Teclado implements KeyListener
{
	public static final String ARRIBA = "arriba";
	public static final String ABAJO = "abajo";
	public static final String IZQUIERDA = "izquierda";
	public static final String DERECHA = "derecha";
	public static final String GOLPEAR = "golpear";
	public static final String IR_RAPIDO= "ir_rapido";
	public static final String SALTAR = "saltar";
	private final static int numeroTeclas=200;
	private static final boolean[] teclas = new boolean[numeroTeclas];
	public static Map<String, Boolean> teclasInterface = new HashMap<String, Boolean>();
	public static ArrayList<sprites.TecladoEsc> Escuchadores = new ArrayList<sprites.TecladoEsc>();
	
	public Teclado()
	{
		for(int x = 0; x < 2; x++)
		{
			teclasInterface.put(ARRIBA + x, null);
			teclasInterface.put(ABAJO + x, null);
			teclasInterface.put(IZQUIERDA + x, null);
			teclasInterface.put(DERECHA + x, null);
			teclasInterface.put(IR_RAPIDO + x, null);
			teclasInterface.put(GOLPEAR + x, null);
			teclasInterface.put(SALTAR + x, null);
		}

	}
	public static void actualizar()
	{


			teclasInterface.replace(ARRIBA + 0, teclas[KeyEvent.VK_UP]);
			teclasInterface.replace(ABAJO + 0, teclas[KeyEvent.VK_DOWN]);
			teclasInterface.replace(IZQUIERDA + 0, teclas[KeyEvent.VK_LEFT]);
			teclasInterface.replace(DERECHA + 0, teclas[KeyEvent.VK_RIGHT]);
			teclasInterface.replace(IR_RAPIDO + 0, teclas[KeyEvent.VK_NUMPAD0]);
			teclasInterface.replace(GOLPEAR + "0", teclas[KeyEvent.VK_NUMPAD3]);
			teclasInterface.replace(SALTAR + 0, teclas[KeyEvent.VK_NUMPAD1]);
			
			
			teclasInterface.replace(ARRIBA + 1, teclas[KeyEvent.VK_W]);
			teclasInterface.replace(ABAJO + 1, teclas[KeyEvent.VK_S]);
			teclasInterface.replace(IZQUIERDA + 1, teclas[KeyEvent.VK_A]);
			teclasInterface.replace(DERECHA + 1, teclas[KeyEvent.VK_D]);
			teclasInterface.replace(IR_RAPIDO + 1, teclas[KeyEvent.VK_SHIFT]);
			teclasInterface.replace(GOLPEAR + "1", teclas[KeyEvent.VK_G]);
			teclasInterface.replace(GOLPEAR + "1", teclas[KeyEvent.VK_G]);
			teclasInterface.replace(GOLPEAR + "1", teclas[KeyEvent.VK_G]);
			teclasInterface.replace(SALTAR + 1, teclas[KeyEvent.VK_SPACE]);
			teclasInterface.replace(ARRIBA + 1, teclas[KeyEvent.VK_W]);
			teclasInterface.replace(ARRIBA + 0, teclas[KeyEvent.VK_UP]);
			
	}
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		teclas[arg0.getKeyCode()]=true; 

		if (arg0.getKeyChar()=='P' || arg0.getKeyChar()=='p')
		{
			if(Marco.pause)
			{
				Marco.pause=false;
				Marco.temporizador.start();
			}
			else
			{
				Marco.pause=true;
				Marco.temporizador.stop();
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		teclas[arg0.getKeyCode()]=false;
			for(TecladoEsc t : Escuchadores){
				t.accion(arg0.getKeyCode());
			}
	}
	

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

