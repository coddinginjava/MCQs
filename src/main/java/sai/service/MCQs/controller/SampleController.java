package sai.service.MCQs.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sai.service.MCQs.dto.QuestionAnswerDBSave;
import sai.service.MCQs.repository.QuestionAnswerRepository;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class SampleController {

    private final QuestionAnswerRepository questionAnswerRepository;

    @PostMapping("/post")
    public String postdbgsave(@RequestBody QuestionAnswerDBSave questionAnswerDBSave) {
        questionAnswerDBSave.setCreatedTimeStamp(OffsetDateTime.now().toString());
        QuestionAnswerDBSave saveedResponse = questionAnswerRepository.save(questionAnswerDBSave);
        return "saved";
    }

    @GetMapping("/get/{id}")
    public Optional<QuestionAnswerDBSave> getdbsave(@NotNull @RequestBody @PathVariable String id) {
        return questionAnswerRepository.findById(id);
    }
}
