package grafos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class GrafoNPD {
	private int cantNodos;
	private int cantAristas;
	private int[][] grafo;
	private int[] aristasEntrantes;
	
	public GrafoNPD(String path) throws FileNotFoundException {
		File file = new File(path);
		Scanner sc = new Scanner(file);
		cantNodos = sc.nextInt();
		cantAristas = sc.nextInt();
		grafo = new int[cantNodos][cantNodos];
		aristasEntrantes = new int[cantNodos];
		while(sc.hasNext()) {
			int origen = sc.nextInt();
			int destino = sc.nextInt();
			grafo[origen-1][destino-1] = 1;
			aristasEntrantes[destino-1]++;
		}
		sc.close();
	}

	public int getCantNodos() {
		return cantNodos;
	}
	
	public int sacarArista(int destino) {
		int aristas = aristasEntrantes[destino]--;
		return aristas;
	}
	
	public int getAristasEntrantes(int destino) {
		return aristasEntrantes[destino];
	}

	public ArrayList<Integer> getAdyacentes(int origen) {
		ArrayList<Integer> ady = new ArrayList<Integer>();
		for(int i=0; i<cantNodos; i++) {
			if(grafo[origen][i] == 1) {
				ady.add(i+1);
			}
		}
		return ady;
	}

	public void escribirSolucion(String pathSalida, int cantCaminos) throws IOException {
		FileWriter fw = new FileWriter(pathSalida);
		PrintWriter pw = new PrintWriter(fw);
		pw.print(cantCaminos);
		pw.close();
	}
	
	
}
