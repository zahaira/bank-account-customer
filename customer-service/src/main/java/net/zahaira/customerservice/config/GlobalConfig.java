package net.zahaira.customerservice.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "global.params")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class GlobalConfig {
    private int p1;
    private  int p2;
}
