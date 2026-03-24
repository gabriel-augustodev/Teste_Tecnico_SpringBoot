package com.teste.produtos_api.controllers;


import com.teste.produtos_api.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> request){
        String email = request.get("email");
        String senha = request.get("senha");

        if("admin@exemplo.com".equals(email) && "admin123".equals(senha)){
            String token = jwtUtil.gerarToken(email);
            return Map.of("token",token);
        }

        throw new RuntimeException("Credenciais InválidaS");
    }
}
