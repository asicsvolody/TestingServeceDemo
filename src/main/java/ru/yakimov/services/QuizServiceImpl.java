/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.yakimov.dao.QuizRepository;
import ru.yakimov.entities.Quiz;

import java.util.List;

@Transactional
@Repository("quizDao")
public class QuizServiceImpl implements QuizService {
    private static final Log logger = LogFactory.getLog(QuizServiceImpl.class);

    private QuizRepository repository;

    public QuizServiceImpl(QuizRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Quiz> findAll() {
        return this.repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Quiz findById(Long id) {
        return this.repository.findById(id).orElseThrow(NullPointerException::new);
    }

    @Override
    @Transactional
    public Quiz save(Quiz obj) {
       this.repository.save(obj);
       return obj;
    }

    @Override
    public void delete(Quiz obj) {
        this.repository.delete(obj);
    }

}
