package sk.momosilabs.releasemanager.service.retrieve_services

import sk.momosilabs.releasemanager.service.model.Deploy

interface RetrieveServicesInteractor {

    fun retrieve(systemVersion: Int): List<Deploy>

}
