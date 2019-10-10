package sai.service.MCQs.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sai.service.MCQs.DTO.QuestionAnswerCore;
import sai.service.MCQs.DTO.QuestionAnswerSaveRequestDTO;
import sai.service.MCQs.repository.QuestionAnswerRepository;
import sai.service.MCQs.dto.QuestionAnswerDBSave;

@Service
@AllArgsConstructor
public class QuestionServices {

    private final QuestionAnswerRepository questionAnswerRepository;


    public QuestionAnswerSaveRequestDTO saveInDb(QuestionAnswerSaveRequestDTO questionAnswerSaveRequestDTO) {
    	
    	questionAnswerSaveRequestDTO.getQuestionAnswerCore().parallelStream().map(request -> {
    		QuestionAnswerDBSave = new QuestionServices(questionAnswerRepository)
    	})

    return null;

    }
}
