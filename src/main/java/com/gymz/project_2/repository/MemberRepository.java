package com.gymz.project_2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gymz.project_2.domain.Booking;
import com.gymz.project_2.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member save(Member member);

}