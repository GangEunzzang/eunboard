package com.example.eunboard.domain.entity;

import lombok.*;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@ToString
@Table(name = "area")
@Entity
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "area_id")
    private Long id;

    /**  이름 */
    @Column(name ="name")
    private String name;

    /**  출발지 */
    @Column(name = "start_point")
    private String startPoint;

    /** 도착지 */
    @Column(name = "end_point")
    private String endPoint;
}
