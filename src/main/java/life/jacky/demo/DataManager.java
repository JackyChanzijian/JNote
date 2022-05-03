package life.jacky.demo;

import life.jacky.demo.LinkedList.LinkedList;
import life.jacky.demo.Notes.Blog;
import life.jacky.demo.Notes.Note;
import life.jacky.demo.Notes.Todo;

import java.io.*;

public class DataManager {
    static String notePath = "Notes.dat";
    static String blogPath = "Blogs.dat";
    static String todoPath = "Todos.dat";
    static LinkedList<? extends Note> load(String path) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(path);
        ObjectInputStream in = new ObjectInputStream(fileIn);

        LinkedList<Note> object = (LinkedList<Note>) in.readObject();
        return object;
    }

    static void saveNote() throws IOException {
        FileOutputStream fileOut = new FileOutputStream(notePath);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        out.writeObject(Global.notes);
    }
    static void saveBlog() throws IOException {
        FileOutputStream fileOut = new FileOutputStream(blogPath);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        out.writeObject(Global.blogs);
    }
    static void saveTodo() throws IOException {
        FileOutputStream fileOut = new FileOutputStream(todoPath);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        out.writeObject(Global.todos);
    }
    static void loadNote() throws IOException, ClassNotFoundException {
        Global.notes = (LinkedList<Note>) load(notePath);
    }
    static void loadBlog() throws IOException, ClassNotFoundException {
        Global.blogs = (LinkedList<Blog>) load(blogPath);
    }
    static void loadTodo() throws IOException, ClassNotFoundException {
        Global.todos = (LinkedList<Todo>) load(todoPath);
    }
    static void saveAll() throws IOException {
        saveNote();
        saveBlog();
        saveTodo();
    }
    static void loadAll() throws IOException, ClassNotFoundException {
        loadNote();
        loadBlog();
        loadTodo();
    }
}
//class DataPair<T> {
//    T object;
//    String path;
//
//    DataPair(T object, String path) {
//        this.object = object;
//        this.path = path;
//    }
//}
