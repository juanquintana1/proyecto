# 🚗 AutoGest

## Sistema de Gestión de Concesionario de Vehículos

AutoGest es una aplicación de escritorio desarrollada en **Java** con **Swing**, orientada a la gestión de un concesionario de vehículos.

El sistema permitirá administrar usuarios, vehículos, clientes, ventas, contratos e inventario, además de incorporar diferentes **estructuras de datos y algoritmos** como listas, pilas, colas, tablas hash, árboles y grafos.

El proyecto está diseñado aplicando principios de **Programación Orientada a Objetos (POO)**, estructuras de datos, algoritmos, manejo de excepciones, pruebas unitarias y una arquitectura separada entre la interfaz gráfica y la lógica del sistema.

---

# 🎯 Objetivo

Desarrollar un sistema que permita:

* Gestionar el inventario de vehículos.
* Registrar y consultar clientes.
* Registrar y administrar ventas.
* Gestionar contratos.
* Administrar empleados y usuarios.
* Controlar el acceso según el tipo de usuario.
* Consultar información de manera eficiente.
* Organizar y ordenar información mediante algoritmos.
* Gestionar solicitudes y procesos mediante estructuras de datos.
* Representar las sucursales y sus rutas mediante un grafo.
* Analizar la complejidad de los principales algoritmos utilizados.

---

# 👥 Tipos de usuario

El sistema tendrá dos tipos principales de usuario:

### 👨‍💼 Administrador / Supervisor

Tendrá acceso a las funciones administrativas del sistema.

Entre ellas:

* Gestionar empleados.
* Gestionar vehículos.
* Gestionar clientes.
* Consultar ventas.
* Gestionar contratos.
* Consultar estadísticas.
* Consultar inventario.
* Gestionar categorías de clientes y descuentos.
* Consultar información de sucursales.
* Gestionar o consultar rutas.
* Acceder a reportes administrativos.

### 👨‍💻 Empleado / Vendedor

Tendrá acceso únicamente a las funciones necesarias para realizar su trabajo.

Entre ellas:

* Consultar catálogo de vehículos.
* Consultar vehículos disponibles.
* Registrar clientes.
* Registrar ventas.
* Consultar sus ventas.
* Consultar información necesaria para realizar una venta.
* Gestionar solicitudes relacionadas con su trabajo.

El sistema utilizará **autenticación** para determinar quién está ingresando y, dependiendo del tipo de usuario, abrirá el menú correspondiente.

No se plantea inicialmente un sistema independiente de permisos. La separación se realizará mediante los diferentes menús de la aplicación.

---

# 🧱 Entidades principales

El modelo inicial contempla las siguientes clases:

```text
Usuario (abstracta)
│
├── Administrador
└── Empleado

Vehiculo
Cliente
Venta
Contrato
CategoriaCliente
Descuento
Sucursal
Ruta
```

Algunas entidades podrán modificarse, dividirse o agregarse durante el desarrollo si el diseño lo requiere.

---

# 🧬 Programación Orientada a Objetos

El proyecto aplicará los principales conceptos de POO:

### Encapsulamiento

Los atributos de las entidades estarán protegidos mediante modificadores de acceso y serán manipulados mediante métodos apropiados.

### Herencia

Se utilizará principalmente para representar los diferentes tipos de usuario:

```text
Usuario
├── Administrador
└── Empleado
```

### Clases abstractas

`Usuario` será una clase abstracta porque representa el concepto general de usuario del sistema y no se pretende crear un objeto de tipo `Usuario` directamente.

No se añadirá un método abstracto artificialmente solo para cumplir el requisito. Se incorporará comportamiento abstracto únicamente si posteriormente existe una diferencia real de comportamiento entre las clases hijas.

### Polimorfismo

Se utilizará cuando diferentes tipos de objetos puedan ser tratados mediante una referencia común y presenten comportamientos diferentes.

### Interfaces

Se incorporarán interfaces cuando exista un comportamiento que tenga sentido abstraer y que pueda ser compartido por diferentes clases.

---

# 🔐 Autenticación

El flujo básico será:

