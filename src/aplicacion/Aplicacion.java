package aplicacion;

import java.io.IOException;

import algoritmos.BFS;
import grafos.GrafoNPD;

public class Aplicacion {
	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\Diego\\eclipse-workspace\\InspeccionandoLaReserva\\entrada01.in";
		String pathSalida = "C:\\Users\\Diego\\eclipse-workspace\\InspeccionandoLaReserva\\salida01.out";
		GrafoNPD grafo = new GrafoNPD(path);
		BFS bfs = new BFS(grafo,1);
		bfs.ejecutar();
		int nodoDestino = 10;
		int cantCaminos = bfs.cantCaminosAlNodo(nodoDestino);
		grafo.escribirSolucion(pathSalida,cantCaminos);
	}
}
