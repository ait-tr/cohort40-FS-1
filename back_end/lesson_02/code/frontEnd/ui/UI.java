package lesson_02.code.frontEnd.ui;

import code.backEnd.dto.RequestDto;
import code.backEnd.dto.ResponseDto;
import code.backEnd.entity.Task;
import code.backEnd.service.TaskServiceAdd;

import java.util.Scanner;

public class UI {

    private TaskServiceAdd addService;

    public UI(TaskServiceAdd addService) {
        this.addService = addService;
    }

    public void start(){

        while (true){
            System.out.println("Please enter your choice:");
            System.out.println("1. Add new task");
            System.out.println("2. Find task by id");
            System.out.println("3. Find task by name");
            System.out.println("4. Exit");

            Scanner scanner = new Scanner(System.in);

            int userInput = scanner.nextInt();
            scanner.nextLine();

            switch (userInput){
                case 1:
                    System.out.println("Please enter task name:");
                    String taskName = scanner.nextLine();
                    System.out.println("Please enter task description:");
                    String taskDescription = scanner.nextLine();

                    ResponseDto<Task> responseDto = addService.addNewTask(new RequestDto(taskName,taskDescription));

                    if (responseDto.getResponseCode() == 200) {
                        System.out.println("Добавление задачи прошло успешно");
                    } else {
                        System.out.println(responseDto.getErrors());
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
            }

        }
    }

}
