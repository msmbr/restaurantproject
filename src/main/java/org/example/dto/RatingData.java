package org.example.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RatingData {
    private String rating;
    private Integer votes;
}
