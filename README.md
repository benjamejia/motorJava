#  MotorJava

Un motor de videojuegos 2D ligero desarrollado desde cero en Java.


## Objetivo del Proyecto

El objetivo principal de este proyecto es construir la infraestructura base (motor) para mis propios videojuegos en 2D. 

A diferencia de los motores de desarrollo comerciales tradicionales (como Unity o Godot), este motor **no cuenta con una interfaz gráfica (GUI) de editor**, sino que está diseñado como un **framework programable**. Proporciona los sistemas fundamentales que cualquier juego requiere, permitiendo enfocar el desarrollo directamente en la lógica del juego.

##  Estructura del Código

```text
src/
├── core/       # Motor base, ventana, entradas y Game Loop
├── scenes/     # Sistema y gestor de escenas (Scene Manager)
├── entities/   # Plantillas base para objetos del juego
└── games/      # Implementación de juegos individuales (ej. Pong, Snake)
