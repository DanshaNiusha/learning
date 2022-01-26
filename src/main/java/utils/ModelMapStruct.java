package utils;

import model.Model1;
import model.Model2;
import model.Model3;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ModelMapStruct {
    
    ModelMapStruct INSTANCE =  Mappers.getMapper(ModelMapStruct.class);
    
    // Model1 transform (Model2 model2);
}
