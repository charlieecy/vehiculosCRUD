package dev.carloscy.models
/**
 * Clase que representa a un coche de gasolina, es un subtipo de Vehiculo.
 * @property matricula matrícula del coche.
 * @property kms kilómetros del coche.
 * @property anoMatriculacion año de matriculación del coche.
 * @property consumo consumo del motor de gasolina.
 */
class CocheGasolina (
    matricula: String,
    kms: Int,
    anoMatriculacion: Int,
    override var consumo: Int
) : Vehiculo (matricula = matricula, kms = kms, anoMatriculacion = anoMatriculacion), IMotorGasolina {

    /**
     * Copia un vehículo.
     * @return el vehículo copiado, de tipo CocheGasolina.
     */
    override fun copy(): CocheGasolina {
        return CocheGasolina(matricula, kms, anoMatriculacion, consumo)
    }

    override fun toString(): String {
        logger.debug { "Usando el toString() de la clase CocheGasolina" }
        return "( ⛽ id = $id, matricula = $matricula, kms = $kms, anoMatriculacion = $anoMatriculacion, consumo = $consumo, createdAt = $createdAt, updatedAt = $updatedAt, isDeleted = $isDeleted )"
    }
}