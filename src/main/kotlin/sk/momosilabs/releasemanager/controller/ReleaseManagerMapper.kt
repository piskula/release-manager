package sk.momosilabs.releasemanager.controller

import sk.momosilabs.releasemanager.api.dto.DeployDTO
import sk.momosilabs.releasemanager.service.model.Deploy

fun DeployDTO.toModel() = Deploy(
    name = name,
    version = version!!,
)

fun List<Deploy>.toDto() = map {
    DeployDTO(
        name = it.name,
        version = it.version,
    )
}
