package dev.carloscy.models

class Motocicleta(
    matricula: String,
    kms: Int,
    anoMatriculacion: Int,
    override var cilindrada: Int
) : Vehiculo (matricula = matricula, kms = kms, anoMatriculacion = anoMatriculacion), IMotorMotocicleta {

    override fun toString(): String {
        return "( id = $id, matricula = $matricula, kms = $kms, anoMatriculacion = $anoMatriculacion, cilindrada = $cilindrada, createdAt = $createdAt, updatedAt = $updatedAt, isActive = $isActive )"
    }
}