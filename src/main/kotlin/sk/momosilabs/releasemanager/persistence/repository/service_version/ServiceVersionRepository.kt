package sk.momosilabs.releasemanager.persistence.repository.service_version

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import sk.momosilabs.releasemanager.persistence.entity.ServiceVersionEntity
import sk.momosilabs.releasemanager.persistence.entity.ServiceVersionIdEntity
import sk.momosilabs.releasemanager.persistence.entity.ServiceVersionRetrieve
import java.time.ZonedDateTime

@Repository
interface ServiceVersionRepository: JpaRepository<ServiceVersionEntity, ServiceVersionIdEntity> {

    override fun findAll(): MutableList<ServiceVersionEntity> {
        TODO("Not yet implemented")
    }

    @Query("SELECT new sk.momosilabs.releasemanager.persistence.entity.ServiceVersionRetrieve(e.id.name, MAX(e.id.version)) " +
            "FROM #{#entityName} e " +
            "WHERE e.startDate <= :timestamp " +
            "GROUP BY e.id.name")
    fun getServiceVersionsForTimestamps(@Param("timestamp") timestamp: ZonedDateTime): Iterable<ServiceVersionRetrieve>

}
