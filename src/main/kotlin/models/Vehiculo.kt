package dev.carloscy.models

import org.lighthousegames.logging.logging
import java.time.LocalDateTime

val logger = logging()

abstract class Vehiculo (
    private val id: Int = generarID(),
    val matricula: String,
    var kms: Int,
    var anoMatriculacion: Int,
    var motor: IMotor,
    var createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime = LocalDateTime.now(),
    var isActive: Boolean = true
){
    companion object {
        private var lastID: Int = 0
        private fun generarID (): Int {
            logger.debug { "Generando nuevo ID" }
            lastID++
            val newId = lastID
            logger.info { "ID: $newId" }
            return newId
        }
    }

    override fun toString(): String {
        return "( id = $id, matricula = $matricula, kms = $kms, anoMatriculacion = $anoMatriculacion, motor = ${motor}, createdAt = $createdAt, updatedAt = $updatedAt, isActive = $isActive )"
    }
}