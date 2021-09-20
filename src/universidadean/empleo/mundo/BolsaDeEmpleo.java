/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot� - Colombia)
 * Departamento de Tecnolog�a de la Informaci�n y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Basado en un Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: Bolsa de Empleo
 * Fecha: 11 de marzo de 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.empleo.mundo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Es la clase que se encarga de manejar y organizar los aspirantes <br>
 * <b>inv: </b> <br>
 * aspirantes != null <br>
 * En el vector de aspirantes no hay dos o m�s con el mismo nombre
 */
public class BolsaDeEmpleo {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la lista que contiene todos los aspirantes
     */
    private ArrayList<Aspirante> aspirantes;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una nueva bolsa de emplea sin aspirantes.
     */
    public BolsaDeEmpleo() {
        aspirantes = new ArrayList<>();
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna una lista de aspirantes. La lista retornada no es la misma que la almacenada en esta clase, pero si tiene el mismo orden.
     *
     * @return lista de aspirantes
     */
    public ArrayList<Aspirante> darAspirantes() {
        ArrayList<Aspirante> copia = new ArrayList<>(aspirantes);
        return copia;
    }

    /**
     * Agrega un nuevo aspirante a la bolsa
     *
     * @param nombreA           El nombre del aspirante - nombreA != null
     * @param profesionA        La profesi�n del aspirante - profesionA es uno de estos { ADMINISTRADOR, INGENIERO_INDUSTRIAL, CONTADOR, ECONOMISTA }
     * @param aniosExperienciaA A�os de experiencia del aspirante - aniosExperienciaA > 0
     * @param edadA             La edad del aspirante - edadA > 0
     * @param telefonoA         El tel�fono del aspirante - telefonoA != null
     * @param imagenA           La ruta a la imagen del aspirante - imagenA != null
     * @return Se retorn� true si el aspirante fue adicionado o false de lo contrario
     */

    public boolean agregarAspirante(String nombreA, String profesionA, int aniosExperienciaA, int edadA, String telefonoA, String imagenA) {
        int aspiranteBuscado = buscarAspirante(nombreA);
        boolean agregado = false;
        if (aspiranteBuscado == -1) {
            Aspirante nuevoAspirante = new Aspirante(nombreA, profesionA, aniosExperienciaA, edadA, telefonoA, imagenA);
            aspirantes.add(nuevoAspirante);
            agregado = true;
        }

        return agregado;
    }

    /**
     * Organiza la lista de aspirantes por nombre usando el algoritmo de burbuja. <br>
     * <b>post: </b>La lista de aspirantes est� ordenada por nombre (orden ascendente).
     */
    public void ordenarPorNombre() {
        Aspirante aux = null;
		for(int i = 0; i < aspirantes.size() - 1; i++) {
			for (int j = 0; j < aspirantes.size() - i - 1; j++) {
				if (aspirantes.get(j).darNombre().compareTo(aspirantes.get(j + 1).darNombre()) > 0) {
					aux = aspirantes.get(j + 1);
					aspirantes.set(j + 1, aspirantes.get(j));
					aspirantes.set(j, aux);
				}
			}
		}
    }

    /**
     * Organiza la lista de aspirantes por edad usando el algoritmo de selecci�n <br>
     * <b>post: </b>La lista de aspirantes est� ordenada por edad
     */
    public void ordenarPorEdad() {
        // TODO: Realizar el ejercicio correspondiente
        for(int i = 0; i < aspirantes.size(); i++) {
            int initMinValue = aspirantes.get(i).darEdad();
            for(int j = i +1; j < aspirantes.size(); j++) {
                if(aspirantes.get(j).darEdad() < initMinValue) {
                    swapPlaces(aspirantes, i, j);
                }
            }
        }

    }

    public void swapPlaces(ArrayList<Aspirante> list, int a, int b) {
        Aspirante temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }
    /**
     * Organiza la lista de aspirantes por profesi�n usando el algoritmo de burbuja <br>
     * <b>post: </b>El conjunto de aspirantes esta ordenado por profesi�n
     */
    public void ordenarPorProfesion() {
        // TODO: Realizar el ejercicio correspondiente
        Aspirante aux = null;
		for(int i = 0; i < aspirantes.size() - 1; i++){
			for(int j = 0; j < aspirantes.size() - i - 1; j++){
				if(aspirantes.get(j).darProfesion().compareTo(aspirantes.get(j+1).darProfesion()) > 0){
					aux = aspirantes.get(j+1);
					aspirantes.set(j+1, aspirantes.get(j));
					aspirantes.set(j, aux);
				}
			}
		}
    }

    /**
     * Organiza la lista de aspirantes por a�os de experiencia usando el algoritmo de inserci�n <br>
     * <b>post: </b>La lista de aspirantes est� ordenada por a�os de experiencia
     */
    public void ordenarPorAniosDeExperiencia() {
        // TODO: Realizar el ejercicio correspondiente
        for(int i = 1; i < aspirantes.size(); i++) {
            leftCheck(aspirantes, i);
        }
    }

    public void leftCheck(ArrayList<Aspirante> list, int currentPos) {
        if(currentPos != 0)  {
            if(list.get(currentPos).darAniosExperiencia() < list.get(currentPos - 1).darAniosExperiencia()) {
                swapPlaces(list, currentPos, currentPos - 1);
            }
            leftCheck(list, currentPos - 1);
        }
    }

    /**
     * Busca un Aspirante seg�n su nombre y retorna la posici�n en la que se encuentra. <br>
     *
     * @param nombre El nombre del aspirante buscado - nombre!=null
     * @return Se retorn� la posici�n donde se encuentra un aspirante con el nombre dado. Si no se encuentra ning�n aspirante con ese nombre se retorn� -1.
     */
    public int buscarAspirante(String nombre) {
        int posicion = -1;
		String a,b;
		for(int i = 0; i < aspirantes.size(); i++) {
			a = aspirantes.get(i).darNombre().toUpperCase();
			b = nombre.toUpperCase();
			if(a.indexOf(b) > -1 ){
				return i;
			}
		}
		return posicion;
    }

    /**
     * Busca un aspirante utilizando una b�squeda binaria. <br>
     * <b>pre: </b> La lista de aspirantes se encuentra ordenada por nombre. <br>
     *
     * @param nombre es el nombre del aspirante que se va a buscar - nombre!=null
     * @return Se retorn� la posici�n del aspirante con el nombre dado. Si el aspirante no existe se retorn� -1.
     */
    public int buscarBinarioPorNombre(String nombre) {
        // TODO: Realizar el ejercicio correspondiente
        ordenarPorNombre();
        return binarySearch(aspirantes, nombre);
    }

    static int binarySearch(ArrayList<Aspirante> arr, String x)
    {
        int l = 0, r = arr.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            int res = x.compareTo(arr.get(m).darNombre());

            // Check if x is present at mid
            if (res == 0)
                return m;

            // If x greater, ignore left half
            if (res > 0)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        return -1;
    }

    /**
     * Busca el aspirante que tenga la menor edad en la bolsa.
     *
     * @return Se retorn� la posici�n donde se encuentra el aspirante m�s joven. Si no hay aspirantes en la bolsa se retorn� -1
     */
    public int buscarAspiranteMasJoven() {
        int posicion = -1;
		int highest = 500;
        if(aspirantes.size() > 0) {
            for (Aspirante aspirante : aspirantes) {
                if (aspirante.darEdad() < highest) {
                    highest = aspirante.darEdad();
                    posicion = aspirantes.indexOf(aspirante);
                }
            }
        }
        return posicion;
    }

    /**
     * Busca el aspirante que tenga la mayor edad en la bolsa.
     *
     * @return Se retorn� la posici�n donde se encuentra el aspirante con m�s edad. Si no hay aspirantes en la bolsa se retorn� -1
     */
    public int buscarAspiranteMayorEdad() {
        int posicion = -1;
        int highest = -1;
        if(aspirantes.size() > 0) {
            for (Aspirante aspirante : aspirantes) {
                if (aspirante.darEdad() > highest) {
                    highest = aspirante.darEdad();
                    posicion = aspirantes.indexOf(aspirante);
                }
            }
        }
        return posicion;
    }

    /**
     * Busca el aspirante con m�s a�os de experiencia en la bolsa.
     *
     * @return Se retorn� la posici�n donde se encuentra el aspirante con mayor experiencia. Si no hay aspirantes en la bolsa se retorn� -1
     */
    public int buscarAspiranteMayorExperiencia() {
        int posicion = -1;
        int highest = 0;
        if(aspirantes.size() > 0) {
            for (Aspirante aspirante : aspirantes) {
                if (aspirante.darAniosExperiencia() > highest) {
                    highest = aspirante.darAniosExperiencia();
                    posicion = aspirantes.indexOf(aspirante);
                }
            }
        }
        return posicion;
    }

    /**
     * Contrata a un aspirante.<br>
     * <b>post: </b>Se elimin� el aspirante de la lista de aspirantes.
     *
     * @param nombre El nombre del aspirante a contratar - nombre!=null
     * @return Se retorn� true si el aspirante estaba registrado en la bolsa o false de lo contrario
     */
    public boolean contratarAspirante(String nombre) {
        boolean contratado = false;
		int i = this.buscarBinarioPorNombre(nombre);
		if(i > -1){
			aspirantes.remove(i);
			return true;
		}
        return contratado;
    }

    /**
     * Elimina todos los aspirantes de la bolsa cuyos a�os de experiencia <br>
     * son menores a la cantidad de a�os especificada <br>
     *
     * @param aniosExperiencia La cantidad de a�os con relaci�n a la cual se van a eliminar los aspirantes. aniosExperiencia>=0
     * @return La cantidad de aspirantes que fueron eliminados
     */
    public int eliminarAspirantesPorExperiencia(int aniosExperiencia) {
        int eliminados = 0;
        for(int i = aspirantes.size() - 1; i >= 0; i--){
            if(aspirantes.get(i).darAniosExperiencia() < aniosExperiencia) {
                aspirantes.remove(i);
                eliminados += 1;
            }
        }

        return eliminados;
    }

}