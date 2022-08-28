package ru.t1.dkononov.tm.api.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.t1.dkononov.tm.exception.entity.ProjectNotFoundException;
import ru.t1.dkononov.tm.exception.field.IdEmptyException;
import ru.t1.dkononov.tm.exception.field.IndexIncorrectException;
import ru.t1.dkononov.tm.exception.field.UserIdEmptyException;
import ru.t1.dkononov.tm.model.AbstractUserOwnedModel;

import java.util.Comparator;
import java.util.List;

public interface IUserOwnedRepository<M extends AbstractUserOwnedModel> {

    @NotNull
    List<M> findAll(@Nullable String userId) throws UserIdEmptyException;

    @Nullable
    List<M> findAll(@Nullable String userId, @Nullable Comparator<M> comparator) throws UserIdEmptyException;

    @Nullable M add(@Nullable String userId, @NotNull M m) throws ProjectNotFoundException, UserIdEmptyException;

    void clear(@Nullable String userId) throws UserIdEmptyException;

    boolean existsById(@Nullable String userId, @Nullable String id) throws UserIdEmptyException;

    @Nullable
    M findById(@Nullable String userId, @Nullable String id) throws IdEmptyException, UserIdEmptyException;

    @Nullable
    M findByIndex(@NotNull String userId, @NotNull Integer index) throws IndexIncorrectException, UserIdEmptyException;

    @Nullable
    M remove(@Nullable String userId, @Nullable M m) throws UserIdEmptyException;

    @Nullable
    M removeById(@Nullable String userId, @Nullable String id) throws IdEmptyException, UserIdEmptyException;

    @Nullable
    M removeByIndex(@NotNull String userId, @NotNull Integer index) throws IndexIncorrectException, UserIdEmptyException;

    void removeAll(@Nullable String userId) throws UserIdEmptyException;
}
