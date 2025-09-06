package service;

import model.Question;
import java.util.List;

/**
 * Provides quiz questions.
 */
public class QuizService {

    // Hardcoded list of 7 capital-city questions
    private final List<Question> questions = List.of(
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

    public List<Question> getQuestions() {
        return questions;
    }
}
