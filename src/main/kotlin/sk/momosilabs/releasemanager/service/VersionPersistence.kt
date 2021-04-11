package sk.momosilabs.releasemanager.service

import sk.momosilabs.releasemanager.service.model.Deploy
import java.time.ZonedDateTime

interface VersionPersistence {

    fun deployAlreadyExists(deploy: Deploy): Boolean

    fun getAllDeploysForTimestamp(timestamp: ZonedDateTime): List<Deploy>

    fun saveNewServiceVersion(deploy: Deploy, timestamp: ZonedDateTime): Deploy

    fun getMaxSystemVersion(): Int?

    fun getTimestampForSystemVersion(version: Int): ZonedDateTime?

    fun saveNewSystemVersion(version: Int, timestamp: ZonedDateTime): Int

}
