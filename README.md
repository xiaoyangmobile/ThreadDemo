## Java内存模型
所有变量都在主存中，每个线程有自己的工作线程，工作线程中备份了主存中的变量数据，线程中的操作都是操作的工作线程中备份数据。
## Volatile
使用条件：
* 变量的写入不能依赖于变量本身
* 不能用于其他变量不等式
特性：
* 可见性
* 有序性
* 不具有原子性