package sk.momosilabs.releasemanager.persistence.repository.system_version

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import sk.momosilabs.releasemanager.persistence.entity.SystemVersionEntity

@Repository
interface SystemVersionRepository: JpaRepository<SystemVersionEntity, Long> {

    fun findByVersionNumber(versionNumber: Int): SystemVersionEntity?

    @Query("SELECT MAX(s.versionNumber) FROM system_version s")
    fun findMaxVersion(): Int?

}
