/***
 *   Clase			: CaminoMasCorto.java
 *   Fecha Inicio	: 13 de Julio del 2005
 *   Fecha T�rmino  : 14 de Julio del 2005
 *   Hora Inicio	: 21:35
 *   Hora T�rmino	: 00:30
 *
 *   Autor          : Jorge Orellana
 *
 ***/
//Importaci�n de las bibliotecas necesarias para la clase...
import java.io.*;
//Declaracion de la clase
public class CaminoMasCorto
{
	public static void main( String []args ) throws Exception
	{
		int n,inicio,termino;
		int [][]matriz;
		BufferedReader lectura;
		lectura = new BufferedReader(new InputStreamReader( System.in ) );
		// Se pide el orden de la matriz de adyacencia.
		System.out.print("Ingrese el orden de la matriz de adyacencia : ");
		n = Integer.parseInt(lectura.readLine());
		// Se genera la matriz..
		matriz = new int[n][n];
		System.out.println();
		// Se piden los datos para la matriz.
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			{
				System.out.print("Ingrese elemento ("+i+","+j+") : ");
				matriz[i][j] = Integer.parseInt(lectura.readLine());
			}
		System.out.println("\n\nMatriz de Adyacencia : \n");
		// Se pide indefinidamente nodos para ver su factibilidad.
		// El ciclo sale con
		do
		{
			// Se muestra la matriz.
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					System.out.print(" "+matriz[i][j]);
				}
				System.out.println();
			}
			System.out.println();
			// Se piden los nodos a analizar.
			System.out.print("Ingrese Nodo de Inicio  : ");
			inicio = Integer.parseInt(lectura.readLine());
			System.out.print("Ingrese Nodo de Termino : ");
			termino = Integer.parseInt(lectura.readLine());
			System.out.println();
			// Se verifica que los indices sean mayores o iguales a 0.
			if((inicio >= 0)&&(termino>=0))
				encontrarCaminoMasCorto(matriz,inicio,termino);
		} while((inicio!=-1)&&(termino!=-1));
	}
	// Metodo que encuentra el camino mas corto entre 2
	// vertices del grafo.



	public static void encontrarCaminoMasCorto(int [][]m,int ini,int fin)
	{
		// Se verifica que no se este tratando de accesar a un vértice fuera del rango de la matriz de adyacencia.
		if((ini>m.length-1)||(fin>m[0].length))
		{
			System.out.print("Indices fuera de rango...");
			return;
		}
		// Se quiere ver el camino más corto desde un nodo a si mismo entonces se imprime el coste de llegar a si mismo.
		if( ini == fin )
		{
			System.out.println("\t\t Costo de llegar de "+ini+" a "+fin+" es de "+m[ini][fin]);
			System.out.println("\n");
			return;
		}
		/* Como los indices estan bien ingresados y no se esta tratando con el caso base de que se quiera llegar al mismo nodo
		 entonces se busca la distancia mas corta que hay entre el nodo "ini" y el nodo "fin".*/

		System.out.println("\n\t\t Costo de llegar de "+ini+" a "+fin+" es de "+MostrarCaminoMasCorto(ini,fin,ini,0,m));
		System.out.println("\n");
	}


	// Metodo que muestra el camino mas corto entre dos vertices del grafo.
	public static int MostrarCaminoMasCorto(int ini,int ter,int x,int suma,int [][]matriz)
	{
		int i,j,garage;
		// Si se pasaron los limites de orden de la matriz entonces
		// quiere decir que el camino no se encuentra y se retorna 0.
		if(x>(matriz.length-1))
		{
			System.out.print("El camino entre los nodos no existe...");
			System.out.println("\n");
			return -1;
		}
		// Como se esta todavia dentro de la matriz entonces se
		// sigue buscando un nodo que llegue al nodo terminal.
		for(i=0;i<matriz[0].length;i++)
		{
			// Existe una llegada al nodo deseado entonces
			// Se suma el costo al costo general y se retorna la suma.
			if(matriz[x][ter]!=0)
			{
				System.out.println("Revisando Nodo "+x+" - Costo : "+suma);
				suma += matriz[x][ter];
				break;
			}
			else
				// Como lo anterior no pasa entonces se verifica que
				// existe un camino para pasar al proximo nivel.
				if(matriz[x][i]!=0)		// Camino existe
				{
					System.out.println("Revisando Nodo "+x+" - Costo : "+suma);
					garage = suma;
					suma += MostrarCaminoMasCorto(ini,ter,x+1,suma,matriz);
					if(suma==-1)
						suma = garage;
					else
						if((suma>garage)&&(garage!=0))
							suma=garage;
				}
		}
		
		return suma;
	}
}// Fin de la clase