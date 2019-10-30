1.公平锁 / 非公平锁

    公平锁 ReentrantLock构造参数指定
    非公平锁 ReentrantLock默认 synchronized

2.可重入锁 / 不可重入锁

    可重入锁 ReentrantLock synchronized
    不可重入锁 自旋锁递归

3.独享锁 / 共享锁

    独享锁 ReeReentrantLock synchronized
    共享锁 ReentrantReadWriteLock

4.互斥锁 / 读写锁

    互斥锁 锁通常都是互斥锁
    读写锁 ReadWriteLock

5.乐观锁 / 悲观锁

    乐观锁 CAS实现
    悲观锁 ReentrantLock synchronized

6.分段锁

    分段锁 ConcurrentHashMap实现

7.偏向锁 / 轻量级锁 / 重量级锁

    锁的状态总共有四种：无锁状态、偏向锁、轻量级锁和重量级锁

8.自旋锁

    自旋锁 CAS + while实现 synchronized轻量级状态