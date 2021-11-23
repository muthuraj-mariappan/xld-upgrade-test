package config.upgrade.test

import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.context.annotation.Configuration

@Configuration
@RefreshScope
class ConfigurationHolder {

  @Value("${deploy.server.hostname:defaultfromvalueannotation}")
  var hostname: String = _

}
