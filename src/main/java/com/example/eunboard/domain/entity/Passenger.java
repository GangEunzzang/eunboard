package com.example.eunboard.domain.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@ToString
@Table(name = "passenger")
@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passenger_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    @ToString.Exclude
    private Ticket ticket;

    /** 드라이버 학번*/
    @Column(name = "driver_student_id")
    private String driverStudentId;

    /**  탑승자 학번 */
    @Column(name = "passenger_student_id")
    private String passengerStudentId;
}
