package sai.service.MCQs.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import sai.service.MCQs.dto.QuestionAnswerDBSave;
import sai.service.MCQs.dto.QuestionAnswerGeneralSearch;

public interface QuestionAnswerRepository extends MongoRepository<QuestionAnswerDBSave, String> {

}
