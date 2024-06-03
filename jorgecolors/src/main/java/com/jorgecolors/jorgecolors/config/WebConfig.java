//SPRINGBOOTFLUTTER/jorgecolors/src/main/java/com/jorgecolors/jorgecolors/config/WebConfig.java

package com.jorgecolors.jorgecolors.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:56315") // Reemplaza esto con el origen de tu aplicación Flutter
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowCredentials(true)
            .exposedHeaders("Access-Control-Allow-Origin");
    }
}



