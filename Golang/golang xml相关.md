#### Golang 中xml定义使用



##### xml文件基本样式

```xml
<xml>
  <ToUserName><![CDATA[toUser]]></ToUserName>
  <FromUserName><![CDATA[fromUser]]></FromUserName>
  <CreateTime>1348831860</CreateTime>
  <MsgType><![CDATA[text]]></MsgType>
  <Content><![CDATA[this is a test]]></Content>
  <MsgId>1234567890123456</MsgId>
  <MsgDataId>xxxx</MsgDataId>
  <Idx>xxxx</Idx>
</xml>
```



##### 在golang中定义是实体类

```golang
type WeMessage struct {
	ToUserName   string `xml:"ToUserName"`
	FromUserName string `xml:"FromUserName"`
	CreateTime   int64  `xml:"CreateTime"`
	MsgType      string `xml:"MsgType"`
	Content      string `xml:"Content"`
	MsgId        string `xml:"MsgId"`
	MsgDataId    string `xml:"MsgDataId"`
	Idx          string `xml:"Idx"`
}
```

##### 但是这样转换存在一个问题，可以将xml中的每个字段正常转换。但是<font color='red'>xml根标签</font>却不能实现自定义。

#### <font color='orange'>解</font>

##### 在golang中 encoding/xml 包对自定义根标签添加了一个字段 xml.Name。即，标注了该字段当实体类转换为xml时，会自动根据此字段设置xml跟标签的值

```golang
type ReplyMessage struct {
	XMLName      xml.Name `xml:"xml（自定义根标签）"`
	ToUserName   string   `xml:"ToUserName"`
	FromUserName string   `xml:"FromUserName"`
	CreateTime   int64    `xml:"CreateTime"`
	MsgType      string   `xml:"MsgType"`
	Content      string   `xml:"Content"`
}

>> 得到的xml >>>>>>>>>>>>>>>>>

<xml>
    <ToUserName>[5J8gG4-9iDrcLhw]</ToUserName>
    <FromUserName>[gh_57e3837]</FromUserName>
    <CreateTime>1665313</CreateTime>
    <MsgType>text</MsgType>
    <Content>接收成功</Content>
</xml>
```

