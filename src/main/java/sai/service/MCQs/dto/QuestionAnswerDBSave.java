package sai.service.MCQs.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;

@Data
@Document(collection = "QuestionAndAnswer")
public class QuestionAnswerDBSave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String testCreaterId;
    private String subjectName;
    private String testCode;
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private List<String> answer;
    private String createdTimeStamp;

}
