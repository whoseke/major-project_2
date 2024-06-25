package com.gymz.project_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gymz.project_2.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member save(Member member);

    Member findById(long id);

    void deleteById(long id);

    @Query("SELECT a.member FROM Account a WHERE a.user = :username")
    Member findMemberByAccount(@Param("username") String username);

}