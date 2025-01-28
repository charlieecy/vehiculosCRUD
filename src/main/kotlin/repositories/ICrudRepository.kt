package dev.carloscy.repositories

interface ICrudRepository <T, ID> {
    fun save (item: T): T
    fun findAll (): Array<T>
    fun findById(id: ID) : T?
    fun update (id: ID, item: T): T?
    fun delete (id: ID): T?
}