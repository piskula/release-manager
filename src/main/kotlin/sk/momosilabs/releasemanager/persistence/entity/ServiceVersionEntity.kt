package sk.momosilabs.releasemanager.persistence.entity

import java.time.ZonedDateTime
import javax.persistence.Column
import javax.persistence.EmbeddedId
import javax.persistence.Entity

@Entity(name = "service_version")
class ServiceVersionEntity (

    @EmbeddedId
    val id: ServiceVersionIdEntity,

    @Column(nullable = false)
    val startDate: ZonedDateTime,
)
