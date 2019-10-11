package sai.service.MCQs.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sai.service.MCQs.dto.QuestionAnswerCore;
import sai.service.MCQs.dto.QuestionAnswerDBSave;
import sai.service.MCQs.dto.QuestionAnswerGeneralSearch;
import sai.service.MCQs.dto.QuestionAnswerSaveRequestDTO;
import sai.service.MCQs.repository.QuestionAnswerRepository;

@Service
@AllArgsConstructor
public class QuestionServices {

	private final QuestionAnswerRepository questionAnswerRepository;
	private final MongoTemplate mongoTemplate;

	public List<QuestionAnswerDBSave> saveInDb(QuestionAnswerSaveRequestDTO questionAnswerSaveRequestDTO) {

		List<QuestionAnswerDBSave> dbSaveRequest = questionAnswerSaveRequestDTO.getQuestionAnswerCore().parallelStream()
				.map(request -> {
					return arrangeForDBSave(questionAnswerSaveRequestDTO, request);
				}).collect(Collectors.toList());

		List<QuestionAnswerDBSave> dbSaved = questionAnswerRepository.saveAll(dbSaveRequest);

		return dbSaved;

	}

	private QuestionAnswerDBSave arrangeForDBSave(QuestionAnswerSaveRequestDTO questionAnswerSaveRequestDTO,
			QuestionAnswerCore questionAnswerCore) {
		QuestionAnswerDBSave questionAnswerDBSave = new QuestionAnswerDBSave();
		questionAnswerDBSave.setQuestionAnswerCore(new QuestionAnswerCore(questionAnswerCore.getQuestion(),
				questionAnswerCore.getOptionA(), questionAnswerCore.getOptionB(), questionAnswerCore.getOptionC(),
				questionAnswerCore.getOptionD(), questionAnswerCore.getAnswer()));
		questionAnswerDBSave.setCreatedTimeStamp(OffsetDateTime.now().toString());
		questionAnswerDBSave.setSubjectName(questionAnswerSaveRequestDTO.getSubjectName());
		questionAnswerDBSave.setTestCode(questionAnswerSaveRequestDTO.getTestCode());
		questionAnswerDBSave.setTestCreatedPersonId(questionAnswerSaveRequestDTO.getTestCreatedPersonId());
		questionAnswerDBSave.setTestCreatedPersonName(questionAnswerSaveRequestDTO.getTestCreatedPersonName());
		return questionAnswerDBSave;
	}

	public List<QuestionAnswerDBSave> generalSearch(QuestionAnswerGeneralSearch questionAnswerGeneralSearch) {

		Query q = new Query();

		Criteria subjectName = null, testCode = null, testCreatedPersonName = null, testCreatedPersonId = null;
		if (CollectionUtils.isNotEmpty(questionAnswerGeneralSearch.getSubjectName())
				&& Objects.nonNull(questionAnswerGeneralSearch.getSubjectName())) {
			subjectName = Criteria.where("subjectName").in(questionAnswerGeneralSearch.getSubjectName());
		}
		if (CollectionUtils.isNotEmpty(questionAnswerGeneralSearch.getTestCode())
				&& Objects.nonNull(questionAnswerGeneralSearch.getTestCode())) {
			testCode = Criteria.where("testCode").in(questionAnswerGeneralSearch.getTestCode());
		}
		if (CollectionUtils.isNotEmpty(questionAnswerGeneralSearch.getTestCreatedPersonId())
				&& Objects.nonNull(questionAnswerGeneralSearch.getTestCreatedPersonId())) {
			testCreatedPersonId = Criteria.where("testCreatedPersonId")
					.in(questionAnswerGeneralSearch.getTestCreatedPersonId());
		}
		if (CollectionUtils.isNotEmpty(questionAnswerGeneralSearch.getTestCreatedPersonName())
				&& Objects.nonNull(questionAnswerGeneralSearch.getTestCreatedPersonName())) {
			testCreatedPersonName = Criteria.where("testCreatedPersonName")
					.in(questionAnswerGeneralSearch.getTestCreatedPersonName());
		}
		
		
		

		return null;
	}
}
