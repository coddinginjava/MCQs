package sai.service.MCQs.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "QuestionAndAnswer")
public class QuestionAnswerDBSave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String testCreatedPersonId;
    private String testCreatedPersonName;
    private String subjectName;
    private String testCode;
    private QuestionAnswerCore questionAnswerCore;
    private String createdTimeStamp;

}
