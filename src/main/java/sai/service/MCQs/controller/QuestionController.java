package sai.service.MCQs.controller;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import sai.service.MCQs.dto.QuestionAnswerDBSave;
import sai.service.MCQs.dto.QuestionAnswerSaveRequestDTO;
import sai.service.MCQs.service.QuestionServices;

@RestController
@AllArgsConstructor
@RequestMapping("/question")
public class QuestionController {

	private final QuestionServices questionServices;

	@PostMapping("/post")
	public ResponseEntity<List<QuestionAnswerDBSave>> postdbgsave(
			@RequestBody QuestionAnswerSaveRequestDTO questionAnswerDBSave) {
		List<QuestionAnswerDBSave> dbSaved = questionServices.saveInDb(questionAnswerDBSave);

		return CollectionUtils.isNotEmpty(dbSaved) ? new ResponseEntity<>(dbSaved, HttpStatus.CREATED)
				: new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	/*
	 * @GetMapping("/get/{id}") public Optional<QuestionAnswerDBSave>
	 * getdbsave(@NotNull @RequestBody @PathVariable String id) { return
	 * questionAnswerRepository.findById(id); }
	 */
}
