package sai.service.MCQs.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionAnswerGeneralSearch {

	private List<String> testCreatedPersonId;
	private List<String> testCreatedPersonName;
	private List<String> subjectName;
	private List<String> testCode;
	private String createdTimeStamp;
	private List<String> parameters;

}
