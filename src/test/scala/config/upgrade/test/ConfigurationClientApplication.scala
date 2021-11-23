package config.upgrade.test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.cloud.context.refresh.ContextRefresher
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.EventListener

object ConfigurationClientApplication extends App {
  SpringApplication.run(classOf[ConfigurationClientApplication], args: _*)
}

@Configuration
@SpringBootApplication
class ConfigurationClientApplication {

  @Autowired
  var configurationHolder: ConfigurationHolder = _

  @Autowired
  var contextRefresher: ContextRefresher = _

  @EventListener(Array(classOf[ApplicationReadyEvent]))
  def onApplicationReady(): Unit = {
    // contextRefresher.refresh()
    println(s"the hostname is ${configurationHolder.hostname}")
  }
}
