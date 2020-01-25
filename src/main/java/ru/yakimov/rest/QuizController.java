
package ru.yakimov.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.yakimov.entities.Question;
import ru.yakimov.entities.Quiz;
import ru.yakimov.services.QuizService;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

@Controller
@RequestMapping(value = "/quizzes")
public class QuizController {
    private final Logger logger = LoggerFactory.getLogger(QuizController.class);
    private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    public String list(Model uiModel) {
        logger.info("Listing quizzes");
        List<Quiz> quizzes = quizService.findAll();
        uiModel.addAttribute("quizzes", quizzes);
        logger.info("No. of quizzes: " + quizzes.size());
        return "quizzes";
    }

    @GetMapping(value = "/{id}")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        Quiz quiz = quizService.findById(id);
        uiModel.addAttribute("quiz", quiz);
        return "show";
    }

    @GetMapping(value = "/edit/{id}")
    public String updateForm(@PathVariable Long id, Model uiModel) {
        Quiz quiz = quizService.findById(id);
        uiModel.addAttribute("quiz", quiz);
        return "update1";
    }

//    !!!!
    @GetMapping(value = "/quizzes/addQue/{id}")
    public String addQuestion(@PathVariable("id") Long id, Model uiModel) {
        Quiz quiz = (Quiz) uiModel.getAttribute("quiz");
        Question question = new Question();
        question.setDisplayOrder(quiz.getQuestions().size()+1);
        quiz.addQuestion(question);
        uiModel.addAttribute("quiz", quiz);
        return  "redirect:/quizzes/edit/id";
    }

    @GetMapping(value = "/new")
    public String createForm(Model uiModel) {
        Quiz quiz = new Quiz();

        Question question = new Question();
        question.setTitle("Hello");
        question.setDisplayOrder(quiz.getQuestions().size()+1);
        quiz.addQuestion(question);
        question = new Question();
        question.setTitle("World");
        question.setDisplayOrder(quiz.getQuestions().size() +1);
        quiz.addQuestion(question);

        uiModel.addAttribute("quiz", quiz);
        return "update1";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteQuiz(@PathVariable("id") Long id) {
        Quiz quiz = quizService.findById(id);
        quizService.delete(quiz);
        return "redirect:/quizzes";
    }


    @PostMapping
    public String saveQuiz(@Valid Quiz quiz) {
        quizService.save(quiz);
        return "redirect:/quizzes/" + quiz.getId();
    }

}
