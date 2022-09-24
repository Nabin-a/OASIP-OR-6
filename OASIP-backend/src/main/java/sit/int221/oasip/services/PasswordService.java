package sit.int221.oasip.services;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int221.oasip.configs.JwtTokenUtil;
import sit.int221.oasip.configs.PasswordConfig;
import sit.int221.oasip.dto.userdto.JwtRequest;
import sit.int221.oasip.dto.userdto.JwtResponse;
import sit.int221.oasip.dto.userdto.UserDtoLogin;
import sit.int221.oasip.entities.User;
import sit.int221.oasip.repositories.UserRepository;

@Service
public class PasswordService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    private final PasswordConfig passwordConfig;
    private final Argon2 argon2;

    public PasswordService(PasswordConfig passwordConfig) {
        this.passwordConfig = passwordConfig;
        argon2 = getArgon2Instance();
    }

    public User checkPassword(UserDtoLogin login){
        if (login.getEmail()!=null && userRepository.existsByEmail(login.getEmail())){
            User user = userRepository.findByEmail(login.getEmail());
            if (argon2.verify(user.getPassword(), login.getPassword())){
                return modelMapper.map(user, User.class);

            }else {throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Password NOT match");}
        }else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Email not found");
    }

    private Argon2 getArgon2Instance() {
        return Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id, 14, 29);
    }

    public String securePassword(String password) {
        return argon2.hash(4, 65586, 2, password.toCharArray());
    }

    public ResponseEntity<?> login(JwtRequest login){
        if (login.getEmail()!=null && userRepository.existsByEmail(login.getEmail())){
            User user = userRepository.findByEmail(login.getEmail());
            if (argon2.verify(user.getPassword(), login.getPassword())){
                Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                        login.getEmail(),
                        login.getPassword()
                ));
                SecurityContextHolder.getContext().setAuthentication(authentication);
                final UserDetails userDetails = userDetailsService
                        .loadUserByUsername(login.getEmail());

                final String token = jwtTokenUtil.generateToken(userDetails);

                return ResponseEntity.ok(new JwtResponse(token));

            }else {throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Password NOT match");}
        }else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Email not found");
    }

}
