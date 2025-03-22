
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
 * 送养
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/songyang")
public class SongyangController {
    private static final Logger logger = LoggerFactory.getLogger(SongyangController.class);

    @Autowired
    private SongyangService songyangService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
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
        PageUtils page = songyangService.queryPage(params);

        //字典表数据转换
        List<SongyangView> list =(List<SongyangView>)page.getList();
        for(SongyangView c:list){
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
        SongyangEntity songyang = songyangService.selectById(id);
        if(songyang !=null){
            //entity转view
            SongyangView view = new SongyangView();
            BeanUtils.copyProperties( songyang , view );//把实体数据重构到view中

                //级联表
                YuangongEntity yuangong = yuangongService.selectById(songyang.getYuangongId());
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
    public R save(@RequestBody SongyangEntity songyang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,songyang:{}",this.getClass().getName(),songyang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            songyang.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<SongyangEntity> queryWrapper = new EntityWrapper<SongyangEntity>()
            .eq("yuangong_id", songyang.getYuangongId())
            .eq("songyang_uuid_number", songyang.getSongyangUuidNumber())
            .eq("songyangren_name", songyang.getSongyangrenName())
            .eq("songyangren_phone", songyang.getSongyangrenPhone())
            .eq("songyangren_id_number", songyang.getSongyangrenIdNumber())
            .eq("songyang_sex_types", songyang.getSongyangSexTypes())
            .eq("songyang_types", songyang.getSongyangTypes())
            .eq("bei_name", songyang.getBeiName())
            .eq("bei_sex_types", songyang.getBeiSexTypes())
            .eq("bei_age", songyang.getBeiAge())
            .eq("bei_id_number", songyang.getBeiIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SongyangEntity songyangEntity = songyangService.selectOne(queryWrapper);
        if(songyangEntity==null){
            songyang.setInsertTime(new Date());
            songyang.setCreateTime(new Date());
            songyangService.insert(songyang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody SongyangEntity songyang, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,songyang:{}",this.getClass().getName(),songyang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("员工".equals(role))
//            songyang.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<SongyangEntity> queryWrapper = new EntityWrapper<SongyangEntity>()
            .notIn("id",songyang.getId())
            .andNew()
            .eq("yuangong_id", songyang.getYuangongId())
            .eq("songyang_uuid_number", songyang.getSongyangUuidNumber())
            .eq("songyangren_name", songyang.getSongyangrenName())
            .eq("songyangren_phone", songyang.getSongyangrenPhone())
            .eq("songyangren_id_number", songyang.getSongyangrenIdNumber())
            .eq("songyang_sex_types", songyang.getSongyangSexTypes())
            .eq("songyang_types", songyang.getSongyangTypes())
            .eq("bei_name", songyang.getBeiName())
            .eq("bei_sex_types", songyang.getBeiSexTypes())
            .eq("bei_age", songyang.getBeiAge())
            .eq("bei_id_number", songyang.getBeiIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SongyangEntity songyangEntity = songyangService.selectOne(queryWrapper);
        if("".equals(songyang.getSongyangrenPhoto()) || "null".equals(songyang.getSongyangrenPhoto())){
                songyang.setSongyangrenPhoto(null);
        }
        if("".equals(songyang.getSongyangrenShenfenzhengPhoto()) || "null".equals(songyang.getSongyangrenShenfenzhengPhoto())){
                songyang.setSongyangrenShenfenzhengPhoto(null);
        }
        if("".equals(songyang.getSongyangrenYuanshijiluFile()) || "null".equals(songyang.getSongyangrenYuanshijiluFile())){
                songyang.setSongyangrenYuanshijiluFile(null);
        }
        if("".equals(songyang.getSongyangrenJiguanzhengmingFile()) || "null".equals(songyang.getSongyangrenJiguanzhengmingFile())){
                songyang.setSongyangrenJiguanzhengmingFile(null);
        }
        if("".equals(songyang.getBeiPhoto()) || "null".equals(songyang.getBeiPhoto())){
                songyang.setBeiPhoto(null);
        }
        if(songyangEntity==null){
            songyangService.updateById(songyang);//根据id更新
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
        songyangService.deleteBatchIds(Arrays.asList(ids));
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
            List<SongyangEntity> songyangList = new ArrayList<>();//上传的东西
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
                            SongyangEntity songyangEntity = new SongyangEntity();
//                            songyangEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            songyangEntity.setSongyangUuidNumber(data.get(0));                    //送养编号 要改的
//                            songyangEntity.setSongyangrenName(data.get(0));                    //送养人姓名 要改的
//                            songyangEntity.setSongyangrenPhone(data.get(0));                    //送养人手机号 要改的
//                            songyangEntity.setSongyangrenIdNumber(data.get(0));                    //送养人身份证号 要改的
//                            songyangEntity.setSongyangrenPhoto("");//详情和图片
//                            songyangEntity.setSongyangSexTypes(Integer.valueOf(data.get(0)));   //送养者性别 要改的
//                            songyangEntity.setSongyangrenShenfenzhengPhoto("");//详情和图片
//                            songyangEntity.setSongyangrenYuanshijiluFile(data.get(0));                    //原始记录相关文件 要改的
//                            songyangEntity.setSongyangrenJiguanzhengmingFile(data.get(0));                    //机关相关证明文件 要改的
//                            songyangEntity.setSongyangTypes(Integer.valueOf(data.get(0)));   //送养类型 要改的
//                            songyangEntity.setBeiName(data.get(0));                    //被送养者姓名 要改的
//                            songyangEntity.setBeiPhoto("");//详情和图片
//                            songyangEntity.setBeiSexTypes(Integer.valueOf(data.get(0)));   //被送养者性别 要改的
//                            songyangEntity.setBeiAge(data.get(0));                    //被送养者年龄 要改的
//                            songyangEntity.setBeiIdNumber(data.get(0));                    //被送养者身份证号 要改的
//                            songyangEntity.setBeiTime(sdf.parse(data.get(0)));          //送养时间 要改的
//                            songyangEntity.setInsertTime(date);//时间
//                            songyangEntity.setCreateTime(date);//时间
                            songyangList.add(songyangEntity);


                            //把要查询是否重复的字段放入map中
                                //送养编号
                                if(seachFields.containsKey("songyangUuidNumber")){
                                    List<String> songyangUuidNumber = seachFields.get("songyangUuidNumber");
                                    songyangUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> songyangUuidNumber = new ArrayList<>();
                                    songyangUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("songyangUuidNumber",songyangUuidNumber);
                                }
                        }

                        //查询是否重复
                         //送养编号
                        List<SongyangEntity> songyangEntities_songyangUuidNumber = songyangService.selectList(new EntityWrapper<SongyangEntity>().in("songyang_uuid_number", seachFields.get("songyangUuidNumber")));
                        if(songyangEntities_songyangUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(SongyangEntity s:songyangEntities_songyangUuidNumber){
                                repeatFields.add(s.getSongyangUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [送养编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        songyangService.insertBatch(songyangList);
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
