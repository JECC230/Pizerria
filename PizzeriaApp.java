import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PizzeriaApp {

    // Estructuras de datos
    private static Stack<TareaUrgente> tareasUrgentes = new Stack<>();
    private static Queue<Pedido> colaDePedidos = new LinkedList<>();
    private static List<Producto> menu = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Inicializar el menú con productos de ejemplo
        inicializarMenu();

        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    gestionarTareasUrgentes();
                    break;
                case 2:
                    gestionarPedidos();
                    break;
                case 3:
                    gestionarMenu();
                    break;
                case 4:
                    verTodasLasTareasPendientes();
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta la próxima!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n--- Sistema de Gestión de Pizzería ---");
        System.out.println("1. Gestionar Tareas Urgentes (Pila)");
        System.out.println("2. Gestionar Pedidos (Cola)");
        System.out.println("3. Gestionar Menú de Productos (Lista)");
        System.out.println("4. Ver todas las tareas pendientes");
        System.out.println("0. Salir");
        System.out.print("Selecciona una opción: ");
    }

    private static void inicializarMenu() {
        menu.add(new Producto(1, "Pizza Pepperoni", new BigDecimal("150.00")));
        menu.add(new Producto(2, "Pizza Hawaiana", new BigDecimal("140.00")));
        menu.add(new Producto(3, "Pizza Vegetariana", new BigDecimal("130.00")));
        menu.add(new Producto(4, "Refresco de Cola", new BigDecimal("30.00")));
    }

    // Métodos para la Pila (Tareas Urgentes)
    private static void gestionarTareasUrgentes() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Tareas Urgentes ---");
            System.out.println("1. Agregar tarea (Push)");
            System.out.println("2. Resolver tarea (Pop)");
            System.out.println("3. Ver tarea más urgente (Peek)");
            System.out.println("0. Volver al menú principal");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Describe la tarea urgente: ");
                    String descripcion = scanner.nextLine();
                    tareasUrgentes.push(new TareaUrgente(descripcion));
                    System.out.println("Tarea agregada a la pila.");
                    break;
                case 2:
                    if (!tareasUrgentes.isEmpty()) {
                        TareaUrgente resuelta = tareasUrgentes.pop();
                        System.out.println("Tarea resuelta: " + resuelta);
                    } else {
                        System.out.println("No hay tareas urgentes pendientes.");
                    }
                    break;
                case 3:
                    if (!tareasUrgentes.isEmpty()) {
                        System.out.println("Tarea más urgente: " + tareasUrgentes.peek());
                    } else {
                        System.out.println("No hay tareas urgentes pendientes.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    // Métodos para la Cola (Pedidos)
    private static void gestionarPedidos() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Pedidos ---");
            System.out.println("1. Tomar nuevo pedido (Enqueue)");
            System.out.println("2. Preparar siguiente pedido (Dequeue)");
            System.out.println("3. Ver siguiente pedido (Front)");
            System.out.println("0. Volver al menú principal");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    Pedido nuevoPedido = crearPedido();
                    colaDePedidos.add(nuevoPedido);
                    System.out.println("Pedido #" + nuevoPedido.getIdPedido() + " agregado a la cola.");
                    break;
                case 2:
                    if (!colaDePedidos.isEmpty()) {
                        Pedido preparado = colaDePedidos.poll();
                        System.out.println("Pedido preparado y entregado:\n" + preparado);
                    } else {
                        System.out.println("No hay pedidos pendientes en la cola.");
                    }
                    break;
                case 3:
                    if (!colaDePedidos.isEmpty()) {
                        System.out.println("Siguiente pedido a preparar:\n" + colaDePedidos.peek());
                    } else {
                        System.out.println("No hay pedidos pendientes en la cola.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static Pedido crearPedido() {
        Pedido pedido = new Pedido();
        int opcionProducto;
        do {
            System.out.println("\n--- Crear Pedido ---");
            System.out.println("Menú de Productos:");
            for (Producto p : menu) {
                System.out.println("  " + p);
            }
            System.out.println("0. Finalizar pedido");
            System.out.print("Agrega un producto por ID (o 0 para terminar): ");
            opcionProducto = scanner.nextInt();
            if (opcionProducto > 0) {
                Producto productoSeleccionado = buscarProducto(opcionProducto);
                if (productoSeleccionado != null) {
                    pedido.agregarProducto(productoSeleccionado);
                    System.out.println(productoSeleccionado.getNombre() + " agregado al pedido.");
                } else {
                    System.out.println("Producto no encontrado.");
                }
            }
        } while (opcionProducto != 0);
        return pedido;
    }

    // Métodos para la Lista (Menú)
    private static void gestionarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Menú ---");
            System.out.println("1. Ver menú (Ver Lista)");
            System.out.println("2. Agregar producto (Insertar)");
            System.out.println("3. Eliminar producto (Borrar)");
            System.out.println("4. Buscar producto por ID");
            System.out.println("0. Volver al menú principal");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Menú Completo ---");
                    menu.forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("ID del nuevo producto: ");
                    int idNuevo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nombre del nuevo producto: ");
                    String nombreNuevo = scanner.nextLine();
                    System.out.print("Precio del nuevo producto: ");
                    BigDecimal precioNuevo = scanner.nextBigDecimal();
                    menu.add(new Producto(idNuevo, nombreNuevo, precioNuevo));
                    System.out.println("Producto agregado al menú.");
                    break;
                case 3:
                    System.out.print("ID del producto a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    Producto aEliminar = buscarProducto(idEliminar);
                    if (aEliminar != null) {
                        menu.remove(aEliminar);
                        System.out.println("Producto eliminado.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("ID del producto a buscar: ");
                    int idBuscar = scanner.nextInt();
                    Producto encontrado = buscarProducto(idBuscar);
                    if (encontrado != null) {
                        System.out.println("Producto encontrado: " + encontrado);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static Producto buscarProducto(int id) {
        for (Producto p : menu) {
            if (p.getIdProducto() == id) {
                return p;
            }
        }
        return null;
    }

    // Ver todas las tareas pendientes
    private static void verTodasLasTareasPendientes() {
        System.out.println("\n--- Resumen de Tareas Pendientes ---");
        System.out.println("\n** TAREAS URGENTES (PILA) **");
        if (tareasUrgentes.isEmpty()) {
            System.out.println("No hay tareas urgentes.");
        } else {
            // Recorre la pila sin modificarla
            Stack<TareaUrgente> tempStack = (Stack<TareaUrgente>) tareasUrgentes.clone();
            while (!tempStack.isEmpty()) {
                System.out.println("- " + tempStack.pop());
            }
        }

        System.out.println("\n** PEDIDOS EN COLA **");
        if (colaDePedidos.isEmpty()) {
            System.out.println("No hay pedidos en la cola.");
        } else {
            // Recorre la cola sin modificarla
            for (Pedido p : colaDePedidos) {
                System.out.println("- Pedido #" + p.getIdPedido() + ", Total: $" + p.getTotal());
            }
        }
    }
}
