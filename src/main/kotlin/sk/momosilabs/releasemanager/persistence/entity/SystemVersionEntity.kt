package sk.momosilabs.releasemanager.persistence.entity

import java.time.ZonedDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "system_version")
class SystemVersionEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    @Column(unique = true, nullable = false)
    val versionNumber: Int,

    @Column(nullable = false)
    val startDate: ZonedDateTime,
)
