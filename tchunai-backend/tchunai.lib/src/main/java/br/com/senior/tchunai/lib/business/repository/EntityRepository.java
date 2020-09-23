package br.com.senior.tchunai.lib.business.repository;

import br.com.senior.tchunai.lib.business.application.commom.exceptions.EntityNotFoundException;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface EntityRepository<T, TID> extends CrudRepository<T, TID>,
        QuerydslPredicateExecutor<T>, ProjectionRepository<T, TID> {

    default T require(TID id){
        Optional<T> registro = findById(id);
        if(!registro.isPresent()){
            throw new EntityNotFoundException(id);
        }
        return registro.get();
    }
}