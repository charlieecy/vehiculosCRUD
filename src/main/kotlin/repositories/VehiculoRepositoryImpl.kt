package dev.carloscy.repositories

import dev.carloscy.extensions.*
import dev.carloscy.models.*
import org.lighthousegames.logging.logging
import java.time.LocalDateTime

/**
 * Clase que representa un repositorio para gestionar el stock de un concesionario de vehículos.
 * @property vehiculos lista que almacena los vehículos.
 * @property newId id autonumérico que se le asigna a cada vehículo al almacenarlo en la lista.
 */
class VehiculoRepositoryImpl: IVehiculoRepository {
    val logger = logging()
    private var vehiculos: MutableList<Vehiculo> = mutableListOf<Vehiculo>()
    private var newId: Int = 0

    /**
     * Genera un id autonumérico.
     * @return el id generado.
     */
    private fun generarId (): Int {
        newId++
        return newId
    }

    /**
     * Filtra los vehículos de una lista que cumplen una condición.
     * @param condition condición a cumplir.
     * @return una lista que contiene solo los vehículos que cumplen la condición.
     */
    override fun findBy(condition: (Vehiculo) -> Boolean): List<Vehiculo> {
        return vehiculos.filterBy { condition(it) }
    }

    /**
     * Calcula la media de los vehículos de una lista que cumplen una condición.
     * @param condition condición a cumplir.
     * @return la media.
     */
    override fun averageBy(condition: (Vehiculo) -> Boolean): Double {
        return vehiculos.averageBy(condition)
    }

    /**
     * Cuenta el número de vehículos de una lista que cumplen una condición.
     * @param condition condición a cumplir.
     * @return el número de vehículos que la cumplen.
     */
    override fun countby(condition: (Vehiculo) -> Boolean): Int {
        return vehiculos.countBy { condition(it) }
    }

    /**
     * Busca el vehículo con el valor máximo de un determinado selector y que cumpla una condición.
     * @param selector propiedad de la que se desea obtener el vehículo que contiene el máximo valor.
     * @param condition condición a cumplir.
     * @return el vehículo con el valor máximo de aquellos que cumplen la condición. Si ningún vehículo la cumple, devuelve null.
     */
    override fun maxBy(selector: (Vehiculo) -> Int, condition: (Vehiculo) -> Boolean): Vehiculo? {
        return vehiculos.maxByOrNull(selector, condition)
    }

    /**
     * Busca el vehículo con el valor mínimo de un determinado selector y que cumpla una condición.
     * @param selector propiedad de la que se desea obtener el vehículo que contiene el mínimo valor.
     * @param condition condición a cumplir.
     * @return el vehículo con el valor mínimo de aquellos que cumplen la condición. Si ningún vehículo la cumple, devuelve null.
     */
    override fun minBy(selector: (Vehiculo) -> Int, condition: (Vehiculo) -> Boolean): Vehiculo? {
        return vehiculos.minByOrNull(selector, condition)
    }

    /**
     * Ordena una lista de vehículos en función de un selector y un modo de ordenamiento.
     * @param mode modo de ordenamiento, puede ser ascendente o descendente.
     * @param selector propiedad en base a la cual se va a ordenar la lista.
     * @return la lista ordenada.
     */
    override fun sortedBy(mode: ModoOrdenamiento, selector: (Vehiculo) -> Int): List<Vehiculo> {
        return vehiculos.sortedBy(mode, selector)
    }

    /**
     * Guarda un vehículo en la lista de vehículos, actualizando su fecha de creación y de actualización.
     * @return el vehículo guardado.
     */
    override fun save(item: Vehiculo): Vehiculo {
        logger.debug { "Guardando vehículo" }
        val nuevoVehiculo = item.copy()
        nuevoVehiculo.id = generarId()
        nuevoVehiculo.createdAt = LocalDateTime.now()
        nuevoVehiculo.updatedAt = LocalDateTime.now()

        vehiculos.addLast(nuevoVehiculo)

        logger.info { " 💚 Vehículo guardado con éxito" }

        return nuevoVehiculo
    }

    /**
     * Busca todos los elementos de la lista de vehículos.
     * @return la lista que contiene todos los vehículos.
     */
    override fun findAll(): List<Vehiculo> {
        logger.debug { "Obteniendo todos los vehículos" }
        return vehiculos.filterBy { true }
    }

    /**
     * Busca un vehículo en la lista en función de su id.
     * @param id id del vehículo buscado.
     * @return El vehículo con dicha id en caso de existir. En caso contrario, null.
     */
    override fun findById(id: Int): Vehiculo? {
        logger.debug { "Obteniendo vehículo por ID" }
        return vehiculos.firstOrNull { it.id == id }
    }

    /**
     * Actualiza un vehículo.
     * @param id id del vehículo.
     * @param item vehículo a actualizar.
     * @return el vehículo actualizado en caso de existir, null en caso contrario.
     */
    override fun update(id: Int, item: Vehiculo): Vehiculo? {
        logger.debug { "Actualizando vehículo" }
        var vehiculoActualizado = this.findById(id)

        if (vehiculoActualizado != null){
            val indice = vehiculos.indexOf {item.id == id}
            vehiculoActualizado = vehiculoActualizado.copy()
            vehiculoActualizado.updatedAt = LocalDateTime.now()
            vehiculos[indice] = vehiculoActualizado
            logger.info { " 🧡 Vehículo actualizado con éxito" }
            return vehiculoActualizado
        }
        logger.info { " 🛑 No se ha encontrado el vehículo para actualizar" }
        return null
    }

    /**
     * Borra un vehículo.
     * @param id id del vehículo a borrar.
     * @return el vehículo borrado en caso de existir, null en caso contrario.
     */
    override fun delete(id: Int): Vehiculo? {
        logger.debug { "Borrando vehículo" }

        val vehiculoBorrado = this.findById(id)

        if (vehiculoBorrado != null){
            vehiculoBorrado.updatedAt = LocalDateTime.now()
            vehiculoBorrado.isDeleted = true
            logger.info { " ❤️ Vehículo borrado con éxito" }
        } else {
            logger.info { " 🛑 No se ha encontrado el vehículo para borrar" }
        }
        return vehiculoBorrado
    }
}




