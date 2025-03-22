
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 收养者配偶
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shouyangPeiou")
public class ShouyangPeiouController {
    private static final Logger logger = LoggerFactory.getLogger(ShouyangPeiouController.class);

    @Autowired
    private ShouyangPeiouService shouyangPeiouService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private ShouyangService shouyangService;
    @Autowired
    private YuangongService yuangongService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = shouyangPeiouService.queryPage(params);

        //字典表数据转换
        List<ShouyangPeiouView> list =(List<ShouyangPeiouView>)page.getList();
        for(ShouyangPeiouView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShouyangPeiouEntity shouyangPeiou = shouyangPeiouService.selectById(id);
        if(shouyangPeiou !=null){
            //entity转view
            ShouyangPeiouView view = new ShouyangPeiouView();
            BeanUtils.copyProperties( shouyangPeiou , view );//把实体数据重构到view中

                //级联表
                ShouyangEntity shouyang = shouyangService.selectById(shouyangPeiou.getShouyangId());
                if(shouyang != null){
                    BeanUtils.copyProperties( shouyang , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yuangongId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShouyangId(shouyang.getId());
                    view.setShouyangYuangongId(shouyang.getYuangongId());
                }
                //级联表
                YuangongEntity yuangong = yuangongService.selectById(shouyangPeiou.getYuangongId());
                if(yuangong != null){
                    BeanUtils.copyProperties( yuangong , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYuangongId(yuangong.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShouyangPeiouEntity shouyangPeiou, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shouyangPeiou:{}",this.getClass().getName(),shouyangPeiou.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            shouyangPeiou.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ShouyangPeiouEntity> queryWrapper = new EntityWrapper<ShouyangPeiouEntity>()
            .eq("shouyang_id", shouyangPeiou.getShouyangId())
            .eq("shouyang_peiouren_name", shouyangPeiou.getShouyangPeiourenName())
            .eq("shouyang_peiouren_phone", shouyangPeiou.getShouyangPeiourenPhone())
            .eq("shouyang_peiouren_guoji", shouyangPeiou.getShouyangPeiourenGuoji())
            .eq("shouyang_peiouren_age", shouyangPeiou.getShouyangPeiourenAge())
            .eq("shouyang_peiouren_sex_types", shouyangPeiou.getShouyangPeiourenSexTypes())
            .eq("shouyang_peiouren_chushengnianyue", shouyangPeiou.getShouyangPeiourenChushengnianyue())
            .eq("shouyang_peiouren_id_number", shouyangPeiou.getShouyangPeiourenIdNumber())
            .eq("shouyang_peiouren_xianzhuzhi", shouyangPeiou.getShouyangPeiourenXianzhuzhi())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShouyangPeiouEntity shouyangPeiouEntity = shouyangPeiouService.selectOne(queryWrapper);
        if(shouyangPeiouEntity==null){
            shouyangPeiou.setInsertTime(new Date());
            shouyangPeiou.setCreateTime(new Date());
            shouyangPeiouService.insert(shouyangPeiou);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShouyangPeiouEntity shouyangPeiou, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shouyangPeiou:{}",this.getClass().getName(),shouyangPeiou.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("员工".equals(role))
//            shouyangPeiou.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ShouyangPeiouEntity> queryWrapper = new EntityWrapper<ShouyangPeiouEntity>()
            .notIn("id",shouyangPeiou.getId())
            .andNew()
            .eq("yuangong_id", shouyangPeiou.getYuangongId())
            .eq("shouyang_id", shouyangPeiou.getShouyangId())
            .eq("shouyang_peiouren_name", shouyangPeiou.getShouyangPeiourenName())
            .eq("shouyang_peiouren_phone", shouyangPeiou.getShouyangPeiourenPhone())
            .eq("shouyang_peiouren_guoji", shouyangPeiou.getShouyangPeiourenGuoji())
            .eq("shouyang_peiouren_age", shouyangPeiou.getShouyangPeiourenAge())
            .eq("shouyang_peiouren_sex_types", shouyangPeiou.getShouyangPeiourenSexTypes())
            .eq("shouyang_peiouren_chushengnianyue", shouyangPeiou.getShouyangPeiourenChushengnianyue())
            .eq("shouyang_peiouren_id_number", shouyangPeiou.getShouyangPeiourenIdNumber())
            .eq("shouyang_peiouren_xianzhuzhi", shouyangPeiou.getShouyangPeiourenXianzhuzhi())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShouyangPeiouEntity shouyangPeiouEntity = shouyangPeiouService.selectOne(queryWrapper);
        if("".equals(shouyangPeiou.getShouyangPeiourenShenfenzhengPhoto()) || "null".equals(shouyangPeiou.getShouyangPeiourenShenfenzhengPhoto())){
                shouyangPeiou.setShouyangPeiourenShenfenzhengPhoto(null);
        }
        if(shouyangPeiouEntity==null){
            shouyangPeiouService.updateById(shouyangPeiou);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        shouyangPeiouService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<ShouyangPeiouEntity> shouyangPeiouList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ShouyangPeiouEntity shouyangPeiouEntity = new ShouyangPeiouEntity();
//                            shouyangPeiouEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            shouyangPeiouEntity.setShouyangId(Integer.valueOf(data.get(0)));   //收养 要改的
//                            shouyangPeiouEntity.setShouyangPeiourenName(data.get(0));                    //收养者配偶姓名 要改的
//                            shouyangPeiouEntity.setShouyangPeiourenPhone(data.get(0));                    //收养者配偶手机号 要改的
//                            shouyangPeiouEntity.setShouyangPeiourenGuoji(data.get(0));                    //收养者配偶国籍 要改的
//                            shouyangPeiouEntity.setShouyangPeiourenAge(data.get(0));                    //收养者配偶年龄 要改的
//                            shouyangPeiouEntity.setShouyangPeiourenSexTypes(Integer.valueOf(data.get(0)));   //收养者配偶性别 要改的
//                            shouyangPeiouEntity.setShouyangPeiourenChushengnianyue(data.get(0));                    //收养者配偶出生年月 要改的
//                            shouyangPeiouEntity.setShouyangPeiourenIdNumber(data.get(0));                    //收养者配偶身份证号 要改的
//                            shouyangPeiouEntity.setShouyangPeiourenXianzhuzhi(data.get(0));                    //现住址 要改的
//                            shouyangPeiouEntity.setShouyangPeiourenShenfenzhengPhoto("");//详情和图片
//                            shouyangPeiouEntity.setInsertTime(date);//时间
//                            shouyangPeiouEntity.setCreateTime(date);//时间
                            shouyangPeiouList.add(shouyangPeiouEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        shouyangPeiouService.insertBatch(shouyangPeiouList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
