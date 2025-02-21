package modular;

public class modular {
    public static String[] hierba = {"Maria Juana", "Hierba de los bosques", "La seta feliz", "El oro verde"};
    public static String[] origen = {"Mexico", "Andorra", "Marruecos", "Palestina"};
    public static double[] precio = {1.70, 4.20, 2.47, 1.33};

    public static String[] carrito = new String[10];
    public static double[] cantidades = new double[10];
    public static int carritoSize = 0;

    public static void main(String[] args) {
        System.out.println("Buenos días! ¿Qué quieres hacer hoy?");

        System.out.println("Usuario selecciona buscar por nombre");
        buscarnombre("Juana");

        System.out.println("Usuario selecciona buscar por origen");
        buscarorigen("Andorra");
        
        System.out.println("Usuario selecciona ordenar por precio de menor a mayor");
        ordenar();
        
        System.out.println("Usuario selecciona varios productos para comprar");
        agregarAlCarrito("Hierba de los bosques", 3);
        agregarAlCarrito("El oro verde", 1);
        agregarAlCarrito("La seta feliz", 2.5);
        
        System.out.println("Usuario elimina el segundo elemento de su carrito");
        eliminarDelCarrito("El oro verde");
        
        System.out.println("Usuario finaliza la compra");
        finalizarCompra();
    }

    public static void buscarnombre(String nombre) {
        boolean encontrado = false;
        for (int i = 0; i < hierba.length; i++) {
            if (hierba[i].toLowerCase().contains(nombre.toLowerCase())) {
                System.out.println(hierba[i] + " - " + origen[i] + " - " + precio[i] + "$ ");
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron coincidencias.");
        }
    }

    public static void buscarorigen(String lugar) {
        boolean encontrado = false;
        for (int i = 0; i < origen.length; i++) {
            if (origen[i].equalsIgnoreCase(lugar)) {
                System.out.println(hierba[i] + " - " + origen[i] + " - " + precio[i] + "$ ");
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron coincidencias.");
        }
    }

    public static void ordenar() {
        for (int i = 0; i < precio.length - 1; i++) {
            for (int j = i + 1; j < precio.length; j++) {
                if (precio[i] > precio[j]) {
                    double tempPrecio = precio[i];
                    precio[i] = precio[j];
                    precio[j] = tempPrecio;

                    String tempHierba = hierba[i];
                    hierba[i] = hierba[j];
                    hierba[j] = tempHierba;

                    String tempOrigen = origen[i];
                    origen[i] = origen[j];
                    origen[j] = tempOrigen;
                }
            }
        }
        for (int i = 0; i < hierba.length; i++) {
            System.out.println(hierba[i] + " - " + origen[i] + " - " + precio[i] + "$ ");
        }
    }

    public static void agregarAlCarrito(String nombre, double cantidad) {
        if (carritoSize < carrito.length) {
            carrito[carritoSize] = nombre;
            cantidades[carritoSize] = cantidad;
            carritoSize++;
            System.out.println("Agregado al carrito: " + nombre + " - Cantidad: " + cantidad);
        } else {
            System.out.println("El carrito está lleno.");
        }
    }

    public static void eliminarDelCarrito(String nombre) {
        for (int i = 0; i < carritoSize; i++) {
            if (carrito[i].equals(nombre)) {
                for (int j = i; j < carritoSize - 1; j++) {
                    carrito[j] = carrito[j + 1];
                    cantidades[j] = cantidades[j + 1];
                }
                carritoSize--;
                System.out.println("Producto eliminado del carrito: " + nombre);
                return;
            }
        }
        System.out.println("El producto no está en el carrito.");
    }

    public static void finalizarCompra() {
        double total = 0;
        System.out.println("Resumen de la compra:");
        for (int i = 0; i < carritoSize; i++) {
            String producto = carrito[i];
            double cantidad = cantidades[i];
            double precioUnitario = 0;
            for (int j = 0; j < hierba.length; j++) {
                if (hierba[j].equals(producto)) {
                    precioUnitario = precio[j];
                    break;
                }
            }
            double subtotal = cantidad * precioUnitario;
            total += subtotal;

            // Muestra el subtotal con 2 decimales
            System.out.printf("%s - Cantidad: %.2f - Subtotal: %.2f$ \n", producto, cantidad, subtotal);
        }

        // Muestra el total con 2 decimales
        System.out.printf("Total de la compra: %.2f$ \n", total);
    }
}
