package sai.service.MCQs.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuestionAnswerCore {
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private List<String> answer;
}
