package ru.t1.dkononov.tm.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.t1.dkononov.tm.api.repository.IUserRepository;
import ru.t1.dkononov.tm.model.User;

public class UserRepository extends AbstractRepository<User> implements IUserRepository {

    @Nullable
    @Override
    public User findByLogin(@NotNull final String login) {
        return models
                .stream()
                .filter(u -> login.equals(u.getLogin()))
                .findFirst()
                .orElse(null);
    }

    @Nullable
    @Override
    public User findByEmail(@NotNull final String email) {
        return models
                .stream()
                .filter(u -> email.equals(u.getEmail()))
                .findFirst()
                .orElse(null);
    }


    @Override
    public Boolean isLoginExist(@NotNull final String login) {
        return models
                .stream()
                .anyMatch(u -> login.equals(u.getLogin()));
    }

    @Override
    public Boolean isEmailExist(@NotNull final String email) {
        return models
                .stream()
                .anyMatch(u -> email.equals(u.getEmail()));
    }

}
