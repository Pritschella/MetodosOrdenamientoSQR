
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
			System.out.println(A[i] + ",");
		}
		System.out.println("\n");
	}
	
}//Clase


public class PruebaShellsort {

	public static void main(String[] args) {
		
		int [] A = {5, 8, 48, 1, 79, 7, 89, 10, 49, 6};
		OrdenamientoShellsort os = new OrdenamientoShellsort();
		os.mostrarArreglo(A);
		
		
		

	}//main

}//clase
