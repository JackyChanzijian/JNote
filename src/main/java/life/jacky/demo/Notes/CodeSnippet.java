package life.jacky.demo.Notes;

public class CodeSnippet extends Note {
    ProgrammingLanguage language;
    CodeSnippet() {
        super();
    }
    CodeSnippet(String content, ProgrammingLanguage language) {
        super(content);
        this.language = language;
    }
}
