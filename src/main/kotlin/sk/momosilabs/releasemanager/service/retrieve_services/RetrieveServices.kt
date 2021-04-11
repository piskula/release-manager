package sk.momosilabs.releasemanager.service.retrieve_services

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import sk.momosilabs.releasemanager.service.VersionPersistence
import sk.momosilabs.releasemanager.service.model.Deploy

@Service
class RetrieveServices(
    private val persistence: VersionPersistence,
): RetrieveServicesInteractor {

    @Transactional(readOnly = true)
    override fun retrieve(systemVersion: Int): List<Deploy> {
        val timestamp = persistence.getTimestampForSystemVersion(systemVersion)
            ?: throw IllegalArgumentException("system version does not exist yet")

        return persistence.getAllDeploysForTimestamp(timestamp)
    }

}
