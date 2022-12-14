package ru.t1.dkononov.tm.command.task;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.t1.dkononov.tm.api.services.IProjectTaskService;
import ru.t1.dkononov.tm.api.services.ITaskService;
import ru.t1.dkononov.tm.command.AbstractCommand;
import ru.t1.dkononov.tm.enumerated.Role;
import ru.t1.dkononov.tm.enumerated.Status;
import ru.t1.dkononov.tm.model.Task;

import java.util.List;

public abstract class AbstractTaskCommand extends AbstractCommand {

    @NotNull
    protected ITaskService getTaskService() {
        return serviceLocator.getTaskService();
    }

    @NotNull
    protected IProjectTaskService getProjectTaskService() {
        return getServiceLocator().getProjectTaskService();
    }

    @Nullable
    @Override
    public String getARGUMENT() {
        return null;
    }

    protected void renderTasks(@NotNull final List<Task> tasks) {
        int index = 1;
        for (@Nullable final Task task : tasks) {
            if (task == null) continue;
            System.out.println(index + ". " + task);
            index++;
        }
    }

    protected void showTask(@Nullable final Task task) {
        if (task == null) return;
        System.out.println("ID: " + task.getId());
        System.out.println("NAME: " + task.getName());
        System.out.println("DESCRIPTION: " + task.getDescription());
        System.out.println("STATUS: " + Status.toName(task.getStatus()));
    }

    @Nullable
    public Role[] getRoles() {
        return Role.values();
    }

}
