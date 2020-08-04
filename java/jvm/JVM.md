# JVM

## OpenJDK的编译

## 自动内存管理

### 虚拟机内存的划分

- 程序计数器

程序计数器（Program Counter Register）是一块较小的内存空间，它可以看作是当前线程所执行的字节码的行号指示器。它是线程隔离的数据区（线程私有）。在Java
虚拟机的概念模型里，字节码解释器工作时就是通过改变这个计数器的值来选取下一条需要执行的字节码指令，它是程序控制流的指示器，分支、循环、跳转、异常处理、线程恢复等基础功能都需要依赖这个计数器来完成。<br>由于Java虚拟机的多线程是通过线程轮流切换、分配处理器执行时间的方式来实现的，在任何一个确定的时刻，一个处理器（对于多核处理器来说是一个内核）都只是执行一条线程中的指令。因此，为了线程切换后能恢复到正确的执行位置，每条线程都需要有一个独立的程序计数器，各条线程之间计数器互不影响，独立存储，这类内存区域呢，就被称为"线程私有"的内存。<br>如果线程正在执行的是Java方法，这个计数器记录的是正在执行的虚拟机字节码指令的地址；如果正在执行的是本地（Native）方法，这个计数器值应为空（Undefined）。此内存区域是唯一一个在《Java虚拟机规范》中没有规定任何OutOfMemoryError情况的区域。

- Java虚拟机栈

Java虚拟机栈（Java Virtual Machine Stack）是线程私有的，它的生命周期与线程相同（也就是说依赖用户线程的启动和结束而建立和销毁）。虚拟机栈描述的是Java方法执行的线程内存模型：每个方法被执行的时候，Java虚拟机都会同步创建一个**栈帧**（Stack Frame）用于存储局部变量表、操作数栈、动态连接、方法出口等信息。每一个方法被调用直至执行完毕的过程，就对应着一个栈帧在虚拟机栈中从入栈到出栈的过程。<br>局部变量表存放了编译期可知的各种Java虚拟机基本数据类型（boolean、byte、char、short、int、float、long、double），对象引用（reference类型，它并不等同于对象本身，可能是一个指向对象起始地址的引用指针，也可能是指向一个代表对象的句柄或者其他与此对象相关的位置）和returnAddress类型（指向了一条字节码指令的地址）。<br>这些数据类型在局部变量表中的存储空间以局部变量槽（Slot）来表示，其中6位长度的long和double类型的数据会占用两个变量槽，其余的数据类型只占用一个。局部变量表所需的内存空间在编译期间完成分配，当进入一个方法时，这个方法需要在栈帧中分配多大的局部变量空间是完全确定的，在方法运行期期间不会改变局部变量表的大小，注：这个大小指的是变量槽的数量，虚拟机真正使用多大的内存空间（譬如按照1个变量槽占用32个比特、64个比特，或者更多）来实现一个变量槽，这是完全由具体的虚拟机实现自行决定的事情。<br>在《Java虚拟机规范》中，对这个内存区域规定来两类异常状况：1.如果线程请求的栈深度大于虚拟机所允许的深度，将抛出StackOverFlowError异常；2.如果Java虚拟机容量可以动态扩展（HotSpot虚拟机的栈容量不可以动态扩展），当栈扩展时无法申请到足够的内存会抛出OutOfMemoryError异常。

> HotSpot虚拟机的栈容量是不可以动态扩展的。

### 哪部分区域、什么样的代码和操作可能导致内存溢出异常

### 各个区域出现内存溢出异常的常见原因

### 垃圾收集算法

### HotSpot虚拟机提供的垃圾收集器的特点及运作原理

### 代码实例验证Java虚拟机中自动内存分配及回收的主要规则

### 随JDK发布的基础命令行工具与可视化的故障处理工具的使用方法

### 通过实际案例来获得故障处理和调优的经验