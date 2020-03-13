package model;

import lombok.*;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@RequiredArgsConstructor
@NoArgsConstructor
public class Task extends Model{
    @NonNull
    private String projectId;
    @NonNull
    private String description;
}
