# Nosql

减少CPU压力：直接存放在内存中

减少IO操作：缓存数据库（存放高频次，热门访问的数据、Session），减少读数据库的操作



NoSQL(NoSQL = **Not Only SQL** )，意即“不仅仅是SQL”，泛指**非关系型的数据库**。 

NoSQL 不依赖业务逻辑方式存储，而以简单的key-value模式存储。因此大大的增加了数据库的扩展能力。

1. 不遵循SQL标准。

2. 不支持ACID。

3. 远超于SQL的性能。



适用场景：

1. 对数据高并发的读写

2. 海量数据的读写

3. 对数据高可扩展性的

不适用场景：

1. 需要事务支持

2. 基于sql的结构化查询存储，处理复杂的关系,需要即席查询。

3. 用不着sql的和用了sql也不行的情况，请考虑用NoSql







# 配置和启动

1. 前台启动：直接输入 (不推荐，因为命令行窗口不能关闭，否则服务器停止)

   ```shell
   redis-server
   ```

2. 后台启动：

   1. 拷贝一份redis.conf到其他目录 （~CS/redis.conf）
   2. 修改redis.conf(128行)文件将里面的daemonize no 改成 yes
   3. 先输命令启动Redis

   ```shell
   redis-server ~CS/redis.conf #输入拷贝修改出来的redis.conf文件地址
   ```

   4. 客户端访问：

      ```
      redis-cli
      ```

   5. 关闭：

      在客户端内shutdown 

      或

      ```shell
      redis-cli shutdown
      #多实例关闭，指定端口关闭：redis-cli -p 6379 shutdown
      ```

      或

      kill进程