# Cincuentazo

Mini proyecto 3 del curso **750014C Fundamentos de Programación Orientada a Eventos**, Universidad del Valle.

Juego de cartas hecho en Java con JavaFX. El jugador humano juega contra 1, 2 o 3 máquinas. Cada uno pone una carta en la mesa sin que la suma pase de **50**. Quien no pueda jugar queda eliminado, y gana el último jugador que quede.

<!-- Agregar la captura cuando la ventana de juego esté lista: -->
<!-- ![Captura del juego](docs/captura.png) -->

## Integrantes

- Santiago Ruiz Vanegas
- Jose Luis Valencia
- Juan Manuel Cadena

## Reglas

**Valor de las cartas**

| Carta | Valor |
|---|---|
| 2 a 8 y 10 | Suman su número |
| 9 | 0 |
| J, Q, K | Restan 10 |
| A | Suma 10 si la suma no pasa de 50; si pasa, suma 1 |

**Cómo se juega**

1. Se baraja el mazo, cada jugador recibe 4 cartas y se pone 1 carta en la mesa. La suma empieza con el valor de esa carta (si es un As, vale 1).
2. Los turnos van así: humano → máquina 1 → máquina 2 → máquina 3 → humano...
3. En su turno, el jugador pone una carta que no haga pasar la suma de 50 y luego toma una carta del mazo, para quedar otra vez con 4.
4. Si al empezar su turno el jugador no tiene ninguna carta que pueda jugar, queda **eliminado** y sus cartas van al final del mazo.
5. Si el mazo se acaba, las cartas de la mesa (menos la última) se barajan y pasan al mazo. La suma no cambia.
6. Gana el último jugador que quede. Si el humano queda eliminado, las máquinas siguen jugando hasta que gane una.

## Cómo ejecutarlo

Requisitos: JDK 17 o superior y Maven (IntelliJ IDEA ya trae Maven).

- **IntelliJ IDEA:** abrir la carpeta del proyecto y ejecutar la clase `Launcher`.
- **Terminal:**

  ```bash
  mvn clean javafx:run
  ```

- **Pruebas unitarias:**

  ```bash
  mvn test
  ```

Para generar la documentación Javadoc en IntelliJ: **Tools → Generate JavaDoc...**, elegir la carpeta de salida `javadoc/` (está en el `.gitignore`) y en *Other command line arguments* poner `-encoding UTF-8`.

## Estructura (Modelo-Vista-Controlador)

```
src/main/java/com/example/cincuentazo/
├── Main.java, Launcher.java           Inicio de la aplicación
├── model/
│   ├── card/
│   │   ├── Rank.java                  Valores A, 2..10, J, Q, K y lo que suma cada uno
│   │   ├── Suit.java                  Palos
│   │   ├── Card.java                  Carta: valor del As y si se puede jugar
│   │   └── CardFactory.java           Crea las 52 cartas (Factory Method)
│   ├── deck/
│   │   ├── Deck.java                  Mazo con Deque
│   │   └── Table.java                 Mesa con Stack y la suma
│   ├── exceptions/
│   │   ├── InvalidCardPlayException   Marcada: la carta pasa de 50
│   │   └── EmptyDeckException         No marcada: el mazo está vacío
│   ├── player/                        Jugadores y estrategia de la máquina
│   ├── game/                          Lógica del juego (Facade) y Observer
│   └── threads/                       Hilo de la máquina y cronómetro
├── view/                              Ventanas de inicio y de juego
└── controller/                        Controladores y adaptador de clic
src/test/java/com/example/cincuentazo/
├── CardTest.java
├── DeckTest.java
└── GameTest.java
```

## Requisitos del enunciado

| Requisito | Dónde está |
|---|---|
| Interfaz gráfica con UX/UI | Ventana de inicio y ventana de juego, `styles.css` e imágenes de las cartas |
| Arquitectura MVC | Paquetes `model`, `view` y `controller` |
| Javadoc | Todas las clases y métodos están documentados |
| Git y GitHub | Ramas `SRV`, `JLV` y `JMC`, con Pull Requests hacia `main` |
| Excepción marcada | `InvalidCardPlayException extends Exception`, la lanza `Table.play` |
| Excepción no marcada | `EmptyDeckException extends RuntimeException`, la lanza `Deck.draw`; también `IllegalArgumentException` al validar datos |
| Excepciones propias | `InvalidCardPlayException` y `EmptyDeckException` |
| Uso de `finally` | `Deck.refillFrom`: siempre vacía la lista de cartas de la mesa |
| Dos hilos | `MachineTurnThread` (turno de la máquina, 2 a 4 s) y `GameClockThread` (cronómetro) |
| Tres clases de pruebas | `CardTest`, `DeckTest` y `GameTest` (JUnit 5) |
| Estructuras de datos | `Deque` en el mazo, `Stack` en la mesa y `ArrayList` en las manos |

## Patrones de diseño

| Patrón | Tipo | Clase | Para qué |
|---|---|---|---|
| Factory Method | Creacional | `CardFactory` | Es el único lugar donde se crean cartas. El constructor de `Card` no es público. |
| Facade | Estructural | `Game` | El controlador solo habla con `Game`, no con el mazo, la mesa y los jugadores por separado. |
| Adapter | Estructural | `CardClickAdapter` | Clase adaptadora de eventos de mouse: se hereda solo el método que se usa. |
| Observer | Comportamiento | `IGameObserver` | El modelo avisa los cambios y el controlador redibuja la vista. |
| Strategy | Comportamiento | `IPlayStrategy` | Define cómo escoge carta la máquina. |

## Cómo funciona el modelo de cartas

- **Valor del As:** `Card.getValueFor(suma)` devuelve 10 si `suma + 10 <= 50`; si no, devuelve 1. En la carta inicial de la mesa el As siempre vale 1 (`Table.placeInitialCard` usa el valor base de `Rank`).
- **Carta jugable:** `Card.canBePlayedOn(suma)` revisa que `suma + valor <= 50`. El 9 y las figuras siempre se pueden jugar.
- **Mazo (`Deque`):** `draw` saca la carta del frente y `addToBottom` agrega cartas al final. Se usa una cola doble porque se trabaja por los dos extremos.
- **Mesa (`Stack`):** `play` hace `push` y `getTopCard` hace `peek`. `takeAllButTop` saca la carta de arriba, toma todas las demás y vuelve a poner la de arriba, sin cambiar la suma.
- **Límite de 50:** está en la constante `Card.MAX_SUM`. Si se quiere cambiar, se cambia solo ahí.

## Créditos

<!-- Poner aquí la fuente y la licencia de las imágenes de las cartas. -->
