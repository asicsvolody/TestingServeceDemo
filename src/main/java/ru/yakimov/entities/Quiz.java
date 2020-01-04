/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "quiz")

//@NamedQueries({
//        @NamedQuery(name=Quiz.FIND_ALL, query="select q from Quiz q"),
//        @NamedQuery(name=Quiz.FIND_SINGER_BY_ID,
//                query="select distinct q from Quiz q " +
//                        "left join fetch q.questions qe " +
//                        "where q.id = :id"),
//        @NamedQuery(name=Quiz.FIND_ALL_WITH_QUESTIONS,
//                query="select distinct q from Quiz q " +
//                        "left join fetch q.questions qe ")
//})
//@SqlResultSetMapping(
//        name="quizResult",
//        entities=@EntityResult(entityClass=Quiz.class)
//)
public class Quiz implements Serializable {

//    public static final String FIND_ALL = "Quiz.findAll";
//    public static final String FIND_SINGER_BY_ID = "Quiz.findById";
//    public static final String FIND_ALL_WITH_QUESTIONS = "Quiz.findAllWithQuestions";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Version
    @Column(name = "VERSION")
    private int version;

    @Column(name = "TITLE")
    private String title;

    @Temporal(TemporalType.DATE)
    @Column(name = "BEGIN_DATE")
    private Date beginDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "END_DATE")
    private Date endDate;

//    @Column(name = "ACTIVE")
//    private boolean isActive;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Question> questions = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isActive() {
        Date dateNow = new Date();
        return dateNow.after(this.beginDate) && dateNow.before(this.endDate);
    }


    public List<Question> getQuestionsList(){
        return new ArrayList<>(this.questions);
    }

//    public void setActive(boolean active) {
//        isActive = active;
//    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public boolean addQuestion(Question question){
        question.setQuiz(this);
        return this.questions.add(question);
    }

    public void removeQuestion(Question question){
        this.questions.remove(question);
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", version=" + version +
                ", title='" + title + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", isActive=" + isActive() +
                ", questions=" + questions +
                '}';
    }
}
