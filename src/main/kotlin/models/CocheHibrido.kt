package dev.carloscy.models

/**
 * Clase que representa a un coche híbrido, es un subtipo de Vehiculo.
 * @property matricula matrícula del coche.
 * @property kms kilómetros del coche.
 * @property anoMatriculacion año de matriculación del coche.
 * @property tiempoCarga tiempo de carga del motor eléctrico.
 * @property consumo consumo del motor de gasolina.
 */
class CocheHibrido(
    matricula: String,
    kms: Int,
    anoMatriculacion: Int,
    override var tiempoCarga: Int,
    override var consumo: Int
) : Vehiculo (matricula = matricula, kms = kms, anoMatriculacion = anoMatriculacion), IMotorHibrido {

    /**
     * Copia un vehículo.
     * @return el vehículo copiado, de tipo CocheHibrido.
     */
    override fun copy(): CocheHibrido {
        return CocheHibrido(matricula, kms, anoMatriculacion, tiempoCarga, consumo)
    }

    override fun toString(): String {
        logger.debug { "Usando el toString() de la clase CocheHibrido" }
        return "( 🍃 id = $id, matricula = $matricula, kms = $kms, anoMatriculacion = $anoMatriculacion, consumo = $consumo, tiempo de carga = $tiempoCarga, createdAt = $createdAt, updatedAt = $updatedAt, isDeleted = $isDeleted )"
    }

}