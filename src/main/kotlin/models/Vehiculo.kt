package dev.carloscy.models

import org.lighthousegames.logging.logging
import java.time.LocalDateTime

val logger = logging()

/**
 * Clase abstracta que representa a un vehículo, supertipo del resto de clases.
 * @property id identificador único del vehículo.
 * @property matricula matrícula del vehículo.
 * @property kms kilómetros del vehículo.
 * @property anoMatriculacion año de matriculación del vehículo.
 * @property createdAt fecha en que se crea el vehículo en la base de datos.
 * @property updatedAt fecha en que se actualiza el vehículo en la base de datos.
 * @property isDeleted true si el vehículo ha sido eliminado, false en caso contrario.
 */
abstract class Vehiculo(
    var id: Int = NEW_ID,
    val matricula: String,
    var kms: Int,
    var anoMatriculacion: Int,
    var createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime = LocalDateTime.now(),
    var isDeleted: Boolean = false
){

    companion object{
        private var NEW_ID: Int = 1
    }

    abstract fun copy(): Vehiculo

    override fun toString(): String {
        logger.debug { "Usando el toString() de la clase Vehiculo" }
        return "(id = $id, matricula = $matricula, kms = $kms, anoMatriculacion = $anoMatriculacion, createdAt = $createdAt, updatedAt = $updatedAt, isDeleted = $isDeleted )"
    }
}