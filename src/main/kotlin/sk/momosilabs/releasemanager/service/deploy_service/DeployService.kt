package sk.momosilabs.releasemanager.service.deploy_service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import sk.momosilabs.releasemanager.service.VersionPersistence
import sk.momosilabs.releasemanager.service.model.Deploy
import java.time.ZonedDateTime

@Service
class DeployService(
    private val persistence: VersionPersistence,
) : DeployServiceInteractor {

    @Transactional
    override fun deploy(deploy: Deploy): Int {
        validateDeploy(deploy)
        val currentVersion = persistence.getMaxSystemVersion() ?: 0

        if (persistence.deployAlreadyExists(deploy))
            return currentVersion

        val timestampOfDeploy = ZonedDateTime.now()
        return persistence.saveNewSystemVersion(currentVersion.plus(1), timestampOfDeploy).also {
            persistence.saveNewServiceVersion(deploy = deploy, timestamp = timestampOfDeploy)
        }
    }

    private fun validateDeploy(deploy: Deploy) {
        if (deploy.name.isBlank())
            throw IllegalArgumentException("name of service cannot be empty")
        if (deploy.version < 0)
            throw IllegalArgumentException("version cannot be negative")
    }

}
