package sai.service.MCQs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
