import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import shouyang from '@/views/modules/shouyang/list'
    import shouyangGenggai from '@/views/modules/shouyangGenggai/list'
    import shouyangPeiou from '@/views/modules/shouyangPeiou/list'
    import songyang from '@/views/modules/songyang/list'
    import yuangong from '@/views/modules/yuangong/list'
    import dictionaryBeiSex from '@/views/modules/dictionaryBeiSex/list'
    import dictionaryBeishouyangSex from '@/views/modules/dictionaryBeishouyangSex/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShouyang from '@/views/modules/dictionaryShouyang/list'
    import dictionaryShouyangPeiourenSex from '@/views/modules/dictionaryShouyangPeiourenSex/list'
    import dictionaryShouyangSex from '@/views/modules/dictionaryShouyangSex/list'
    import dictionarySongyang from '@/views/modules/dictionarySongyang/list'
    import dictionarySongyangSex from '@/views/modules/dictionarySongyangSex/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryBeiSex',
        name: '被送养者性别',
        component: dictionaryBeiSex
    }
    ,{
        path: '/dictionaryBeishouyangSex',
        name: '被收养者性别',
        component: dictionaryBeishouyangSex
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShouyang',
        name: '收养类型',
        component: dictionaryShouyang
    }
    ,{
        path: '/dictionaryShouyangPeiourenSex',
        name: '收养者配偶性别',
        component: dictionaryShouyangPeiourenSex
    }
    ,{
        path: '/dictionaryShouyangSex',
        name: '送养者性别',
        component: dictionaryShouyangSex
    }
    ,{
        path: '/dictionarySongyang',
        name: '送养类型',
        component: dictionarySongyang
    }
    ,{
        path: '/dictionarySongyangSex',
        name: '送养者性别',
        component: dictionarySongyangSex
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/shouyang',
        name: '收养',
        component: shouyang
      }
    ,{
        path: '/shouyangGenggai',
        name: '收养信息更改记录',
        component: shouyangGenggai
      }
    ,{
        path: '/shouyangPeiou',
        name: '收养者配偶',
        component: shouyangPeiou
      }
    ,{
        path: '/songyang',
        name: '送养',
        component: songyang
      }
    ,{
        path: '/yuangong',
        name: '员工',
        component: yuangong
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
