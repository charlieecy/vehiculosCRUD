package dev.carloscy.repositories

/**
 * Interfaz que contiene las funciones que tendrá que implementar un CRUD (Create, Read, Update y Delete).
 */
interface ICrudRepository <T, ID> {
    fun save (item: T): T
    fun findAll (): Array<T>
    fun findById(id: ID) : T?
    fun update (id: ID, item: T): T?
    fun delete (id: ID): T?
}