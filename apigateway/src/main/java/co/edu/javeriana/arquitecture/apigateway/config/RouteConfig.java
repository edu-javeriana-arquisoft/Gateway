package co.edu.javeriana.arquitecture.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder){
        return builder.routes()
                .route("user", r -> r.path("/user/**")
                        .filters(f -> f.rewritePath("/user/(?<remaining>.*)", "/${remaining}"))
                        .uri("http://authentication:8080")
                )
                .route("api", r-> r.path("/api/pays/**")
                        .filters(f -> f.rewritePath("/(?<remaining>.*)", "/${remaining}"))
                        .uri("http://10.43.100.45:8072")
                )
                .route("api", r-> r.path("/api/orders/**")
                        .filters(f -> f.rewritePath("/(?<remaining>.*)", "/${remaining}"))
                        .uri("http://10.43.100.45:8073")
                )
                .route("api", r-> r.path("/api/customers/**")
                        .filters(f -> f.rewritePath("/(?<remaining>.*)", "/${remaining}"))
                        .uri("http://10.43.100.45:8071")
                )
                .route("Products", r-> r.path("/Products/**")
                        .filters(f -> f.rewritePath("/(?<remaining>.*)", "/${remaining}"))
                        .uri("http://10.43.100.41:8051")
                )
                .route("Recommendations", r-> r.path("/Recommendations/**")
                        .filters(f -> f.rewritePath("/(?<remaining>.*)", "/${remaining}"))
                        .uri("http://10.43.100.41:8052")
                )
                .build();
    }
}
