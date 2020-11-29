package com.mustafa.dto;

import com.mustafa.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProjectDTO {

    private String projectName;
    private String projectCode;
    private UserDTO assignedManager;
    @DateTimeFormat(pattern = "yyyy-dd-MM")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-dd-MM")
    private LocalDate endDate;
    private String projectDetail;
    private Status status;


}
