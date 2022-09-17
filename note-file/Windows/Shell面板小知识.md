- ### 批量修改文件名中相同的部分

  ```shell
  Dir | Rename-Item –NewName { $_.name –replace “ “,”_” 
  ```

  



- ###  删除特定文件

  ```shell
  del *xxx.*
  
  //*代表匹配任意字符 
  ```

  
