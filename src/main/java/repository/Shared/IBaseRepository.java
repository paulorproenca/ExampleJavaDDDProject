package repository.Shared;
import java.util.Optional;

public interface IBaseRepository<I /*extends Comparable<I>*/,T /*extends AggregateRoot*/> {

        <S extends T> S save(final S entity);

        Iterable<T> findAll();

        Optional<T> findById(final I id);

        void delete(final T entity);

}
