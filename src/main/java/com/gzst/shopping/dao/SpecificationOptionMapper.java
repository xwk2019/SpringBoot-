package com.gzst.shopping.dao;

import com.gzst.shopping.model.SpecificationOption;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SpecificationOptionMapper {

    public Integer insertOption(SpecificationOption option);

    public Integer deleteOptionsBySpecId(Long specId);

    public List<SpecificationOption> selectOptionsBySpecId(Long specId);
}
