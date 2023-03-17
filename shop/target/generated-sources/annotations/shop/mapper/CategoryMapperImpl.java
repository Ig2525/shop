package shop.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import shop.dto.category.CategoryItemDTO;
import shop.dto.category.CreateCategoryDTO;
import shop.entities.CategoryEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-17T18:12:38+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryItemDTO CategoryItemDTOByCategory(CategoryEntity category) {
        if ( category == null ) {
            return null;
        }

        CategoryItemDTO categoryItemDTO = new CategoryItemDTO();

        categoryItemDTO.setDescription( category.getDescription() );
        categoryItemDTO.setId( category.getId() );
        categoryItemDTO.setName( category.getName() );
        categoryItemDTO.setImage( category.getImage() );

        return categoryItemDTO;
    }

    @Override
    public List<CategoryItemDTO> CategoryItemDTOsByCategories(List<CategoryEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<CategoryItemDTO> list1 = new ArrayList<CategoryItemDTO>( list.size() );
        for ( CategoryEntity categoryEntity : list ) {
            list1.add( CategoryItemDTOByCategory( categoryEntity ) );
        }

        return list1;
    }

    @Override
    public CategoryEntity CategoryByCreateCategoryDTO(CreateCategoryDTO dto) {
        if ( dto == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setName( dto.getName() );
        categoryEntity.setDescription( dto.getDescription() );

        return categoryEntity;
    }
}
