package io.tshapeddev.grpc.learnings.models;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameToken {

    private Player player;
    @Setter
    private Cell currentCell;
    private String tokenColorHash;

}
