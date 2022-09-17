## <font color='red'>Vue中动画效果</font>



- #### 定义动画

  - ```css
    @keyframes bounce {
      0% {
        transform: scale(0);
      }
      50% {
        transform: scale(1.5);
      }
      100% {
        transform: scale(1);
      }
    }
    ```

- #### 使用标签 <font color='red'>transition</font>

  - ```html
        <transition>
          <h1 v-show="isShow">你好 我叫小娜</h1>
        </transition>
    ```

- #### css中添加进入离开样式

  - ```css
    .v-enter-active {
      animation: bounce 0.3s ease;
    }
    .v-leave-active {
      animation: bounce 0.8s reverse;
    }
    ```

  - ##### 这里动画名字应用的是自己定义的动画

- ##### Code

  - 完整

    ```vue
    //html
    <transition>
       <h1 v-show="isShow">你好 我叫小娜</h1>
    </transition>
    
    
    //css
    .v-enter-active {
      animation: bounce 0.3s ease;
    }
    .v-leave-active {
      animation: bounce 0.8s reverse;
    }
    @keyframes bounce {
      0% {
        transform: scale(0);
      }
      50% {
        transform: scale(1.5);
      }
      100% {
        transform: scale(1);
      }
    }
    ```





<hr>



## <font color='red'>动画拆分</font>



- #### v-enter-active

  - ##### v-enter   v-enter-to

- #### v-leave-active

  - ##### v-leave  v-leave-to

- #### Code

  - ```css
    /*开始和离开的样式表的过度时间等设置*/
    .yiwyn-enter-active, .yiwyn-leave-active{
        transition: 0.5s;
    }
    
    /*开始的样式*/
    .yiwyn-enter , .yiwyn-leave-to{
        transform: scale(0);
    }
    /*结束的样式*/
    .yiwyn-enter-to , .yiwyn-leave{
        transform: scale(1);
    }
    ```

    

  - ##### 使用<font color='red'> , </font> 将相同的样式并列起来，若enter和leave动画不同则可以分开编辑







<hr>

### <font color='red'>细节说明</font>



- #### <font color='red'>transition</font>命令拥有<font color='cornflowerblue'>name</font>属性指定这个名字之后如<font color='red'>xxx</font>，css中<font color='red'>v-enter-active</font> 要替换为<font color='red'>xxx-enter-active</font> 

- #### 使用<font color='cornflowerblue'>appear </font>属性可以开始的时候立即执行一次动画





### <font color='red'>第三方动画库</font>



- ### animate.css [animate.css - npm (npmjs.com)](https://www.npmjs.com/package/animate.css)

- #### 快速开始 [Animate.css | A cross-browser library of CSS animations.](https://animate.style/#documentation)

  - ##### 安装

    - ```shell
      $ npm install animate.css --save
      ```

  - ##### 导入

    - ```js
      import "animate.css"
      ```

  - ##### 使用

    - ```html
      <h1 class="animate__animated animate__bounce">An animated element</h1>
      ```

    - ##### 这里的<font color='red'>animate__animated</font>是必须要添加的

  - ##### 结合transition使用

    - ##### code

      - ```html
            <transition
              name="animate__animated "
              enter-active-class="animate__bounceInDown"
              leave-active-class="animate__backOutUp"
              appear
            >
              <h1 v-show="isShow">你好 我叫小娜</h1>
            </transition>
        ```

    - #### 说明

      - ##### 这里的<font color='cornflowerblue'>name</font>一定要写为<font color='red'>animate__animated</font>并且后面附带一个空格，因为他会将<font color='cornflowerblue'>enter-active-class</font>等属性的值连接起来共同实现我们需要的动画。

      - ##### 如 name="animate_animated  "  enter-active-class="animate_bounceInDown"  

        - ##### 会成为 <font color='fuchsia'>animate_animated animate_bounceInDown</font>  这样效果才会生效

        - ##### name的作用就是相当于前缀

          - ##### 本身就是替代v-enter-active 中的v 所以name的值相当于给当前一组transition变得好理解了

  

  

  

  





