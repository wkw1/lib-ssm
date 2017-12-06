package com.wkw.dto;

import com.wkw.enums.SearchBookType;
import lombok.Data;

import java.util.List;

/**
 * create by wkw
 */
@Data
public class SearchDto {
    private List<SearchBookType> searchType;
    private List<String> bookType;
}
