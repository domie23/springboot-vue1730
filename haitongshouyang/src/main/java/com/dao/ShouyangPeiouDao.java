package com.dao;

import com.entity.ShouyangPeiouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShouyangPeiouView;

/**
 * 收养者配偶 Dao 接口
 *
 * @author 
 */
public interface ShouyangPeiouDao extends BaseMapper<ShouyangPeiouEntity> {

   List<ShouyangPeiouView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
