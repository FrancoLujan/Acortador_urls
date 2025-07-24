package com.example.Acortador.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SegurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests().anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .build();
        /*
        HICE UNA AUTENTICACION RE BASICA PARA ACCEDER A TODOS LOS ENDOPOINT; OJO Y EL FORMULARIO DE LOGIN
        ES ACCESIBLE PARA TODOS, E USO VARIABLE DE ENTORNO PARA INGRESAR
         */
    }
}
