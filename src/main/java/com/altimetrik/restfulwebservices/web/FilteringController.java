package com.altimetrik.restfulwebservices.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.restfulwebservices.model.CustomBean;
import com.altimetrik.restfulwebservices.model.CustomDynamicBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

    @GetMapping("/static-filtering")
    public CustomBean retrieveCustomBean() {
        return new CustomBean("v1", "v2", "v3");
    }

    @GetMapping("/static-filtering-list")
    public List<CustomBean> retrieveListCustomBean() {
        return Arrays.asList(new CustomBean("v1", "v2", "v3"), new CustomBean("v4", "v5", "v6"));
    }

    @GetMapping("/dynamic-filtering")
    public MappingJacksonValue retrieveDynamicCustomBean() {
        CustomDynamicBean dBean = new CustomDynamicBean("v1", "v2", "v3");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("f1", "f2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(dBean);
        mapping.setFilters(filters);

        return mapping;
    }

    @GetMapping("/dynamic-filtering-list")
    public MappingJacksonValue retrieveDynamicCustomBeanList() {
        List<CustomDynamicBean> dBean = Arrays.asList(new CustomDynamicBean("v1", "v2", "v3"),
                new CustomDynamicBean("v4", "v5", "v6"));

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("f2", "f3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(dBean);
        mapping.setFilters(filters);

        return mapping;
    }
}
