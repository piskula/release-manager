package sk.momosilabs.releasemanager.controller

import org.springframework.web.bind.annotation.RestController
import sk.momosilabs.releasemanager.api.ReleaseManagerApi
import sk.momosilabs.releasemanager.api.dto.DeployDTO
import sk.momosilabs.releasemanager.service.deploy_service.DeployServiceInteractor
import sk.momosilabs.releasemanager.service.retrieve_services.RetrieveServicesInteractor

@RestController
class ReleaseManagerController(
    private val deployServiceInteractor: DeployServiceInteractor,
    private val retrieveServicesInteractor: RetrieveServicesInteractor,
): ReleaseManagerApi {

    override fun deployService(data: DeployDTO): Int =
        deployServiceInteractor.deploy(data.toModel())

    override fun retrieveServices(systemVersion: Int): List<DeployDTO> =
        retrieveServicesInteractor.retrieve(systemVersion = systemVersion).toDto()

}
