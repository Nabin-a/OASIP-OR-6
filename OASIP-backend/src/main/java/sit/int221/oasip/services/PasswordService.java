package sit.int221.oasip.services;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Service;
import sit.int221.oasip.configs.PasswordConfig;

@Service
public class PasswordService {

    private final PasswordConfig passwordConfig;
    private final Argon2 argon2;

    public PasswordService(PasswordConfig passwordConfig) {
        this.passwordConfig = passwordConfig;
        argon2 = getArgon2Instance();
    }

    private Argon2 getArgon2Instance() {
        return Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id, 14, 29);
    }

    public String securePassword(String password) {
        return argon2.hash(4, 65586, 2, password.toCharArray());
    }


}
