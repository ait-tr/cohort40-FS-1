package org.group40fs1project2.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min =3, max = 15, message = "Task name length must be between 3 and 15 characters")
    private String taskName;

    private String taskDescription;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_id")
    @JsonBackReference
    private Manager manager;
    private LocalDateTime createDate;
    // @Type(type="org.hibernate.type.StringType")
    private LocalDateTime lastUpdate;
    private LocalDateTime deadline;
    @Enumerated(EnumType.ORDINAL)
    private TaskStatus status;

//    @Convert(converter = StringBufferConverter.class)
//    private StringBuffer stringBuffer;

/*
Список типов

HibernateClass - Тип SQL - Тип JAVA

StringTyp - VARCHAR - String
TextType  - LONGVARCHAR - String
BooleanType - BIT - boolean
IntegerType - INTEGER - Integer
LongType - BIGINT - long

BigDecimalType - NUMERIC - BigDecimal

TimeType    - TIME - Time (библиотека НЕ java.util, а java.sql)
DateType    - Date - Date
CalendarType



 */

}
