package dev.carloscy.Arrays


inline fun <T> Array<T?>.countBy(predicate: (T) -> Boolean = { true }): Int { //contar en función de si cada elemento cumple el predicado, devuelve el número de elementos que lo cumplen
    var count = 0 // recuento, variable que devuelve
    for (element in this) {  //recorremos el array (this)
        if (element != null && predicate(element)) { // si la posición no está vacía y cumple el predicado, sumamos 1 al recuento
            count++
        }
    }
    return count
}


inline fun <reified T> Array<T?>.filterBy(predicate: (T) -> Boolean): Array<T> { //Queremos filtrar los elementos de un array que cumplen una condición
    val result =    //Creamos el array que después devolveremos con los elementos que cumplen el predicado. Su tamaño es el recuento de aquellos que lo cumplen.
        Array<T>(this.countBy(predicate)) { null as T }
    var index = 0
    for (item in this) {    //Recorremos el array original
        if (item != null && predicate(item)) {
            result[index] = item    //Y si un elemento es distinto de nulo y cumple la condición, lo incluímos en el array que devolvemos
            index++
        }
    }
    return result
}


fun <T> Array<T?>.forEach(action: (T) -> Unit) {    //action es la función lambda
    for (item in this) {    //recorremos el array
        if (item != null) { //si cada elemento (item) es distino de null
            action(item)    //realizamos la acción sobre ese elemento
        }
    }
}


fun <T> Array<T?>.indexOf(condition: (T?) -> Boolean): Int {    //buscamos el índice de la posición del array que cumpla la condición
    for (index in this.indices) {   //recorremos los índices del array (this)
        if (condition(this[index])) { //si una posición cumple la condición,
            return index        // devolvemos su índice
        }
    }
    return -1   // si ninguna posición cumple la condición, devolvemos -1
}


fun <T> Array<T?>.averageBy(predicate: (T) -> Boolean): Double {  //queremos obtener la media en función de los elementos que cumplen un predicado
    var count = 0   //variable que representa el número de elementos que lo cumplen
    var total = 0.0 //numerador de la operación para obtener la media
    for (element in this) { //recorremos el array
        if (element != null && predicate(element)) { //si el elemento es distinto de nulo y cumple el predicado,
            total += (element as? Number)?.toDouble() ?: 0.0 //Se lo sumamos al total (siempre que se pueda transformar a doble)
            count++ //e incrementamos en 1 el número de elementos que lo cumplen
        }
    }
    return if (count == 0) 0.0 else total / count
}


fun <T> Array<T?>.sumBy(predicate: (T) -> Boolean): Double { //Queremos obtener la suma de los elementos que cumplan el predicado
    var total = 0.0     //creamos la variable que devolveremos como resultado
    for (element in this) { //recorremos el array (this)
        if (element != null && predicate(element)) {    //si el elemento es distinto de null y cumple el predicado, le sumamos su valor al total
            total += element.toString().toDouble()
        }
    }
    return total
}


fun <T> Array<T?>.firstOrNull(predicate: (T) -> Boolean = { true }): T? {   //buscamos el primer elemento del array que cumpla el predicado, devolvemos ese elemento o null en caso de no cumplirlo ninguno
    for (element in this) { //recorremos el array (this)
        if (element != null && predicate(element)) {    //si la posición es distinto de null y cumple el predicado, devolvemos ese elemento
            return element
        }
    }
    return null // si ningñun elemento lo cumple, devolvemos null
}


fun <T> Array<T?>.lastOrNull(predicate: (T) -> Boolean = { true }): T? {    //buscamos el último elemento del array que cumpla el predicado, devolvemos ese elemento o null en caso de no cumplirlo ninguno
    var lastMatch: T? = null    //variable que devolveremos, inicialmente se asigna valor null, a la espera de recorrer el array
    for (element in this) { //recorremos el array (this)
        if (element != null && predicate(element)) { //si un elemento es distinto de null y cumple el predicado
            lastMatch = element //le asignamos el valor a la variable que devolvemos
        }
    }
    return lastMatch
}


fun <T> Array<T?>.maxByOrNull(selector: (T) -> Double, predicate: (T) -> Boolean): T? { //buscamos el máximo de los elementos cuyo valor del selector (propiedad) cumpla el predicado
    var maxElement: T? = null   //creamos la variable que devolveremos, inicialmente le asignamos null a la espera de recorrer el array
    var maxValue: Double? = null    //creamos la variable que almacenará el mayor valor que encontremos en el selector de aquellos elementos que cumplan el predicado
    for (element in this) { //recorremos el array
        if (element != null && predicate(element)) {    //si el elemento es distinto de null y cumple el predicado
            val value = selector(element)   //creamos la variable auxiliar para hacer el swap y le asignamos el valor del selector de dicho elemento
            if (maxValue == null || value > maxValue) { //o bien si es la primera vez que encontramos un elemento que cumple el predicado, o bien si el valor encontrado en el último elemento que cumple el predicado es mayor al valor encontrado en el anterior elemento que cumple el predicado
                maxValue = value    //hacemos el swap
                maxElement = element
            }
        }
    }
    return maxElement
}


fun <T> Array<T?>.minByOrNull(selector: (T) -> Double, predicate: (T) -> Boolean): T? { //igual funcionamiento que maxByOrNull, pero con el valor mínimo en lugar del máximo
    var minElement: T? = null
    var minValue: Double? = null
    for (element in this) {
        if (element != null && predicate(element)) {
            val value = selector(element)
            if (minValue == null || value < minValue) {
                minValue = value
                minElement = element
            }
        }
    }
    return minElement
}


inline fun <reified T> Array<T?>.redimensionar(modo: ModoRedimension, maxItems: Int): Array<T?> { //redimensionamos el array según el modo (ascendente o descendente) y su tamaño (maxItems)
    val nuevoArray = arrayOfNulls<T>(maxItems)  //creamos el array que devolveremos ya redimendionado, con el tamaño que le entra por parámetro y relleno de nulls
    var index = 0   //inicializamos el índice con el que recorremos este nuevo array a 0
    for (item in this) {    //recorremos el array original (this), el que queremos redimensionar
        if (item != null || modo != ModoRedimension.DISMINUIR) {    //si la posición es distinta de null y el modo NO es disminuir
            nuevoArray[index] = item    //asignamos ese elemento a la primera posición (0) del nuevo array
            if (index < maxItems - 1) index++ //siempre que el índice sea menor que el tamaño máximo del array, lo incrementamos en 1
        }
    }
    return nuevoArray //devolvemos el nuevo array ya redimensionado
}

inline fun <reified T> Array<T?>.sortedBy(
    mode: ModoOrdenamiento = ModoOrdenamiento.DESCENDENTE,
    selector: (T) -> Double
): Array<T> {
    val result = this.filterBy { true }
    val compare: (Double, Double) -> Boolean =
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


enum class ModoRedimension {
    AUMENTAR, DISMINUIR
}

enum class ModoOrdenamiento {
    ASCENDENTE, DESCENDENTE
}