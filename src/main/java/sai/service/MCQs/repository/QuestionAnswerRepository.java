package sai.service.MCQs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import sai.service.MCQs.dto.QuestionAnswerDBSave;

public interface QuestionAnswerRepository extends MongoRepository<QuestionAnswerDBSave, String> {

}
