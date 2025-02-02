package dev.carloscy.factories

import dev.carloscy.models.*

/**
 * Clase que representa una factoría de vehículos, generados de forma aleatoria.
 */
class VehiculosFactory {

    /**
     * Genera un vehículo con valores y subtipo aleatorios.
     * @return el vehículo generado.
     */
    fun vehiculoRandom () : Vehiculo {
        logger.debug { "Generando vehículo aleatorio" }

        //Propiedades comunes a todos los vehículos
        val numeros: Int = (0..9999).random()
        val primeraLetra: String = listOf("B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N", "P", "R", "S", "T", "V", "W", "X", "Y", "Z").random()
        val segundaLetra: String = listOf("B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N", "P", "R", "S", "T", "V", "W", "X", "Y", "Z").random()
        val terceraLetra: String = listOf("B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N", "P", "R", "S", "T", "V", "W", "X", "Y", "Z").random()

        val matriculaCompleta: String = numeros.toString() + primeraLetra + segundaLetra + terceraLetra
        val kms: Int = (0..300000).random()
        val anoMatriculacion: Int = (1950..2025).random()

        //Propiedades específicas según el tipo de vehículo
        val consumo: Int = (0..10).random()
        val tiempoCarga: Int = (0..10).random()
        val cilindrada: Int = (0..1000).random()

        val tipoVehiculo: Int = (0..100).random()
        return when (tipoVehiculo) {
            in 0..25 -> {CocheGasolina(matricula = matriculaCompleta, anoMatriculacion = anoMatriculacion, kms = kms, consumo = consumo)}
            in 26..50 -> {CocheElectrico(matricula = matriculaCompleta, anoMatriculacion = anoMatriculacion, kms = kms, tiempoCarga = tiempoCarga)}
            in 51..75 ->{CocheHibrido(matricula = matriculaCompleta, anoMatriculacion = anoMatriculacion, kms = kms, consumo = consumo, tiempoCarga = tiempoCarga)}
            else -> {Motocicleta(matricula = matriculaCompleta, anoMatriculacion = anoMatriculacion, kms = kms, cilindrada = cilindrada)}

        }
    }
}