package sai.service.MCQs.DTO;

import lombok.Data;

import java.util.List;

@Data
public class QuestionAnswerSaveRequestDTO {

    private String testCreatedPersonId;
    private String testCreatedPersonName;
    private String subjectName;
    private String testCode;
    private List<QuestionAnswerCore> questionAnswerCore;
    private String createdTimeStamp;
}
