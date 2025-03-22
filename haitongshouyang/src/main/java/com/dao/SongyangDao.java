package com.dao;

import com.entity.SongyangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.SongyangView;

/**
 * 送养 Dao 接口
 *
 * @author 
 */
public interface SongyangDao extends BaseMapper<SongyangEntity> {

   List<SongyangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
