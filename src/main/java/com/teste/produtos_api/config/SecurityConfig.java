package com.teste.produtos_api.config;

import com.teste.produtos_api.security.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

/**
 * Configuração de segurança da aplicação.
 * Define autenticação via JWT, rotas públicas e protegidas,
 * além do tratamento de erros 401 e 403.
 */

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers(
                        "/auth/**",
                        "/h2-console/**",
                        "/swagger-ui/**",
                        "/v3/api-docs/**",
                        "/swagger-resources/**"
                ).permitAll()// Libera acesso sem autenticação para o login, swagger e o console do H2
                .anyRequest().authenticated(); // qualquer outra requisição tem que estar autenticada

        http.exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);// define status 401
                    response.getWriter().write("Erro 401: Não autenticado");//retorna mensagem personalizada
                })
                .accessDeniedHandler((request, response, accessDeniedException) -> {
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);// define status 403
                    response.getWriter().write("Erro 403: Acesso negado");
                });

        http.headers().frameOptions().disable();

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}