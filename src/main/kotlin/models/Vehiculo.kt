package dev.carloscy.models

import org.lighthousegames.logging.logging
import java.time.LocalDateTime

val logger = logging()

abstract class Vehiculo(
    val id: Int = NEW_ID,
    val matricula: String,
    var kms: Int,
    var anoMatriculacion: Int,
    var createdAt: LocalDateTime = LocalDateTime.now(),
    var updatedAt: LocalDateTime = LocalDateTime.now(),
    var isDeleted: Boolean = false
){
    companion object {
        private var NEW_ID: Int = 0

        /*
        private fun generarID (): Int {
            logger.debug { "Generando nuevo ID" }
            lastID++
            val newId = lastID
            logger.info { "ID: $newId" }
            return newId
        }

         */
    }
}