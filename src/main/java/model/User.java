package model;

import lombok.*;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain=true)
@RequiredArgsConstructor
public class User extends Model{
    @NonNull
    private String name;
    @NonNull
    private Integer age;
}
