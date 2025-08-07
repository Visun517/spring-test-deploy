package lk.ijse.gdse71.back_end.repository;

import jakarta.transaction.Transactional;
import lk.ijse.gdse71.back_end.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
    // JPA methods
    @Query(value = "UPDATE Job SET status='Deactivate' WHERE id=?1", nativeQuery = true)
    @Modifying
    @Transactional
    void updateJobStatus(String id);

    List<Job> findJobByJobTitleContainingIgnoreCase(String input);
}

