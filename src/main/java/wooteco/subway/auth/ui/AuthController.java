package wooteco.subway.auth.ui;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import wooteco.subway.auth.application.AuthService;
import wooteco.subway.auth.dto.LoginRequest;
import wooteco.subway.auth.dto.LoginResponse;
import wooteco.subway.auth.dto.TokenRequest;

@RestController
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login/token")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok().body(
                new LoginResponse(authService.createToken(loginRequest))
        );
    }

    @PostMapping("/auth/token")
    public ResponseEntity<Void> validateToken(@RequestBody TokenRequest tokenRequest) {
        authService.validateToken(tokenRequest.getToken());

        return ResponseEntity.ok().build();
    }

}
