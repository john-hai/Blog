##导入数据库(建表)
新建数据库db_blog,在数据库中新建5个表，分别如下。
###t_blog表的创建
~~~
CREATE TABLE `t_blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(200) DEFAULT NULL COMMENT '标题',
  `summary` varchar(2000) DEFAULT NULL COMMENT '摘要',
  `releaseDate` datetime DEFAULT NULL COMMENT '发表时间',
  `clickHit` int(11) DEFAULT NULL COMMENT '点击数',
  `replyHit` int(11) DEFAULT NULL COMMENT '评论数',
  `content` text COMMENT '内容',
  `typeId` int(11) DEFAULT NULL COMMENT '所属博客类型',
  `keyWord` varchar(200) DEFAULT NULL COMMENT '关键字',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`) USING BTREE,
  KEY `typeId` (`typeId`),
  CONSTRAINT `t_blog_ibfk_1` FOREIGN KEY (`typeId`) REFERENCES `t_blogtype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COMMENT='博客表';
~~~
###t_blogger表的创建
~~~
CREATE TABLE `t_blogger` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userName` varchar(50) DEFAULT NULL COMMENT '登录名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `profile` text COMMENT '个人信息',
  `nickName` varchar(50) DEFAULT NULL COMMENT '昵称',
  `sign` varchar(100) DEFAULT NULL COMMENT '个性签名',
  `imageName` varchar(100) DEFAULT NULL COMMENT '头像地址',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='博主';
~~~
###t_blogtype表的创建
~~~
CREATE TABLE `t_blogtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `typeName` varchar(100) DEFAULT NULL COMMENT '类型名称',
  `orderNo` int(11) DEFAULT NULL COMMENT '序号',
  PRIMARY KEY (`id`),
  KEY `id` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COMMENT='博客类型表';
~~~
###t_comment表的创建
~~~
CREATE TABLE `t_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userIp` varchar(50) DEFAULT NULL COMMENT '评论者ip',
  `blogId` int(11) DEFAULT NULL COMMENT '被评论博客的主键',
  `content` varchar(1000) DEFAULT NULL COMMENT '评论内容',
  `commentDate` datetime DEFAULT NULL COMMENT '评论时间',
  `state` int(11) DEFAULT NULL COMMENT '评论状态：0未审核1审核',
  UNIQUE KEY `id` (`id`) USING BTREE,
  KEY `blogId` (`blogId`),
  CONSTRAINT `t_comment_ibfk_1` FOREIGN KEY (`blogId`) REFERENCES `t_blog` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COMMENT='评论表';
~~~
###t_link表的创建
~~~
CREATE TABLE `t_link` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `linkName` varchar(100) DEFAULT NULL COMMENT '网站名称',
  `linkUrl` varchar(500) DEFAULT NULL COMMENT '网站地址',
  `orderNo` int(11) DEFAULT NULL COMMENT '序号',
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='友情链接';
~~~
##建立项目
##注入依赖
###添加Servlet支持
Eclipse建立项目时index.jsp可能会出现红色，所以添加这个依赖javax.servlet。然后引入jsp的依赖javax.servlet-api.我这里没有添加，因为index.jsp没有报错。
###添加jstl支持javax.servlet...
##导入webapp
在webapp中导入admin, foreground, static, favicon.ico,image.jsp,login.jsp,源码中缺少index.jsp
##修改web.xml
##空
##BlogMapper.xml
有一个地方是，编写Blog的resultMap时，其中的blogType是外键，所以要用到association，而不是result，注意一下。
##评论审核不成功
CommentMapper.xml中update 的<update></update> 错写成了<select></select>
##个人信息页面的profile无法更新
是jsp中写成proFile了
##博客中上传的图片无法显示
路径问题
##个人资料中图片无法上传
路径问题

