package com.example.redisDemo.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GenericResponse {

  String message;
  Object data;
}
