package com.bjsxt.base.mapper;

import com.bjsxt.base.pojo.Menu;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface MenuMapper {

    List<Menu> selMenus(Map<String,Object> map);
}
