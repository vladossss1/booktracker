package ru.cringe.booktracker.service;

import ru.cringe.booktracker.web.dto.auth.JwtRequest;
import ru.cringe.booktracker.web.dto.auth.JwtResponse;

public interface AuthService {

    JwtResponse login(JwtRequest loginRequest);

    JwtResponse refresh(String refreshToken);
}
