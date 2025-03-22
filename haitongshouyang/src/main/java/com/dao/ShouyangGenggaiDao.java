package com.dao;

import com.entity.ShouyangGenggaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShouyangGenggaiView;

/**
 * 收养信息更改记录 Dao 接口
 *
 * @author 
 */
public interface ShouyangGenggaiDao extends BaseMapper<ShouyangGenggaiEntity> {

   List<ShouyangGenggaiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