```text
Usuario
   ↓
LoginFrame
   ↓
AuthService
   ↓
Buscar usuario
   ↓
¿Credenciales correctas?
   ↓
Usuario autenticado
   ↓
¿Administrador o Empleado?
   ├── Administrador → AdminFrame
   └── Empleado      → EmpleadoFrame
```

La autenticación será responsabilidad de la lógica del sistema, no de la clase `Usuario`.

De esta manera:

* `Usuario` representa los datos del usuario.
* `AuthService` se encarga de autenticar.
* `LoginFrame` se encarga de la interfaz.
* Los menús se encargan de mostrar las funcionalidades correspondientes.

---

# 🗃️ Estructuras de datos

Uno de los objetivos principales del proyecto es utilizar estructuras de datos en **procesos reales del sistema**, y no simplemente implementarlas para cumplir un requisito.

## Lista enlazada

Podrá utilizarse para almacenar, por ejemplo:

* Historial de ventas.
* Registros que necesiten recorridos secuenciales.
* Colecciones dinámicas.

---

## 🥞 Pila (Stack)

Se plantea utilizar una pila para implementar un mecanismo como:

* Historial de acciones.
* Deshacer acciones.
* Historial de navegación.

Ejemplo:

```text
Acción 1
   ↓
Acción 2
   ↓
Acción 3
   ↓
   TOP
```

La última acción realizada sería la primera en recuperarse.

---

## 🚶 Cola (Queue)

Se utilizará para representar un proceso real basado en turnos.

Por ejemplo:

```text
Clientes esperando atención

Cliente A → Cliente B → Cliente C → Cliente D
    ↑
   SALE
```

El primero en entrar será el primero en ser atendido.

---

## ⚡ Tabla Hash

La tabla hash permitirá realizar búsquedas rápidas mediante una clave.

Posibles claves:

* VIN del vehículo.
* Placa.
* Documento del cliente.
* Identificador del usuario.

Se deberá implementar un mecanismo para manejar **colisiones**, por ejemplo:

* Encadenamiento.
* Sondeo lineal.
* Sondeo cuadrático.
* Doble hashing.

---

# 🌳 Árbol

Se incorporará un árbol, probablemente un **árbol binario de búsqueda (BST)**.

Una posible utilización será organizar vehículos según su precio:

```text
             80M
            /   \
          50M   120M
         /  \    /  \
       30M 60M 100M 150M
```

Esto permitirá realizar operaciones de búsqueda y recorridos.

Se deberán implementar al menos dos recorridos, por ejemplo:

* Inorden.
* Preorden.
* Postorden.

El recorrido **inorden** permitiría obtener los vehículos ordenados según la clave utilizada.

---

# 🗺️ Grafo y rutas

Las **sucursales del concesionario** podrán representarse mediante un grafo.

```text
Sucursal A ───── Sucursal B
     │                │
     │                │
     └──── Sucursal C ┘
            │
            │
        Sucursal D
```

* Cada sucursal será un nodo.
* Cada conexión entre sucursales será una arista.
* Las aristas podrán tener un peso que represente distancia, tiempo o costo.

Esto permitirá implementar:

### BFS

Para explorar las sucursales por niveles y determinar conectividad.

### DFS

Para realizar recorridos profundos y analizar la estructura del grafo.

### Dijkstra

Como posible funcionalidad avanzada para encontrar la ruta de menor costo entre dos sucursales.

---

# 🔎 Algoritmos de búsqueda

El proyecto deberá implementar al menos dos algoritmos de búsqueda.

Se contemplan:

### Búsqueda lineal

Recorre los elementos hasta encontrar el buscado.

```text
[10, 25, 40, 55, 80]

Buscar 55

10 → 25 → 40 → 55 ✓
```

Complejidad:

```text
O(n)
```

### Búsqueda binaria

Se utilizará sobre datos previamente ordenados.

Complejidad:

```text
O(log n)
```

### Búsqueda mediante tabla hash

Permitirá realizar búsquedas utilizando una clave.

En condiciones ideales:

```text
O(1)
```

La elección final de las búsquedas dependerá de cómo se integren con las funcionalidades del sistema.

---

# 🔃 Algoritmos de ordenamiento

