package cn.edu.scut.shoppinngweb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    private Long id;
    private Long userId;
    private Long itemId;
    private int count;
}
