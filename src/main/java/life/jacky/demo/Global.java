package life.jacky.demo;

import life.jacky.demo.LinkedList.LinkedList;
import life.jacky.demo.Notes.CodeSnippet;
import life.jacky.demo.Notes.Essay;
import life.jacky.demo.Notes.Note;

public class Global {

    public static LinkedList<Note> notes = new LinkedList<>("Notes");
    public static LinkedList<Essay> essays = new LinkedList<>("Essays");
    public static LinkedList<CodeSnippet> snippets = new LinkedList<>("Code Snippet");
}
