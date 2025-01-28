package dev.carloscy.repositories

import dev.carloscy.Arrays.*
import dev.carloscy.models.*
import org.lighthousegames.logging.logging
import java.time.LocalDateTime

class VehiculoRepositoryImpl: IVehiculoRepository {
    val logger = logging()
    private var maxVehiculos: Int = 10
    private var vehiculos: Array<Vehiculo?> = arrayOfNulls<Vehiculo>(maxVehiculos)
    private var newId: Int = 0

    private fun generarId (): Int {
        newId++
        return newId
    }

    override fun findBy(condition: (Vehiculo) -> Boolean): Array<Vehiculo> {
        return vehiculos.filterBy { condition(it) }
    }

    override fun averageBy(condition: (Vehiculo) -> Boolean): Number {
        TODO("Not yet implemented")
    }

    override fun countby(condition: (Vehiculo) -> Boolean): Int {
        TODO("Not yet implemented")
    }

    override fun maxBy(selector: (Vehiculo) -> Number, condition: (Vehiculo) -> Boolean): Vehiculo? {
        TODO("Not yet implemented")
    }

    override fun minBy(selector: (Vehiculo) -> Number, condition: (Vehiculo) -> Boolean): Vehiculo? {
        TODO("Not yet implemented")
    }

    override fun sortedBy(selector: (Vehiculo) -> Number, mode: OrdenationMode): Array<Vehiculo> {
        TODO("Not yet implemented")
    }

    override fun save(item: Vehiculo): Vehiculo {
        logger.debug { "Guardando vehículo" }
        val nuevoVehiculo = item.copy(
            id = generarId(),   //le damos un id
            matricula = item.matricula,
            kms = item.kms,
            anoMatriculacion = item.anoMatriculacion,
            createdAt = LocalDateTime.now(), //cambiamos su fecha de creación
            updatedAt = LocalDateTime.now(), //cambiamos su fecha de actualización
            isDeleted = item.isDeleted
        )

        var indiceLibre: Int = 0
        indiceLibre = vehiculos.indexOf {it == null}

        if (indiceLibre == -1){
            logger.info { "Redimensionando array" }
            vehiculos = vehiculos.redimensionar(modo = ModoRedimension.AUMENTAR, maxItems = vehiculos.size * 2)
            indiceLibre = vehiculos.indexOf {it == null}
        }

        vehiculos[indiceLibre] = nuevoVehiculo
        logger.info { " 💚 Vehículo guardado con éxito" }

        return nuevoVehiculo
    }

    override fun findAll(): Array<Vehiculo> {
        logger.debug { "Obteniendo todos los vehículos" }
        return vehiculos.filterBy {it != null}
    }

    override fun findById(id: Int): Vehiculo? {
        logger.debug { "Obteniendo vehículo por ID" }
        return vehiculos.firstOrNull() { it.id == id }
    }

    override fun update(id: Int, item: Vehiculo): Vehiculo? {
        logger.debug { "Actualizando vehículo" }
        var vehiculoActualizado = this.findById(id)

        if (vehiculoActualizado != null){
            val indice = vehiculos.indexOf {item.id == id}
            vehiculoActualizado = vehiculoActualizado.copy(
                id = item.id,
                matricula = item.matricula,
                kms = item.kms,
                anoMatriculacion = item.anoMatriculacion,
                createdAt = item.createdAt,
                updatedAt = LocalDateTime.now(), // solo cambiamos la fecha de actualización
                isDeleted = item.isDeleted
            )
            vehiculos[indice] = vehiculoActualizado
            logger.info { " 🧡 Vehículo actualizado con éxito" }
            return vehiculoActualizado
        }
        logger.info { " 🛑 No se ha encontrado el vehículo para actualizar" }
        return null
    }

    override fun delete(id: Int): Vehiculo? {
        logger.debug { "Borrando vehículo" }

        val vehiculoBorrado = this.findById(id)

        if (vehiculoBorrado != null){
            vehiculoBorrado.isDeleted = true
            logger.info { " ❤️ Vehículo borrado con éxito" }
        } else {
            logger.info { " 🛑 No se ha encontrado el vehículo para borrar" }
        }
        return vehiculoBorrado
    }
}




