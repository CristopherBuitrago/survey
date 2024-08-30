package com.survey.survey.security;

import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.survey.survey.auth.role.domain.entity.Role;
import com.survey.survey.auth.role.infrastructure.out.RoleRepository;
import com.survey.survey.auth.user.domain.entity.User;
import com.survey.survey.auth.user.infrastructure.out.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .build();
    }

    public AuthResponse register(RegisterRequest request) {
        // Obtener el rol predeterminado "USER"
        Role userRole = roleRepository.findByName("USER")
                .orElseThrow(() -> new RuntimeException("Rol USER no encontrado"));

        // Crear una nueva instancia de User
        User newuser = User.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode(request.getPassword()))  // encriptar la contraseña 
            .email(request.getEmail())
            .roles(List.of(userRole))  // Asignar el rol USER por defecto
            .build();

        // Guardar el usuario en la base de datos
        userRepository.save(newuser);

        // Devolver una respuesta de autenticación (AuthResponse)
        return AuthResponse.builder()
            .token(jwtService.getToken(newuser))
            .build();
    }
}
