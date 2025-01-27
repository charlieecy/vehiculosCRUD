package dev.carloscy.models

class CocheHibrido(
    matricula: String,
    kms: Int,
    anoMatriculacion: Int,
    override var tiempoCarga: Double,
    override var consumo: Double
) : Vehiculo (matricula = matricula, kms = kms, anoMatriculacion = anoMatriculacion), IMotorHibrido {

    override fun toString(): String {
        return "( id = $id, matricula = $matricula, kms = $kms, anoMatriculacion = $anoMatriculacion, consumo = $consumo, tiempo de carga = $tiempoCarga, createdAt = $createdAt, updatedAt = $updatedAt, isActive = $isActive )"
    }

}