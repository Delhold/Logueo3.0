package com.elvis.login.logueo.services;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public interface LoginService {
    //obtenemos los datos del usuario
    Optional<String> getUserName(HttpServletRequest request);
}
