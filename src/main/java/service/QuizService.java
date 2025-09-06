package service;

import model.Category;
import model.Question;

import java.util.List;

/** Provides 7 questions per category. */
public class QuizService {

    public List<Question> getQuestions(Category cat) {
        return switch (cat) {
            case CAPITALS   -> capitals();
            case CURRENCIES -> currencies();
            case LANGUAGES  -> languages();
            case FLAGS      -> flags();
            case CONTINENTS -> continents();
        };
    }

    // -------- Category data (7 Q each) --------

    private List<Question> capitals() {
        return List.of(
                new Question("What is the capital of France?",
                        List.of("Madrid", "Paris", "Rome", "Berlin"), 1),
                new Question("What is the capital of Japan?",
                        List.of("Beijing", "Tokyo", "Seoul", "Bangkok"), 1),
                new Question("What is the capital of Canada?",
                        List.of("Ottawa", "Toronto", "Vancouver", "Montreal"), 0),
                new Question("What is the capital of Australia?",
                        List.of("Sydney", "Melbourne", "Canberra", "Brisbane"), 2),
                new Question("What is the capital of Brazil?",
                        List.of("Rio de Janeiro", "São Paulo", "Brasília", "Salvador"), 2),
                new Question("What is the capital of Egypt?",
                        List.of("Cairo", "Alexandria", "Giza", "Luxor"), 0),
                new Question("What is the capital of Germany?",
                        List.of("Berlin", "Munich", "Frankfurt", "Hamburg"), 0)
        );
    }

    private List<Question> currencies() {
        return List.of(
                new Question("What is the currency of Japan?",
                        List.of("Won", "Yuan", "Yen", "Ringgit"), 2),
                new Question("What is the currency of the UK?",
                        List.of("Euro", "Pound sterling", "Krone", "Lira"), 1),
                new Question("What is the currency of Switzerland?",
                        List.of("Euro", "Franc", "Krone", "Peso"), 1),
                new Question("What is the currency of India?",
                        List.of("Rupee", "Rial", "Rand", "Dinar"), 0),
                new Question("What is the currency of Mexico?",
                        List.of("Peso", "Real", "Dollar", "Ruble"), 0),
                new Question("What is the currency of China?",
                        List.of("Yuan (Renminbi)", "Yen", "Won", "Baht"), 0),
                new Question("What is the currency of Brazil?",
                        List.of("Peso", "Real", "Lira", "Sol"), 1)
        );
    }

    private List<Question> languages() {
        return List.of(
                new Question("Official language of Brazil?",
                        List.of("Spanish", "Portuguese", "French", "English"), 1),
                new Question("Official languages of Canada (pick the most correct single)?",
                        List.of("English only", "French only", "English and French", "Spanish and English"), 2),
                new Question("Official language of Egypt?",
                        List.of("Arabic", "Berber", "French", "English"), 0),
                new Question("Official language of Germany?",
                        List.of("Dutch", "German", "Danish", "Swedish"), 1),
                new Question("Official language of Japan?",
                        List.of("Korean", "Japanese", "Chinese", "Ainu"), 1),
                new Question("Official language of Russia?",
                        List.of("Ukrainian", "Belarusian", "Russian", "Tatar"), 2),
                new Question("Official language of Turkey?",
                        List.of("Arabic", "Persian", "Turkish", "Kurdish"), 2)
        );
    }

    private List<Question> flags() {
        return List.of(
                new Question("Which flag has a red circle on white background?",
                        List.of("Japan", "Bangladesh", "Switzerland", "Canada"), 0),
                new Question("Which flag has a maple leaf?",
                        List.of("Canada", "UK", "Germany", "USA"), 0),
                new Question("Which flag has stars and stripes?",
                        List.of("USA", "France", "Brazil", "Australia"), 0),
                new Question("Which flag is red with a white cross?",
                        List.of("Switzerland", "Denmark", "England", "Norway"), 0),
                new Question("Which flag is blue with yellow cross?",
                        List.of("Sweden", "Finland", "Ukraine", "Iceland"), 0),
                new Question("Which flag is green with white crescent and star?",
                        List.of("Turkey", "Pakistan", "Malaysia", "Algeria"), 1),
                new Question("Which flag has three vertical stripes: green, white, orange?",
                        List.of("Ireland", "India", "Italy", "Ivory Coast"), 3)
        );
    }

    private List<Question> continents() {
        return List.of(
                new Question("On which continent is Egypt?",
                        List.of("Asia", "Europe", "Africa", "South America"), 2),
                new Question("On which continent is Argentina?",
                        List.of("South America", "North America", "Europe", "Australia"), 0),
                new Question("On which continent is Australia?",
                        List.of("Oceania", "Asia", "Europe", "Africa"), 0),
                new Question("On which continent is Canada?",
                        List.of("South America", "Europe", "North America", "Asia"), 2),
                new Question("On which continent is Germany?",
                        List.of("Asia", "Europe", "Africa", "North America"), 1),
                new Question("On which continent is Japan?",
                        List.of("Asia", "Oceania", "Europe", "Africa"), 0),
                new Question("On which continent is Kenya?",
                        List.of("Europe", "South America", "Africa", "Asia"), 2)
        );
    }
}
