package com.nocountry.S12G15.util;

import com.nocountry.S12G15.dto.request.PageableDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Utility {
    public Pageable setPageable(PageableDto pageableDTO) {
        Integer sortOrder = pageableDTO.getOrder();
        String sortField = pageableDTO.getField();
        int pageNumber = pageableDTO.getPageNumber();
        int perPage = pageableDTO.getPageSize();

        Pageable pageable;
        if (Objects.nonNull(sortOrder) && !sortField.isBlank()) {
            Sort.Direction direction = sortOrder.equals(1) ? Sort.Direction.ASC : Sort.Direction.DESC;
            pageable = PageRequest.of(pageNumber, perPage, Sort.by(direction, sortField));
        } else {
            pageable = PageRequest.of(pageNumber, perPage, Sort.by("id").descending());
        }
        return pageable;
    }
}
