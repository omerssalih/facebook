package com.example.facebook.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubmitPostDto {

    private String userName;
    private String post;


}
