class Juego(palabra: Palabra, jugador: Jugador){

    fun iniciar(){
        println("¡Bienvenido al juego del Ahorcado!")
        println("La palabra tiene ${palabra.palabraOculta.length} letras.")

        while (intentos > 0 && palabra.esCompleta() == false) {
            println("Palabra: ${palabra.progreso}")
            println("Intentos restantes: $intentos")
            println("Letras usadas: $jugador.letrasUsadas")
            println("Introduce una letra: ")
            var letra: Char? = readln().lowercase().firstOrNull()

            if (letra == null && jugador.intentarLetra(letra) == false){
                println("Letra no válida o ya utilizada. Intenta otra vez.")
            } else {
                if (palabra.revelarLetra(letra)){
                    println("¡Bien hecho! La letra '$letra' está en la palabra.")
                } else {
                    println("La letra '$letra' no está en la palabra.")
                    jugador.fallarIntento()
                }
            }
        }
        if (palabra.esCompleta()){
            println("\n¡Felicidades! Has adivinado la palabra: ${palabra.obtenerProgreso()}")
        } else {
            println("\nLo siento, te has quedado sin intentos. La palabra era: ${palabra.palabraOculta}")
        }
    }

    fun preguntar(msj: String): Boolean {
        do {
            print("$msj (s/n): ")
            val respuesta = readln().trim().lowercase()
            when (respuesta) {
                "s" -> return true
                "n" -> return false
                else -> println("Respuesta no válida! Inténtelo de nuevo...")
            }
        } while (true)
    }
}
