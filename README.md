# ChatRoom
Java Socket实现的聊天室
复习Java Socket模块,于是便写了这么个聊天室

### 配置环境
- JDK版本：JDK 1.8.0_121
- jar包：无格外jar包
- 运行环境：Win10

### 设计思路
- 将各个功能分隔成各个模块
- 客户端的监听，回复模块分别用多线程实现
- 将服务端分隔成三个模块：线程创建，消息监听，Socket管理
