## <font color='red'>Docker网络</font>



> ##### 只要安装了docker，就会有一个网卡<font color='cornflowerblue'>docker0</font>，使用的是桥接模式，使用的技术是evth-pair 技术



##### 在运行了容器之后，docker会自动给容器分配一个网卡地址，这个网卡地址和docker0之间为桥接关系。evth-pair就像桥梁一样。

##### 当容器与容器之间进行网络交互的时候，请求会通过docker0发送到被请求的容器上








