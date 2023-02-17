package co.develhope.interceptorsmiddleware2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Month {

    private Integer monthNumber;
    private String englishName;
    private String italianName;
    private String germanName;


}