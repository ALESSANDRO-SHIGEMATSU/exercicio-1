package ada.caixaverso.repository;

import ada.caixaverso.model.Vehicle;

import java.util.Map;
import java.util.Optional;

public interface RepositoryInterface<ID,T>{
    T create(T entity);

    void deleteById(ID id);

    Map<Long, Vehicle> findAll();

    T findById(ID id);

    void update(T entity);
}
