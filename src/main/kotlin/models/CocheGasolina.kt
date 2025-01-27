package dev.carloscy.models

class CocheGasolina (
    matricula: String,
    kms: Int,
    anoMatriculacion: Int,
    override var consumo: Double
) : Vehiculo (matricula = matricula, kms = kms, anoMatriculacion = anoMatriculacion), IMotorGasolina {

    override fun toString(): String {
        return "( id = $id, matricula = $matricula, kms = $kms, anoMatriculacion = $anoMatriculacion, consumo = $consumo, createdAt = $createdAt, updatedAt = $updatedAt, isActive = $isActive )"
    }
}