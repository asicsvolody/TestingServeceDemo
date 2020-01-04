/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov.services;


import ru.yakimov.entities.Quiz;
import java.util.List;


public interface QuizService {
    List<Quiz> findAll();
    Quiz findById(Long id);
    Quiz save(Quiz quiz);
    void delete(Quiz quiz);
}
