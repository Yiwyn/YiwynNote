### defineComponent 



> ##### 在定义 Vue 组件时提供类型推导的辅助函数。
>
> ##### 第一个参数是一个组件选项对象。返回值将是该选项对象本身，因为该函数实际上在运行时没有任何操作，仅用于提供类型推导。
>
> ##### 注意返回值的类型有一点特别：它会是一个构造函数类型，它的实例类型是根据选项推断出的组件实例类型。这是为了能让该返回值在 TSX 中用作标签时提供类型推导支持。
>
> ##### 你可以像这样从 `defineComponent()` 的返回类型中提取出一个组件的实例类型 (与其选项中的 `this` 的类型等价)：





##### 若使用typescript 进行开发，需要指定类型，这个时候就需要配合defineComponent 进行开发。

##### 当使用了<script setup lang="ts">语法糖之后则无需配置defineComponent组件

```html
//替换前
<script lang="ts">
export default
    {
        name: "yiwyn",
        setup() {

        }
    }
</script>



//替换后
<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent(
    {
        name: "yiwyn",
        setup(props) {

        }
    }
)
</script>
```

