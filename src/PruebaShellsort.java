import java.util.Random;
import java.util.Scanner;

class OrdenamientoShellsort{
	
	public void ordenamientoShellsort(int A[]) {
		int salto, aux;
		boolean cambios;
		
		for(salto = A.length / 2; salto != 0; salto /= 2 ) {
			cambios = true;
			while (cambios) {
				cambios = false;
				for (int i = salto; i < A.length; i++) {
					if(A[i - salto] > A[i]) {
						aux = A[i];
						A[i] = A[i - salto];
						A[i - salto] = aux;
						cambios = true;
					}
				}
			}
		}
		
		
	}//Metodo
	
	public void mostrarArreglo( int A[]) {
		for (int i = 0; i < A.length; i++) {
			byte cont=0;
			if (cont==15) {
				System.out.println(A[i] + ",");
				cont=0;
			}
			System.out.print(A[i] + ",");
			cont++;
		}
		System.out.println("\n");
	}
	
}//Clase

class ordenamientoQuick{
	
	public void ordenamientoQuickSort(int numeros[], int primero, int ultimo) {
		
		int recorridos = 0, intercambios = 0, comparaciones = 0;
		long totalTiempo, tInicio;
		
		tInicio = System.currentTimeMillis();
		int i, j, pivote, aux;
		i = primero;
		j = ultimo;
		
		pivote = numeros[primero];
		while(i < j) {
			//Poner faltante después
			
			while(numeros[j] > pivote) {
			j --;
		}
		if(i < j) {
			comparaciones ++;
			aux = numeros[i];
			numeros[i] = numeros[j];
			numeros[j] = aux;
			intercambios ++;
		}
		
		
		recorridos ++;
		numeros[primero] =  numeros[j];
		numeros[j] = pivote;
		intercambios ++;
		if(primero < j -1) {
			ordenamientoQuickSort(numeros, primero, j -1);
		}
		 if( j + 1 < ultimo) {
			 ordenamientoQuickSort(numeros, j +1, ultimo);
		 }
		
		 totalTiempo = System.currentTimeMillis() - tInicio;
		 //mostrarVector(numeros);
		 System.out.println("Tiempo demorado: " + totalTiempo + "milisegundos.");
		 System.out.println("Recorridos: " );
		 
		}	
		
	
		
	}//Metodo
	
	public void mostrarArreglo( int A[]) {
		for (int i = 0; i < A.length; i++) {
			byte cont=0;
			if (cont==15) {
				System.out.println(A[i] + ",");
				cont=0;
			}
			cont++;
			System.out.print(A[i] + ",");
		}
		System.out.println("\n");
	}
}//Class

class radix{
	
	public static void radixSort(int[] arr) {
		if (arr.length == 0) {
			return;
		}
		
		int[][] np = new int[arr.length][2];
		int[] q = new int[0x100];
		int i,j,k,l,f = 0;
		for (k = 0; k < 4; k++) {
			for (i = 0; i < (np.length-1); i++) {
				np[i][1] = i+i;}
				np[i][1] = -1;
				for (i = 0; i < q.length; i++) {
					q[i]= -1;
				}
				for (f=i = 0; i < arr.length; i++) {
					j=((0xFF<<(k<<3)&arr[i])>>(k<<3));
					if (q[j]==-1) {
						l=q[j]=f;
					}else {
						l = q[j];
						while(np[l][1] != -1) { l= np[l][1];}
						np[l][1] = f;
						l = np[l][1];
					}
					f= np[f][1];
					np[l][0] = arr[i];
					np[l][1]= -1;
				}
				for (l = q[i=j=0]; i < 0x100; i++) {
					for (l = 0; l != -1; l++) {
						arr[j++] = np[l][0];
					}
				}
		}
		
		
	}
	public void mostrarArreglo( int A[]) {
		for (int i = 0; i < A.length; i++) {
			byte cont=0;
			if (cont==15) {
				System.out.println(A[i] + ",");
				cont=0;
			}
			cont++;
			System.out.print(A[i] + ",");
		}
		System.out.println("\n");
	}
}

public class PruebaShellsort {

