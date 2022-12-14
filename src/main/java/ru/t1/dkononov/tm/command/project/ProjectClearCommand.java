package ru.t1.dkononov.tm.command.project;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.t1.dkononov.tm.exception.AbstractException;

public final class ProjectClearCommand extends AbstractProjectCommand {

    @Getter
    @NotNull
    public final String NAME = "project-clear";

    @Getter
    @NotNull
    public final String DESCRIPTION = "Очистить список проектов.";

    @Override
    public void execute() throws AbstractException {
        @Nullable final String userId = getUserId();
        System.out.println("[PROJECT_CLEAR]");
        getProjectService().clear(userId);
    }

}
