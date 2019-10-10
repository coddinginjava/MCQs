package sai.service.MCQs.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import sai.service.MCQs.DTO.QuestionAnswerSaveRequestDTO;
import sai.service.MCQs.service.QuestionServices;

@RestController
@AllArgsConstructor
@RequestMapping("/question")
public class QuestionController {

    private final QuestionServices questionServices;

    @PostMapping("/post")
    public String postdbgsave(@RequestBody QuestionAnswerSaveRequestDTO questionAnswerDBSave) {
        QuestionAnswerSaveRequestDTO savedRequestDTO = questionServices.saveInDb(questionAnswerDBSave);

        return "saved";
    }

	/*
	 * @GetMapping("/get/{id}") public Optional<QuestionAnswerDBSave>
	 * getdbsave(@NotNull @RequestBody @PathVariable String id) { return
	 * questionAnswerRepository.findById(id); }
	 */
}
