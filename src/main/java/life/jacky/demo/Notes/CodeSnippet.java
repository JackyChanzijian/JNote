package life.jacky.demo.Notes;

public class CodeSnippet extends Note {
    private String language;
    public static String[] languageList = {
            "HTML", "CSS", "JavaScript",
            "C#", "Java", "Kotlin",
            "C", "C++",
    };
    public CodeSnippet() {
        super();
    }
    CodeSnippet(String content, String language) {
        super(content);
        this.setLanguage(language);
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

}
