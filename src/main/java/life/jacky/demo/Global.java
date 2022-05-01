package life.jacky.demo;

import life.jacky.demo.LinkedList.LinkedList;
import life.jacky.demo.Notes.CodeSnippet;
import life.jacky.demo.Notes.Blog;
import life.jacky.demo.Notes.Note;
import life.jacky.demo.Notes.Todo;

public class Global {

    public static LinkedList<Note> notes = new LinkedList<>("Notes");
    public static LinkedList<Blog> blogs = new LinkedList<>("Blogs");
    public static LinkedList<CodeSnippet> codes = new LinkedList<>("Code Snippet");
    public static LinkedList<Todo> todos = new LinkedList<>("Todos");
}