Se implementarán al menos dos algoritmos de ordenamiento.

Se contemplan:

* Bubble Sort.
* Selection Sort.
* Insertion Sort.
* Merge Sort.
* Quick Sort.
* Heap Sort.

Como candidatos principales se consideran:

**Merge Sort** y **Quick Sort**, debido a su utilidad práctica y a que permiten realizar un análisis interesante de complejidad.

Ejemplo de aplicación:

```text
Vehículos sin ordenar

80M
35M
120M
60M
45M

        ↓ Ordenamiento

35M
45M
60M
80M
120M
```

---

# 📊 Complejidad algorítmica

Para los principales algoritmos y estructuras se realizará un análisis de complejidad utilizando la notación **Big O**.

Ejemplos:

| Operación             |       Complejidad aproximada |
| --------------------- | ---------------------------: |
| Búsqueda lineal       |                         O(n) |
| Búsqueda binaria      |                     O(log n) |
| Hash — promedio       |                         O(1) |
| Recorrido de lista    |                         O(n) |
| Merge Sort            |                   O(n log n) |
| Quick Sort — promedio |                   O(n log n) |
| BFS                   |                     O(V + E) |
| DFS                   |                     O(V + E) |
| Dijkstra              | Depende de la implementación |

El análisis definitivo dependerá de las implementaciones realizadas.

---

# 🖥️ Interfaz gráfica

La aplicación será desarrollada utilizando **Java Swing**.

Se utilizarán componentes como:

* `JFrame`
* `JPanel`
* `JButton`
* `JLabel`
* `JTextField`
* `JPasswordField`
* `JTable`
* `JComboBox`
* `JOptionPane`
* Entre otros.

La interfaz tendrá diferentes vistas según el usuario autenticado.

### Login

```text
┌─────────────────────────┐
│        AutoGest         │
│                         │
│ Usuario:  [__________]  │
│                         │
│ Clave:    [__________]  │
│                         │
│       [ INGRESAR ]      │
└─────────────────────────┘
```

### Menú administrativo

```text
┌─────────────────────────────────┐
│         Panel Administrativo    │
├─────────────────────────────────┤
│ [Usuarios] [Vehículos] [Clientes]│
│ [Ventas]   [Contratos] [Reportes]│
│ [Rutas]    [Inventario]          │
└─────────────────────────────────┘
```

### Menú empleado

```text
┌─────────────────────────────────┐
│           Panel Empleado        │
├─────────────────────────────────┤
│ [Catálogo] [Clientes] [Ventas]  │
│ [Disponibilidad] [Mis ventas]   │
└─────────────────────────────────┘
```

---

# 🏗️ Arquitectura del proyecto

Se propone separar el proyecto en diferentes paquetes:

```text
src/
│
├── model/
│   ├── Usuario
│   ├── Administrador
│   ├── Empleado
│   ├── Vehiculo
│   ├── Cliente
│   ├── Venta
│   ├── Contrato
│   ├── CategoriaCliente
│   ├── Descuento
│   └── Sucursal
│
├── structures/
│   ├── ListaEnlazada
│   ├── Pila
│   ├── Cola
│   ├── TablaHash
│   ├── ArbolBST
│   └── Grafo
│
├── algorithms/
│   ├── BusquedaLineal
│   ├── BusquedaBinaria
│   ├── MergeSort
│   ├── QuickSort
│   ├── BFS
│   ├── DFS
│   └── Dijkstra
│
├── services/
│   ├── AuthService
│   ├── VehiculoService
│   ├── ClienteService
│   ├── VentaService
│   ├── RutaService
│   └── ReporteService
│
├── ui/
│   ├── LoginFrame
│   ├── AdminFrame
│   ├── EmpleadoFrame
│   └── panels...
│
├── exceptions/
│
├── test/
│
└── Main
```

La estructura podrá modificarse durante el desarrollo.

---

# 🔄 Separación de responsabilidades

Se buscará evitar que las clases tengan responsabilidades que no les corresponden.

Por ejemplo:

```text
UI
 ↓
Service
 ↓
Model / Structures
 ↓
Algorithms
```

