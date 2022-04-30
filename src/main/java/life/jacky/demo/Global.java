package life.jacky.demo;

import life.jacky.demo.LinkedList.LinkedList;
import life.jacky.demo.Notes.CodeSnippet;
import life.jacky.demo.Notes.Essay;
import life.jacky.demo.Notes.Note;

public class Global {
    public static LinkedList<Note> notes = new LinkedList<>();
    public static LinkedList<Essay> essays = new LinkedList<>();
    public static LinkedList<CodeSnippet> snippets = new LinkedList<>();
}
