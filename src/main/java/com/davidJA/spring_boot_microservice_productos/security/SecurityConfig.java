package com.davidJA.spring_boot_microservice_productos.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


/*Activa la configuración de seguridad web de Spring Security en tu aplicación.*/
@EnableWebSecurity
/*Marca una clase como una clase de configuración de Spring.
Esta clase define beans o configuraciones que Spring debe cargar y gestionar.*/
@Configuration
public class SecurityConfig {

    @Value("davidKeySecureUsername")
    private String SECURE_KEY_USERNAME;

    @Value("davidKeySecurePassword!")
    private String SECURE_KEY_PASSWORD;

    @Value("davidKeySecureUsername2")
    private String SECURE_KEY_USERNAME2;

    @Value("davidKeySecurePassword2!")
    private String SECURE_KEY_PASSWORD2;


    /*es el objeto que Spring Security usa para aplicar sus reglas de seguridad a las solicitudes HTTP.*/
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(
            AuthenticationManagerBuilder.class
        );

        /*Esto define usuarios en memoria para poder hacer login sin base de datos.*/
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser(SECURE_KEY_USERNAME)
                .password(new BCryptPasswordEncoder().encode(SECURE_KEY_PASSWORD))
                .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"))
                .and()
                .withUser(SECURE_KEY_USERNAME2)
                .password(new BCryptPasswordEncoder().encode(SECURE_KEY_PASSWORD2))
                .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_DAVID"))
                .and()
                .passwordEncoder(new BCryptPasswordEncoder());

        return http
                .authorizeHttpRequests(auth ->auth.anyRequest().hasRole("ADMIN"))
                .csrf( csrf -> csrf.disable())                           /*Desactiva CSRF, una protección para formularios*/
                .httpBasic(httpbasic -> {})                          /*Habilita autenticación HTTP básica (usuario y contraseña)*/
                .exceptionHandling(exception -> exception     /*Sin acceso será redirigido a http://david.com.*/
                        .accessDeniedHandler((request, response, accessDeniedException) -> {
                            response.sendRedirect("http://david.com");
                        })
                )
                .build();
    }
}
