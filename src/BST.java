import java.util.Arrays;
public class BST {
    public static int counterLeft = 1; //inician en 1, ya que cuando añadimos la root, la profundidad es 1
    public static int counterRight = 1; //inician en 1, ya que cuando añadimos la root, la profundidad es 1
    Node root;
    public void add(Node node){
        if(root == null){
            root = node;
        }else{
            add(root, node);
        }
    }
    private void add(Node current, Node node){
        if(node.getKey().compareTo(current.getKey()) < 0){ //Si el nodo entrante comparado con el nodo actual, es menor, lo ponemos a la izq
            //Meter a la izquierda
            if(current.getLeft() == null){ //Aqui es si el nodo de la izquierda esta vacia, si es a si, colocamos el nodo nuevo.
                current.setLeft(node);
            }else{
                add(current.getLeft(), node); //Si no, vamos a la izq y volvemos a hacer el llamado al metodo.
            }
        }else if(node.getKey().compareTo(current.getKey()) > 0){ //Si el nodo entrante comparado con el actual es mayor, lo ponemos a la der.
            //Meter a la derecha
            if(current.getRight() == null){ //Si la derecha del actual esta vacio, colocamos el nodo alli.
                current.setRight(node);
            }else{
                add(current.getRight(), node);//Si no, vamos a la der y volvemos a hacer el llamado al metodo.
            }

        }else{
            //No hacer nada
        }
    }
    public void splitToleft(String[] arrayMin){ //SubArreglo de la izquierda
        int middleOfMin=((arrayMin.length-1)/2); //Hallo la mitad del subarreglo de la izquierda
        if(arrayMin.length==0){
            return;
       }
        String theNodeIzq=arrayMin[middleOfMin]; //Obtengo el elemento de la mitad del arreglo menor.
        for(int i=middleOfMin;i<arrayMin.length-1;i++){
            arrayMin[i]=arrayMin[i+1]; //Elimino el elemento de la mitad del arreglo de la izquierda.
        }
        String[] newArrayMin = Arrays.copyOfRange(arrayMin,0,arrayMin.length-1); //Apesar de que elimino un elemento, un arreglo no se le pueden cambiar sus dimensiones, construyo otro con un tamaño de -1 respecto a al copiado
        Node izq = new Node(theNodeIzq); //Creo y añado los nodos que acabo de eliminar del arreglo.
        add(izq);
        splitToleft(newArrayMin);
    }
    public void splitToRight(String[] arrayMax){ //Subarreglo de la derecha.
        int middleOfMax=((arrayMax.length-1)/2);//Hallo la mitad del maximo

        if(arrayMax.length==0){
            return;
        }
        String thenodeDer=arrayMax[middleOfMax];//Obtengo la mitad del elemento mayor.
        for (int i=middleOfMax;i<arrayMax.length-1;i++) {
            arrayMax[i] = arrayMax[i + 1]; //Elimino el elemento de la mitad del arreglo de la derecha.
        }
        String[] newArrayMax = Arrays.copyOfRange(arrayMax,0,arrayMax.length-1); //Apesar de que lo elimino un elemento, un arreglo no se le pueden cambiar sus dimensiones, construyo otro con un tamaño de -1 respecto a al copiado

        Node der = new Node(thenodeDer); //Creo y añado los nodos que acabo de eliminar del arreglo.
        add(der);
        splitToRight(newArrayMax);
    }
    public void profundity(){
        profundityToLeft(root);
        profundityToRight(root);
    }
    private void profundityToRight(Node current) {
        if (current.getRight() == null) {
            return;
        }
        counterRight++;
        profundityToRight(current.getRight());
    }
    private void profundityToLeft(Node current) {
        if (current.getLeft() == null) {
            return;
        }
        counterLeft++;
        profundityToLeft(current.getLeft());
    }
    public void printProfundity(){
        int profundity = Math.max(counterLeft, counterRight);
        System.out.println("La profundidad es: "+profundity);
    }
    public void inOrderReverse(){
        inOrderReverse(root);
    }
    private void inOrderReverse(Node current){ //imprimir el arbol de menor a mayor.
        if(current == null){ //Caso base, si el actual es ==null, retorna todo el metodo, el proceso de impresion inicia...
            return;
        }
        inOrderReverse(current.getRight());//Como el menor es el de la izq, nos dirijimos a el, cuando no haya más izquierda, imprime, regresa a la rama principal y se va a la der, asi hasta terminar con todos los datos.
        System.out.println(current.getKey());
        inOrderReverse(current.getLeft());
    }

}
