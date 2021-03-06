package com.privatekit.server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "question_conditions")
public class QuestionCondition implements Serializable {

    private static final long serialVersionUID = 5243590376458305370L;

    @EmbeddedId
    private QuestionConditionId id;

    @Column(name = "jump_to_key", nullable = false)
    private String jumpToKey;

    public static QuestionCondition from(com.privatekit.server.controller.model.QuestionCondition qc) {
        final QuestionCondition questionCondition = new QuestionCondition();
        questionCondition.setId(new QuestionConditionId());
        questionCondition.setJumpToKey(qc.getJumpToKey());
        return questionCondition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final QuestionCondition that = (QuestionCondition) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
