package com.survey.survey.security;

import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
        // Autenticación usando el correo electrónico
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(); // Cambiado a findByEmail
        String token = jwtService.getToken(user);

        // Obtener el rol del usuario
        String role = user.getRoles().stream()
                           .findFirst()
                           .map(Role::getName)
                           .orElse("UNKNOWN_ROLE");

        return AuthResponse.builder()
            .token(token)
            .role(role) // Incluye el rol en la respuesta
            .build();
    }

    public AuthResponse register(RegisterRequest request) {
        // Obtener el rol predeterminado "USER"
        Role userRole = roleRepository.findByName("USER")
                .orElseThrow(() -> new RuntimeException("Rol USER no encontrado"));

        // Crear una nueva instancia de User
        User newUser = User.builder()
            .username(request.getUsername())  // Puedes mantener el nombre de usuario o eliminar si ya no es necesario
            .password(passwordEncoder.encode(request.getPassword()))  // Encriptar la contraseña
            .email(request.getEmail())
            .roles(List.of(userRole))  // Asignar el rol USER por defecto
            .build();

        // Guardar el usuario en la base de datos
        userRepository.save(newUser);

        // Devolver una respuesta de autenticación (AuthResponse)
        String token = jwtService.getToken(newUser);

        return AuthResponse.builder()
            .token(token)
            .role(userRole.getName()) // Incluye el rol en la respuesta
            .build();
    }
}
