package sk.momosilabs.releasemanager.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import sk.momosilabs.releasemanager.api.dto.DeployDTO

@RequestMapping("/api/release")
interface ReleaseManagerApi {

    @PostMapping("/deploy")
    fun deployService(@RequestBody data: DeployDTO): Int

    @GetMapping("/services")
    fun retrieveServicesForVersion(@RequestParam(required = true) systemVersion: Int): List<DeployDTO>

}
