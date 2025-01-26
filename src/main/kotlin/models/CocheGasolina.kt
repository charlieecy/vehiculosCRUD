package dev.carloscy.models

import java.time.LocalDateTime

class CocheGasolina (
    id: Int,
    matricula: String,
    kms: Int,
    anoMatriculacion: Int,
    motor: IMotorGasolina,
    createdAt: LocalDateTime,
    updatedAt: LocalDateTime,
    isActive: Boolean,
) : Vehiculo (id, matricula, kms, anoMatriculacion, motor, createdAt, updatedAt, isActive) {
}