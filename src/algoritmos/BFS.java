package algoritmos;
import java.util.LinkedList;
import java.util.Queue;

import grafos.GrafoNPD;

public class BFS {
	
	private GrafoNPD grafo;
	private int origen;
	private int[] cantCaminos;
	
	public BFS(GrafoNPD grafo, int origen) {
		this.grafo = grafo;
		this.origen = origen;
		cantCaminos = new int[grafo.getCantNodos()];
	}
	
	public void ejecutar() {
		Queue<Integer> cola = new LinkedList<Integer>();
		cola.add(origen);
		cantCaminos[origen-1] = 1;
		while(!cola.isEmpty()) {
			int actual = cola.poll();
			for (Integer ady : grafo.getAdyacentes(actual-1)) {
				cantCaminos[ady-1] += cantCaminos[actual-1];
				grafo.sacarArista(ady-1);
				if(grafo.getAristasEntrantes(ady-1) == 0) {
					cola.add(ady);
				}
			}
		}
	}
	
	public void mostrarDistancias(){
		for (int i = 0; i < cantCaminos.length; i++) {
			System.out.println((i+1)+" "+cantCaminos[i]);
		}
	}
	
	public int cantCaminosAlNodo(int destino) {
		return cantCaminos[destino-1];
	}
	
	
}
