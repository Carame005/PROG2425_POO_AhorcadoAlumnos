class Jugador(intentosMaximos: Int) {

    private var intentos = intentosMaximos
    private val letrasUsadas = mutableSetOf<Char>()

    fun intentarLetra(letra: Char): Boolean {
        if (letrasUsadas.add(letra)) {
            return true
        } else {
            return false
        }
    }

    fun fallarIntento() {
        intentos--
    }


    fun obtenerLetrasUsadas():String{
        return letrasUsadas.joinToString {" "}


    }

}
