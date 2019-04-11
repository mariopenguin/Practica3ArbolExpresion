

public class Arbol {
    private NodoArbol raiz;
    public Arbol() {
        raiz = null;
    }

    public Arbol(char clave) {
        raiz = new NodoArbol(clave);
    }


    private void preOrden(NodoArbol nodo) {
        if (nodo != null) {
            System.out.print (nodo.getClave() + " "); // Nodo
            preOrden(nodo.getIz()); // Izquierda
            preOrden(nodo.getDe()); // Derecha
        }
    }
    public void preOrden() {
        System.out.print ("Preorden: ");
        preOrden(raiz);
        System.out.println();
    }

    // Escribe las claves del Árbol binario de raiz a en postorden.




    // Escribe las claves del �rbol binario de raiz a en orden central.
    private void ordenCentral(NodoArbol nodo) {
        if (nodo != null) {
            ordenCentral(nodo.getIz()); // Izquierda
            System.out.print(nodo.getClave() + " "); // Nodo
            ordenCentral(nodo.getDe()); // Derecha
        }
    }
    public void ordenCentral() {
        System.out.print ("Orden central: ");
        ordenCentral(raiz);
        System.out.println();
    }

     public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol nodo) {
        raiz = nodo;
    }
	public String postFija(){
        String total="";

        return total;
    }
	public void juntar(char clave, Arbol a1, Arbol a2) {
        if (a1.raiz == a2.raiz && a1.raiz != null)
            System.out.println("no se pueden mezclar, a1 y a2 son iguales");
        else {
            // Crear el nodo nuevo
            raiz = new NodoArbol(clave, a1.raiz, a2.raiz);
            // Borrar los �rboles a1 y a2
            if (this != a1)
                a1.raiz = null;
            if (this != a2)
                a2.raiz = null;
        }
    }

    public String postOrdenRec(NodoArbol nodo) {

        if (nodo != null) {
            // System.out.print(nodo.getClave());

            return postOrdenRec(nodo.getIz()) + postOrdenRec(nodo.getDe()) + nodo.getClave();
        }
        return "";

    }

    public String postOrden() {
        //System.out.print ("Post orden: ");
        return postOrdenRec(raiz);

    }

    public float calcularValor() {
        float resul = 0;
        resul = calcularRec(raiz);

        return resul;
    }

    private float calcularRec(NodoArbol nodo) {
        float resul = 0;
        float izdo, derecho;
        izdo = 0;
        derecho = 0;

        if (nodo != null) {
            if (MetodosAE.esOperador(nodo.getClave())) {
                if (nodo.getIz() != null) {
                    izdo = calcularRec(nodo.getIz());
                    if (nodo.getIz().getIz() == null) {
                        izdo = MetodosAE.pasarAEntero((char) izdo);
                    }
                    System.out.println(izdo);
                }
                if (nodo.getDe() != null) {
                    derecho = calcularRec(nodo.getDe());
                    if (nodo.getDe().getDe() == null) {
                        derecho = MetodosAE.pasarAEntero((char) derecho);
                    }
                }
                resul = operacion(izdo, derecho, nodo.getClave());
                return resul;

            } else {
                return nodo.getClave();
            }
        }
        return 0;

    }

    public float operacion(float n1, float n2, char operando) {

        switch (operando) {
            case '-':
                return n1 - n2;
            case '+':
                return n1 + n2;
            case '*':
                return n1 * n2;
            case '/':
                return n1 / n2;

        }
        return 0;
    }
    //EJERCICIO 1
    public int sumaDatosImparesHijos(){
        return sumaDatosImparesHijosRec(raiz);
    }
    private int sumaDatosImparesHijosRec(NodoArbol nodo){
        if(nodo == null){       //Preguntamos si mi nodo actual es null y devolvemos 0 para la suma
            return 0;
        }
        else{
            if (nodo.getClave()%2==1 &&nodo.getIz()!=null &&nodo.getDe()!=null){ //Si es impar y sus hijos son distintos de null:

                return nodo.getClave()+sumaDatosImparesHijosRec(nodo.getIz())+sumaDatosImparesHijosRec(nodo.getDe());
            }
            else{       //En caso de que la clave del nodo actual sea par, devolvemos la suma de su rama izda y derecha (se devolveran solo los impares)
                return sumaDatosImparesHijosRec(nodo.getIz())+sumaDatosImparesHijosRec(nodo.getDe());

            }
        }

    }
    //Ejercicio 2


    public int sumarDatosNivel(int nivel){
        return sumarDatosNivelRec(raiz,nivel,1);
    }


    private int sumarDatosNivelRec(NodoArbol nodo,Integer nivel,int nivelNodo){

        if (nodo==null){
            return 0;           //Si el nodo es null devolvemos 0
        }
        else{
            if (nivelNodo==nivel){
                return nodo.getClave(); //Si el nivel del nodo es el nivel requerido devolvemos su valor
            }

            else{

                if (nivelNodo>nivel){ //En caso de que el nivel requerido sea mayor, devolvemos 0
                    return 0;
                }
                else{   //Mientras que el nivel sea menor, llamamos de forma recursiva a sus nodos hijos, tanto izquierdo como derecho
                    return sumarDatosNivelRec(nodo.getIz(),nivel,nivelNodo+1)+sumarDatosNivelRec(nodo.getDe(),nivel,nivelNodo+1);
                }
            }
        }
    }


    //Ejercicio 3

    /*  null----> condicion de parada
        nodo con 2 hijos -------> recursividad
        nodo con 1 hijo  -------> creamos nodo y recursividad
        nodo sin hijos ----> condicion de parada (no hacer nada)
     */

    public void completar2Hijos(){
        completar2HijosRec(raiz,1);
    }


    private void completar2HijosRec(NodoArbol nodo,int nivel){
        if (nodo !=null){ //Mi nodo es distinto de null
         if (nodo.getIz()!=null && nodo.getDe()!=null){ //Llamada recursiva, el nodo tiene hijos no nulos
             completar2HijosRec(nodo.getIz(),nivel+1);
             completar2HijosRec(nodo.getDe(),nivel+1);
         }
         else{ //Algún hijo es null, ahora preguntamos cual
             NodoArbol nuevo = new NodoArbol((char) (nivel+1),null,null);
             if (nodo.getIz()!=null){ //Izdo no null pero derecho null
                 nodo.setDe(nuevo);
                 completar2HijosRec(nodo.getDe(),nivel+1);
             }
             else{
                 nodo.setIz(nuevo);
                 completar2HijosRec(nodo.getIz(),nivel+1);
             }

         }
         //En el caso de que no tenga hijos, no hacemos nada
        }
    }


}
