package dev.carloscy.repositories

interface ICrudRepository <T, ID> {
    fun create (): T?
    fun save (item: T): T
    fun findAll (): Array<T>
    fun findById(id: ID) : T?
    fun update (id: ID): T?
    fun delete (id: ID): T?
}