class Nodo {
    String nombre;
    int edad;
    char sexo;
    Nodo izquierdo, derecho;

    public Nodo(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.izquierdo = this.derecho = null;
    }
}