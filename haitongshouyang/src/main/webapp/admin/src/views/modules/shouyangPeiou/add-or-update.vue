<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="80px"
                :style="{backgroundColor:addEditForm.addEditBoxColor}">
            <el-row>
                <el-col :span="12"  v-if="sessionTable !='shouyang'">
                    <el-form-item class="select" v-if="type!='info'"  label="收养" prop="shouyangId">
                        <el-select v-model="ruleForm.shouyangId" :disabled="ro.shouyangId" filterable placeholder="请选择收养" @change="shouyangChange">
                            <el-option
                                    v-for="(item,index) in shouyangOptions"
                                    v-bind:key="item.id"
                                    :label="item.shouyangUuidNumber"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='shouyang' ">
                    <el-form-item class="input" v-if="type!='info'"  label="收养编号" prop="shouyangUuidNumber">
                        <el-input v-model="shouyangForm.shouyangUuidNumber"
                                  placeholder="收养编号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="收养编号" prop="shouyangUuidNumber">
                            <el-input v-model="ruleForm.shouyangUuidNumber"
                                      placeholder="收养编号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='shouyang' ">
                    <el-form-item class="input" v-if="type!='info'"  label="收养类型" prop="shouyangValue">
                        <el-input v-model="shouyangForm.shouyangValue"
                                  placeholder="收养类型" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="收养类型" prop="shouyangValue">
                            <el-input v-model="ruleForm.shouyangValue"
                                      placeholder="收养类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yuangong'">
                    <el-form-item class="select" v-if="type!='info'"  label="员工" prop="yuangongId">
                        <el-select v-model="ruleForm.yuangongId" :disabled="ro.yuangongId" filterable placeholder="请选择员工" @change="yuangongChange">
                            <el-option
                                    v-for="(item,index) in yuangongOptions"
                                    v-bind:key="item.id"
                                    :label="item.yuangongName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='yuangong' ">
                    <el-form-item class="input" v-if="type!='info'"  label="员工工号" prop="yuangongUuidNumber">
                        <el-input v-model="yuangongForm.yuangongUuidNumber"
                                  placeholder="员工工号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="员工工号" prop="yuangongUuidNumber">
                            <el-input v-model="ruleForm.yuangongUuidNumber"
                                      placeholder="员工工号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yuangong' ">
                    <el-form-item class="input" v-if="type!='info'"  label="员工姓名" prop="yuangongName">
                        <el-input v-model="yuangongForm.yuangongName"
                                  placeholder="员工姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="员工姓名" prop="yuangongName">
                            <el-input v-model="ruleForm.yuangongName"
                                      placeholder="员工姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yuangong' ">
                    <el-form-item class="input" v-if="type!='info'"  label="员工手机号" prop="yuangongPhone">
                        <el-input v-model="yuangongForm.yuangongPhone"
                                  placeholder="员工手机号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="员工手机号" prop="yuangongPhone">
                            <el-input v-model="ruleForm.yuangongPhone"
                                      placeholder="员工手机号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24" v-if="sessionTable !='yuangong' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.yuangongPhoto" label="员工头像" prop="yuangongPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (yuangongForm.yuangongPhoto || '').split(',')" :src="item" width="100" height="100">
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.yuangongPhoto" label="员工头像" prop="yuangongPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.yuangongPhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
            <input id="yuangongId" name="yuangongId" type="hidden">
            <input id="shouyangId" name="shouyangId" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="收养者配偶姓名" prop="shouyangPeiourenName">
                       <el-input v-model="ruleForm.shouyangPeiourenName"
                                 placeholder="收养者配偶姓名" clearable  :readonly="ro.shouyangPeiourenName"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="收养者配偶姓名" prop="shouyangPeiourenName">
                           <el-input v-model="ruleForm.shouyangPeiourenName"
                                     placeholder="收养者配偶姓名" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="收养者配偶手机号" prop="shouyangPeiourenPhone">
                       <el-input v-model="ruleForm.shouyangPeiourenPhone"
                                 placeholder="收养者配偶手机号" clearable  :readonly="ro.shouyangPeiourenPhone"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="收养者配偶手机号" prop="shouyangPeiourenPhone">
                           <el-input v-model="ruleForm.shouyangPeiourenPhone"
                                     placeholder="收养者配偶手机号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="收养者配偶国籍" prop="shouyangPeiourenGuoji">
                       <el-input v-model="ruleForm.shouyangPeiourenGuoji"
                                 placeholder="收养者配偶国籍" clearable  :readonly="ro.shouyangPeiourenGuoji"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="收养者配偶国籍" prop="shouyangPeiourenGuoji">
                           <el-input v-model="ruleForm.shouyangPeiourenGuoji"
                                     placeholder="收养者配偶国籍" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="收养者配偶年龄" prop="shouyangPeiourenAge">
                       <el-input v-model="ruleForm.shouyangPeiourenAge"
                                 placeholder="收养者配偶年龄" clearable  :readonly="ro.shouyangPeiourenAge"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="收养者配偶年龄" prop="shouyangPeiourenAge">
                           <el-input v-model="ruleForm.shouyangPeiourenAge"
                                     placeholder="收养者配偶年龄" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="收养者配偶性别" prop="shouyangPeiourenSexTypes">
                        <el-select v-model="ruleForm.shouyangPeiourenSexTypes" :disabled="ro.shouyangPeiourenSexTypes" placeholder="请选择收养者配偶性别">
                            <el-option
                                v-for="(item,index) in shouyangPeiourenSexTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="收养者配偶性别" prop="shouyangPeiourenSexValue">
                        <el-input v-model="ruleForm.shouyangPeiourenSexValue"
                            placeholder="收养者配偶性别" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="收养者配偶出生年月" prop="shouyangPeiourenChushengnianyue">
                       <el-input v-model="ruleForm.shouyangPeiourenChushengnianyue"
                                 placeholder="收养者配偶出生年月" clearable  :readonly="ro.shouyangPeiourenChushengnianyue"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="收养者配偶出生年月" prop="shouyangPeiourenChushengnianyue">
                           <el-input v-model="ruleForm.shouyangPeiourenChushengnianyue"
                                     placeholder="收养者配偶出生年月" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="收养者配偶身份证号" prop="shouyangPeiourenIdNumber">
                       <el-input v-model="ruleForm.shouyangPeiourenIdNumber"
                                 placeholder="收养者配偶身份证号" clearable  :readonly="ro.shouyangPeiourenIdNumber"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="收养者配偶身份证号" prop="shouyangPeiourenIdNumber">
                           <el-input v-model="ruleForm.shouyangPeiourenIdNumber"
                                     placeholder="收养者配偶身份证号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="现住址" prop="shouyangPeiourenXianzhuzhi">
                       <el-input v-model="ruleForm.shouyangPeiourenXianzhuzhi"
                                 placeholder="现住址" clearable  :readonly="ro.shouyangPeiourenXianzhuzhi"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="现住址" prop="shouyangPeiourenXianzhuzhi">
                           <el-input v-model="ruleForm.shouyangPeiourenXianzhuzhi"
                                     placeholder="现住址" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="24">
                    <el-form-item class="upload" v-if="type!='info' && !ro.shouyangPeiourenShenfenzhengPhoto" label="收养者配偶身份证照片" prop="shouyangPeiourenShenfenzhengPhoto">
                        <file-upload
                            tip="点击上传收养者配偶身份证照片"
                            action="file/upload"
                            :limit="3"
                            :multiple="true"
                            :fileUrls="ruleForm.shouyangPeiourenShenfenzhengPhoto?ruleForm.shouyangPeiourenShenfenzhengPhoto:''"
                            @change="shouyangPeiourenShenfenzhengPhotoUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.shouyangPeiourenShenfenzhengPhoto" label="收养者配偶身份证照片" prop="shouyangPeiourenShenfenzhengPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.shouyangPeiourenShenfenzhengPhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                sessionTable : "",//登录账户所在表名
                role : "",//权限
                userId:"",//当前登录人的id
                shouyangForm: {},
                yuangongForm: {},
                ro:{
                    yuangongId: false,
                    shouyangId: false,
                    shouyangPeiourenName: false,
                    shouyangPeiourenPhone: false,
                    shouyangPeiourenGuoji: false,
                    shouyangPeiourenAge: false,
                    shouyangPeiourenSexTypes: false,
                    shouyangPeiourenChushengnianyue: false,
                    shouyangPeiourenIdNumber: false,
                    shouyangPeiourenXianzhuzhi: false,
                    shouyangPeiourenShenfenzhengPhoto: false,
                    insertTime: false,
                },
                ruleForm: {
                    yuangongId: '',
                    shouyangId: '',
                    shouyangPeiourenName: '',
                    shouyangPeiourenPhone: '',
                    shouyangPeiourenGuoji: '',
                    shouyangPeiourenAge: '',
                    shouyangPeiourenSexTypes: '',
                    shouyangPeiourenChushengnianyue: '',
                    shouyangPeiourenIdNumber: '',
                    shouyangPeiourenXianzhuzhi: '',
                    shouyangPeiourenShenfenzhengPhoto: '',
                    insertTime: '',
                },
                shouyangPeiourenSexTypesOptions : [],
                shouyangOptions : [],
                yuangongOptions : [],
                rules: {
                   yuangongId: [
                              { required: true, message: '员工不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   shouyangId: [
                              { required: true, message: '收养不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   shouyangPeiourenName: [
                              { required: true, message: '收养者配偶姓名不能为空', trigger: 'blur' },
                          ],
                   shouyangPeiourenPhone: [
                              { required: true, message: '收养者配偶手机号不能为空', trigger: 'blur' },
                          ],
                   shouyangPeiourenGuoji: [
                              { required: true, message: '收养者配偶国籍不能为空', trigger: 'blur' },
                          ],
                   shouyangPeiourenAge: [
                              { required: true, message: '收养者配偶年龄不能为空', trigger: 'blur' },
                          ],
                   shouyangPeiourenSexTypes: [
                              { required: true, message: '收养者配偶性别不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   shouyangPeiourenChushengnianyue: [
                              { required: true, message: '收养者配偶出生年月不能为空', trigger: 'blur' },
                          ],
                   shouyangPeiourenIdNumber: [
                              { required: true, message: '收养者配偶身份证号不能为空', trigger: 'blur' },
                          ],
                   shouyangPeiourenXianzhuzhi: [
                              { required: true, message: '现住址不能为空', trigger: 'blur' },
                          ],
                   shouyangPeiourenShenfenzhengPhoto: [
                              { required: true, message: '收养者配偶身份证照片不能为空', trigger: 'blur' },
                          ],
                   insertTime: [
                              { required: true, message: '记录时间不能为空', trigger: 'blur' },
                          ],
                }
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");


            if (this.role != "管理员"){
            }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=shouyang_peiouren_sex_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.shouyangPeiourenSexTypesOptions = data.data.list;
                    }
                });

         this.$http({
             url: `shouyang/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.shouyangOptions = data.data.list;
            }
         });
         this.$http({
             url: `yuangong/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.yuangongOptions = data.data.list;
            }
         });

        },
        mounted() {
        },
        methods: {
            // 下载
            download(file){
                window.open(`${file}`)
            },
            // 初始化
            init(id,type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if(this.type=='info'||this.type=='else'){
                    this.info(id);
                }
                // 获取用户信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            shouyangChange(id){
                this.$http({
                    url: `shouyang/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.shouyangForm = data.data;
                    }
                });
            },
            yuangongChange(id){
                this.$http({
                    url: `yuangong/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.yuangongForm = data.data;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `shouyangPeiou/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                        _this.shouyangChange(data.data.shouyangId)
                        _this.yuangongChange(data.data.yuangongId)
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.$http({
                            url:`shouyangPeiou/${!this.ruleForm.id ? "save" : "update"}`,
                            method: "post",
                            data: this.ruleForm
                        }).then(({ data }) => {
                            if (data && data.code === 0) {
                                this.$message({
                                    message: "操作成功",
                                    type: "success",
                                    duration: 1500,
                                    onClose: () => {
                                        this.parent.showFlag = true;
                                        this.parent.addOrUpdateFlag = false;
                                        this.parent.shouyangPeiouCrossAddOrUpdateFlag = false;
                                        this.parent.search();
                                        this.parent.contentStyleChange();
                                    }
                                });
                            } else {
                                this.$message.error(data.msg);
                            }
                        });
                    }
                });
            },
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            // 返回
            back() {
                this.parent.showFlag = true;
                this.parent.addOrUpdateFlag = false;
                this.parent.shouyangPeiouCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片
            shouyangPeiourenShenfenzhengPhotoUploadChange(fileUrls){
                this.ruleForm.shouyangPeiourenShenfenzhengPhoto = fileUrls;
                this.addEditUploadStyleChange()
            },

            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputFontColor
                        el.style.fontSize = this.addEditForm.inputFontSize
                        el.style.borderWidth = this.addEditForm.inputBorderWidth
                        el.style.borderStyle = this.addEditForm.inputBorderStyle
                        el.style.borderColor = this.addEditForm.inputBorderColor
                        el.style.borderRadius = this.addEditForm.inputBorderRadius
                        el.style.backgroundColor = this.addEditForm.inputBgColor
                    })
                    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputLableColor
                        el.style.fontSize = this.addEditForm.inputLableFontSize
                    })
                    // select
                    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectFontColor
                        el.style.fontSize = this.addEditForm.selectFontSize
                        el.style.borderWidth = this.addEditForm.selectBorderWidth
                        el.style.borderStyle = this.addEditForm.selectBorderStyle
                        el.style.borderColor = this.addEditForm.selectBorderColor
                        el.style.borderRadius = this.addEditForm.selectBorderRadius
                        el.style.backgroundColor = this.addEditForm.selectBgColor
                    })
                    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectLableColor
                        el.style.fontSize = this.addEditForm.selectLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                        el.style.color = this.addEditForm.selectIconFontColor
                        el.style.fontSize = this.addEditForm.selectIconFontSize
                    })
                    // date
                    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateFontColor
                        el.style.fontSize = this.addEditForm.dateFontSize
                        el.style.borderWidth = this.addEditForm.dateBorderWidth
                        el.style.borderStyle = this.addEditForm.dateBorderStyle
                        el.style.borderColor = this.addEditForm.dateBorderColor
                        el.style.borderRadius = this.addEditForm.dateBorderRadius
                        el.style.backgroundColor = this.addEditForm.dateBgColor
                    })
                    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateLableColor
                        el.style.fontSize = this.addEditForm.dateLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                        el.style.color = this.addEditForm.dateIconFontColor
                        el.style.fontSize = this.addEditForm.dateIconFontSize
                        el.style.lineHeight = this.addEditForm.dateHeight
                    })
                    // upload
                    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.uploadHeight
                        el.style.color = this.addEditForm.uploadLableColor
                        el.style.fontSize = this.addEditForm.uploadLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                        el.style.color = this.addEditForm.uploadIconFontColor
                        el.style.fontSize = this.addEditForm.uploadIconFontSize
                        el.style.lineHeight = iconLineHeight
                        el.style.display = 'block'
                    })
                    // 多文本输入框
                    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                        el.style.height = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaFontColor
                        el.style.fontSize = this.addEditForm.textareaFontSize
                        el.style.borderWidth = this.addEditForm.textareaBorderWidth
                        el.style.borderStyle = this.addEditForm.textareaBorderStyle
                        el.style.borderColor = this.addEditForm.textareaBorderColor
                        el.style.borderRadius = this.addEditForm.textareaBorderRadius
                        el.style.backgroundColor = this.addEditForm.textareaBgColor
                    })
                    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                        // el.style.lineHeight = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaLableColor
                        el.style.fontSize = this.addEditForm.textareaLableFontSize
                    })
                    // 保存
                    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                        el.style.width = this.addEditForm.btnSaveWidth
                        el.style.height = this.addEditForm.btnSaveHeight
                        el.style.color = this.addEditForm.btnSaveFontColor
                        el.style.fontSize = this.addEditForm.btnSaveFontSize
                        el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                        el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                        el.style.borderColor = this.addEditForm.btnSaveBorderColor
                        el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnSaveBgColor
                    })
                    // 返回
                    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                        el.style.width = this.addEditForm.btnCancelWidth
                        el.style.height = this.addEditForm.btnCancelHeight
                        el.style.color = this.addEditForm.btnCancelFontColor
                        el.style.fontSize = this.addEditForm.btnCancelFontSize
                        el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                        el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                        el.style.borderColor = this.addEditForm.btnCancelBorderColor
                        el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnCancelBgColor
                    })
                })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                })
            },
        }
    };
</script>
<style lang="scss">
.editor{
  height: 500px;

  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
}
.btn .el-button {
  padding: 0;
}</style>

