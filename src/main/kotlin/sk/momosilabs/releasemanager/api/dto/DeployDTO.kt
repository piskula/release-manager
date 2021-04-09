package sk.momosilabs.releasemanager.api.dto

data class DeployDTO (
    val name: String,
    val version: Int? = null,
)
