package dev.carloscy.models

/**
 * Clase que representa a un coche eléctrico, es un subtipo de Vehiculo.
 * @property matricula matrícula del coche.
 * @property kms kilómetros del coche.
 * @property anoMatriculacion año de matriculación del coche.
 * @property tiempoCarga tiempo de carga del motor eléctrico.
 */
class CocheElectrico (
    matricula: String,
    kms: Int,
    anoMatriculacion: Int,
    override var tiempoCarga: Int
) : Vehiculo (matricula = matricula, kms = kms, anoMatriculacion = anoMatriculacion), IMotorElectrico {

    /**
     * Copia un vehículo.
     * @return el vehículo copiado, de tipo CocheEléctrico.
     */
    override fun copy(): CocheElectrico {
        return CocheElectrico(matricula, kms, anoMatriculacion, tiempoCarga)
    }

    override fun toString(): String {
        logger.debug { "Usando el toString() de la clase CocheElectrico" }
        return "( 🪫 id = $id, matricula = $matricula, kms = $kms, anoMatriculacion = $anoMatriculacion, tiempo de carga = $tiempoCarga, createdAt = $createdAt, updatedAt = $updatedAt, isDeleted = $isDeleted )"
    }
}