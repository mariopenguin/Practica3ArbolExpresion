

public class Principal {
    public static void main(String[] args) {
     Arbol arbol = MetodosAE.notacInfija("((5+2)*(8-3))/4");
     Arbol arbol2 = MetodosAE.notacInfija("((2*9)+((3-7)*5))/9");
     //arbol.preOrden();
     //System.out.println(arbol.postOrden());
     char resta = '-';
     System.out.println(arbol2.postOrden());

        System.out.println(arbol.operacion(2,2,'+'));
        arbol.operacion(2,2,'-');

        arbol.operacion(2,2,'*');

        arbol.operacion(2,2,'/');

    }
}
