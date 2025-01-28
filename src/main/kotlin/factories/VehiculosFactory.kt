package dev.carloscy.factories

import dev.carloscy.models.*
import kotlin.random.Random

class VehiculosFactory {

    fun vehiculoRandom () : Vehiculo {
        logger.debug { "Generando vehículo aleatorio" }

        //Propiedades comunes a todos los vehículos
        var numeros: Int = (0..9999).random()
        var primeraLetra: String = arrayOf("B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N", "P", "R", "S", "T", "V", "W", "X", "Y", "Z").random()
        var segundaLetra: String = arrayOf("B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N", "P", "R", "S", "T", "V", "W", "X", "Y", "Z").random()
        var terceraLetra: String = arrayOf("B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N", "P", "R", "S", "T", "V", "W", "X", "Y", "Z").random()

        var matriculaCompleta: String = numeros.toString() + primeraLetra + segundaLetra + terceraLetra
        var kms: Int = (0..300000).random()
        var anoMatriculacion: Int = (1950..2025).random()

        //Propiedades específicas según el tipo de vehículo
        var consumo: Double = Random.nextDouble(0.0,10.0)
        var tiempoCarga: Double = Random.nextDouble(0.0,10.0)
        var cilindrada: Int = (0..1000).random()

        var tipoVehiculo: Int = (0..100).random()
        return when (tipoVehiculo) {
            in 0..25 -> {CocheGasolina(matricula = matriculaCompleta, anoMatriculacion = anoMatriculacion, kms = kms, consumo = consumo)}
            in 26..50 -> {CocheElectrico(matricula = matriculaCompleta, anoMatriculacion = anoMatriculacion, kms = kms, tiempoCarga = tiempoCarga)}
            in 51..75 ->{CocheHibrido(matricula = matriculaCompleta, anoMatriculacion = anoMatriculacion, kms = kms, consumo = consumo, tiempoCarga = tiempoCarga)}
            else -> {Motocicleta(matricula = matriculaCompleta, anoMatriculacion = anoMatriculacion, kms = kms, cilindrada = cilindrada)}

        }
    }
}