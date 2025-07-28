package ada.caixaverso.service;

import java.util.List;

public interface ServiceInterface<D,T,U>{
    T  create(D d);

    void delete(Long id);

    List<T> findAll();

    T findById(Long id);

    void update(Long id, U u);
}
