package dev.carloscy.repositories

import dev.carloscy.COCHE_ELECTRICO
import dev.carloscy.COCHE_GASOLINA
import dev.carloscy.COCHE_HIBRIDO
import dev.carloscy.MOTOCICLETA
import dev.carloscy.models.*
import org.lighthousegames.logging.logging

class VehiculoRepositoryImpl: IVehiculoRepository {
    val logger = logging()
    private var maxVehiculos: Int = 10
    private var vehiculos: Array<Vehiculo?> = arrayOfNulls<Vehiculo>(maxVehiculos)

    override fun create(): Vehiculo? {
        logger.debug { "Creando vehículo" }
        var tipoVehiculo: Int = preguntartipoVehiculo()
        var matricula: String = preguntarMatricula()
        var kms: Int = preguntarKms()
        var anoMatriculacion: Int = preguntarAnoMatriculación()


        when (tipoVehiculo) {
            COCHE_GASOLINA -> {
                val consumo = preguntarConsumo()
                val cocheGasolina: CocheGasolina = CocheGasolina(matricula = matricula, kms = kms, anoMatriculacion = anoMatriculacion, consumo = consumo)
                logger.info { "Coche de gasolina creado" }
                return cocheGasolina
            }
            COCHE_ELECTRICO -> {
                val tiempoCarga = preguntarTiempoCarga()
                val cocheElectrico: CocheElectrico = CocheElectrico(matricula = matricula, kms = kms, anoMatriculacion = anoMatriculacion, tiempoCarga = tiempoCarga)
                logger.info { "Coche eléctrico creado" }
                return cocheElectrico
            }
            COCHE_HIBRIDO -> {
                val consumo = preguntarConsumo()
                val tiempoCarga = preguntarTiempoCarga()
                val cocheHibrido: CocheHibrido = CocheHibrido(matricula = matricula, kms = kms, anoMatriculacion = anoMatriculacion, consumo = consumo, tiempoCarga = tiempoCarga)
                logger.info { "Coche híbrido creado" }
                return cocheHibrido
            }
            MOTOCICLETA -> {
                val cilindrada = preguntarCilindrada()
                val motocicleta: Motocicleta = Motocicleta(matricula = matricula, kms = kms, anoMatriculacion = anoMatriculacion, cilindrada = cilindrada)
                logger.info { "Motocicleta creada" }
                return motocicleta
            }
        }

    return null
    }

    override fun save(item: Vehiculo): Vehiculo {
        TODO("Not yet implemented")
    }

    private fun preguntarTiempoCarga (): Double {
        logger.debug { "Preguntando tiempo de carga al usuario" }
        var inputOk: Boolean = false
        var tiempoCarga: Double

        do {
            println("¿Cuál es el tiempo de carga del vehículo?")
            tiempoCarga = readln().toDoubleOrNull() ?: -1.0

            if (tiempoCarga >= 0.0) {
                inputOk = true
            }
        }while (!inputOk)

        return tiempoCarga
    }

    private fun preguntarConsumo (): Double {
        logger.debug { "Preguntando consumo al usuario" }
        var inputOk: Boolean = false
        var consumo: Double

        do {
            println("¿Qué consumo tiene el vehículo?")
            consumo = readln().toDoubleOrNull() ?: -1.0

            if (consumo >= 0.0) {
                inputOk = true
            }
        }while (!inputOk)

        return consumo
    }

    private fun preguntartipoVehiculo(): Int {
        logger.debug { "Preguntando tipo de vehículo al usuario" }
        var tipoVehiculo: Int
        var inputOk: Boolean = false

        do {
            println("¿De qué tipo de vehículo se trata? Teclee el número correspondiente:")
            println("1. Coche de gasolina")
            println("2. Coche eléctrico")
            println("3. Coche híbrido")
            println("4. Motocicleta")

            tipoVehiculo = readln().toIntOrNull() ?: -1

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
            println("¿Cuál es el año de matriculación del vehículo?")
            ano = readln().toIntOrNull() ?: -1
            if (ano < 1950) {
                println("Por favor, introduzca un año de matriculación válido.")
            } else {
                userInput = true
            }
        } while (!userInput)

        return ano
    }

    private fun preguntarCilindrada (): Int {
        logger.debug { "Preguntando cilindrada al usuario" }
        var userInput: Boolean = false
        var cilindrada: Int

        do {
            println("¿Cuál es la cilindrada del vehículo?")
            cilindrada = readln().toIntOrNull() ?: -1
            if (cilindrada < 0) {
                println("Por favor, introduzca un número de cc válido.")
            } else {
                userInput = true
            }
        } while (!userInput)

        return cilindrada
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