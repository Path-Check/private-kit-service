package com.privatekit.server.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Question {

    @JsonProperty(value = "question_key", required = true)
    @NotEmpty(message = "question_key is missed")
    private String questionKey;

    @JsonProperty(value = "question_text", required = true)
    @NotEmpty(message = "question_text is missed")
    private String questionText;

    @JsonProperty(value = "question_description")
    @NotEmpty(message = "question_description is missed")
    private String questionDescription;

    @JsonProperty(value = "question_title")
    @NotEmpty(message = "question_title is missed")
    private String questionTitle;

    @JsonProperty
    private String image;

    @JsonProperty(value = "question_type", required = true)
    @NotEmpty(message = "question_type is missed")
    private String questionType;

    private boolean required = false;

    @JsonProperty(value = "screen_type", required = true)
    @NotEmpty(message = "screen_type is missed")
    private String screenType;

    @JsonProperty(value = "option_key", required = true)
    @NotEmpty(message = "option_key is missed")
    private String optionKey;

    @JsonProperty(required = true)
    @NotEmpty(message = "condition list is missed")
    private List<QuestionCondition> conditions = new ArrayList<>();

    public static Question from(com.privatekit.server.entity.Question s) {

        final Question question = new Question();
        question.setQuestionKey(s.getId().getQuestionKey());
        question.setQuestionType(s.getType());
        question.setOptionKey(s.getOptionKey());
        question.setQuestionText(s.getText());
        question.setImage(s.getImage());
        question.setQuestionTitle(s.getTitle());
        question.setQuestionDescription(s.getDescription());
        question.setRequired(s.getRequired());
        question.setScreenType(s.getScreenType());

        return question;
    }

}
