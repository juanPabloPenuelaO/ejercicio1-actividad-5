class ArbolGenealogico {
    Nodo raiz;

    // Inserta un nuevo integrante en el árbol
    public void insertar(String nombre, int edad, char sexo) {
        raiz = insertarRecursivo(raiz, nombre, edad, sexo);
    }

    private Nodo insertarRecursivo(Nodo actual, String nombre, int edad, char sexo) {
        if (actual == null) {
            return new Nodo(nombre, edad, sexo);
        }
        // Lógica de inserción aquí, según el árbol específico.
        // Este ejemplo solo inserta de forma arbitraria
        if (actual.izquierdo == null) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, nombre, edad, sexo);
        } else {
            actual.derecho = insertarRecursivo(actual.derecho, nombre, edad, sexo);
        }
        return actual;
    }

    // Calcula la edad promedio
    public double calcularEdadPromedio() {
        int[] resultado = sumarEdadesYContarNodos(raiz);
        return resultado[1] == 0 ? 0 : (double) resultado[0] / resultado[1];
    }

    private int[] sumarEdadesYContarNodos(Nodo nodo) {
        if (nodo == null) {
            return new int[]{0, 0};
        }
        int[] izquierda = sumarEdadesYContarNodos(nodo.izquierdo);
        int[] derecha = sumarEdadesYContarNodos(nodo.derecho);
        int sumaEdades = izquierda[0] + derecha[0] + nodo.edad;
        int cantidadNodos = izquierda[1] + derecha[1] + 1;
        return new int[]{sumaEdades, cantidadNodos};
    }

    // Encuentra el integrante menor en edad
    public Nodo encontrarMenor() {
        return encontrarMenorRecursivo(raiz, raiz);
    }

    private Nodo encontrarMenorRecursivo(Nodo nodo, Nodo menor) {
        if (nodo == null) return menor;
        if (nodo.edad < menor.edad) menor = nodo;
        menor = encontrarMenorRecursivo(nodo.izquierdo, menor);
        return encontrarMenorRecursivo(nodo.derecho, menor);
    }

    // Encuentra el integrante mayor en edad
    public Nodo encontrarMayor() {
        return encontrarMayorRecursivo(raiz, raiz);
    }

    private Nodo encontrarMayorRecursivo(Nodo nodo, Nodo mayor) {
        if (nodo == null) return mayor;
        if (nodo.edad > mayor.edad) mayor = nodo;
        mayor = encontrarMayorRecursivo(nodo.izquierdo, mayor);
        return encontrarMayorRecursivo(nodo.derecho, mayor);
    }

    // Cuenta el número de hombres
    public int contarHombres() {
        return contarSexo(raiz, 'M');
    }

    // Cuenta el número de mujeres
    public int contarMujeres() {
        return contarSexo(raiz, 'F');
    }

    private int contarSexo(Nodo nodo, char sexo) {
        if (nodo == null) return 0;
        int cuenta = (nodo.sexo == sexo) ? 1 : 0;
        cuenta += contarSexo(nodo.izquierdo, sexo);
        return cuenta + contarSexo(nodo.derecho, sexo);
    }

    // Cuenta el número de integrantes
    public int contarIntegrantes() {
        return contarNodos(raiz);
    }

    private int contarNodos(Nodo nodo) {
        if (nodo == null) return 0;
        return 1 + contarNodos(nodo.izquierdo) + contarNodos(nodo.derecho);
    }

    // Calcula la profundidad del árbol
    public int calcularProfundidad() {
        return calcularProfundidadRecursivo(raiz);
    }

    private int calcularProfundidadRecursivo(Nodo nodo) {
        if (nodo == null) return -1;
        int profundidadIzq = calcularProfundidadRecursivo(nodo.izquierdo);
        int profundidadDer = calcularProfundidadRecursivo(nodo.derecho);
        return 1 + Math.max(profundidadIzq, profundidadDer);
    }

    // Cuenta el número de hojas en el árbol
    public int contarHojas() {
        return contarHojasRecursivo(raiz);
    }

    private int contarHojasRecursivo(Nodo nodo) {
        if (nodo == null) return 0;
        if (nodo.izquierdo == null && nodo.derecho == null) return 1;
        return contarHojasRecursivo(nodo.izquierdo) + contarHojasRecursivo(nodo.derecho);
    }
}