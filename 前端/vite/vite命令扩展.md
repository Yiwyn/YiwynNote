- ##### 自定义端口

  - ##### package.json

    ```json
     "scripts": {
        "dev": "vite --port 8080",
        "build": "vue-tsc --noEmit && vite build",
        "preview": "vite preview"
      },
    ```

  - ##### 在指定命令后添加 <font color='red'>--port</font>即可指定运行端口

    ```shell
    npm run dev 
    //修改之后运行该命令则运行在8080端口
    ```

    