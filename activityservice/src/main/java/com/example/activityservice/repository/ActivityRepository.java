package com.example.activityservice.repository;

import com.example.activityservice.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {

    @Query("select a from Activity a where a.createdBy=?1")
    List<Activity> findActivityForUser(String username);

    List<Activity> findAllByCreatedBy(String username);
}
