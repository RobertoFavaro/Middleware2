package co.develhope.Middleware2.InterceptorMiddleware02.repositorues;

import co.develhope.Middleware2.InterceptorMiddleware02.entities.Month;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthRepository extends JpaRepository<Month, Long>{
    Month findByMonthNumber(Integer monthNumber);
}
