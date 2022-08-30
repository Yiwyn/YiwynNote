### <font color='red'>流水线 pipeline</font>



> #### 流水线既能作为任务的本身，也能作为jenkinsfile
>
> ##### 使用流水线可以让我们的任务从UI手动操作，转换为代码化，像dockerfile一样，从shell命令到配置文件。



#### 完整语法

```shell
pipeline：整条流水线
agent：指定执行器
stages：所有阶段
stage：某一阶段，可有多个
steps：阶段内的每一步，可执行命令
```



##### sample

```pipeline
pipeline {
    agent any

    stages {
        stage('Pull') {
            steps {
                echo 'pull project'
            }
        }
         stage('Build') {
            steps {
                echo 'build project'
            }
        }
    }
}
```

