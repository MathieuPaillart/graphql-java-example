package model;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@RequiredArgsConstructor
public class Project extends Model{
    @NonNull
    private String name;
    @NonNull
    private String inChargeOf;
    private List<Task> tasks = new ArrayList<>();
}
