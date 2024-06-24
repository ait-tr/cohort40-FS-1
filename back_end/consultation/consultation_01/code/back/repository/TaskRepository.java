package code.back.repository;

import code.back.entity.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskRepository implements InMemoryRepository {

    private List<Task> database;
    private Integer taskIdCounter = 0;

    public TaskRepository() {
        this.database = new ArrayList<>();
    }

    @Override
    public Task add(Task task) {
        // вариант 1
//        task.setTaskId(++taskIdCounter);
//        database.add(task);
//        return task;

        Task taskForSave = new Task(++taskIdCounter, task.getName(), task.getDescription());
        database.add(taskForSave);
        return taskForSave;

    }

    @Override
    public Optional<Task> findById(Integer id) {
        return database.stream()
                .filter(task -> task.getTaskId().equals(id))
                .findFirst();
    }

    @Override
    public List<Task> findByName(String taskName) {

//        List<Task> foundedTasks = new ArrayList<>();
//        for (Task currentTask : database){
//            if (currentTask.getName().equals(taskName)){
//                foundedTasks.add(currentTask);
//            }
//        }
//
//        return foundedTasks;

        return database.stream()
                .filter(task -> task.getName().equals(taskName))
                .toList();

    }

    @Override
    public boolean deleteById(Integer id) {
        Optional<Task> optTaskById = findById(id);

        if (optTaskById.isPresent()) {
            database.remove(optTaskById.get());
            return true;
        }

        return false;

    }

    @Override
    public Optional<Task> updateTask(Integer id, String newDescription) {

        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).getTaskId().equals(id)) {
                Task newTaskAfterUpdate = new Task(id,database.get(i).getName(),newDescription);
                database.set(i,newTaskAfterUpdate);
                return Optional.of(database.get(i));
            }
        }

        return Optional.empty();
    }

    @Override
    public List<Task> findAll() {
        return database;
    }
}
