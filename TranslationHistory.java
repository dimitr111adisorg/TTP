import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class TranslationHistory {
    private static Map<String, List<String>> translationsByLanguage = new HashMap<>();

    public static void addTranslation(String language, String originalText, String translation) {
        System.out.println("Adding translation to history...");

         translationsByLanguage.computeIfAbsent(language, k -> new ArrayList<>()).add("Original Text: " + originalText + ", Translation: " + translation);

        System.out.println("Translation added to history: Language - " + language + ", Original Text - " + originalText + ", Translation - " + translation);
        return;
    }

    public void displayHistory() {
        System.out.println("\nTranslation History:");
        for (Map.Entry<String, List<String>> entry : translationsByLanguage.entrySet()) {
            String language = entry.getKey();
            List<String> translations = entry.getValue();
            
            System.out.println("Language: " + language);
            for (String translation : translations) {
                System.out.println(translation);
            }
        }
    }

    public List<String> getTranslationsForLanguage(String language) {
        return translationsByLanguage.getOrDefault(language, new ArrayList<>());
    }

}