La interfaz gráfica no debería encargarse directamente de implementar algoritmos o manipular estructuras complejas.

Por ejemplo:

```text
LoginFrame
     ↓
AuthService
     ↓
TablaHash / colección de usuarios
     ↓
Usuario
```

Esto permitirá mantener el código organizado y facilitar las pruebas.

---

# 🧪 Pruebas

El proyecto utilizará **JUnit 5** para probar las funcionalidades principales.

Se realizarán pruebas sobre:

* Clases del modelo.
* Estructuras de datos.
* Algoritmos de búsqueda.
* Algoritmos de ordenamiento.
* Autenticación.
* Operaciones CRUD.
* Casos límite.
* Manejo de excepciones.

---

# ⚠️ Manejo de excepciones

Se utilizarán excepciones para controlar situaciones inválidas, por ejemplo:

* Credenciales incorrectas.
* Vehículo inexistente.
* Cliente inexistente.
* Datos inválidos.
* Intento de registrar información duplicada.
* Operaciones inválidas sobre estructuras vacías.
* Búsquedas sin resultados.

Se podrán crear excepciones personalizadas cuando sea necesario.

---

# 📦 Funcionalidades CRUD

El sistema deberá permitir operaciones CRUD sobre las principales entidades.

CRUD:

```text
C → Create    Crear
R → Read      Consultar
U → Update    Actualizar
D → Delete    Eliminar
```

Por ejemplo, para vehículos:

```text
Crear vehículo
      ↓
Consultar vehículo
      ↓
Actualizar vehículo
      ↓
Eliminar vehículo
```

---

# 📈 Posibles reportes

El administrador podrá consultar información como:

* Total de ventas.
* Vehículos más vendidos.
* Vehículos disponibles.
* Vehículos agotados.
* Ventas por empleado.
* Clientes por categoría.
* Descuentos aplicados.
* Inventario por sucursal.
* Información relacionada con las rutas.

Los reportes podrán servir además como escenarios reales para aplicar búsquedas, ordenamientos y estructuras de datos.

---

# 🔧 Tecnologías

* **Java**
* **Java Swing**
* **JUnit 5**
* **Git**
* **GitHub**
* IDE compatible con Java

---

# 🌿 Control de versiones

El proyecto será desarrollado utilizando Git y GitHub.

Se buscará mantener:

* Commits frecuentes.
* Mensajes de commit descriptivos.
* Ramas para funcionalidades importantes.
* Issues para organizar tareas.
* Kanban para visualizar el progreso.
* Pull Requests cuando sea conveniente.

---

# 👨‍💻 Equipo

Proyecto desarrollado por:

* Integrante 1
* Integrante 2

---

# 🚀 Estado del proyecto

### Actualmente

* [x] Definición general del problema
* [x] Definición inicial de usuarios
* [x] Definición inicial de entidades
* [x] Diseño conceptual de estructuras de datos
* [x] Diseño conceptual de algoritmos
* [ ] Diseño UML
* [ ] Implementación del modelo
* [ ] Implementación de estructuras
* [ ] Implementación de algoritmos
* [ ] Implementación de servicios
* [ ] Interfaz gráfica
* [ ] Pruebas unitarias
* [ ] Integración completa
* [ ] Documentación final
* [ ] Preparación de sustentación

---

# 💡 Principio del proyecto

El objetivo no es simplemente implementar estructuras y algoritmos para cumplir una lista de requisitos.

Cada estructura y algoritmo debe tener una **justificación dentro del problema del concesionario**.

Por ejemplo:

```text
Vehículos
   ↓
Tabla Hash
   ↓
Buscar rápidamente por VIN

Vehículos
   ↓
Árbol BST
   ↓
Organizar/buscar por precio

Clientes
   ↓
Cola
   ↓
Gestionar turnos de atención

Sucursales
   ↓
Grafo
   ↓
Representar rutas

Acciones
   ↓
Pila
   ↓
Historial / deshacer

Ventas
   ↓
Lista enlazada
   ↓
Historial dinámico
```

De esta manera, el proyecto busca demostrar no solamente que las estructuras y algoritmos fueron implementados, sino que **se comprende cuándo, cómo y por qué utilizarlos**.
