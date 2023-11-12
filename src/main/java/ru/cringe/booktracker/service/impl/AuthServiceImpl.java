package ru.cringe.booktracker.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import ru.cringe.booktracker.domain.user.User;
import ru.cringe.booktracker.service.AuthService;
import ru.cringe.booktracker.service.UserService;
import ru.cringe.booktracker.web.dto.auth.JwtRequest;
import ru.cringe.booktracker.web.dto.auth.JwtResponse;
import ru.cringe.booktracker.web.security.JwtTokenProvider;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

  private final AuthenticationManager authenticationManager;
  private final UserService userService;
  private final JwtTokenProvider jwtTokenProvider;

  @Override
  public JwtResponse login(JwtRequest loginRequest) {
    JwtResponse jwtResponse = new JwtResponse();
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
            loginRequest.getPassword()));
    User user = userService.getByUsername(loginRequest.getUsername());
    jwtResponse.setId(user.getId());
    jwtResponse.setUsername(user.getUsername());
    jwtResponse.setAccessToken(
        jwtTokenProvider.createAccessToken(user.getId(), user.getUsername(), user.getRoles()));
    jwtResponse.setRefreshToken(
        jwtTokenProvider.createRefreshToken(user.getId(), user.getUsername()));
    return jwtResponse;
  }

  @Override
  public JwtResponse refresh(String refreshToken) {
    return jwtTokenProvider.refreshUserTokens(refreshToken);
  }
}
