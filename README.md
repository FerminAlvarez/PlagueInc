## PlagueInc
***Proyecto realizado para Tecnología de Programación (2020) - Universidad Nacional del Sur***

### LORE
Las circunstancias actuales que afectan al mundo han hecho que muchas personas pasen más tiempo en sus casas, y una de las consecuencias que se han observado es una creciente demanda de videojuegos como forma de entretenimiento. 
A su vez, el éxito reciente de Plague Inc ha hecho que Ndemic Creations decida apostar nuevamente por una temática parecida.
Sin embargo, en este caso consideran que deben apuntar a acaparar otro mercado, buscando un estilo “vintage” de manera que se pueda apelar a la nostalgia de los consumidores.
Por esta razón, se ha optado por desarrollar un juego con un ambiente de un mundo apocalíptico, pero con un estilo de los clásicos “vertical shooter”.
El personaje principal es uno de los pocos sobrevivientes a una catástrofe desatada por un nuevo virus con una capacidad de propagación y una tasa de mortalidad muy alta. Así
mismo, este nuevo virus tiene efectos un poco extraños, y se sabe que los infectados no pueden darse cuenta ni ser conscientes que lo están, por lo que tomar acciones contra ellos
no es tan simple.
El objetivo principal del juego es sobrevivir, evitando ser contagiado, pero además tratar de recuperar los humanos infectados que, por otro lado, son quienes propagan el virus en
forma involuntaria.


### Mapa
El mapa donde se juega es un escenario vertical donde desde la parte superior hacia la inferior se desplazan los personajes infectados y en la parte inferior se ubica el jugador, el cual solo puede desplazarse en forma horizontal.
Los infectados pueden propagar el virus con un rango de alcance o por un contacto físico directo. Si un infectado pasa la línea inferior de la pantalla, vuelve a aparecer por arriba o (opcionalmente) en su posición original.


### Niveles
El nivel está definido por el conjunto de infectados. La cantidad de infectados en el nivel es fija para cada nivel, pero esta cantidad es dividida en dos tandas. Una vez que los infectados de la primera tanda son desinfectados, la segunda tanda aparece en escena. 
La dificultad del juego se incrementa conforme se avanza a través de los niveles.


### La resistencia del virus y su letalidad
Si bien todos los infectados son portadores del mismo virus, algunos de ellos tienen algunas cepas más resistentes.
Existen al menos 2 tipos de infectados:

* Los portadores de virus Alpha: son fáciles de desinfectar, pero producen un mayor daño al jugador.
* Los portadores de virus Beta: son más difíciles de desinfectar.



### Jugador
Como se mencionó anteriormente, el jugador se encuentra ubicado en la parte inferior del mapa, y solo se desplaza horizontalmente. Este personaje tiene una determinada cantidad
de carga viral que comienza en 0% pero que cuando llega a 100% pierde, y a su vez tiene una velocidad que determina qué tan rápido se desplaza. Además, el jugador dispone de un
arma sanitaria cuyos proyectiles contienen algún tipo de solución capaz de desinfectar a los infectados.


### Proyectiles
Los proyectiles se desplazan verticalmente en dirección contraria a los infectados, con una velocidad definida, y una capacidad de desinfección determinada.


### Infectados
Cada uno de los infectados tienen una carga viral que inicia en 100% y que cuando llega a 0% pasa a estar desinfectado, haciendo que dicho personaje quede fuera del juego.
A medida que se desplazan por el mapa, los infectados propagan el virus con un rango de alcance limitado. Esta propagación del virus es a través de partículas desprendidas de los infectados, con una velocidad de desplazamiento, un rango de alcance, y en dirección vertical desde la parte superior a la parte inferior del mapa.
Así mismo, los infectados se desplazan en una misma dirección vertical desde la parte superior a la parte inferior del mapa y con una velocidad determinada. La excepción a esto
último son los portadores de virus Alpha que cuando se encuentran con una carga viral inferior al 20% produce efectos muy extraños, haciendo que el infectado duplique su velocidad de desplazamiento.


### Premios
Al ser desinfectados, algunos de los infectados dejarán un premio que “cae” en dirección vertical desde la parte superior a la inferior del mapa. El jugador deberá interceptar el premio antes de que el mismo cruce la línea de la pantalla porque ahí el premio desaparece.
Los premios caen a distintas velocidades. Estos premios pueden ser de dos tipos:
* Efecto temporal: Este tipo de premios otorga efectos temporales al jugador. Uno de los efectos deberá ser una “cuarentena obligatoria” que detenga a todos los infectados por un intervalo de tiempo y una “super arma sanitaria” que otorgue un poder de desinfección multiplicado al arma del jugador por un intervalo de tiempo.
* Objetos preciosos: Este tipo de premios le confiere al jugador poderes especiales. Se requiere por lo menos implementar uno de ellos, como puede ser una suerte “poción” que recupere la vida del jugador.
    

### Sprints
**Primer Sprint**
* Diseño del juego
* Diseño UML del juego contemplando todos los aspectos generales del sistema y la incorporación de patrones de diseño: jugador, infectados y premios.
* Diseñar en pseudocódigo (general) la generación del mapa.
* Diseñar el movimiento del jugador e infectados (pseudocódigo).
* Tener pensado como interactuar entre el jugador, los infectados y el mapa.
* Tener funcionando el GitHub con los archivos generados.

**Segundo Sprint**
* Implementar el jugador de manera básica.
* Implementar gráficamente el jugador (sin colisiones).
* Implementar un infectado básico.
* Implementar gráficamente un infectado (sin colisiones ni movimiento).
* Diseñar las partículas que propagan el virus/proyectiles del arma sanitaria.
* Implementar las partículas que propagan el virus/proyectiles del arma sanitaria (sin interacción).
* Incorporar detección de colisiones al juego (implementar).
* Diseñar la interacción entre jugador/infectados y las partículas que propagan el virus/proyectiles del arma sanitaria.
* Diseñar la interacción entre el jugador y los premios.

**Tercer Sprint**
* Implementar las partículas que propagan el virus/proyectiles del arma sanitaria con interacción y gráficamente.
* Implementar la interacción entre jugador/infectados y las partículas que propagan el virus/proyectiles del arma sanitaria.
* Implementar la interacción entre el jugador y los premios.
* Implementar todos los infectados.
* Implementar todos los premios.
* Implementar el ganar/perder.
* Implementar todo gráficamente.


**Diagrama extendido**
![Alt text](https://github.com/FerminAlvarez/PlagueInc/blob/master/Diagramas/Extendido.svg)
<img src="https://github.com/FerminAlvarez/PlagueInc/blob/master/Diagramas/Extendido.svg">

**Diagrama simplificado**
![Alt text](https://github.com/FerminAlvarez/PlagueInc/blob/master/Diagramas/Simplificado.svg)
<img src="https://github.com/FerminAlvarez/PlagueInc/blob/master/Diagramas/Simplificado.svg">



