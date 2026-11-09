package cat.insbaixcamp.fitnessapp2.tools


import kotlin.math.round

class CalculadoraIMC {

    companion object {

        fun calcularIMC(pes: Double, alçada: Int): Double {
            if (alçada <= 0 || pes < 0) return 0.0
            val alturaMetros = alçada.toDouble() / 100
            val imc = pes / (alturaMetros * alturaMetros)
            return round(imc * 100) / 100
        }
    }

}