package com.example.study.utils;

import lombok.experimental.UtilityClass;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@UtilityClass
//@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaginationUtil {
    public static PageRequest getPageRequest(   Integer page,
                                                Integer perPage,
                                                String sort,
                                                Sort.Direction sortDirection) {
        if (page == null) {
            page = 0;
        } else if (page > 0) {
            page--;
        }

        if (perPage == null) {
            perPage = 10;
        }

        if (sort == null || sortDirection == null) {
            return PageRequest.of(page, perPage);
        } else {
            return PageRequest.of(page, perPage, Sort.by(sortDirection, sort));
        }
    }
}
