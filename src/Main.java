import java.util.Arrays;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        BST three = new BST();
        Scanner reader = new Scanner(System.in);
        String names;
        System.out.println("Ingrese los nombres");
        names = reader.nextLine();
        String[] array = names.split(" ");
        int middle = ((array.length - 1) / 2);
        String theRoot = array[middle];
        Node root = new Node(theRoot);
        String[] arrayLeft = Arrays.copyOfRange(array, 0, middle); //Creo el arreglo menor, contendrá los elementos antes de la mitad
        String[] arrayRight = Arrays.copyOfRange(array, middle+1, array.length); //Creo el arreglo mayor, contendra los elementos despues de la mitad
        three.add(root);
        three.splitToleft(arrayLeft);
        three.splitToRight(arrayRight);
        three.inOrderReverse();
        three.profundity();
        three.printProfundity();

    }
}