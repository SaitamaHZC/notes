# Git

## 基本命令

```
init 	将某个目录变成git管理的仓库

add <file>  添加文件到仓库

commit (-m message)	提交。-m为提交说明

status 查看仓库当前状态,有无文件被修改，如何修改

diff <file> 	查看当前工作区文件和最新版本的差别

log (--pretty=oneline) 显示提交日志  
--pretty=oneline改为显示版本号(commit id)
以便确定要回退到哪个版本

reset --hard 版本号  回退到对应版本号(commit id)
reset --hard HEAD^  一个^ ，回退一次
reset --hard HEAD~x 回退x次
git reset命令既可以回退版本，也可以把暂存区的修改回退到工作区。

reflog 记录每一次命令，可用于查看版本号
以便确定要回到未来的哪个版本

checkout -- <file> 丢弃工作区的修改，回到最近一次commit（该文件没有被add）或add（该文件被add过）时的状态
撤销修改：
1. 如果改了工作区文件，并且add到暂存区，先git reset HEAD <file> 把修改退到工作区，再git checkout -- <file>
2. 如果没有add，那么直接git checkout -- <file>


rm 删除版本库（暂存区）里的文件
```





## 工作原理

**.git**是Git的**版本库**，其中有称为stage的**暂存区**，还有Git自动创建的第一个分支**master**，还有指向master的一个指针**HEAD**

![git-repo](http://hzc-typora.oss-cn-shanghai.aliyuncs.com/img/0)

我们把文件往Git版本库里添加的时候，是分两步执行的：

第一步是用`git add`把文件添加进去，实际上就是**把文件修改添加到暂存区；**

第二步是用`git commit`提交更改，实际上就是**把暂存区的所有内容提交到当前分支。**

因为我们创建Git版本库时，Git自动为我们创建了唯一一个`master`分支，所以，现在，`git commit`就是往`master`分支上提交更改。





## Github使用

```
git push origin master 将本地master分支推送到github(github上的远程库创建时名字默认就叫origin)
git remote rm <name> 删除远程库
git remote -v 查看远程库性关系

git clone git@github.com:<path> 克隆一个本地库
```

