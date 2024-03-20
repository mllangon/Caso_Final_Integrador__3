# Caso_Final_Integrador__3
Mario Llansó-->https://github.com/mllangon/Caso_Final_Integrador__3.git


#Comentarios:
->Las peleas estan activadas pero hay un muy pequeño porcentaje de que ocurran ya que tienen que estar en la misma zona y a menos de dos posiciones de distancia.

->Me han dado numerosos errores con la terminal por NullPointer que luego se arreglaban solos, espero que no pasen ahora y vaya todo correcto.

->Usuario: Usuario1

->Contraseña: EcoSim123


##Descripción y Documentación:

#Atributos

scanner: Utilizado para leer entradas del usuario desde la consola.

zonas: Lista de Zona que representa diferentes áreas dentro del ecosistema simulado.

animales: Lista de Animales obtenida a través del método estático getAnimalesList.

simulador: Instancia de Simulador utilizada para iniciar y gestionar la simulación del ecosistema.

autenticacion: Instancia de Autenticacion para verificar las credenciales del usuario.

datos: Instancia de Datos para gestionar y visualizar datos de la simulación.

funciones: Instancia de Funciones que proporciona métodos de utilidad.

problemas: Instancia de Problemas para realizar análisis y resolver problemas dentro de la simulación.

random: Utilizado para generar números aleatorios.

eventos: Array de EventoAleatorio que contiene diferentes tipos de eventos que pueden ocurrir durante la simulación.

#Métodos Principales

Simulacion(): Constructor que inicializa las instancias y prepara el ambiente de simulación con animales, plantas y zonas.

iniciar(): Inicia la aplicación, solicitando al usuario que inicie sesión y mostrando el menú principal.

mostrarMenu(): Muestra el menú principal y ejecuta la opción seleccionada por el usuario.

realizarAnalisis(): Realiza un análisis del ecosistema, mostrando datos relevantes y aplicando eventos aleatorios.

#Flujo de Trabajo

Inicio: El usuario ejecuta la aplicación y se le solicita que inicie sesión.

Menú Principal: Una vez autenticado, se muestra el menú principal con opciones para visualizar poblaciones, realizar un análisis, iniciar una simulación, o salir.

#Ejecución de Opciones:

Población: Muestra listas de animales y plantas presentes en el ecosistema.

Análisis: Ejecuta un análisis del ecosistema, aplicando eventos aleatorios y mostrando datos de ambientes y animales.

Simulación: Inicia la simulación del ecosistema mediante la instancia simulador.

Salir: Finaliza la ejecución de la aplicación.
