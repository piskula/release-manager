package sk.momosilabs.releasemanager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReleasemanagerApplication

fun main(args: Array<String>) {
	runApplication<ReleasemanagerApplication>(*args)
}
