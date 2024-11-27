package app.repository;
import app.entity.Tables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TablesRepository extends JpaRepository<Tables, Long> {}
