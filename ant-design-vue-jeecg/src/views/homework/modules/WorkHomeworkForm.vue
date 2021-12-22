<template>
  <a-spin :spinning="confirmLoading">
    <j-form-container :disabled="formDisabled">
      <a-form-model ref="form" :model="model" :rules="validatorRules" slot="detail">
        <a-row>
          <a-col :span="24">
            <a-form-model-item label="路线名称" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="rdName">
              <a-input v-model="model.rdName" placeholder="请输入路线名称"  ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="24">
            <a-form-model-item label="路线代码" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="rdCode">
              <a-input v-model="model.rdCode" placeholder="请输入路线代码"  ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="24">
            <a-form-model-item label="路线类型" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="rdType">
              <a-input v-model="model.rdType" placeholder="请输入路线类型"  ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="24">
            <a-form-model-item label="线宽" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="rdWidth">
              <a-InputNumber v-model="model.rdWidth" ></a-InputNumber> PX
            </a-form-model-item>
          </a-col>
          <a-col :span="24">
            <a-form-model-item label="连接方式" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="rdConnect">
              <j-dict-select-tag type="list" v-model="model.rdConnect" dictCode="msg_category" placeholder="请选择连接方式" />
            </a-form-model-item>
          </a-col>
          <a-col :span="24">
            <a-form-model-item label="路线颜色" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="rdColor">
              <a-input v-model="model.rdColor" placeholder="请输入路线颜色"  ></a-input>
            </a-form-model-item>
          </a-col>
          <a-col :span="24">
            <a-form-model-item label="上传附件" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="rdFile">
              <j-upload v-model="model.rdFile"   ></j-upload>
            </a-form-model-item>
          </a-col>
          <a-col :span="24">
            <a-form-model-item label="备注" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="rdRemark">
              <a-textarea v-model="model.rdRemark" rows="4" placeholder="请输入备注" />
            </a-form-model-item>
          </a-col>
          <a-col :span="24">
            <a-form-model-item label="车站正常状态" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="rdStatusNorm">
              <j-image-upload isMultiple  v-model="model.rdStatusNorm" ></j-image-upload>
            </a-form-model-item>
          </a-col>
          <a-col :span="24">
            <a-form-model-item label="车站一场状态" :labelCol="labelCol" :wrapperCol="wrapperCol" prop="rdStatusOne">
              <j-image-upload isMultiple  v-model="model.rdStatusOne" ></j-image-upload>
            </a-form-model-item>
          </a-col>
        </a-row>
      </a-form-model>
    </j-form-container>
  </a-spin>
</template>

<script>

  import { httpAction, getAction } from '@/api/manage'
  import { validateDuplicateValue } from '@/utils/util'

  export default {
    name: 'WorkHomeworkForm',
    components: {
    },
    props: {
      //表单禁用
      disabled: {
        type: Boolean,
        default: false,
        required: false
      }
    },
    data () {
      return {
        model:{
         },
        labelCol: {
          xs: { span: 24 },
          sm: { span: 5 },
        },
        wrapperCol: {
          xs: { span: 24 },
          sm: { span: 16 },
        },
        confirmLoading: false,
        validatorRules: {
           rdName: [
              { required: true, message: '请输入路线名称!'},
           ],
           rdCode: [
              { required: true, message: '请输入路线代码!'},
           ],
           rdFile: [
              { required: true, message: '请输入上传附件!'},
           ],
        },
        url: {
          add: "/homework/workHomework/add",
          edit: "/homework/workHomework/edit",
          queryById: "/homework/workHomework/queryById"
        }
      }
    },
    computed: {
      formDisabled(){
        return this.disabled
      },
    },
    created () {
       //备份model原始值
      this.modelDefault = JSON.parse(JSON.stringify(this.model));
    },
    methods: {
      add () {
        this.edit(this.modelDefault);
      },
      edit (record) {
        this.model = Object.assign({}, record);
        this.visible = true;
      },
      submitForm () {
        const that = this;
        // 触发表单验证
        this.$refs.form.validate(valid => {
          if (valid) {
            that.confirmLoading = true;
            let httpurl = '';
            let method = '';
            if(!this.model.id){
              httpurl+=this.url.add;
              method = 'post';
            }else{
              httpurl+=this.url.edit;
               method = 'put';
            }
            httpAction(httpurl,this.model,method).then((res)=>{
              if(res.success){
                that.$message.success(res.message);
                that.$emit('ok');
              }else{
                that.$message.warning(res.message);
              }
            }).finally(() => {
              that.confirmLoading = false;
            })
          }
         
        })
      },
    }
  }
</script>