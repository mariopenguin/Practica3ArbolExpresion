

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
    public String postOrden1(NodoArbol nodo) {

        if (nodo != null) {
           // System.out.print(nodo.getClave());
            calcular(nodo);
            return postOrden1(nodo.getIz())+postOrden1(nodo.getDe())+nodo.getClave();
        }
        return "";

    }
    public String postOrden() {
        //System.out.print ("Post orden: ");
        return postOrden1(raiz);

    }

    public float calcularValor(){
        float resul= 0;


        return resul;
    }
    private float calcular(NodoArbol nodo){
        float resul=0;
        if (nodo!= null){
            if (MetodosAE.esOperador(nodo.getClave()) && MetodosAE.esDigito(nodo.getIz().getClave()) && MetodosAE.esDigito(nodo.getDe().getClave())){
                int izdo =MetodosAE.pasarAEntero(nodo.getIz().getClave());
                int derecho =MetodosAE.pasarAEntero(nodo.getDe().getClave());
                resul= operacion(izdo,derecho,nodo.getClave());
                nodo.setClave((char) resul);
                System.out.println(resul);
            }
        }

        return resul;
    }
    public  void postOrden2(NodoArbol nodo) {

        if (nodo != null) {
            // System.out.print(nodo.getClave());

            postOrden2(nodo.getIz());postOrden1(nodo.getDe());nodo.getClave();
            postOrden2(nodo);
        }


    }
    public float operacion(int n1,int n2, char operando){
        switch (operando){
        case '-':
            return n1 - n2;
            case '+':
                return n1+n2;
            case '*':
                return n1*n2;
            case '/':
                return n1/n2;

        }
        return 0;
    }
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

}
