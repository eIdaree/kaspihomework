package kz.eldar.kaspihomework.kaspihomework.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "security.basic")
@Getter
@Setter
public class SecurityProperties{

    private List<UserConfig> users = new ArrayList<>();

    @Getter
    @Setter
    public static class UserConfig {
        private String username;
        private String password;
        private String role;
    }

}
