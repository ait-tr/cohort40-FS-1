package org.group40fs1project2.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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
