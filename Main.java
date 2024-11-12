import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolGenealogico arbol = new ArbolGenealogico();

        boolean continuar = true;
        while (continuar) {
            System.out.println("Menú de Opciones:");
            System.out.println("a. Insertar integrante");
            System.out.println("b. Edad promedio de la familia");
            System.out.println("c. Integrante menor en edad");
            System.out.println("d. Integrante mayor en edad");
            System.out.println("e. Número de hombres");
            System.out.println("f. Número de mujeres");
            System.out.println("g. Número de integrantes");
            System.out.println("h. Profundidad del árbol");
            System.out.println("i. Número de hojas en el árbol");
            System.out.println("j. Salir");
            System.out.print("Seleccione una opción: ");
            char opcion = scanner.next().charAt(0);

            switch (opcion) {
                case 'a':
                    System.out.print("Nombre: ");
                    String nombre = scanner.next();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    System.out.print("Sexo (M/F): ");
                    char sexo = scanner.next().charAt(0);
                    arbol.insertar(nombre, edad, sexo);
                    break;
                case 'b':
                    System.out.println("Edad promedio: " + arbol.calcularEdadPromedio());
                    break;
                case 'c':
                    Nodo menor = arbol.encontrarMenor();
                    System.out.println("Integrante menor: " + menor.nombre + ", Edad: " + menor.edad);
                    break;
                case 'd':
                    Nodo mayor = arbol.encontrarMayor();
                    System.out.println("Integrante mayor: " + mayor.nombre + ", Edad: " + mayor.edad);
                    break;
                case 'e':
                    System.out.println("Número de hombres: " + arbol.contarHombres());
                    break;
                case 'f':
                    System.out.println("Número de mujeres: " + arbol.contarMujeres());
                    break;
                case 'g':
                    System.out.println("Número de integrantes: " + arbol.contarIntegrantes());
                    break;
                case 'h':
                    System.out.println("Profundidad del árbol: " + arbol.calcularProfundidad());
                    break;
                case 'i':
                    System.out.println("Número de hojas: " + arbol.contarHojas());
                    break;
                case 'j':
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }
}