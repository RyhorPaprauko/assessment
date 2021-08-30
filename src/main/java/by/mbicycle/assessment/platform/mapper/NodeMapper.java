package by.mbicycle.assessment.platform.mapper;

import by.mbicycle.assessment.platform.database.entity.NodeEntity;
import by.mbicycle.assessment.platform.database.entity.enam.NodePriority;
import by.mbicycle.assessment.platform.dto.NodeDataRecord;
import by.mbicycle.assessment.platform.dto.NodeRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = {ProgramMapper.class})
public interface NodeMapper {

    @Mapping(target = "coordinates", expression = "java(toCoordinates(nodeEntity))")
    @Mapping(target = "data", expression = "java(toDataRecord(nodeEntity))")
    NodeRecord toRecord(NodeEntity nodeEntity);

    NodeDataRecord toDataRecord(NodeEntity entity);

    default List<Integer> toCoordinates(NodeEntity entity) {
        return List.of(entity.getCoordinateX(), entity.getCoordinateY());
    }

    default String toPriorityString(NodePriority priority) {
        return priority.getValue();
    }
}