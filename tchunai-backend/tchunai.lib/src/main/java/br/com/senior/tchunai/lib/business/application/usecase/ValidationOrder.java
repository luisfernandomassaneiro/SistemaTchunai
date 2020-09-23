package br.com.senior.tchunai.lib.business.application.usecase;

import br.com.senior.tchunai.lib.business.application.validation.LazyValidation;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class, LazyValidation.class})
public interface ValidationOrder {
}
