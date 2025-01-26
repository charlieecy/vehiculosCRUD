package dev.carloscy.repositories

import dev.carloscy.COCHE_GASOLINA
import dev.carloscy.models.CocheGasolina
import dev.carloscy.models.Vehiculo
import org.lighthousegames.logging.logging

class VehiculoRepositoryImpl: IVehiculoRepository {
    val logger = logging()
    private var maxVehiculos: Int = 10
    private var vehiculos: Array<Vehiculo?> = arrayOfNulls<Vehiculo>(maxVehiculos)

    override fun create(): Vehiculo {
        logger.debug { "Creando vehículo" }
        var tipoVehiculo: Int? = preguntartipoVehiculo()
        var matricula: String = preguntarMatricula()
        var kms: Int = preguntarKms()
        var anoMatriculacion: Int = preguntarAnoMatriculación()

        when (tipoVehiculo) {
            COCHE_GASOLINA -> {
                var vehiculo: CocheGasolina = CocheGasolina(matricula = matricula, kms = kms, anoMatriculacion = anoMatriculacion)
            }
        }


    }

    private fun preguntartipoVehiculo(): Int? {
        logger.debug { "Preguntando tipo de vehículo al usuario" }
        var tipoVehiculo: Int? = null
        var inputOk: Boolean = false

        do {
            println("¿De qué tipo de vehículo se trata? Teclee el número correspondiente:")
            println("1. Coche de gasolina")
            println("2. Coche eléctrico")
            println("3. Coche híbrido")
            println("4. Motocicleta")

            tipoVehiculo = readln().toIntOrNull()

            if (tipoVehiculo in (1..4)) {
                inputOk = true
            }
        } while (!inputOk)

        return tipoVehiculo
    }

    private fun preguntarAnoMatriculación (): Int {
        logger.debug { "Preguntando año de matriculación al usuario" }
        var userInput: Boolean = false
        var ano: Int

        do {
            println("¿Cuántos kms tiene el vehículo?")
            ano = readln().toIntOrNull() ?: -1
            if (ano < 1950) {
                println("Por favor, introduzca un año de matriculación válido.")
            } else {
                userInput = true
            }
        } while (!userInput)

        return ano
    }

    private fun preguntarKms (): Int {
        logger.debug { "Preguntando kms al usuario" }
        var userInput: Boolean = false
        var kms: Int

        do {
            println("¿Cuántos kms tiene el vehículo?")
            kms = readln().toIntOrNull() ?: -1
            if (kms < 0) {
                println("Por favor, introduzca un número de kilómetros válido.")
            } else {
                userInput = true
            }
        } while (!userInput)

        return kms
    }

    private fun preguntarMatricula (): String {
        logger.debug { "Preguntando matrícula al usuario" }
        var userInput: Boolean = false
        var matricula: String

        do {
            println("¿Cuál es la matrícula del vehículo?")
            matricula = readln()
            if (comprobarMatricula(matricula)) {
                userInput = true
            } else {
                println("El formato de la matrícula no es válido.")
            }
        } while (!userInput)

        return matricula
    }

    private fun comprobarMatricula (matricula: String): Boolean {
        logger.debug { "Comprobando matrícula" }
        var inputOk: Boolean = false
        var matriculaRegEx = """^\d{4}[BCDFGHJKLMNPRSTVWXYZ]{3}$""".toRegex()

        if (matriculaRegEx.matches(matricula)) {
            inputOk = true
        }

        return inputOk
    }

    override fun findBy(condition: (Vehiculo) -> Boolean): Array<Vehiculo> {
        TODO("Not yet implemented")
    }

    override fun averageBy(condition: (Vehiculo) -> Boolean): Number {
        TODO("Not yet implemented")
    }

    override fun countby(condition: (Vehiculo) -> Boolean): Int {
        TODO("Not yet implemented")
    }

    override fun maxBy(selector: (Vehiculo) -> Number, condition: (Vehiculo) -> Boolean): Number {
        TODO("Not yet implemented")
    }

    override fun minBy(selector: (Vehiculo) -> Number, condition: (Vehiculo) -> Boolean): Number {
        TODO("Not yet implemented")
    }


    override fun findAll(): Array<Vehiculo> {
        TODO("Not yet implemented")
    }

    override fun findById(id: Int): Vehiculo? {
        TODO("Not yet implemented")
    }

    override fun update(id: Int): Vehiculo? {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int): Vehiculo? {
        TODO("Not yet implemented")
    }
}