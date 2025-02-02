package dev.carloscy.extensions

/**
 * Cuenta el número de elementos de una lista que cumplen una condición.
 * @param predicate condición a cumplir.
 * @return el número de elementos que la cumplen.
 */
inline fun <T> List<T>.countBy(predicate: (T) -> Boolean = { true }): Int { //contar en función de si cada elemento cumple el predicado, devuelve el número de elementos que lo cumplen
    var count = 0 // recuento, variable que devuelve
    for (element in this) {  //recorremos la lista (this)
        if (predicate(element)) { // si cumple el predicado, sumamos 1 al recuento
            count++
        }
    }
    return count
}

/**
 * Filtra los elementos de una lista que cumplen una condición.
 * @param predicate condición a cumplir.
 * @return una lista que contiene solo los elementos que cumplen la condición.
 */
inline fun <reified T> List<T>.filterBy(predicate: (T) -> Boolean): List<T> { //Queremos filtrar los elementos de una lista que cumplen una condición
    val result: MutableList<T> =    //Creamos la lista que después devolveremos con los elementos que cumplen el predicado.
       mutableListOf<T>()
    for (item in this) {    //Recorremos la lista original
        if (predicate(item)) {
            result.addLast(item)    //Y si un elemento cumple la condición, lo incluímos en la lista que devolvemos
        }
    }
    return result
}

/**
 * Recorre una lista y realiza una acción para cada uno de sus elementos.
 * @param action acción a realizar.
 */
fun <T> List<T>.forEach(action: (T) -> Unit) {    //action es la función lambda
    for (item in this) {    //recorremos la lista
            action(item)    //realizamos la acción sobre ese elemento
        }
    }

/**
 * Busca el índice del elemento de una lista que cumpla una condición.
 * @param condition condición a cumplir.
 * @return íncide del primer elemento de una lista que cumpla una condición, en caso de haber alguno. Si no, devuelve -1.
 */
fun <T> List<T>.indexOf(condition: (T?) -> Boolean): Int {    //buscamos el índice de la posición de la lista que cumpla la condición
    for (index in this.indices) {   //recorremos los índices de la lista (this)
        if (condition(this[index])) { //si una posición cumple la condición,
            return index        // devolvemos su índice
        }
    }
    return -1   // si ninguna posición cumple la condición, devolvemos -1
}

/**
 * Calcula la media de los elementos de una lista que cumplen una condición.
 * @param predicate condición a cumplir.
 * @return la media.
 */
fun <T> List<T>.averageBy(predicate: (T) -> Boolean): Double {  //queremos obtener la media en función de los elementos que cumplen un predicado
    var count = 0   //variable que representa el número de elementos que lo cumplen
    var total = 0.0 //numerador de la operación para obtener la media
    for (element in this) { //recorremos la lista
        if (predicate(element)) { //si el elemento cumple el predicado,
            total += (element as? Number)?.toDouble() ?: 0.0 //Se lo sumamos al total (siempre que se pueda transformar a doble)
            count++ //e incrementamos en 1 el número de elementos que lo cumplen
        }
    }
    return if (count == 0) 0.0 else total / count
}

/**
 * Busca el primer elemento de una lista que cumpla una condición.
 * @param predicate condición a cumplir.
 * @return El elemento que cumple la condición en caso de haberlo. Si no, null.
 */
fun <T> List<T>.firstOrNull(predicate: (T) -> Boolean = { true }): T? {   //buscamos el primer elemento de la lista que cumpla el predicado, devolvemos ese elemento o null en caso de no cumplirlo ninguno
    for (element in this) { //recorremos la lista (this)
        if (predicate(element)) {    //si la posición cumple el predicado, devolvemos ese elemento
            return element
        }
    }
    return null // si ningñun elemento lo cumple, devolvemos null
}

/**
 * Busca el elemento con el valor máximo de un determinado selector y que cumpla una condición.
 * @param selector propiedad de la que se desea obtener el elemento que contiene el máximo valor.
 * @param predicate condición a cumplir.
 * @return el elemento con el valor máximo de aquellos que cumplen la condición. Si ningún elemento la cumple, devuelve null.
 */
fun <T> List<T>.maxByOrNull(selector: (T) -> Int, predicate: (T) -> Boolean): T? { //buscamos el máximo de los elementos cuyo valor del selector (propiedad) cumpla el predicado
    var maxElement: T? = null   //creamos la variable que devolveremos, inicialmente le asignamos null a la espera de recorrer la lista
    var maxValue: Int? = null    //creamos la variable que almacenará el mayor valor que encontremos en el selector de aquellos elementos que cumplan el predicado
    for (element in this) { //recorremos la lista
        if (predicate(element)) {    //si el elemento cumple el predicado
            val value = selector(element)   //creamos la variable auxiliar para hacer el swap y le asignamos el valor del selector de dicho elemento
            if (maxValue == null || value > maxValue) { //o bien si es la primera vez que encontramos un elemento que cumple el predicado, o bien si el valor encontrado en el último elemento que cumple el predicado es mayor al valor encontrado en el anterior elemento que cumple el predicado
                maxValue = value    //hacemos el swap
                maxElement = element
            }
        }
    }
    return maxElement
}

/**
 * Busca el elemento con el valor mínimo de un determinado selector y que cumpla una condición.
 * @param selector propiedad de la que se desea obtener el elemento que contiene el mínimo valor.
 * @param predicate condición a cumplir.
 * @return el elemento con el valor mínimo de aquellos que cumplen la condición. Si ningún elemento la cumple, devuelve null.
 */
fun <T> List<T>.minByOrNull(selector: (T) -> Int, predicate: (T) -> Boolean): T? { //igual funcionamiento que maxByOrNull, pero con el valor mínimo en lugar del máximo
    var minElement: T? = null
    var minValue: Int? = null
    for (element in this) {
        if (predicate(element)) {
            val value = selector(element)
            if (minValue == null || value < minValue) {
                minValue = value
                minElement = element
            }
        }
    }
    return minElement
}

/**
 * Ordena una lista en función de un selector y un modo de ordenamiento.
 * @param mode modo de ordenamiento, puede ser ascendente o descendente.
 * @param selector propiedad en base a la cual se va a ordenar la lista.
 * @return la lista ordenada.
 */
inline fun <reified T> List<T>.sortedBy(
    mode: ModoOrdenamiento = ModoOrdenamiento.ASCENDENTE,
    selector: (T) -> Int
): List<T> {
    val result = this.filterBy { true }.toMutableList()
    val compare: (Int, Int) -> Boolean =
        if (mode == ModoOrdenamiento.ASCENDENTE) { a, b -> a > b } else { a, b -> a < b }

    for (i in result.indices) {
        for (j in 0..<result.size - 1 - i) {
            if (compare(selector(result[j]), selector(result[j + 1]))) {
                result[j] = result[j + 1].also { result[j + 1] = result[j] }
            }
        }
    }
    return result
}


/**
 * Enum class que representa las formas de ordenar la lista
 */
enum class ModoOrdenamiento {
    ASCENDENTE, DESCENDENTE
}