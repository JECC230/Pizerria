
###  Documentación del Código: Estructuras de Datos**

El programa de la pizzería utiliza tres estructuras de datos principales de Java: **Pila (Stack)**, **Cola (Queue)** y **Lista (List)**. Cada una se eligió por sus propiedades únicas, las cuales se alinean perfectamente con las necesidades de gestión de una pizzería.

### Pila (Stack)

En el código, la **Pila** se implementa con la clase `java.util.Stack` y se utiliza para gestionar las **tareas urgentes**.

* **¿Por qué una Pila?** La pila sigue un principio de **LIFO (Last-In, First-Out)**, que significa "el último en entrar es el primero en salir". Esto es ideal para manejar tareas que requieren atención inmediata o quejas de clientes, ya que la tarea más reciente (el problema más nuevo) es la primera que se debe abordar. Por ejemplo, si un cliente llama con una queja, su problema se convierte en la tarea más urgente y se coloca en la cima de la pila, siendo la primera en ser atendida.

* **Implementación en el Código:**
    * `push()`: Agrega una nueva `TareaUrgente` a la cima de la pila.
    * `pop()`: Elimina y devuelve la `TareaUrgente` de la cima, resolviendo la tarea más reciente.
    * `peek()`: Permite ver la tarea más urgente sin eliminarla, lo que es útil para que el gerente sepa cuál es la prioridad actual.

---

### Cola (Queue)

La **Cola** se implementa con la clase `java.util.LinkedList` (que es una implementación común de la interfaz `Queue`) y se utiliza para gestionar el **flujo de pedidos de pizza**.

* **¿Por qué una Cola?** La cola opera bajo el principio **FIFO (First-In, First-Out)**, que significa "el primero en entrar es el primero en salir". Este es el método más justo y lógico para procesar pedidos en una cocina. Los clientes que ordenaron primero deben recibir sus pizzas primero. Usar una cola asegura que no se pierda el orden y que la cocina trabaje de manera organizada.

* **Implementación en el Código:**
    * `add()` o `enqueue`: Agrega un nuevo `Pedido` al final de la cola cuando un cliente realiza su orden.
    * `poll()` o `dequeue`: Elimina y devuelve el `Pedido` que ha estado esperando más tiempo en la cola, indicando que se ha completado.
    * `peek()` o `front`: Permite ver el próximo pedido a preparar sin sacarlo de la cola, ayudando al chef a planificar su trabajo.

---

### Lista (List)

La **Lista** se implementa con la clase `java.util.ArrayList` y se usa para gestionar el **menú de productos de la pizzería**.

* **¿Por qué una Lista?** A diferencia de las pilas y colas, una lista no tiene un orden de procesamiento fijo. Permite el **acceso aleatorio** a sus elementos. Esto es ideal para un menú, ya que los productos pueden ser consultados, agregados o eliminados en cualquier orden, sin depender de su posición de entrada. Por ejemplo, un cliente podría preguntar por un producto específico sin importar cuándo se añadió al menú.

* **Implementación en el Código:**
    * `add()`: Se utiliza para agregar nuevos productos al menú.
    * `remove()`: Permite eliminar un producto del menú, por ejemplo, si se descontinúa.
    * Un bucle `for` o un método `stream()` se usa para **buscar** un producto por su ID, lo que demuestra la facilidad de acceso aleatorio de la lista para encontrar información específica.
