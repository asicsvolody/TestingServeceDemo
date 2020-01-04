/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yakimov.entities.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
