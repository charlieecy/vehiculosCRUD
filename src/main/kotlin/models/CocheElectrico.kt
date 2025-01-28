package dev.carloscy.models

class CocheElectrico (
    matricula: String,
    kms: Int,
    anoMatriculacion: Int,
    override var tiempoCarga: Double
) : Vehiculo (matricula = matricula, kms = kms, anoMatriculacion = anoMatriculacion), IMotorElectrico {

    override fun toString(): String {
        return "( 🪫 id = $id, matricula = $matricula, kms = $kms, anoMatriculacion = $anoMatriculacion, tiempo de carga = $tiempoCarga, createdAt = $createdAt, updatedAt = $updatedAt, isDeleted = $isDeleted )"
    }
}