package sk.momosilabs.releasemanager.persistence.repository

import sk.momosilabs.releasemanager.persistence.entity.ServiceVersionEntity
import sk.momosilabs.releasemanager.persistence.entity.ServiceVersionIdEntity
import sk.momosilabs.releasemanager.persistence.entity.ServiceVersionRetrieve
import sk.momosilabs.releasemanager.service.model.Deploy
import java.time.ZonedDateTime

fun Deploy.toEntity(timestamp: ZonedDateTime) = ServiceVersionEntity(
    id = ServiceVersionIdEntity(
        name = name,
        version = version,
    ),
    startDate = timestamp,
)

fun ServiceVersionEntity.toModel() = Deploy(
    name = id.name,
    version = id.version,
)

fun Iterable<ServiceVersionRetrieve>.toModel() = map {
    Deploy(
        name = it.name,
        version = it.version,
    )
}