	public static void main(String[] args) {
		OrdenamientoShellsort shell  =new OrdenamientoShellsort();
		ordenamientoQuick quick = new ordenamientoQuick();
		radix radix = new radix();
		
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("Seleccione el metodo: ");
		System.out.println("1) ShellSort");
		System.out.println("2) QuickSort");
		System.out.println("3) Radix");
		byte op = sc.nextByte();
		
		int[] numeros = new int[100];
		for (int i = 0; i < numeros.length; i++) {
			numeros[i]= random.nextInt(100);
		}
		
		int[] numeros2 = new int[1000];
		for (int i = 0; i < numeros2.length; i++) {
			numeros2[i]= random.nextInt(100);
		}
		
		int[] numeros3 = new int[10000];
		for (int i = 0; i < numeros3.length; i++) {
			numeros3[i]= random.nextInt(100);
		}
		
		int[] numeros4 = new int[100000];
		for (int i = 0; i < numeros4.length; i++) {
			numeros4[i]= random.nextInt(100);
		}
		
		int[] numeros5 = new int[1000000];
		for (int i = 0; i < numeros5.length; i++) {
			numeros5[i]= random.nextInt(100);
		}
		
		switch (op) {
		case 1:
			System.out.println("Seleccionó el metodo ShellSort");
			System.out.println("Prueba de 100");
			shell.mostrarArreglo(numeros);
			shell.ordenamientoShellsort(numeros);
			shell.mostrarArreglo(numeros);
			System.out.println();
			System.out.println("Prueba de 1,000");
			shell.mostrarArreglo(numeros2);
			shell.ordenamientoShellsort(numeros2);
			shell.mostrarArreglo(numeros2);
			System.out.println();
			System.out.println("Prueba de 10,000");
			shell.mostrarArreglo(numeros3);
			shell.ordenamientoShellsort(numeros3);
			shell.mostrarArreglo(numeros3);
			System.out.println();
			System.out.println("Prueba de 100,000");
			shell.mostrarArreglo(numeros4);
			shell.ordenamientoShellsort(numeros4);
			shell.mostrarArreglo(numeros4);
			System.out.println();
			System.out.println("Prueba de 1,000,000");
			shell.mostrarArreglo(numeros5);
			shell.ordenamientoShellsort(numeros5);
			shell.mostrarArreglo(numeros5);
			System.out.println();
		break;
		case 2: 
			System.out.println("Seleccionó el metodo QuickSort");
			System.out.println("Prueba de 100");
			quick.mostrarArreglo(numeros);
			quick.ordenamientoQuickSort(numeros, 0, numeros.length);
			quick.mostrarArreglo(numeros);
			System.out.println();
			System.out.println("Prueba de 1,000");
			quick.mostrarArreglo(numeros2);
			quick.ordenamientoQuickSort(numeros2, 0, numeros2.length);
			quick.mostrarArreglo(numeros2);
			System.out.println();
			System.out.println("Prueba de 10,000");
			quick.mostrarArreglo(numeros3);
			quick.ordenamientoQuickSort(numeros3, 0, numeros3.length);
			quick.mostrarArreglo(numeros3);
			System.out.println();
			System.out.println("Prueba de 100,000");
			quick.mostrarArreglo(numeros4);
			quick.ordenamientoQuickSort(numeros4, 0, numeros4.length);
			quick.mostrarArreglo(numeros4);
			System.out.println();
			System.out.println("Prueba de 1,000,000");
			quick.mostrarArreglo(numeros5);
			quick.ordenamientoQuickSort(numeros5, 0, numeros5.length);
			quick.mostrarArreglo(numeros5);
			System.out.println();
		break;
		case 3:
			System.out.println("Seleccionó el metodo Radix");
			System.out.println("Prueba de 100");
			radix.mostrarArreglo(numeros);
			radix.radixSort(numeros);
			radix.mostrarArreglo(numeros);
			System.out.println();
			System.out.println("Prueba de 1,000");
			radix.mostrarArreglo(numeros2);
			radix.radixSort(numeros2);
			radix.mostrarArreglo(numeros2);
			System.out.println();
			System.out.println("Prueba de 10,000");
			radix.mostrarArreglo(numeros3);
			radix.radixSort(numeros3);
			radix.mostrarArreglo(numeros3);
			System.out.println();
			System.out.println("Prueba de 100,000");
			radix.mostrarArreglo(numeros4);
			radix.radixSort(numeros4);
			radix.mostrarArreglo(numeros4);
			System.out.println();
			System.out.println("Prueba de 1,000,000");
			radix.mostrarArreglo(numeros5);
			radix.radixSort(numeros5);
			radix.mostrarArreglo(numeros5);
			System.out.println();
		break;
		default:
			System.out.println("Seleccion erronea");
		break;
		}
	}//main

}//clase
