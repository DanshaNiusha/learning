package utils;

import model.Model1;
import model.Model3;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ModelMapStruct {
    
    ModelMapStruct INSTANCE = Mappers.getMapper(ModelMapStruct.class);
    
    Model1 convert2Model1(Model1 model1);
    
    
}
