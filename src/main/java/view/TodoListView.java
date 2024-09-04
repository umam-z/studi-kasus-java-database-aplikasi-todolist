package view;

import service.TodoListService;
import util.InputUtil;

public class TodoListView {
    private TodoListService todoListService;
    
    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList() {
        while (true) {
            
            System.out.println("TODOLIST");
            todoListService.showTodoList();
            
            System.out.println("Menu");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");
    
            String input = InputUtil.input("pilih");
            if (input.equals("1")) {
                addTodoList();
            } else if(input.equals("2")) {
                removeTodoList();
            } else if(input.equals("x")) {
                System.out.println("Bye");
                break;
            } else {
                System.out.println("Pilahan tidak dimengerti");
            }
        }
    }

    public void addTodoList() {
        System.out.println("MENAMBAH TODOLIST");
        var todo = InputUtil.input("x jika batal");

        if (todo.equals("x")) {
            // batal
        } else {
            todoListService.addTodoList(todo);
        }
    }

    public void removeTodoList() {
        System.out.println("MENGHAPUS TODOLIST");
        var number = InputUtil.input("No Todo (x Batal)");

        if (number.equals("x")) {
            // batal
        } else {
            todoListService.removeTodoList(Integer.valueOf(number));
        }
    }
    
}
