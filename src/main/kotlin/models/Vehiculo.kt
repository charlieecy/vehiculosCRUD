package dev.carloscy.models

import org.lighthousegames.logging.logging
import java.time.LocalDateTime

val logger = logging()

open class Vehiculo(
    val id: Int = NEW_ID,
    val matricula: String,
    var kms: Int,
    var anoMatriculacion: Int,
    var createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime = LocalDateTime.now(),
    var isDeleted: Boolean = false
){

    companion object{
        private var NEW_ID: Int = 0
    }

    fun copy(id: Int, matricula: String, kms: Int, anoMatriculacion: Int, createdAt: LocalDateTime, updatedAt: LocalDateTime, isDeleted: Boolean): Vehiculo {
            return Vehiculo(id, matricula, kms, anoMatriculacion, createdAt, updatedAt, isDeleted)
    }

    override fun toString(): String {
        return "(id = $id, matricula = $matricula, kms = $kms, anoMatriculacion = $anoMatriculacion, createdAt = $createdAt, updatedAt = $updatedAt, isDeleted = $isDeleted )"
    }
}