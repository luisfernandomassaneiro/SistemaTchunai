package br.com.senior.tchunai.lib.business.application.usecase;

import org.mapstruct.factory.Mappers;

public abstract class UseCase<T> {


    protected abstract T execute();

    protected <E> E map(Class<E> clazz){
        return Mappers.getMapper(clazz);
    }
}
