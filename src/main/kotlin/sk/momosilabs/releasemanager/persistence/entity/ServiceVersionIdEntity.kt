package sk.momosilabs.releasemanager.persistence.entity

import java.io.Serializable
import java.util.Objects
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class ServiceVersionIdEntity (

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val version: Int,
): Serializable {

    override fun equals(other: Any?): Boolean = this === other ||
            other is ServiceVersionIdEntity && name == other.name && version == other.version

    override fun hashCode(): Int = Objects.hash(name, version)

}
