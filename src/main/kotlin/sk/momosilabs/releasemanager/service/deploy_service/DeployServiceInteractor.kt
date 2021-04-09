package sk.momosilabs.releasemanager.service.deploy_service

import sk.momosilabs.releasemanager.service.model.Deploy

interface DeployServiceInteractor {

    fun deploy(deploy: Deploy): Int

}
