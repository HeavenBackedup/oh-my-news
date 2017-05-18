'use strict';
/**
 * @ngdoc overview
 * @name ohMyNewsClientApp
 * @description
 * # ohMyNewsClientApp
 *
 * Main module of the application.
 */
var app =angular
  .module('ohMyNewsClientApp', [
    'ngAnimate',
    'ngAria',
    'ngCookies',
      'ngStorage',
    'ngMessages',
    'ngResource',
    'ngSanitize',
    'ngTouch',
    'ui.router',
    'ui.bootstrap',
    'ui.load',
    'ui.jq',
    'ui.validate',
    'ngFileUpload',
    'ui.bootstrap.pagination',
    'ui.bootstrap.datetimepicker',
      'textAngular',
      'ngClipboard'
  ])
  .run(
  [  '$rootScope', '$state', '$stateParams',
    function ($rootScope,   $state,   $stateParams) {
      $rootScope.$state = $state;
      $rootScope.$stateParams = $stateParams;
    }
  ]
)
  .config(['$stateProvider', '$urlRouterProvider', '$controllerProvider', '$compileProvider', '$filterProvider', '$provide','ngClipProvider',
    function ($stateProvider,   $urlRouterProvider,   $controllerProvider,   $compileProvider,   $filterProvider,   $provide,ngClipProvider) {
      app.controller = $controllerProvider.register;
      app.directive  = $compileProvider.directive;
      app.filter     = $filterProvider.register;
      app.factory    = $provide.factory;
      app.service    = $provide.service;
      app.constant   = $provide.constant;
      app.value      = $provide.value;
      $urlRouterProvider.otherwise('main');
        // /app/personal_home_page/hp_tabset/my_home_page
        ngClipProvider.setPath(bootPATH+"/bower_components/zeroclipboard/dist/ZeroClipboard.swf");
      $stateProvider
      // 整体页面路由
          .state('app',{
              abstract: true,
              url: '/app',
              templateUrl: 'views/app.html',
              controller: 'appController'
          })

          // 个人主页模块根路由
          .state('app.personalHomepage',{
              abstract: true,
              url: '/personal_home_page',
              templateUrl: 'views/block/homepage/personal_homepage.html',
              controller: 'personalHomePageController'
          })
          // 资产模块页面根路由，包含我的钱包和我的打赏页面
          .state('app.assetHomepage',{
              abstract: true,
              url: '/asset_homepage',
              templateUrl: 'views/block/homepage/asset_homepage.html',
              controller: 'assetHomePageController'
          })
          // 个人主页模块路由，控制我的主页，草稿箱，私信，喜欢，收藏几个模块
          .state('app.personalHomepage.hpTabset',{
              abstract: true,
              url: '/hp_tabset',
              templateUrl: 'views/block/homepage/hp_tabset.html',
              controller: 'hbTabsetController',
              params:{"userId":null}
          })

        // 个人主页模块
        .state('app.personalHomepage.hpTabset.myHomePage',{
          url: '/my_home_page',
          templateUrl: 'views/block/homepage/my_home_page.html',
            controller: 'myHomePageController'
        })

        // 草稿箱模块
        .state('app.personalHomepage.hpTabset.draft',{
          url: '/draft',
          templateUrl: 'views/block/homepage/draft.html',
            controller: 'draftController'
        })
        // 喜欢／收藏模块
        .state('app.personalHomepage.hpTabset.likeCollect',{
          url: '/like_collect',
          templateUrl: 'views/block/homepage/like_collect.html',
            controller: 'likeCollectController'
        })
        // 私信模块
        .state('app.personalHomepage.hpTabset.privateMsg',{
          url: '/private_msg',
          templateUrl: 'views/block/homepage/private_msg.html',
            controller: 'privateMsgController'
        })
          // 历史文章
          .state('app.personalHomepage.hpTabset.history',{
              url: '/history',
              templateUrl: 'views/block/homepage/history.html',
              controller: 'historyController'
          })
          // 我的关注
          .state('app.personalHomepage.hpTabset.myConcern',{
              url: '/my_concern',
              templateUrl: 'views/block/homepage/my_concern.html',
              controller: 'myConcernController'
          })
          // 我的粉丝
          .state('app.personalHomepage.hpTabset.myFans',{
              url:'/my_fans',
              templateUrl: 'views/block/homepage/my_fans.html',
              controller: 'myFansController'
          })
          // 我的钱包模块
        .state('app.assetHomepage.myWallet',{
          url: '/my_wallet',
          templateUrl: 'views/block/homepage/my_wallet.html',
            controller: 'myWalletController'
        })
        // 我的打赏模块
        .state('app.assetHomepage.myReward',{
          url: '/my_reward',
          templateUrl: 'views/block/homepage/my_reward.html',
            controller: 'myRewardController'
        })
        // 账户管理模块
        .state('app.accountManage',{
          url: '/account_manage',
          templateUrl: 'views/block/homepage/account_manage.html',
            controller: 'accountManageController'
        })
        // 新闻主页模块
        .state('main',{
          url: '/main',
          templateUrl: 'views/block/mainpage/main.html',
            controller: 'mainController',
            params:{'categoryId':{}}
        })
          //新闻搜索模块
          .state('search',{
              url:'/search',
              templateUrl: 'views/block/mainpage/search.html',
              controller: 'searchController',
              params:{'search':{}}
          })
        // 新闻编辑页面模块
        .state('app.edit',{
          url: '/edit',
          templateUrl: 'views/block/edit/edit.html',
            controller: 'editController'
        })
        // 新闻显示页面模块
        .state('app.detail',{
          url: '/detail/:articleId',
          templateUrl: 'views/block/detail/detail.html',
            controller: 'detailController'
        })
        // 登录模块
        .state('login',{
          url: '/login',
          templateUrl: 'views/block/common/login.html',
            controller: 'loginController',

        })
        // 注册模块
        .state('register',{
          url: '/register',
          templateUrl: 'views/block/common/register.html',
            controller: 'registerController'
        })
          // 模板模块，参考代码
          .state('app.template',{
              url:'/template',
              templateUrl: 'views/block/template/template.html',
              controller: 'templateController'
          })
          .state('error',{
              url: '/error',
              templateUrl: 'views/error.html',
              controller: 'errorController'
          })
      ;

  }]);
