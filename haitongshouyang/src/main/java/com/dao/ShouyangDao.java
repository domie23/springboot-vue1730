package com.dao;

import com.entity.ShouyangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShouyangView;

/**
 * 收养 Dao 接口
 *
 * @author 
 */
public interface ShouyangDao extends BaseMapper<ShouyangEntity> {

   List<ShouyangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
