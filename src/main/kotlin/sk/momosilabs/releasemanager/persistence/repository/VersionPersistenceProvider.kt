package sk.momosilabs.releasemanager.persistence.repository

import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import sk.momosilabs.releasemanager.persistence.entity.ServiceVersionIdEntity
import sk.momosilabs.releasemanager.persistence.entity.SystemVersionEntity
import sk.momosilabs.releasemanager.persistence.repository.service_version.ServiceVersionRepository
import sk.momosilabs.releasemanager.persistence.repository.system_version.SystemVersionRepository
import sk.momosilabs.releasemanager.service.VersionPersistence
import sk.momosilabs.releasemanager.service.model.Deploy
import java.time.ZonedDateTime

@Repository
class VersionPersistenceProvider(
    private val repositoryServiceVersion: ServiceVersionRepository,
    private val repositorySystemVersion: SystemVersionRepository,
) : VersionPersistence {

    @Transactional(readOnly = true)
    override fun checkIfDeployAlreadyHappened(deploy: Deploy): Boolean =
        with(deploy) {
            repositoryServiceVersion.existsById(ServiceVersionIdEntity(name = name, version = version))
        }

    @Transactional(readOnly = true)
    override fun getAllDeploysForTimestamp(timestamp: ZonedDateTime): List<Deploy> =
        repositoryServiceVersion.getServiceVersionsForTimestamps(timestamp = timestamp).toModel()

    @Transactional
    override fun saveNewServiceVersion(deploy: Deploy, timestamp: ZonedDateTime) =
        repositoryServiceVersion.save(
            deploy.toEntity(timestamp = timestamp)
        ).toModel()

    @Transactional(readOnly = true)
    override fun getMaxSystemVersion(): Int =
        repositorySystemVersion.findMaxVersion()?.toInt() ?: 0

    @Transactional(readOnly = true)
    override fun getTimestampForSystemVersion(version: Int): ZonedDateTime? =
        repositorySystemVersion.findByVersionNumber(versionNumber = version)?.startDate

    @Transactional
    override fun saveNewSystemVersion(version: Int, timestamp: ZonedDateTime): Int =
        repositorySystemVersion.save(
            SystemVersionEntity(versionNumber = version, startDate = timestamp)
        ).versionNumber

}
