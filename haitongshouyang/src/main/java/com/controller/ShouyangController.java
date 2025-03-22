
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
 * 收养
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shouyang")
public class ShouyangController {
    private static final Logger logger = LoggerFactory.getLogger(ShouyangController.class);

    @Autowired
    private ShouyangService shouyangService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YuangongService yuangongService;
    //级联表service
    @Autowired
    private ShouyangGenggaiService shouyangGenggaiService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
//        else if("员工".equals(role))
//            params.put("yuangongId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = shouyangService.queryPage(params);

        //字典表数据转换
        List<ShouyangView> list =(List<ShouyangView>)page.getList();
        for(ShouyangView c:list){
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
        ShouyangEntity shouyang = shouyangService.selectById(id);
        if(shouyang !=null){
            //entity转view
            ShouyangView view = new ShouyangView();
            BeanUtils.copyProperties( shouyang , view );//把实体数据重构到view中

                //级联表
                YuangongEntity yuangong = yuangongService.selectById(shouyang.getYuangongId());
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
    public R save(@RequestBody ShouyangEntity shouyang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shouyang:{}",this.getClass().getName(),shouyang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            shouyang.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ShouyangEntity> queryWrapper = new EntityWrapper<ShouyangEntity>()
            .eq("yuangong_id", shouyang.getYuangongId())
            .eq("shouyang_uuid_number", shouyang.getShouyangUuidNumber())
            .eq("shouyangren_name", shouyang.getShouyangrenName())
            .eq("shouyangren_phone", shouyang.getShouyangrenPhone())
            .eq("shouyangren_guoji", shouyang.getShouyangrenGuoji())
            .eq("shouyang_sex_types", shouyang.getShouyangSexTypes())
            .eq("shouyangren_chushengnianyue", shouyang.getShouyangrenChushengnianyue())
            .eq("shouyangren_id_number", shouyang.getShouyangrenIdNumber())
            .eq("shouyangren_xianzhuzhi", shouyang.getShouyangrenXianzhuzhi())
            .eq("shouyang_types", shouyang.getShouyangTypes())
            .eq("beishouyang_name", shouyang.getBeishouyangName())
            .eq("beishouyang_sex_types", shouyang.getBeishouyangSexTypes())
            .eq("beishouyang_age", shouyang.getBeishouyangAge())
            .eq("beishouyang_id_number", shouyang.getBeishouyangIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShouyangEntity shouyangEntity = shouyangService.selectOne(queryWrapper);
        if(shouyangEntity==null){
            shouyang.setInsertTime(new Date());
            shouyang.setCreateTime(new Date());
            shouyangService.insert(shouyang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShouyangEntity shouyang, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shouyang:{}",this.getClass().getName(),shouyang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("员工".equals(role))
//            shouyang.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ShouyangEntity> queryWrapper = new EntityWrapper<ShouyangEntity>()
            .notIn("id",shouyang.getId())
            .andNew()
            .eq("yuangong_id", shouyang.getYuangongId())
            .eq("shouyang_uuid_number", shouyang.getShouyangUuidNumber())
            .eq("shouyangren_name", shouyang.getShouyangrenName())
            .eq("shouyangren_phone", shouyang.getShouyangrenPhone())
            .eq("shouyangren_guoji", shouyang.getShouyangrenGuoji())
            .eq("shouyang_sex_types", shouyang.getShouyangSexTypes())
            .eq("shouyangren_chushengnianyue", shouyang.getShouyangrenChushengnianyue())
            .eq("shouyangren_id_number", shouyang.getShouyangrenIdNumber())
            .eq("shouyangren_xianzhuzhi", shouyang.getShouyangrenXianzhuzhi())
            .eq("shouyang_types", shouyang.getShouyangTypes())
            .eq("beishouyang_name", shouyang.getBeishouyangName())
            .eq("beishouyang_sex_types", shouyang.getBeishouyangSexTypes())
            .eq("beishouyang_age", shouyang.getBeishouyangAge())
            .eq("beishouyang_id_number", shouyang.getBeishouyangIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShouyangEntity shouyangEntity = shouyangService.selectOne(queryWrapper);
        if("".equals(shouyang.getShouyangrenNengliqingkuangFile()) || "null".equals(shouyang.getShouyangrenNengliqingkuangFile())){
                shouyang.setShouyangrenNengliqingkuangFile(null);
        }
        if("".equals(shouyang.getShouyangrenShenfenzhengPhoto()) || "null".equals(shouyang.getShouyangrenShenfenzhengPhoto())){
                shouyang.setShouyangrenShenfenzhengPhoto(null);
        }
        if("".equals(shouyang.getShouyangrenJiankangjianchazhengmingFile()) || "null".equals(shouyang.getShouyangrenJiankangjianchazhengmingFile())){
                shouyang.setShouyangrenJiankangjianchazhengmingFile(null);
        }
        if("".equals(shouyang.getShouyangrenHukoubuFile()) || "null".equals(shouyang.getShouyangrenHukoubuFile())){
                shouyang.setShouyangrenHukoubuFile(null);
        }
        if("".equals(shouyang.getBeishouyangPhoto()) || "null".equals(shouyang.getBeishouyangPhoto())){
                shouyang.setBeishouyangPhoto(null);
        }
        if(shouyangEntity==null){
            StringBuffer qian = new StringBuffer();
            StringBuffer hou = new StringBuffer();


            ShouyangEntity yuanShouyangEntity = shouyangService.selectById(shouyang.getId());

            if(!yuanShouyangEntity.getShouyangUuidNumber().equals(shouyang.getShouyangUuidNumber())){
                qian.append("<br />");
                hou.append("<br />");
                qian.append("收养编号:"+yuanShouyangEntity.getShouyangUuidNumber());
                hou.append("收养编号:"+shouyang.getShouyangUuidNumber());
            }
            if(!yuanShouyangEntity.getShouyangrenName().equals(shouyang.getShouyangrenName())){
                qian.append("<br />");
                hou.append("<br />");
                qian.append("收养人姓名:"+yuanShouyangEntity.getShouyangrenName());
                hou.append("收养人姓名:"+shouyang.getShouyangrenName());
            }
            if(!yuanShouyangEntity.getShouyangrenPhone().equals(shouyang.getShouyangrenPhone())){
                qian.append("<br />");
                hou.append("<br />");
                qian.append("收养人手机号:"+yuanShouyangEntity.getShouyangrenPhone());
                hou.append("收养人手机号:"+shouyang.getShouyangrenPhone());
            }
            if(!yuanShouyangEntity.getShouyangrenGuoji().equals(shouyang.getShouyangrenGuoji())){
                qian.append("<br />");
                hou.append("<br />");
                qian.append("收养人国籍:"+yuanShouyangEntity.getShouyangrenGuoji());
                hou.append("收养人国籍:"+shouyang.getShouyangrenGuoji());
            }
            if(!yuanShouyangEntity.getShouyangSexTypes().equals(shouyang.getShouyangSexTypes())){
                qian.append("<br />");
                hou.append("<br />");
                qian.append("收养者性别:"+ (yuanShouyangEntity.getShouyangSexTypes() == 1? "男":"女"));
                hou.append("收养者性别:"+ (shouyang.getShouyangSexTypes() == 1? "男":"女"));
            }
            if(!yuanShouyangEntity.getShouyangrenChushengnianyue().equals(shouyang.getShouyangrenChushengnianyue())){
                qian.append("<br />");
                hou.append("<br />");
                qian.append("收养人出生年月:"+yuanShouyangEntity.getShouyangrenChushengnianyue());
                hou.append("收养人出生年月:"+shouyang.getShouyangrenChushengnianyue());
            }
            if(!yuanShouyangEntity.getShouyangrenIdNumber().equals(shouyang.getShouyangrenIdNumber())){
                qian.append("<br />");
                hou.append("<br />");
                qian.append("收养人身份证号:"+yuanShouyangEntity.getShouyangrenIdNumber());
                hou.append("收养人身份证号:"+shouyang.getShouyangrenIdNumber());
            }
            if(!yuanShouyangEntity.getShouyangrenXianzhuzhi().equals(shouyang.getShouyangrenXianzhuzhi())){
                qian.append("<br />");
                hou.append("<br />");
                qian.append("现住址:"+yuanShouyangEntity.getShouyangrenXianzhuzhi());
                hou.append("现住址:"+shouyang.getShouyangrenXianzhuzhi());
            }
            if(shouyang.getShouyangrenNengliqingkuangFile() != null && !yuanShouyangEntity.getShouyangrenNengliqingkuangFile().equals(shouyang.getShouyangrenNengliqingkuangFile())){
                qian.append("<br />");
                hou.append("<br />");
                qian.append("收养人能力情况证明文件:<a type=\"text\" style=\"text-decoration:none\" class=\"el-button\" href=\""+yuanShouyangEntity.getShouyangrenNengliqingkuangFile()+"\"  >下载</a>");
                hou.append("收养人能力情况证明文件:<a type=\"text\" style=\"text-decoration:none\" class=\"el-button\" href=\""+shouyang.getShouyangrenNengliqingkuangFile()+"\"  >下载</a>");
//                qian.append("收养人能力情况证明文件:"+yuanShouyangEntity.getShouyangrenNengliqingkuangFile());
//                hou.append("收养人能力情况证明文件:"+shouyang.getShouyangrenNengliqingkuangFile());
            }
            if(shouyang.getShouyangrenShenfenzhengPhoto() != null && !yuanShouyangEntity.getShouyangrenShenfenzhengPhoto().equals(shouyang.getShouyangrenShenfenzhengPhoto())){
                qian.append("<br />");
                hou.append("<br />");
                qian.append("收养人身份证照片:<img style=\"margin-right:20px;\" src=\""+yuanShouyangEntity.getShouyangrenShenfenzhengPhoto()+"\" width=\"100\" height=\"100\">");
                hou.append("收养人身份证照片:<img style=\"margin-right:20px;\" src=\""+shouyang.getShouyangrenShenfenzhengPhoto()+"\" width=\"100\" height=\"100\">");
            }
            if(shouyang.getShouyangrenJiankangjianchazhengmingFile() != null && !yuanShouyangEntity.getShouyangrenJiankangjianchazhengmingFile().equals(shouyang.getShouyangrenJiankangjianchazhengmingFile())){
                qian.append("<br />");
                hou.append("<br />");
                qian.append("健康检查证明文件:<a type=\"text\" style=\"text-decoration:none\" class=\"el-button\" href=\""+yuanShouyangEntity.getShouyangrenJiankangjianchazhengmingFile()+"\"  >下载</a>");
                hou.append("健康检查证明文件:<a type=\"text\" style=\"text-decoration:none\" class=\"el-button\" href=\""+shouyang.getShouyangrenJiankangjianchazhengmingFile()+"\"  >下载</a>");
//                qian.append("健康检查证明文件:"+yuanShouyangEntity.getShouyangrenJiankangjianchazhengmingFile());
//                hou.append("健康检查证明文件:"+shouyang.getShouyangrenJiankangjianchazhengmingFile());
            }
            if(shouyang.getShouyangrenHukoubuFile() != null && !yuanShouyangEntity.getShouyangrenHukoubuFile().equals(shouyang.getShouyangrenHukoubuFile())){
                qian.append("<br />");
                hou.append("<br />");
                qian.append("居民户口簿文件:<a type=\"text\" style=\"text-decoration:none\" class=\"el-button\" href=\""+yuanShouyangEntity.getShouyangrenHukoubuFile()+"\"  >下载</a>");
                hou.append("居民户口簿文件:<a type=\"text\" style=\"text-decoration:none\" class=\"el-button\" href=\""+shouyang.getShouyangrenHukoubuFile()+"\"  >下载</a>");
//                qian.append("居民户口簿文件:"+yuanShouyangEntity.getShouyangrenHukoubuFile());
//                hou.append("居民户口簿文件:"+shouyang.getShouyangrenHukoubuFile());
            }
            if(!yuanShouyangEntity.getShouyangTypes().equals(shouyang.getShouyangTypes())){

                List<DictionaryEntity> dictionaryEntities = dictionaryService.selectList(new EntityWrapper<DictionaryEntity>().eq("dic_code", "shouyang_types").eq("dic_name", "收养类型"));

                HashMap<Integer, String> map = new HashMap<>();
                for(DictionaryEntity d:dictionaryEntities){
                    map.put(d.getCodeIndex(),d.getIndexName());
                }
                qian.append("<br />");
                hou.append("<br />");
                qian.append("收养类型:"+map.get(yuanShouyangEntity.getShouyangTypes()));
                hou.append("收养类型:"+map.get(shouyang.getShouyangTypes()));
            }
            if(!yuanShouyangEntity.getBeishouyangName().equals(shouyang.getBeishouyangName())){
                qian.append("<br />");
                hou.append("<br />");
                qian.append("被收养者姓名:"+yuanShouyangEntity.getBeishouyangName());
                hou.append("被收养者姓名:"+shouyang.getBeishouyangName());
            }
            if(shouyang.getBeishouyangPhoto() != null && !yuanShouyangEntity.getBeishouyangPhoto().equals(shouyang.getBeishouyangPhoto())){
                qian.append("<br />");
                hou.append("<br />");
                qian.append("被收养者照片:<img style=\"margin-right:20px;\" src=\""+yuanShouyangEntity.getBeishouyangPhoto()+"\" width=\"100\" height=\"100\">");
                hou.append("被收养者照片:<img style=\"margin-right:20px;\" src=\""+shouyang.getBeishouyangPhoto()+"\" width=\"100\" height=\"100\">");
//                qian.append("被收养者照片:"+yuanShouyangEntity.getBeishouyangPhoto());
//                hou.append("被收养者照片:"+shouyang.getBeishouyangPhoto());
            }
            if(!yuanShouyangEntity.getBeishouyangSexTypes().equals(shouyang.getBeishouyangSexTypes())){
                qian.append("<br />");
                hou.append("<br />");
                qian.append("被收养者性别:"+(yuanShouyangEntity.getBeishouyangSexTypes() == 1? "男":"女"));
                hou.append("被收养者性别:"+(shouyang.getBeishouyangSexTypes() == 1? "男":"女"));
            }
            if(!yuanShouyangEntity.getBeishouyangAge().equals(shouyang.getBeishouyangAge())){
                qian.append("<br />");
                hou.append("<br />");
                qian.append("被收养者年龄:"+yuanShouyangEntity.getBeishouyangAge());
                hou.append("被收养者年龄:"+shouyang.getBeishouyangAge());
            }
            if(!yuanShouyangEntity.getBeishouyangIdNumber().equals(shouyang.getBeishouyangIdNumber())){
                qian.append("<br />");
                hou.append("<br />");
                qian.append("被收养人身份证号:"+yuanShouyangEntity.getBeishouyangIdNumber());
                hou.append("被收养人身份证号:"+shouyang.getBeishouyangIdNumber());
            }
            if(!yuanShouyangEntity.getBeishouyangTime().equals(shouyang.getBeishouyangTime())){
                qian.append("<br />");
                hou.append("<br />");
                qian.append("收养时间:"+yuanShouyangEntity.getBeishouyangTime());
                hou.append("收养时间:"+shouyang.getBeishouyangTime());
            }







            ShouyangGenggaiEntity shouyangGenggaiEntity = new ShouyangGenggaiEntity();

            shouyangGenggaiEntity.setCreateTime(new Date());
            shouyangGenggaiEntity.setInsertTime(new Date());
            shouyangGenggaiEntity.setShouyangId(shouyang.getId());

            if("员工".equals(role))
                shouyangGenggaiEntity.setYuangongId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
            else
                shouyangGenggaiEntity.setYuangongId(null);


            shouyangGenggaiEntity.setXiugaiqianText(qian.toString());
            shouyangGenggaiEntity.setXiugaihouText(hou.toString());






            shouyangService.updateById(shouyang);//根据id更新



            shouyangGenggaiService.insert(shouyangGenggaiEntity);
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
        shouyangService.deleteBatchIds(Arrays.asList(ids));
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
            List<ShouyangEntity> shouyangList = new ArrayList<>();//上传的东西
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
                            ShouyangEntity shouyangEntity = new ShouyangEntity();
//                            shouyangEntity.setYuangongId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            shouyangEntity.setShouyangUuidNumber(data.get(0));                    //收养编号 要改的
//                            shouyangEntity.setShouyangrenName(data.get(0));                    //收养人姓名 要改的
//                            shouyangEntity.setShouyangrenPhone(data.get(0));                    //收养人手机号 要改的
//                            shouyangEntity.setShouyangrenGuoji(data.get(0));                    //收养人国籍 要改的
//                            shouyangEntity.setShouyangSexTypes(Integer.valueOf(data.get(0)));   //送养者性别 要改的
//                            shouyangEntity.setShouyangrenChushengnianyue(data.get(0));                    //收养人出生年月 要改的
//                            shouyangEntity.setShouyangrenIdNumber(data.get(0));                    //收养人身份证号 要改的
//                            shouyangEntity.setShouyangrenXianzhuzhi(data.get(0));                    //现住址 要改的
//                            shouyangEntity.setShouyangrenNengliqingkuangFile(data.get(0));                    //收养人能力情况证明文件 要改的
//                            shouyangEntity.setShouyangrenShenfenzhengPhoto("");//详情和图片
//                            shouyangEntity.setShouyangrenJiankangjianchazhengmingFile(data.get(0));                    //健康检查证明文件 要改的
//                            shouyangEntity.setShouyangrenHukoubuFile(data.get(0));                    //居民户口簿文件 要改的
//                            shouyangEntity.setShouyangTypes(Integer.valueOf(data.get(0)));   //收养类型 要改的
//                            shouyangEntity.setBeishouyangName(data.get(0));                    //被收养者姓名 要改的
//                            shouyangEntity.setBeishouyangPhoto("");//详情和图片
//                            shouyangEntity.setBeishouyangSexTypes(Integer.valueOf(data.get(0)));   //被收养者性别 要改的
//                            shouyangEntity.setBeishouyangAge(data.get(0));                    //被收养者年龄 要改的
//                            shouyangEntity.setBeishouyangIdNumber(data.get(0));                    //被收养人身份证号 要改的
//                            shouyangEntity.setBeishouyangTime(sdf.parse(data.get(0)));          //收养时间 要改的
//                            shouyangEntity.setInsertTime(date);//时间
//                            shouyangEntity.setCreateTime(date);//时间
                            shouyangList.add(shouyangEntity);


                            //把要查询是否重复的字段放入map中
                                //收养编号
                                if(seachFields.containsKey("shouyangUuidNumber")){
                                    List<String> shouyangUuidNumber = seachFields.get("shouyangUuidNumber");
                                    shouyangUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shouyangUuidNumber = new ArrayList<>();
                                    shouyangUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shouyangUuidNumber",shouyangUuidNumber);
                                }
                        }

                        //查询是否重复
                         //收养编号
                        List<ShouyangEntity> shouyangEntities_shouyangUuidNumber = shouyangService.selectList(new EntityWrapper<ShouyangEntity>().in("shouyang_uuid_number", seachFields.get("shouyangUuidNumber")));
                        if(shouyangEntities_shouyangUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShouyangEntity s:shouyangEntities_shouyangUuidNumber){
                                repeatFields.add(s.getShouyangUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [收养编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shouyangService.insertBatch(shouyangList);
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
