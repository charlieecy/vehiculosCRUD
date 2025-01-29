package dev.carloscy.models

/**
 * Clase que representa a una motocicleta, es un subtipo de Vehiculo.
 * @property matricula matrícula de la motocicleta.
 * @property kms kilómetros de la motocicleta.
 * @property anoMatriculacion año de matriculación de la motocicleta.
 * @property cilindrada cilindrada del motor de la motocicleta.
 */
class Motocicleta(
    matricula: String,
    kms: Int,
    anoMatriculacion: Int,
    override var cilindrada: Int
) : Vehiculo (matricula = matricula, kms = kms, anoMatriculacion = anoMatriculacion), IMotorMotocicleta {

    /**
     * Copia un vehículo.
     * @return el vehículo copiado, de tipo Motocicleta.
     */
    override fun copy(): Motocicleta {
        return Motocicleta(matricula, kms, anoMatriculacion, cilindrada)
    }

    override fun toString(): String {
        logger.debug { "Usando el toString() de la clase Motocicleta" }
        return "( 🏍️ id = $id, matricula = $matricula, kms = $kms, anoMatriculacion = $anoMatriculacion, cilindrada = $cilindrada, createdAt = $createdAt, updatedAt = $updatedAt, isDeleted = $isDeleted )"
    }
}