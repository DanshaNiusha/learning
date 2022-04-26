package utils;

import model.Model4;
import model.Model5;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ModelMapStruct {
    
    ModelMapStruct INSTANCE = Mappers.getMapper(ModelMapStruct.class);
    
    Model5 transform(Model4 model4);
    
}
