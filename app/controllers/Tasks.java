package controllers;

import models.Task;
import play.data.validation.Required;
import play.data.validation.Valid;
import play.mvc.Controller;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Vincent
 * Date: 17/04/12
 * Time: 12:28
 * To change this template use File | Settings | File Templates.
 */
public class Tasks extends Controller{

    public static void list() {
        List<Task> tasks = Task.findAll();
        render(tasks);
    }

    public static void newTask(@Valid Task task) {
        if(validation.hasErrors()) {
            params.flash();
            validation.keep();
            list();
        } else {
            Task taskToSave = new Task();
            taskToSave.setLabel(task.getLabel());
            taskToSave.setDescription(task.getDescription());
            taskToSave.save();
            detail(taskToSave.getId());
        }
    }

    public static void detail(Long id) {
        Task task = Task.findById(id);
        if(task != null) {
            render(task);
        } else {
            redirect("/tasks");
        }
    }
    
    public static void deleteTask(Long id) {
        Task task = Task.findById(id);
        task.delete();
        String message = "Task deleted !";
        String page = "/tasks";
        renderTemplate("/information.html", message, page);
    }
}
