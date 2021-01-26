

# 学习VUE3 + TypeScript

## 实践：编写一个H5编辑器

## 前期准备

- [x] 了解VUE3(TypeScript)版本的项目目录结构

  ```reStructuredText
  vue3-typescript-demo
  |   .browserslistrc             # 兼容文件
  |   .eslintrc.js
  |   .gitignore
  |   babel.config.js
  |   package-lock.json
  |   package.json                # 配置文件
  |   README.md
  |   tsconfig.json               # TS配置文件
  |               
  +---public
  |       favicon.ico
  |       index.html              # 入口文件
  |       
  \---src                         # 源码目录
      |   App.vue
      |   main.ts
      |   shims-vue.d.ts          # 定义文件
      |   
      +---assets                  # 静态资源
      |       logo.png
      |       
      +---components              # 公共组件
      |       HelloWorld.vue
      |       
      +---router                  # 路由管理
      |       index.ts
      |       
      +---store                   # 数据管理
      |       index.ts
      |       
      \---views                   # 页面管理
              About.vue
              Home.vue
  ```

- [ ] 学习官方例子，熟悉vue3和typescript的结合使用

- [ ] 学习别人开发的H5编辑器，理解原理，并使用

- [ ] 搜集第三方好用的库，避免重复造轮子
