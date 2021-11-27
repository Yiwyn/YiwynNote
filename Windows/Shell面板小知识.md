- ### 批量修改文件名中相同的部分

```shell
Dir | Rename-Item –NewName { $_.name –replace “ “,”_” 
```



