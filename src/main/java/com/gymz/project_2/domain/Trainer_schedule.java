// package com.gymz.project_2.domain;

// import java.time.LocalDate;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;

// @Entity
// public class Trainer_schedule {
// @Id
// @Column(length = 6, nullable = false, unique = true)
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// private String trainer;

// @ManyToOne
// @JoinColumn(name = "pt_id", referencedColumnName = "pt_id")
// private Pt pt_id;

// @ManyToOne
// @JoinColumn(name = "session_id", referencedColumnName = "session_id")
// private Session session_id;

// @Column(nullable = false)
// private LocalDate end_time;

// public String getTrainer() {
// return trainer;
// }

// public void setTrainer(String trainer) {
// this.trainer = trainer;
// }

// public Pt getPt_id() {
// return pt_id;
// }

// public void setPt_id(Pt pt_id) {
// this.pt_id = pt_id;
// }

// public LocalDate getEnd_time() {
// return end_time;
// }

// public void setEnd_time(LocalDate end_time) {
// this.end_time = end_time;
// }

// public Session getSession_id() {
// return session_id;
// }

// public void setSession_id(Session session_id) {
// this.session_id = session_id;
// }

// @Override
// public String toString() {
// return "Trainer_schedule [trainer=" + trainer + ", pt_id=" + pt_id + ",
// session_id=" + session_id
// + ", end_time=" + end_time + "]";
// }

// }
